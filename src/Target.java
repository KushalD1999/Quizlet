import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import sun.audio.*;
import java.io.FileInputStream;
import java.io.IOException;
public class Target extends JFrame {

	private JPanel contentPane;
	
	public static int sc = 0;
	public static int c =0;
	public static boolean sou = true;


	/**
	 * Launch the application.
	 * @throws LineUnavailableException 
	 * @throws UnsupportedAudioFileException 
	 * @throws IOException 
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Target frame = new Target();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	

	/**
	 * Create the frame.
	 */
	public Target() {
		//backgorund sound for the target class
		File Clap = new File ("target.wav");
		//plays the sound by calling the method playsound
		PlaySound(Clap);
		getContentPane().setBackground(new Color(0, 0, 51));
		getContentPane().setLayout(null);
		
		//label on the top named target for user
		JLabel lblTarget = new JLabel("Target ");
		lblTarget.setFont(new Font("Rockwell", Font.BOLD, 83));
		lblTarget.setForeground(Color.WHITE);
		lblTarget.setBounds(474, -13, 357, 137);
		getContentPane().add(lblTarget);
		
		//button that allows usr to select $1000 as their target amount in the game
		JButton btnNewButton = new JButton("$1000");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//if the user selects $1000, then variable sc is set 1 that helps counting score
				sc=1;
				//Opens up the screen 2 class and close this class using method close
				Screen2 s= new Screen2();
				s.setVisible(true);
				close();			}
		});
		btnNewButton.setFont(new Font("Palatino Linotype", Font.BOLD, 31));
		btnNewButton.setBounds(543, 593, 155, 57);
		getContentPane().add(btnNewButton);
		
		//button that allows user to select $5000 as their target amount in the game
		JButton button = new JButton("$5000");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if the user selects $5000, then variable sc is set 1 that helps counting score
				sc=2;
				//Opens up the screen 2 class and close this class using method close
				Screen2 s= new Screen2();
				s.setVisible(true);
				close();
			}
		});
		button.setFont(new Font("Palatino Linotype", Font.BOLD, 31));
		button.setBounds(543, 526, 155, 57);
		getContentPane().add(button);
		
		//button that allows user to select $10000 as their target amount in the game
		JButton button_1 = new JButton("$10000");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if the user selects $10000, then variable sc is set 1 that helps counting score
				sc=3;
				//Opens up the screen 2 class and close this class using method close
				Screen2 s= new Screen2();
				s.setVisible(true);
				close();
			}
		});
		button_1.setFont(new Font("Palatino Linotype", Font.BOLD, 31));
		button_1.setBounds(543, 458, 155, 57);
		getContentPane().add(button_1);
		
		//button that allows user to select $50000 as their target amount in the game
		JButton button_2 = new JButton("$50000");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if the user selects $50000, then variable sc is set 1 that helps counting score
				sc=4;
				//Opens up the screen 2 class and close this class using method close
				Screen2 s= new Screen2();
				s.setVisible(true);
				close();
			}
		});
		button_2.setFont(new Font("Palatino Linotype", Font.BOLD, 31));
		button_2.setBounds(543, 390, 155, 57);
		getContentPane().add(button_2);
		
		//button that allows usr to select $100000 as their target amount in the game
		JButton button_3 = new JButton("$100000");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if the user selects $100000, then variable sc is set 1 that helps counting score
				sc=5;
				//Opens up the screen 2 class and close this class using method close
				Screen2 s= new Screen2();
				s.setVisible(true);
				close();
			}
		});
		button_3.setFont(new Font("Palatino Linotype", Font.BOLD, 31));
		button_3.setBounds(543, 322, 155, 57);
		getContentPane().add(button_3);
		
		//button that allows user to select $300000 as their target amount in the game
		JButton button_4 = new JButton("$3000000");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if the user selects $300000, then variable sc is set 1 that helps counting score
				sc=6;
				//Opens up the screen 2 class and close this class using method close
				Screen2 s= new Screen2();
				s.setVisible(true);
				close();
			}
		});
		button_4.setFont(new Font("Palatino Linotype", Font.BOLD, 30));
		button_4.setBounds(543, 254, 155, 57);
		getContentPane().add(button_4);
		
		
		//button that allows user to select $500000 as their target amount in the game
		JButton button_5 = new JButton("$500000");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if the user selects $500000, then variable sc is set 1 that helps counting score
				sc=7;
				//Opens up the screen 2 class and close this class using method close
				Screen2 s= new Screen2();
				s.setVisible(true);
				close();
			}
		});
		button_5.setFont(new Font("Palatino Linotype", Font.BOLD, 31));
		button_5.setBounds(543, 186, 155, 57);
		getContentPane().add(button_5);
		
		//button that allows user to select $1000000 as their target amount in the game
		JButton button_6 = new JButton("$1000000");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if the user selects $1000000, then variable sc is set 1 that helps counting score
				sc=8;
				//Opens up the screen 2 class and close this class using method close
				Screen2 s= new Screen2();
				s.setVisible(true);
				close();
			}
		});
		button_6.setFont(new Font("Palatino Linotype", Font.BOLD, 31));
		button_6.setBounds(512, 118, 221, 57);
		getContentPane().add(button_6);
		
		//back button in the game
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//goes back to screen 1 and closes this screen
				Screen1 s= new Screen1();
				s.setVisible(true);
				close();
				
			}
		});
		btnNewButton_1.setBounds(25, 26, 89, 23);
		getContentPane().add(btnNewButton_1);
		setTitle("Target");
		setSize(1250,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	/**
	 * Gets sound as a parameter and plays the sound by generating the clip
	 * @param sound
	 */
	public static void PlaySound(File sound)
	{

		try{
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(sound));
				clip.start();
				clip.loop(2);

		}
		catch(Exception e)
		{
			
		}
	}
	/**
	 * method to close the current screen
	 */
	public void close(){
		this.setVisible(false);
	}
}
