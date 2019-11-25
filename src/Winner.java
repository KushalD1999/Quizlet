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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class Winner extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 * The main method is used to create an instance of the frame using JFrame.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Winner frame = new Winner();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
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
	 * Create the frame.
	 * The constructor instantiated to create the winner screen.
	 */
	public Winner() {
		
		
		//file that plays the sound in the game accessing the method Playsound
		File Clap = new File ("winn.wav");
		PlaySound(Clap);
		
		getContentPane().setBackground(new Color(0, 0, 51));
		getContentPane().setLayout(null);
		
		//Layout and dimensions of the winner screen
		JLabel lblWinner = new JLabel("WINNER");
		lblWinner.setFont(new Font("Jokerman", Font.BOLD, 99));
		lblWinner.setForeground(Color.WHITE);
		lblWinner.setBounds(387, 184, 486, 148);
		getContentPane().add(lblWinner);
		
		JLabel lblCongratulationsYouHave = new JLabel("Congratulations You Have won 1 million Dollar!!");
		lblCongratulationsYouHave.setFont(new Font("Consolas", Font.PLAIN, 43));
		lblCongratulationsYouHave.setForeground(Color.WHITE);
		lblCongratulationsYouHave.setBounds(51, 217, 1223, 297);
		getContentPane().add(lblCongratulationsYouHave);
		
		//Reseting the instance variables in screen 1 if the player chooses to play again.
		JButton btnNewButton = new JButton("Play Again");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//reseting variables....
				Leaderboard.addScore(Screen1.score);
				Screen1 s=new Screen1();
				Screen1.score = 0;
				Screen1.life1 = 0;
				Screen1.life2 = 0;
				Screen1.life3 = 0;
				Target.sc=0;
				Target.c=0;

				s.setVisible(true);
				close();
			}
		});
		btnNewButton.setBounds(193, 525, 173, 61);
		getContentPane().add(btnNewButton);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(768, 525, 173, 61);
		
		//dimensions of the frame.
		getContentPane().add(btnExit);
		setTitle("Who wants to be a millionaire?");
		setSize(1250,700);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	public void close(){
		this.setVisible(false);
	}
}
