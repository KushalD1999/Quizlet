import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import javax.swing.Timer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Label;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.Box;
import java.awt.Component;


public class Screen7 extends JFrame {
	
	int dice=(int)(Math.random()*6+1);
	Object[]options={"Thanks mate","Come on!"};
	private JPanel contentPane;
	private ImageIcon img=new ImageIcon("images//new.jpg");
	private ImageIcon ll1=new ImageIcon("ll1.jpg");
	private ImageIcon ll1used=new ImageIcon("ll1used.jpg");
	private ImageIcon ll2=new ImageIcon("5050.jpg");
	private ImageIcon ll2used=new ImageIcon("5050used.jpg");
	private ImageIcon ll3=new ImageIcon("aud.png");
	private ImageIcon ll3used=new ImageIcon("audused.png");

	private static String op1;
	private static String op2;
	private static String op3;
	private static String op4;
	private static String q1;
	static int rand=(int)(Math.random()*4+1);
	static int change=(int)(Math.random()*4+1);
	private static String ans;
	JButton option1;
	JButton option2;
	JButton option3;
	JButton option4;
	
	private int count=15;
	
	/**
	 * Method that access to play the sound in the game 
	 * @param sound
	 */
	public static void PlaySound(File sound)
	{
		try{
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(sound));
			clip.start();
		}
		catch(Exception e)
		{
			
		}
	}
	/**
	 * Constructor for screen 7 that has the game mechanics and the layout and dimensions.
	 */
	
	public Screen7() {
		
		//file that plays the sound in the game accessing the method Playsound
		File Clap = new File ("ques1.wav");
		PlaySound(Clap);
		
		JLabel lblTimer = new JLabel("Timer:");
		lblTimer.setBackground(Color.WHITE);
		lblTimer.setForeground(Color.WHITE);
		lblTimer.setFont(new Font("SimSun-ExtB", Font.BOLD, 38));
		lblTimer.setBounds(10, 323, 151, 100);
		getContentPane().add(lblTimer);
		
		//location and dimension of timer.
		JLabel timer = new JLabel("15");
		timer.setForeground(Color.WHITE);
		timer.setFont(new Font("SimSun-ExtB", Font.BOLD, 48));
		timer.setBounds(137, 310, 63, 137);
		getContentPane().add(timer);
		
		//Creating timer, each timer instance last 1000 milliseconds which is 1 second.
		Timer time=new Timer(1000, new ActionListener(){

			@Override
			/**
			 * What the timer must do every second that is counted down
			 */
			public void actionPerformed(ActionEvent arg0) {
				//1 second has passed.
				count--;
				timer.setText(count+"");
				//if the count value if 0 the game is ended and the user is told about there winnings
				if(count==0){
					
					if(Target.c != 1)
        			{
						Screen1.score = 0;
        			}
        			else if(Target.c == 1)
        			{
        				if(Target.sc==1)
        				{
    						Screen1.score = 1000;
        				}
        				if(Target.sc==2)
        				{
    						Screen1.score = 5000;
        				}        				
        				if(Target.sc==3)
        				{
    						Screen1.score = 10000;
        				}
        				if(Target.sc==4)
        				{
    						Screen1.score = 50000;
        				}
        				if(Target.sc==5)
        				{
    						Screen1.score = 100000;
        				}
        			}
					JOptionPane.showMessageDialog(null, "Sorry You ran out of time. You have won " + Screen1.score);
    				//asks user to play the game again 
					int res = JOptionPane.showOptionDialog(null, "Would you like to play again?", "Wrong answer", JOptionPane.ERROR_MESSAGE,
	        		        JOptionPane.INFORMATION_MESSAGE, null, null, null);
					//if user selects yes then it resets the game but setting everything to 0
	        		if(res==0){
	    				Leaderboard.addScore(Screen1.score);
	    				Screen1.score = 0;
	    				Screen1.life1 = 0;
	    				Screen1.life2 = 0;
	    				Screen1.life3 = 0;
	    				Target.sc=0;
	    				Target.c=0;
	        			Screen1 s=new Screen1();
	        			s.setVisible(true);
	    				close();
	    				rand = (int)(Math.random()*4+1);
	        		}
	        		//closes the screen
	        		else{
	    				Leaderboard.addScore(Screen1.score);
	        			System.exit(0);
	        		}
				}
			}
			
		});
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				//timer is started once the screen is visible/opened.
				time.start();
			}
		});
		
		
		String[] splitted = new String[50];
		try{
			  // Open the file
			  FileInputStream fstream = new FileInputStream("Question6.txt");
			  // Get the object of DataInputStream
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine = null;
			  //Read File Line By Line
			  for (int i = 0; i < rand; i++)
			  {
				  strLine = br.readLine();
			  }
			     splitted = strLine.split("-"); // here - is used as the delimiter

			  //Close the input stream
			  in.close();
			    }catch (Exception e){//Catch exception if any
			  System.out.println("Error: " + e.getMessage());
			  }
		//Questions and options are splitted out from the array
		q1 = "Question 6: " + splitted[0];
		op1 = splitted[1];
		op2 = splitted[2];
		op3 = splitted[3];
		op4 = splitted[4];
		ans = splitted[5];
	
		//font, color 
		getContentPane().setBackground(new Color(0, 0, 51));
		setTitle("Who wants to be a millionaire?");
		setSize(1250,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);	
		
		//label
		JLabel lblNewLabel = new JLabel(){
			 public void paintComponent(Graphics g) {
			        g.drawImage(img.getImage(), 0, 0, 300,208,null);
			        super.paintComponent(g);
			      }
		};
		lblNewLabel.setBounds(339, 84, 300, 208);
		getContentPane().add(lblNewLabel);
		
		//question 1 label
		JLabel question1 = new JLabel(q1);
		question1.setForeground(Color.WHITE);
		question1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		question1.setBounds(262, 222, 511, 61);
		getContentPane().add(question1);
		//if change is equal to 1 then ans is 1 soption
		if(change==1)
		{
			//ans option is first
			option1 = new JButton(ans);
			option1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg){
					
					//if target is chosen $30000 then score starts counting from here
					if(Target.sc==6 && Target.c != 1)
					{
						Target.c = 1;
						Screen1.score = 300000;
					}
					//else it is 0
					else
					{
						Screen1.score = 0;
					}
					
					//if target is chosen $30000 then score starts counting from here
					if (Target.c == 1)
					{
						Screen1.score = 300000;
					}
					time.stop();
				  	Screen8 s=new Screen8();
					s.setVisible(true);
					close();
    				rand = (int)(Math.random()*4+1);
				}
			});
			option1.setBounds(339, 384, 169, 61);
			getContentPane().add(option1);
			
			//wrong option
			 option2 = new JButton(op2);
			 option2.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg){
						//if target chosen is blow that then user gets 0 money
						if(Target.c != 1)
	        			{
							Screen1.score = 0;
	        			}
						//else gets the target money according to their chosen target
	        			else if(Target.c == 1)
	        			{
	        				if(Target.sc==1)
	        				{
	    						Screen1.score = 1000;
	        				}
	           				if(Target.sc==2)
	        				{
	    						Screen1.score = 5000;
	        				}
	           				if(Target.sc==3)
	        				{
	    						Screen1.score = 10000;
	        				}
	           				if(Target.sc==4)
	        				{
	    						Screen1.score = 50000;
	        				}
	           				if(Target.sc==5)
	        				{
	    						Screen1.score = 100000;
	        				}
	        			}
						//and can play the game again
	    				JOptionPane.showMessageDialog(null, "Sorry your answer was wrong. You have won " + Screen1.score);
						int res = JOptionPane.showOptionDialog(null, "Would you like to play again?", "Wrong answer", JOptionPane.ERROR_MESSAGE,
		        		        JOptionPane.INFORMATION_MESSAGE, null, null, null);
						//if user wants to play again then everything is ressetted after adding the score to the leaderboard
		        		if(res==0){
		    				Leaderboard.addScore(Screen1.score);
		        			Screen1 s=new Screen1();
		        			s.setVisible(true);
		    				Screen1.score = 0;
		    				Screen1.life1 = 0;
		    				Screen1.life2 = 0;
		    				Screen1.life3 = 0;
		    				rand = (int)(Math.random()*4+1);
							time.stop();
		    				Target.sc=0;
		    				Target.c=0;
		    				close();

		        		}
		        		//else it is closed
		        		else{
		    				Leaderboard.addScore(Screen1.score);
		        			System.exit(0);
		        		}
					}
				});
			option2.setBounds(655, 384, 169, 61);
			getContentPane().add(option2);
			
			//same as above 
			 option3 = new JButton(op3);
			 option3.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg){
						if(Target.c != 1)
	        			{
							Screen1.score = 0;
	        			}
	        			else if(Target.c == 1)
	        			{
		        			if(Target.c != 1)
		        			{
								Screen1.score = 0;
		        			}
		        			else if(Target.c == 1)
		        			{
		        				if(Target.sc==1)
		        				{
		    						Screen1.score = 1000;
		        				}
		        				if(Target.sc==2)
		        				{
		    						Screen1.score = 5000;
		        				}
		        				if(Target.sc==3)
		        				{
		    						Screen1.score = 10000;
		        				}
		        				if(Target.sc==4)
		        				{
		    						Screen1.score = 50000;
		        				}
		        				if(Target.sc==5)
		        				{
		    						Screen1.score = 100000;
		        				}
		        			}
	        			}
	    				JOptionPane.showMessageDialog(null, "Sorry your answer was wrong. You have won " + Screen1.score);
						int res = JOptionPane.showOptionDialog(null, "Would you like to play again?", "Wrong answer", JOptionPane.ERROR_MESSAGE,
		        		        JOptionPane.INFORMATION_MESSAGE, null, null, null);
		        		if(res==0){
		    				Leaderboard.addScore(Screen1.score);
		        			Screen1 s=new Screen1();
		        			s.setVisible(true);
		    				Screen1.score = 0;
		    				Screen1.life1 = 0;
		    				Screen1.life2 = 0;
		    				Screen1.life3 = 0;
		    				rand = (int)(Math.random()*4+1);
							time.stop();
		    				Target.sc=0;
		    				Target.c=0;
		    				close();
		        		}
		        		else{
		    				Leaderboard.addScore(Screen1.score);
		        			System.exit(0);
		        		}
					}
				});
			option3.setBounds(339, 529, 169, 61);
			getContentPane().add(option3);
			
			//same as above 
			 option4 = new JButton(op4);
			 option4.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg){
						if(Target.c != 1)
	        			{
							Screen1.score = 0;
	        			}
	        			else if(Target.c == 1)
	        			{
		        			if(Target.c != 1)
		        			{
								Screen1.score = 0;
		        			}
		        			else if(Target.c == 1)
		        			{
		        				if(Target.sc==1)
		        				{
		    						Screen1.score = 1000;
		        				}
		        				if(Target.sc==2)
		        				{
		    						Screen1.score = 5000;
		        				}
		        				if(Target.sc==3)
		        				{
		    						Screen1.score = 10000;
		        				}
		        				if(Target.sc==4)
		        				{
		    						Screen1.score = 50000;
		        				}
		        				if(Target.sc==5)
		        				{
		    						Screen1.score = 100000;
		        				}
		        			}
	        			}
	    				JOptionPane.showMessageDialog(null, "Sorry your answer was wrong. You have won " + Screen1.score);
						int res = JOptionPane.showOptionDialog(null, "Would you like to play again?", "Wrong answer", JOptionPane.ERROR_MESSAGE,
		        		        JOptionPane.INFORMATION_MESSAGE, null, null, null);
		        		if(res==0){
		    				Leaderboard.addScore(Screen1.score);
		        			Screen1 s=new Screen1();
		        			s.setVisible(true);
		    				Screen1.score = 0;
		    				Screen1.life1 = 0;
		    				Screen1.life2 = 0;
		    				Screen1.life3 = 0;
		    				rand = (int)(Math.random()*4+1);
							time.stop();
		    				Target.sc=0;
		    				Target.c=0;
		    				close();


		        		}
		        		else{
		    				Leaderboard.addScore(Screen1.score);
		        			System.exit(0);
		        		}
					}
				});
			option4.setBounds(655, 529, 169, 61);
			getContentPane().add(option4);
		}
		//does the same thing as above for the other 2 remaining changes that changes the options location and if user answers it correctly then continues the game or ask user if he wants to play the game again and if user agrees resets the game.
		if(change==2)
		{
			option1 = new JButton(op2);
			option1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg){
					if(Target.c != 1)
        			{
						Screen1.score = 0;
        			}
        			else if(Target.c == 1)
        			{
	        			if(Target.c != 1)
	        			{
							Screen1.score = 0;
	        			}
	        			else if(Target.c == 1)
	        			{
	        				if(Target.sc==1)
	        				{
	    						Screen1.score = 1000;
	        				}
	        				if(Target.sc==2)
	        				{
	    						Screen1.score = 5000;
	        				}
	        				if(Target.sc==3)
	        				{
	    						Screen1.score = 10000;
	        				}
	        				if(Target.sc==4)
	        				{
	    						Screen1.score = 50000;
	        				}
	        				if(Target.sc==5)
	        				{
	    						Screen1.score = 100000;
	        				}
	        			}
        			}
    				JOptionPane.showMessageDialog(null, "Sorry your answer was wrong. You have won " + Screen1.score);
					int res = JOptionPane.showOptionDialog(null, "Would you like to play again?", "Wrong answer", JOptionPane.ERROR_MESSAGE,
	        		        JOptionPane.INFORMATION_MESSAGE, null, null, null);
	        		if(res==0){
	    				Leaderboard.addScore(Screen1.score);
	        			Screen1 s=new Screen1();
	        			s.setVisible(true);
	    				Screen1.score = 0;
	    				Screen1.life1 = 0;
	    				Screen1.life2 = 0;
	    				Screen1.life3 = 0;
	    				rand = (int)(Math.random()*4+1);
						time.stop();
	    				Target.sc=0;
	    				Target.c=0;
	    				close();

	        		}
	        		else{
	    				Leaderboard.addScore(Screen1.score);
	        			System.exit(0);
	        		}
				}
			});
			option1.setBounds(339, 384, 169, 61);
			getContentPane().add(option1);
			
			option2 = new JButton(ans);
			option2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg){

					if(Target.sc==6 && Target.c != 1)
					{
						Target.c = 1;
						Screen1.score = 300000;
					}
					else
					{
						Screen1.score = 0;
					}
					
					if (Target.c == 1)
					{
						Screen1.score = 300000;
					}
					time.stop();
					Screen8 s=new Screen8();
					s.setVisible(true);
					close();
    				rand = (int)(Math.random()*4+1);
				}
			});
			option2.setBounds(655, 384, 169, 61);
			getContentPane().add(option2);
			
			 option3 = new JButton(op3);
			 option3.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg){
						if(Target.c != 1)
	        			{
							Screen1.score = 0;
	        			}
	        			else if(Target.c == 1)
	        			{
		        			if(Target.c != 1)
		        			{
								Screen1.score = 0;
		        			}
		        			else if(Target.c == 1)
		        			{
		        				if(Target.sc==1)
		        				{
		    						Screen1.score = 1000;
		        				}
		        				if(Target.sc==2)
		        				{
		    						Screen1.score = 5000;
		        				}
		        				if(Target.sc==3)
		        				{
		    						Screen1.score = 10000;
		        				}
		        				if(Target.sc==4)
		        				{
		    						Screen1.score = 50000;
		        				}
		        				if(Target.sc==5)
		        				{
		    						Screen1.score = 100000;
		        				}
		        			}
	        			}
	    				JOptionPane.showMessageDialog(null, "Sorry your answer was wrong. You have won " + Screen1.score);
						int res = JOptionPane.showOptionDialog(null, "Would you like to play again?", "Wrong answer", JOptionPane.ERROR_MESSAGE,
		        		        JOptionPane.INFORMATION_MESSAGE, null, null, null);
		        		if(res==0){
		    				Leaderboard.addScore(Screen1.score);
		        			Screen1 s=new Screen1();
		        			s.setVisible(true);
		    				Screen1.score = 0;
		    				Screen1.life1 = 0;
		    				Screen1.life2 = 0;
		    				Screen1.life3 = 0;
		    				rand = (int)(Math.random()*4+1);
							time.stop();
		    				Target.sc=0;
		    				Target.c=0;
		    				close();

		        		}
		        		else{
		    				Leaderboard.addScore(Screen1.score);
		        			System.exit(0);
		        		}

					}
				});
			option3.setBounds(339, 529, 169, 61);
			getContentPane().add(option3);
			
			 option4 = new JButton(op4);
			 option4.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg){
						if(Target.c != 1)
	        			{
							Screen1.score = 0;
	        			}
	        			else if(Target.c == 1)
	        			{
		        			if(Target.c != 1)
		        			{
								Screen1.score = 0;
		        			}
		        			else if(Target.c == 1)
		        			{
		        				if(Target.sc==1)
		        				{
		    						Screen1.score = 1000;
		        				}
		        				if(Target.sc==2)
		        				{
		    						Screen1.score = 5000;
		        				}
		        				if(Target.sc==3)
		        				{
		    						Screen1.score = 10000;
		        				}
		        				if(Target.sc==4)
		        				{
		    						Screen1.score = 50000;
		        				}
		        				if(Target.sc==5)
		        				{
		    						Screen1.score = 100000;
		        				}
		        			}
	        			}
	    				JOptionPane.showMessageDialog(null, "Sorry your answer was wrong. You have won " + Screen1.score);
						int res = JOptionPane.showOptionDialog(null, "Would you like to play again?", "Wrong answer", JOptionPane.ERROR_MESSAGE,
		        		        JOptionPane.INFORMATION_MESSAGE, null, null, null);
		        		if(res==0){
		    				Leaderboard.addScore(Screen1.score);
		        			Screen1 s=new Screen1();
		        			s.setVisible(true);
		    				Screen1.score = 0;
		    				Screen1.life1 = 0;
		    				Screen1.life2 = 0;
		    				Screen1.life3 = 0;
		    				rand = (int)(Math.random()*4+1);
							time.stop();
		    				Target.sc=0;
		    				Target.c=0;
		    				close();

		        		}
		        		else{
		    				Leaderboard.addScore(Screen1.score);
		        			System.exit(0);
		        		}
					}
				});
			option4.setBounds(655, 529, 169, 61);
			getContentPane().add(option4);
		}
		
		
		//does the same thing as above for the other 2 remaining changes that changes the options location and if user answers it correctly then continues the game or ask user if he wants to play the game again and if user agrees resets the game.
		if(change==3)
		{
			 option1 = new JButton(op2);
			 option1.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg){
						if(Target.c != 1)
	        			{
							Screen1.score = 0;
	        			}
	        			else if(Target.c == 1)
	        			{
		        			if(Target.c != 1)
		        			{
								Screen1.score = 0;
		        			}
		        			else if(Target.c == 1)
		        			{
		        				if(Target.sc==1)
		        				{
		    						Screen1.score = 1000;
		        				}
		        				if(Target.sc==2)
		        				{
		    						Screen1.score = 5000;
		        				}
		        				if(Target.sc==3)
		        				{
		    						Screen1.score = 10000;
		        				}
		        				if(Target.sc==4)
		        				{
		    						Screen1.score = 50000;
		        				}
		        				if(Target.sc==5)
		        				{
		    						Screen1.score = 100000;
		        				}
		        			}
	        			}
	    				JOptionPane.showMessageDialog(null, "Sorry your answer was wrong. You have won " + Screen1.score);
						int res = JOptionPane.showOptionDialog(null, "Would you like to play again?", "Wrong answer", JOptionPane.ERROR_MESSAGE,
		        		        JOptionPane.INFORMATION_MESSAGE, null, null, null);
		        		if(res==0){
		    				Leaderboard.addScore(Screen1.score);
		        			Screen1 s=new Screen1();
		        			s.setVisible(true);
		    				Screen1.score = 0;
		    				Screen1.life1 = 0;
		    				Screen1.life2 = 0;
		    				Screen1.life3 = 0;
		    				rand = (int)(Math.random()*4+1);
							time.stop();
		    				Target.sc=0;
		    				Target.c=0;
		    				close();

		        		}
		        		else{
		    				Leaderboard.addScore(Screen1.score);
		        			System.exit(0);
		        		}
					}
				});
			option1.setBounds(339, 384, 169, 61);
			getContentPane().add(option1);
			
			 option2 = new JButton(op3);
			 option2.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg){
						if(Target.c != 1)
	        			{
							Screen1.score = 0;
	        			}
	        			else if(Target.c == 1)
	        			{
		        			if(Target.c != 1)
		        			{
								Screen1.score = 0;
		        			}
		        			else if(Target.c == 1)
		        			{
		        				if(Target.sc==1)
		        				{
		    						Screen1.score = 1000;
		        				}
		        				if(Target.sc==2)
		        				{
		    						Screen1.score = 5000;
		        				}
		        				if(Target.sc==3)
		        				{
		    						Screen1.score = 10000;
		        				}
		        				if(Target.sc==4)
		        				{
		    						Screen1.score = 50000;
		        				}
		        				if(Target.sc==5)
		        				{
		    						Screen1.score = 100000;
		        				}
		        			}
	        			}
	    				JOptionPane.showMessageDialog(null, "Sorry your answer was wrong. You have won " + Screen1.score);
						int res = JOptionPane.showOptionDialog(null, "Would you like to play again?", "Wrong answer", JOptionPane.ERROR_MESSAGE,
		        		        JOptionPane.INFORMATION_MESSAGE, null, null, null);
		        		if(res==0){
		    				Leaderboard.addScore(Screen1.score);
		        			Screen1 s=new Screen1();
		        			s.setVisible(true);
		    				Screen1.score = 0;
		    				Screen1.life1 = 0;
		    				Screen1.life2 = 0;
		    				Screen1.life3 = 0;
		    				rand = (int)(Math.random()*4+1);
							time.stop();
		    				Target.sc=0;
		    				Target.c=0;
		    				close();
		        		}
		        		else{
		    				Leaderboard.addScore(Screen1.score);
		        			System.exit(0);
		        		}
					}
				});
			option2.setBounds(655, 384, 169, 61);
			getContentPane().add(option2);
			
			 option3 = new JButton(ans);
			option3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg){
					if(Target.sc==6 && Target.c != 1)
					{
						Target.c = 1;
						Screen1.score = 300000;
					}
					else
					{
						Screen1.score = 0;
					}
					
					if (Target.c == 1)
					{
						Screen1.score = 300000;
					}
					time.stop();
					Screen8 s=new Screen8();
					s.setVisible(true);
					close();
    				rand = (int)(Math.random()*4+1);
				}
			});
			option3.setBounds(339, 529, 169, 61);
			getContentPane().add(option3);
			
			 option4 = new JButton(op4);
			 option4.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg){
						if(Target.c != 1)
	        			{
							Screen1.score = 0;
	        			}
	        			else if(Target.c == 1)
	        			{
		        			if(Target.c != 1)
		        			{
								Screen1.score = 0;
		        			}
		        			else if(Target.c == 1)
		        			{
		        				if(Target.sc==1)
		        				{
		    						Screen1.score = 1000;
		        				}
		        				if(Target.sc==2)
		        				{
		    						Screen1.score = 5000;
		        				}
		        				if(Target.sc==3)
		        				{
		    						Screen1.score = 10000;
		        				}
		        				if(Target.sc==4)
		        				{
		    						Screen1.score = 50000;
		        				}
		        				if(Target.sc==5)
		        				{
		    						Screen1.score = 100000;
		        				}
		        			}
	        			}
	    				JOptionPane.showMessageDialog(null, "Sorry your answer was wrong. You have won " + Screen1.score);
						int res = JOptionPane.showOptionDialog(null, "Would you like to play again?", "Wrong answer", JOptionPane.ERROR_MESSAGE,
		        		        JOptionPane.INFORMATION_MESSAGE, null, null, null);
		        		if(res==0){
		    				Leaderboard.addScore(Screen1.score);
		        			Screen1 s=new Screen1();
		        			s.setVisible(true);
		    				Screen1.score = 0;
		    				Screen1.life1 = 0;
		    				Screen1.life2 = 0;
		    				Screen1.life3 = 0;
		    				rand = (int)(Math.random()*4+1);
							time.stop();
		    				Target.sc=0;
		    				Target.c=0;
		    				close();
		        		}
		        		else{
		    				Leaderboard.addScore(Screen1.score);
		        			System.exit(0);
		        		}
					}
				});
			option4.setBounds(655, 529, 169, 61);
			getContentPane().add(option4);
		}
		//does the same thing as above for the other 2 remaining changes that changes the options location and if user answers it correctly then continues the game or ask user if he wants to play the game again and if user agrees resets the game.
		if(change==4)
		{
			 option1 = new JButton(op2);
			 option1.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg){
						if(Target.c != 1)
	        			{
							Screen1.score = 0;
	        			}
	        			else if(Target.c == 1)
	        			{
		        			if(Target.c != 1)
		        			{
								Screen1.score = 0;
		        			}
		        			else if(Target.c == 1)
		        			{
		        				if(Target.sc==1)
		        				{
		    						Screen1.score = 1000;
		        				}
		        				if(Target.sc==2)
		        				{
		    						Screen1.score = 5000;
		        				}
		        				if(Target.sc==3)
		        				{
		    						Screen1.score = 10000;
		        				}
		        				if(Target.sc==4)
		        				{
		    						Screen1.score = 50000;
		        				}
		        				if(Target.sc==5)
		        				{
		    						Screen1.score = 100000;
		        				}
		        			}
	        			}
	    				JOptionPane.showMessageDialog(null, "Sorry your answer was wrong. You have won " + Screen1.score);
						int res = JOptionPane.showOptionDialog(null, "Would you like to play again?", "Wrong answer", JOptionPane.ERROR_MESSAGE,
		        		        JOptionPane.INFORMATION_MESSAGE, null, null, null);
		        		if(res==0){
		    				Leaderboard.addScore(Screen1.score);
		        			Screen1 s=new Screen1();
		        			s.setVisible(true);
		    				Screen1.score = 0;
		    				Screen1.life1 = 0;
		    				Screen1.life2 = 0;
		    				Screen1.life3 = 0;
		    				rand = (int)(Math.random()*4+1);
							time.stop();
		    				Target.sc=0;
		    				Target.c=0;
		    				close();
		        		}
		        		else{
		    				Leaderboard.addScore(Screen1.score);
		        			System.exit(0);
		        		}
					}
				});
			option1.setBounds(339, 384, 169, 61);
			getContentPane().add(option1);
			
			 option2 = new JButton(op3);
			 option2.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg){
						if(Target.c != 1)
	        			{
							Screen1.score = 0;
	        			}
	        			else if(Target.c == 1)
	        			{
		        			if(Target.c != 1)
		        			{
								Screen1.score = 0;
		        			}
		        			else if(Target.c == 1)
		        			{
		        				if(Target.sc==1)
		        				{
		    						Screen1.score = 1000;
		        				}
		        				if(Target.sc==2)
		        				{
		    						Screen1.score = 5000;
		        				}
		        				if(Target.sc==3)
		        				{
		    						Screen1.score = 10000;
		        				}
		        				if(Target.sc==4)
		        				{
		    						Screen1.score = 50000;
		        				}
		        				if(Target.sc==5)
		        				{
		    						Screen1.score = 100000;
		        				}
		        			}
	        			}
	    				JOptionPane.showMessageDialog(null, "Sorry your answer was wrong. You have won " + Screen1.score);
						int res = JOptionPane.showOptionDialog(null, "Would you like to play again?", "Wrong answer", JOptionPane.ERROR_MESSAGE,
		        		        JOptionPane.INFORMATION_MESSAGE, null, null, null);
		        		if(res==0){
		    				Leaderboard.addScore(Screen1.score);
		        			Screen1 s=new Screen1();
		        			s.setVisible(true);
		    				Screen1.score = 0;
		    				Screen1.life1 = 0;
		    				Screen1.life2 = 0;
		    				Screen1.life3 = 0;
		    				rand = (int)(Math.random()*4+1);
							time.stop();
		    				Target.sc=0;
		    				Target.c=0;
		    				close();

		        		}
		        		else{
		    				Leaderboard.addScore(Screen1.score);
		        			System.exit(0);
		        		}
					}
				});
			option2.setBounds(655, 384, 169, 61);
			getContentPane().add(option2);
			
			 option3 = new JButton(op4);
			 option3.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg){
						if(Target.c != 1)
	        			{
							Screen1.score = 0;
	        			}
	        			else if(Target.c == 1)
	        			{
		        			if(Target.c != 1)
		        			{
								Screen1.score = 0;
		        			}
		        			else if(Target.c == 1)
		        			{
		        				if(Target.sc==1)
		        				{
		    						Screen1.score = 1000;
		        				}
		        				if(Target.sc==2)
		        				{
		    						Screen1.score = 5000;
		        				}
		        				if(Target.sc==3)
		        				{
		    						Screen1.score = 10000;
		        				}
		        				if(Target.sc==4)
		        				{
		    						Screen1.score = 50000;
		        				}
		        				if(Target.sc==5)
		        				{
		    						Screen1.score = 100000;
		        				}
		        			}
	        			}
	    				JOptionPane.showMessageDialog(null, "Sorry your answer was wrong. You have won " + Screen1.score);
						int res = JOptionPane.showOptionDialog(null, "Would you like to play again?", "Wrong answer", JOptionPane.ERROR_MESSAGE,
		        		        JOptionPane.INFORMATION_MESSAGE, null, null, null);
		        		if(res==0){
		    				Leaderboard.addScore(Screen1.score);
		        			Screen1 s=new Screen1();
		        			s.setVisible(true);
		    				Screen1.score = 0;
		    				Screen1.life1 = 0;
		    				Screen1.life2 = 0;
		    				Screen1.life3 = 0;
		    				rand = (int)(Math.random()*4+1);
							time.stop();
		    				Target.sc=0;
		    				Target.c=0;
		    				close();

		        		}
		        		else{
		    				Leaderboard.addScore(Screen1.score);
		        			System.exit(0);
		        		}
					}
				});
			option3.setBounds(339, 529, 169, 61);
			getContentPane().add(option3);
			
			 option4 = new JButton(ans);
			option4.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg){
					if(Target.sc==6 && Target.c != 1)
					{
						Target.c = 1;
						Screen1.score = 300000;
					}
					else
					{
						Screen1.score = 0;
					}
					
					if (Target.c == 1)
					{
						Screen1.score = 300000;
					}
					time.stop();
					Screen8 s=new Screen8();
					s.setVisible(true);
					close();
    				rand = (int)(Math.random()*4+1);
				}
			});
			option4.setBounds(655, 529, 169, 61);
			getContentPane().add(option4);
		}
		
		//When call a friend line button is pressed by the user this following code decides the dialog to use theres an equal chance of getting the right ans or a wrong ans
		//from the "friend".
		Screen1.button = new JButton();
		Screen1.button.addActionListener(new ActionListener() {
			/**
			 * action executed when button is pressed.
			 * If the random number generated by dice is odd the user if given right answer from the 4 options.
			 * if the random number generated by dice is even the user is given the wrong answer.
			 */
			public void actionPerformed(ActionEvent e) {
				Screen1.life1=1;
				Screen1.button.setIcon(ll1used);
				
				//If the number ans is in option 1 give the ans from button1 or give the wrong ans.
				if(change==1){
					//odd number dice gives ans
					if(dice==1||dice==3||dice==5){
						 JOptionPane.showOptionDialog(null,
								"hm....let see"+"\n well I'm no expert but.. I think the answer is"+ans,
							    "Siri at your service",
							    JOptionPane.YES_NO_OPTION,
							    JOptionPane.QUESTION_MESSAGE,
							    null,     //do not use a custom Icon
							    options,  //the titles of buttons
							    options[0]); //default button title

					}
					//even dice number gives wrong ans in the message from "the friend".
					else if(dice==2){
						 JOptionPane.showOptionDialog(null,
								"hm....let see"+"\n well I'm no expert but.. I think the answer is"+op2,
							    "Siri at your service",
							    JOptionPane.YES_NO_OPTION,
							    JOptionPane.QUESTION_MESSAGE,
							    null,     //do not use a custom Icon
							    options,  //the titles of buttons
							    options[0]); //default button title
					}
					//even dice number gives wrong ans in the message from "the friend".
					else if(dice==4){
						 JOptionPane.showOptionDialog(null,
								"hm....let see"+"\n well I'm no expert but.. I think the answer is"+op3,
							    "Siri at your service",
							    JOptionPane.YES_NO_OPTION,
							    JOptionPane.QUESTION_MESSAGE,
							    null,     //do not use a custom Icon
							    options,  //the titles of buttons
							    options[0]); //default button title

					}
					//even dice number gives wrong ans in the message from "the friend".
					else if(dice==6){
						JOptionPane.showOptionDialog(null,
								"hm....let see"+"\n well I'm no expert but.. I think the answer is"+op4,
							    "Siri at your service",
							    JOptionPane.YES_NO_OPTION,
							    JOptionPane.QUESTION_MESSAGE,
							    null,     //do not use a custom Icon
							    options,  //the titles of buttons
							    options[0]); //default button title

					}
				}
				//if the ans is in button 2 and the number from the dice is odd give the ans or give the wrong ans if the number is even
				else if(change==2){
					//odd number dice gives ans
					if(dice==1||dice==3||dice==5){
						JOptionPane.showOptionDialog(null,
								"hm....let see"+"\n well I'm no expert but.. I think the answer is"+ans,
							    "Siri at your service",
							    JOptionPane.YES_NO_OPTION,
							    JOptionPane.QUESTION_MESSAGE,
							    null,     //do not use a custom Icon
							    options,  //the titles of buttons
							    options[0]); //default button title
					}
					//even dice number gives wrong ans in the message from "the friend".
					else if(dice==2){
						JOptionPane.showOptionDialog(null,
								"hm....let see"+"\n well I'm no expert but.. I think the answer is"+op1,
							    "Siri at your service",
							    JOptionPane.YES_NO_OPTION,
							    JOptionPane.QUESTION_MESSAGE,
							    null,     //do not use a custom Icon
							    options,  //the titles of buttons
							    options[0]); //default button title
					}
					//even dice number gives wrong ans in the message from "the friend".
					else if(dice==4){
						JOptionPane.showOptionDialog(null,
								"hm....let see"+"\n well I'm no expert but.. I think the answer is"+op3,
							    "Siri at your service",
							    JOptionPane.YES_NO_OPTION,
							    JOptionPane.QUESTION_MESSAGE,
							    null,     //do not use a custom Icon
							    options,  //the titles of buttons
							    options[0]); //default button title
					}
					//even dice number gives wrong ans in the message from "the friend".
					else if(dice==6){
						JOptionPane.showOptionDialog(null,
								"hm....let see"+"\n well I'm no expert but.. I think the answer is"+op4,
							    "Siri at your service",
							    JOptionPane.YES_NO_OPTION,
							    JOptionPane.QUESTION_MESSAGE,
							    null,     //do not use a custom Icon
							    options,  //the titles of buttons
							    options[0]); //default button title
					}
				}
				
				//if the ans is in button 3 and the number from the dice is odd give the ans or give the wrong ans if the number is even
				else if(change==3){
					//odd number dice gives ans
					if(dice==1||dice==3||dice==5){
						 JOptionPane.showOptionDialog(null,
								"hmm....let see"+"\n well I'm no expert but.. I think the answer is"+ans,
							    "Siri at your service",
							    JOptionPane.YES_NO_OPTION,
							    JOptionPane.QUESTION_MESSAGE,
							    null,     //do not use a custom Icon
							    options,  //the titles of buttons
							    options[0]); //default button title
					}
					//even dice number gives wrong ans in the message from "the friend".
					else if(dice==2){
						JOptionPane.showOptionDialog(null,
								"hm....let see"+"\n well I'm no expert but.. I think the answer is"+op2,
							    "Siri at your service",
							    JOptionPane.YES_NO_OPTION,
							    JOptionPane.QUESTION_MESSAGE,
							    null,     //do not use a custom Icon
							    options,  //the titles of buttons
							    options[0]); //default button title
					}
					//even dice number gives wrong ans in the message from "the friend".
					else if(dice==4){
						JOptionPane.showOptionDialog(null,
								"hm....let see"+"\n well I'm no expert but.. I think the answer is"+op1,
							    "Siri at your service",
							    JOptionPane.YES_NO_OPTION,
							    JOptionPane.QUESTION_MESSAGE,
							    null,     //do not use a custom Icon
							    options,  //the titles of buttons
							    options[0]); //default button title
					}
					//even dice number gives wrong ans in the message from "the friend".
					else if(dice==6){
						 JOptionPane.showOptionDialog(null,
								"hm....let see"+"\n well I'm no expert but.. I think the answer is"+op4,
							    "Siri at your service",
							    JOptionPane.YES_NO_OPTION,
							    JOptionPane.QUESTION_MESSAGE,
							    null,     //do not use a custom Icon
							    options,  //the titles of buttons
							    options[0]); //default button title
					}
				}
				
				//if the ans is in button 4 and the number from the dice is odd give the ans or give the wrong ans if the number is even
				else if(change==4){
					//odd number dice gives ans
					if(dice==1||dice==3||dice==5){
						 JOptionPane.showOptionDialog(null,
								"hm....let see"+"\n well I'm no expert but.. I think the answer is"+ans,
							    "Siri at your service",
							    JOptionPane.YES_NO_OPTION,
							    JOptionPane.QUESTION_MESSAGE,
							    null,     //do not use a custom Icon
							    options,  //the titles of buttons
							    options[0]); //default button title
					}
					//even dice number gives wrong ans in the message from "the friend".
					else if(dice==2){
						 JOptionPane.showOptionDialog(null,
								"hm....let see"+"\n well I'm no expert but.. I think the answer is"+op2,
							    "Siri at your service",
							    JOptionPane.YES_NO_OPTION,
							    JOptionPane.QUESTION_MESSAGE,
							    null,     //do not use a custom Icon
							    options,  //the titles of buttons
							    options[0]); //default button title
					}
					//even dice number gives wrong ans in the message from "the friend".
					else if(dice==4){
						 JOptionPane.showOptionDialog(null,
								"hm....let see"+"\n well I'm no expert but.. I think the answer is"+op3,
							    "Siri at your service",
							    JOptionPane.YES_NO_OPTION,
							    JOptionPane.QUESTION_MESSAGE,
							    null,     //do not use a custom Icon
							    options,  //the titles of buttons
							    options[0]); //default button title
					}
					//even dice number gives wrong ans in the message from "the friend".
					else if(dice==6){
						 JOptionPane.showOptionDialog(null,
								"hm....let see"+"\n well I'm no expert but.. I think the answer is"+op1,
							    "Siri at your service",
							    JOptionPane.YES_NO_OPTION,
							    JOptionPane.QUESTION_MESSAGE,
							    null,     //do not use a custom Icon
							    options,  //the titles of buttons
							    options[0]); //default button title
					}
				}

				
			}
		});
		
		Screen1.button.setIcon(ll1);
		Screen1.button.setBounds(41, 30, 143, 77);
		getContentPane().add(Screen1.button);
		
		//if user uses the 50-50 life then it removes 2 wrong option from the game
				Screen1.button_1 = new JButton();
				Screen1.button_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//if change is equal to 1 then remove option 2 and option 4 from the question and sets life1 global variable to 1 
						if(change==1)
						{
								Screen1.life2=1;
							   option2.setVisible(false);
							   option4.setVisible(false);
							   Screen1.button_1.setIcon(ll2used);
						}
						//if change is equal to 1 then remove option 3 and option 1 from the question and sets life1 global variable to 1 
						if(change==2)
						{
							Screen1.life2=1;
							   option3.setVisible(false);
							   option1.setVisible(false);
							   Screen1.button_1.setIcon(ll2used);
						}
						//if change is equal to 1 then remove option 1 and option 4 from the question and sets life1 global variable to 1 
						if(change==3)
						{
							Screen1.life2=1;
							   option1.setVisible(false);
							   option4.setVisible(false);
							   Screen1.button_1.setIcon(ll2used);
						}
						//if change is equal to 1 then remove option 2 and option 3 from the question and sets life1 global variable to 1 
						if(change==4)
						{
							Screen1.life2=1;
							   option2.setVisible(false);
							   option3.setVisible(false);
							Screen1.button_1.setIcon(ll2used);
						}
					}
				});
				Screen1.button_1.setIcon(ll2);
				Screen1.button_1.setBounds(244, 30, 160, 77);
				getContentPane().add(Screen1.button_1);
				
		//if user selects the audience poll lifeline then it changes the icons and sets the life3 variable to 1 and open the audience pollscreen
		Screen1.button_2 = new JButton();
		Screen1.button_2.setIcon(ll3);
		Screen1.button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Screen1.life3=1;
				Screen1.audience = 6;
				Screen1.button_2.setIcon(ll3used);
				AudiencePoll s=new AudiencePoll();
				s.setVisible(true);

				
			}
		});
		
		
		// if lifeline 2 is already used the it disable that button
		if(Screen1.life2 == 1)
		{
			Screen1.button_1.setIcon(ll2used);
			Screen1.button_1.setEnabled(false);
		}
		else
		{
		Screen1.button_1.setIcon(ll2);
		}

		// if lifeline 1 is already used the it disable that button
		if(Screen1.life1 == 1)
		{
			Screen1.button.setIcon(ll1used);
			Screen1.button.setEnabled(false);
		}
		else
		{
		Screen1.button.setIcon(ll1);
		}

		// if lifeline 3 is already used the it disable that button
		if(Screen1.life3 == 1)
		{
			Screen1.button_2.setIcon(ll3used);
			Screen1.button_2.setEnabled(false);
		}
		else
		{
			Screen1.button_2.setIcon(ll3);
		}

		Screen1.button_2.setBounds(455, 30, 160, 77);
		getContentPane().add(Screen1.button_2);
		
		
		
		//Score bar with the label score
				JLabel lblYourScore = new JLabel("Your Score: $" + Screen1.score);
				lblYourScore.setForeground(Color.WHITE);
				lblYourScore.setBounds(52, 169, 165, 14);
				getContentPane().add(lblYourScore);

				//Score bar with the label $5000
				JLabel lblNewLabel_2 = new JLabel("$1000");
				lblNewLabel_2.setFont(new Font("SimSun", Font.BOLD, 24));
				lblNewLabel_2.setForeground(new Color(255, 255, 255));
				lblNewLabel_2.setBounds(979, 575, 227, 30);
				getContentPane().add(lblNewLabel_2);
				
				//Score bar with the label $5000
				JLabel label = new JLabel("$5000");
				label.setForeground(Color.WHITE);
				label.setFont(new Font("SimSun", Font.BOLD, 24));
				label.setBounds(979, 540, 227, 30);
				getContentPane().add(label);
				
				//Score bar with the label $10000
				JLabel label_1 = new JLabel("$10000");
				label_1.setForeground(Color.WHITE);
				label_1.setFont(new Font("SimSun", Font.BOLD, 24));
				label_1.setBounds(979, 499, 227, 30);
				getContentPane().add(label_1);
				
				//Score bar with the label $50000
				JLabel label_2 = new JLabel("$50000");
				label_2.setForeground(Color.WHITE);
				label_2.setFont(new Font("SimSun", Font.BOLD, 24));
				label_2.setBounds(979, 458, 227, 30);
				getContentPane().add(label_2);
				
				//Score bar with the label $100000
				JLabel label_3 = new JLabel("$100000");
				label_3.setForeground(Color.WHITE);
				label_3.setFont(new Font("SimSun", Font.BOLD, 24));
				label_3.setBounds(979, 417, 227, 30);
				getContentPane().add(label_3);
			
				//Score bar with the label $300000
				JLabel label_4 = new JLabel("$300000");
				label_4.setForeground(Color.WHITE);
				label_4.setFont(new Font("SimSun", Font.BOLD, 24));
				label_4.setBounds(979, 376, 227, 30);
				getContentPane().add(label_4);
				
				//Score bar with the label $500000
				JLabel label_5 = new JLabel("$500000");
				label_5.setForeground(Color.WHITE);
				label_5.setFont(new Font("SimSun", Font.BOLD, 24));
				label_5.setBounds(979, 335, 227, 30);
				getContentPane().add(label_5);
				
				//Score bar with the label $1000000
				JLabel label_6 = new JLabel("$1000000");
				label_6.setForeground(Color.WHITE);
				label_6.setFont(new Font("SimSun", Font.BOLD, 24));
				label_6.setBounds(979, 296, 227, 30);
				getContentPane().add(label_6);
				
				JPanel panel = new JPanel();
				panel.setBackground(Color.BLACK);
				panel.setBounds(968, 376, 113, 36);
				getContentPane().add(panel);
				
				//Score bar with the label Score bar
				JLabel lblScoreBar = new JLabel("SCORE BAR");
				lblScoreBar.setForeground(Color.WHITE);
				lblScoreBar.setBackground(Color.WHITE);
				lblScoreBar.setFont(new Font("OCR A Extended", Font.BOLD, 48));
				lblScoreBar.setBounds(918, 222, 288, 70);
				getContentPane().add(lblScoreBar);
				
				//quit button if user wants to leave the game in between taking the winning amount
				JButton btnQuit = new JButton("Quit");
				btnQuit.setFont(new Font("Footlight MT Light", Font.BOLD, 29));
				btnQuit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//ask user that he is sure about quitting the game with yes and no option
						int quit = JOptionPane.showOptionDialog(null, "Are you sure you want to Quit?", "Quit", JOptionPane.ERROR_MESSAGE,
		        		        JOptionPane.INFORMATION_MESSAGE, null, null, null);
		        		//if user says yes then dsplays users winning amount and ask user to play the game again
						if(quit==0){
		    				Leaderboard.addScore(Screen1.score);
		    				JOptionPane.showMessageDialog(null, "You have won " + Screen1.score);
							int res = JOptionPane.showOptionDialog(null, "Would you like to play again?", "Play Again?", JOptionPane.ERROR_MESSAGE,
			        		        JOptionPane.INFORMATION_MESSAGE, null, null, null);
							//if user wants to play the game again then it resets the score, lifelines and targets of all users
			        		if(res==0){
			    				Leaderboard.addScore(Screen1.score);
			        			Screen1 s=new Screen1();
			        			s.setVisible(true);
			    				Screen1.score = 0;
			    				Screen1.life1 = 0;
			    				Screen1.life2 = 0;
			    				Screen1.life3 = 0;
								time.stop();
			    				Target.sc=0;
			    				Target.c=0;
			    				close();
			    				rand = (int)(Math.random()*4+1);

			        		}
			        		//else closes the screen
			        		else{
			    				Leaderboard.addScore(Screen1.score);
			        			System.exit(0);
			        		}
		        		}
		        		else{

		        		}
						
					}
				});
				btnQuit.setBounds(262, 134, 121, 37);
				getContentPane().add(btnQuit);
						
				JMenuBar menuBar = new JMenuBar();
				setJMenuBar(menuBar);
				
				JMenu mnFile = new JMenu("File");
				menuBar.add(mnFile);
				
				//menu item new game that resets the game
				JMenuItem ng = new JMenuItem("New Game");
				ng.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0){
						Screen1 s=new Screen1();
						Leaderboard.addScore(Screen1.score);
						Screen1.score = 0;
						Screen1.life1 = 0;
						Screen1.life2 = 0;
						Screen1.life3 = 0;
						Target.sc=0;
						Target.c=0;
						time.stop();
						s.setVisible(true);
						close();
						rand = (int)(Math.random()*4+1);
					}
				});
				mnFile.add(ng);
				//options menu item that has leaderboard
				JMenu mnNewMenu = new JMenu("Options");
				mnNewMenu.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				menuBar.add(mnNewMenu);
				
				JMenuItem mntmNewMenuItem = new JMenuItem("Leaderboard\r\n");
				mntmNewMenuItem.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Leaderboard s= new Leaderboard();
						s.setVisible(true);
					}
				});
				mnNewMenu.add(mntmNewMenuItem);
			
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmRules = new JMenuItem("rules");
		mntmRules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Help s=new Help();
				s.setVisible(true);
			}
		});
		mnHelp.add(mntmRules);
	
	}
	/**
	 * method used to close the current screen.
	 */
	public void close(){
		this.setVisible(false);
	}
	
	/**
	 * 
	 * The frame is created and shown
	 */
public static void main(String[] args)  {
		
	
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Screen7 frame = new Screen7();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
