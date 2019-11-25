import java.awt.EventQueue;

import sun.audio.*;
import java.io.FileInputStream;



import java.awt.Graphics;

import javax.swing.JFrame;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

public class Screen1 extends JFrame{
	
	private ImageIcon img=new ImageIcon("lg.png");
	public static int score = 0;
	static JButton button;
	static JButton button_1;
	static JButton button_2;
	public static int audience = 0;
	
	public static int life1 = 0;
	public static int life2 = 0;
	public static int life3 = 0;
    private String name;
	public static int stop = 0;
    private JTextField textField;

	public static void main(String[] args) throws IOException, LineUnavailableException, UnsupportedAudioFileException{
		
		JFrame frame=new Screen1();
		frame.show();
		Screen1 s=new Screen1();
		//Background sound
		File Clap = new File ("theme.wav");
		// gets the clip
		Clip clip = AudioSystem.getClip();
		clip.open(AudioSystem.getAudioInputStream(Clap));
		//start the clip to play
		clip.start();
	}


	/**
	 * Constructor with all play botton , exit button, leaderboard button 
	 */
	public Screen1()  {
		//color
		getContentPane().setBackground(new Color(0, 0, 51));
		//sets the tittle of the screen
		setTitle("Who wants to be a millionaire?");
		//overall size of the screen
		setSize(1250,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		//Play button on the main that allows the game to continue further
		JButton play = new JButton("PLAY");
		//sets the font and its size
		play.setFont(new Font("Cambria Math", Font.PLAIN, 29));
		play.addActionListener(new ActionListener() {
			//action performed when th play botton is clicked
			public void actionPerformed(ActionEvent arg0) {
				// goes to the target screen(target class)
				Target s= new Target();
				s.setVisible(true);
				//close this screen/class
				close();
			}
		});
		play.setBounds(547, 436, 144, 50);
		getContentPane().add(play);
		
		//exit button
		JButton b2 = new JButton("EXIT");
		b2.setFont(new Font("Cambria Math", Font.PLAIN, 29));
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				//closes the game when exit putton is presed
				System.exit(0);
			}
		});
		b2.setBounds(547, 558, 144, 50);
		getContentPane().add(b2);
		
		JLabel lblNewLabel = new JLabel(){
			 public void paintComponent(Graphics g) {
			        g.drawImage(img.getImage(), 0, 0, 300,208,null);
			        super.paintComponent(g);
			      }
		};
		lblNewLabel.setBackground(new Color(0, 51, 153));
		lblNewLabel.setBounds(473, 76, 476, 226);
		getContentPane().add(lblNewLabel);
		
		//leaderboard button that pops up the leaderboard with scores and players
		JButton btnLeaderboard = new JButton("LEADERBOARD");
		btnLeaderboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//opens leaderboard class 
				Leaderboard s= new Leaderboard();
				s.setVisible(true);
			}
		});
		btnLeaderboard.setFont(new Font("Cambria Math", Font.PLAIN, 21));
		btnLeaderboard.setBounds(410, 497, 189, 50);
		getContentPane().add(btnLeaderboard);
		
		//Rules button that pops up the reules page with all the game rules
		JButton btnRules = new JButton("RULES");
		btnRules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Help s= new Help();
				s.setVisible(true);
			}
		});
		btnRules.setFont(new Font("Cambria Math", Font.PLAIN, 21));
		btnRules.setBounds(630, 497, 189, 50);
		getContentPane().add(btnRules);
		
		
		
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField.setBounds(454, 387, 349, 31);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Please enter your name:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Stencil", Font.BOLD, 20));
		lblNewLabel_1.setBounds(145, 385, 299, 33);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name=textField.getText();
				textField.setText("Thank your name is saved");
				Leaderboard.addName(name);
			}
		});
		btnEnter.setBounds(826, 387, 97, 31);
		getContentPane().add(btnEnter);
		
		
		
		//menubar on the top of the screen
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		//menu bar option called file
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		//menu bar option called options
		JMenuItem mntmOptions = new JMenuItem("Options");
		mnFile.add(mntmOptions);
		
		//menu bar option called file
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		//menu item
		JMenuItem mntmRules = new JMenuItem("rules");
		mnHelp.add(mntmRules);
	}


	

	/**
	 * method to close the current screen
	 */
	public void close(){
		//changes setvisible function to false and closes the current screen
		this.setVisible(false);
	}
	}

