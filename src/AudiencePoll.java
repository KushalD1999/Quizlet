import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;

public class AudiencePoll extends JFrame {

	private JPanel contentPane;
	private static String ans;
	private static String op1;
	private static String op2;
	private static String op3;
	private static String op4;
	private static String q1;
	
	

	/**
	 * Launch the application.
	 * Creating instance of the frame.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AudiencePoll frame = new AudiencePoll();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * constructor of the class that creates the screen every time it is instantiated.
	 */
	public AudiencePoll() {
		//the dimensions and format of the screen.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 25, 416, 277);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Checks if which screen question is the lifeline used.
		//The statistics generated for question 1 using the question1 file.
		if (Screen1.audience==1)
		{
			//basic file reading algorithm as used before to generate question.
			String[] splitted = new String[50];
			try{
				  // Open the file
				  FileInputStream fstream = new FileInputStream("Question1.txt");
				  // Get the object of DataInputStream
				  DataInputStream in = new DataInputStream(fstream);
				  BufferedReader br = new BufferedReader(new InputStreamReader(in));
				  String strLine = null;
				  //Read File Line By Line
				  for (int i = 0; i < Screen2.rand; i++)
				  {
					  strLine = br.readLine();
				  }
				     splitted = strLine.split("-"); // here - is used as the delimiter

				  //Close the input stream
				  in.close();
				    }catch (Exception e){//Catch exception if any
				  System.out.println("Error: " + e.getMessage());
				  }

			q1 = "Question 1: " + splitted[0];
			op1 = splitted[1];
			op2 = splitted[2];
			op3 = splitted[3];
			op4 = splitted[4];
			ans = splitted[5];
			

		}
		//The statistics generated for question 2 using the question2 file.
		if (Screen1.audience==2)
		{
			//basic file reading algorithm as used before to generate question.
			String[] splitted = new String[50];
			try{
				  // Open the file
				  FileInputStream fstream = new FileInputStream("Question2.txt");
				  // Get the object of DataInputStream
				  DataInputStream in = new DataInputStream(fstream);
				  BufferedReader br = new BufferedReader(new InputStreamReader(in));
				  String strLine = null;
				  //Read File Line By Line
				  for (int i = 0; i < Screen3.rand; i++)
				  {
					  strLine = br.readLine();
				  }
				     splitted = strLine.split("-"); // here - is used as the delimiter

				  //Close the input stream
				  in.close();
				    }catch (Exception e){//Catch exception if any
				  System.out.println("Error: " + e.getMessage());
				  }

			q1 = "Question 2: " + splitted[0];
			op1 = splitted[1];
			op2 = splitted[2];
			op3 = splitted[3];
			op4 = splitted[4];
			ans = splitted[5];
			

		}
		//The statistics generated for question 3 using the question3 file.
		if (Screen1.audience==3)
		{
			//basic file reading algorithm as used before to generate question.
			String[] splitted = new String[50];
			try{
				  // Open the file
				  FileInputStream fstream = new FileInputStream("Question3.txt");
				  // Get the object of DataInputStream
				  DataInputStream in = new DataInputStream(fstream);
				  BufferedReader br = new BufferedReader(new InputStreamReader(in));
				  String strLine = null;
				  //Read File Line By Line
				  for (int i = 0; i < Screen4.rand; i++)
				  {
					  strLine = br.readLine();
				  }
				     splitted = strLine.split("-"); // here - is used as the delimiter

				  //Close the input stream
				  in.close();
				    }catch (Exception e){//Catch exception if any
				  System.out.println("Error: " + e.getMessage());
				  }

			q1 = "Question 3: " + splitted[0];
			op1 = splitted[1];
			op2 = splitted[2];
			op3 = splitted[3];
			op4 = splitted[4];
			ans = splitted[5];
			

		}
		//The statistics generated for question 4 using the question4 file.
		if (Screen1.audience==4)
		{
			//basic file reading algorithm as used before to generate question.
			String[] splitted = new String[50];
			try{
				  // Open the file
				  FileInputStream fstream = new FileInputStream("Question4.txt");
				  // Get the object of DataInputStream
				  DataInputStream in = new DataInputStream(fstream);
				  BufferedReader br = new BufferedReader(new InputStreamReader(in));
				  String strLine = null;
				  //Read File Line By Line
				  for (int i = 0; i < Screen5.rand; i++)
				  {
					  strLine = br.readLine();
				  }
				     splitted = strLine.split("-"); // here - is used as the delimiter

				  //Close the input stream
				  in.close();
				    }catch (Exception e){//Catch exception if any
				  System.out.println("Error: " + e.getMessage());
				  }

			q1 = "Question 4: " + splitted[0];
			op1 = splitted[1];
			op2 = splitted[2];
			op3 = splitted[3];
			op4 = splitted[4];
			ans = splitted[5];
			

		}
		//The statistics generated for question 5 using the question5 file.
		if (Screen1.audience==5)
		{
			//basic file reading algorithm as used before to generate question.
			String[] splitted = new String[50];
			try{
				  // Open the file
				  FileInputStream fstream = new FileInputStream("Question5.txt");
				  // Get the object of DataInputStream
				  DataInputStream in = new DataInputStream(fstream);
				  BufferedReader br = new BufferedReader(new InputStreamReader(in));
				  String strLine = null;
				  //Read File Line By Line
				  for (int i = 0; i < Screen6.rand; i++)
				  {
					  strLine = br.readLine();
				  }
				     splitted = strLine.split("-"); // here - is used as the delimiter

				  //Close the input stream
				  in.close();
				    }catch (Exception e){//Catch exception if any
				  System.out.println("Error: " + e.getMessage());
				  }

			q1 = "Question 5: " + splitted[0];
			op1 = splitted[1];
			op2 = splitted[2];
			op3 = splitted[3];
			op4 = splitted[4];
			ans = splitted[5];
			

		}
		//The statistics generated for question 6 using the question6 file.
		if (Screen1.audience==6)
		{
			//basic file reading algorithm as used before to generate question.
			String[] splitted = new String[50];
			try{
				  // Open the file
				  FileInputStream fstream = new FileInputStream("Question6.txt");
				  // Get the object of DataInputStream
				  DataInputStream in = new DataInputStream(fstream);
				  BufferedReader br = new BufferedReader(new InputStreamReader(in));
				  String strLine = null;
				  //Read File Line By Line
				  for (int i = 0; i < Screen7.rand; i++)
				  {
					  strLine = br.readLine();
				  }
				     splitted = strLine.split("-"); // here - is used as the delimiter

				  //Close the input stream
				  in.close();
				    }catch (Exception e){//Catch exception if any
				  System.out.println("Error: " + e.getMessage());
				  }

			q1 = "Question 3: " + splitted[0];
			op1 = splitted[1];
			op2 = splitted[2];
			op3 = splitted[3];
			op4 = splitted[4];
			ans = splitted[5];
			

		}
		//The statistics generated for question 7 using the question7 file.
		if (Screen1.audience==7)
		{
			//basic file reading algorithm as used before to generate question.
			String[] splitted = new String[50];
			try{
				  // Open the file
				  FileInputStream fstream = new FileInputStream("Question7.txt");
				  // Get the object of DataInputStream
				  DataInputStream in = new DataInputStream(fstream);
				  BufferedReader br = new BufferedReader(new InputStreamReader(in));
				  String strLine = null;
				  //Read File Line By Line
				  for (int i = 0; i < Screen8.rand; i++)
				  {
					  strLine = br.readLine();
				  }
				     splitted = strLine.split("-"); // here - is used as the delimiter

				  //Close the input stream
				  in.close();
				    }catch (Exception e){//Catch exception if any
				  System.out.println("Error: " + e.getMessage());
				  }

			q1 = "Question 7: " + splitted[0];
			op1 = splitted[1];
			op2 = splitted[2];
			op3 = splitted[3];
			op4 = splitted[4];
			ans = splitted[5];
			

		}
		
		//The statistics generated for question 8 using the question8 file.
		if (Screen1.audience==8)
		{
			//basic file reading algorithm as used before to generate question.
			String[] splitted = new String[50];
			try{
				  // Open the file
				  FileInputStream fstream = new FileInputStream("Question8.txt");
				  // Get the object of DataInputStream
				  DataInputStream in = new DataInputStream(fstream);
				  BufferedReader br = new BufferedReader(new InputStreamReader(in));
				  String strLine = null;
				  //Read File Line By Line
				  for (int i = 0; i < Screen9.rand; i++)
				  {
					  strLine = br.readLine();
				  }
				     splitted = strLine.split("-"); // here - is used as the delimiter

				  //Close the input stream
				  in.close();
				    }catch (Exception e){//Catch exception if any
				  System.out.println("Error: " + e.getMessage());
				  }

			q1 = "Question 8: " + splitted[0];
			op1 = splitted[1];
			op2 = splitted[2];
			op3 = splitted[3];
			op4 = splitted[4];
			ans = splitted[5];
			

		}
		
		JLabel lblNewLabel = new JLabel("Audience poll: "+q1);
		lblNewLabel.setBounds(60, 60, 291, 29);
		contentPane.add(lblNewLabel);
		
		
			JLabel lblNewLabel_1 = new JLabel(op2 + " - 13%");
			lblNewLabel_1.setBounds(60, 123, 115, 14);
			contentPane.add(lblNewLabel_1);
			
			
			JLabel lblNewLabel_2 = new JLabel(op3 + " - 7%");
			lblNewLabel_2.setBounds(60, 158, 115, 14);
			contentPane.add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel(op4 + " - 20%");
			lblNewLabel_3.setBounds(271, 123, 119, 14);
			contentPane.add(lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel(ans + " - 60%");
			lblNewLabel_4.setBounds(269, 158, 121, 14);
			contentPane.add(lblNewLabel_4);
			
			JLabel lblAudiencePoll = new JLabel("AUDIENCE POLL");
			lblAudiencePoll.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 32));
			lblAudiencePoll.setBounds(98, 0, 257, 57);
			contentPane.add(lblAudiencePoll);
			
			JButton btnClose = new JButton("Close");
			btnClose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
	        		close();
				}
			});
			btnClose.setBounds(161, 196, 89, 23);
			contentPane.add(btnClose);

	
		
		
	}
	
	protected void close() {
		// TODO Auto-generated method stub
		this.setVisible(false);
	}
}
