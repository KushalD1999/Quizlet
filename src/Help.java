import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window;


import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.Color;


public class Help extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Help frame = new Help();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * This frame has all the rules of the game that the user may want to know.
	 */
	public Help() {
		getContentPane().setBackground(new Color(0, 0, 51));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Who wants to be a millionaire?");
		setResizable(false);
        setSize(1000, 700);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        
        JLabel lblHelp = new JLabel("Help");
        lblHelp.setForeground(new Color(255, 255, 255));
        lblHelp.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 58));
        lblHelp.setBounds(397, 29, 345, 65);
        getContentPane().add(lblHelp);
        
        JButton btnOk = new JButton("Ok");
        btnOk.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		close();
        	}
        });
        
        btnOk.setBounds(395, 548, 154, 58);
        getContentPane().add(btnOk);
        
        //The rules of the game.
        JLabel lblNewLabel = new JLabel("-Enter your name when the game is started.\r\n");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(36, 107, 934, 38);
        getContentPane().add(lblNewLabel);
        
        JLabel lblyouMustSelect = new JLabel("-You must select a target score before you start playing.");
        lblyouMustSelect.setForeground(Color.WHITE);
        lblyouMustSelect.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblyouMustSelect.setBounds(36, 147, 934, 38);
        getContentPane().add(lblyouMustSelect);
        
        JLabel lblifTheTarget = new JLabel("-If the target you selected is not reached and you lose, the amount you win will be $0.");
        lblifTheTarget.setForeground(Color.WHITE);
        lblifTheTarget.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblifTheTarget.setBounds(36, 183, 934, 38);
        getContentPane().add(lblifTheTarget);
        
        JLabel lblthereAre = new JLabel("-There are 3 lifelines you can choose from( can only be used once):");
        lblthereAre.setForeground(Color.WHITE);
        lblthereAre.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblthereAre.setBounds(36, 217, 934, 38);
        getContentPane().add(lblthereAre);
        
        JLabel lblCallA = new JLabel("1) Call A Friend, A friend will give you advice on which option to choose, may not be the answer.");
        lblCallA.setForeground(Color.WHITE);
        lblCallA.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblCallA.setBounds(36, 259, 934, 38);
        getContentPane().add(lblCallA);
        
        JLabel lblThe = new JLabel("2) 50/50, the options will be reduced to 2 from which one will be the right answer. ");
        lblThe.setForeground(Color.WHITE);
        lblThe.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblThe.setBounds(36, 310, 934, 38);
        getContentPane().add(lblThe);
        
        JLabel lblaudienceStatisticsBased = new JLabel("3)Audience, statistics based on the audiences' response.");
        lblaudienceStatisticsBased.setForeground(Color.WHITE);
        lblaudienceStatisticsBased.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblaudienceStatisticsBased.setBounds(36, 352, 934, 38);
        getContentPane().add(lblaudienceStatisticsBased);
        
        JLabel lblyouWillHave = new JLabel("-You will have the opportunity to quit anytime you want, but you will walk away with the amount ");
        lblyouWillHave.setForeground(Color.WHITE);
        lblyouWillHave.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblyouWillHave.setBounds(36, 391, 934, 58);
        getContentPane().add(lblyouWillHave);
        
        JLabel lblYouHaveRight = new JLabel("you have right now.");
        lblYouHaveRight.setForeground(Color.WHITE);
        lblYouHaveRight.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblYouHaveRight.setBounds(36, 422, 934, 58);
        getContentPane().add(lblYouHaveRight);
        
        JLabel lblifYouQuit = new JLabel("-If you quit before reaching your target you will walk away with no money.");
        lblifYouQuit.setForeground(Color.WHITE);
        lblifYouQuit.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblifYouQuit.setBounds(36, 462, 934, 58);
        getContentPane().add(lblifYouQuit);
	}
	
	//method that closes the screen.
	protected void close() {
		// TODO Auto-generated method stub
		this.setVisible(false);
	}
}
