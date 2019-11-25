import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class Leaderboard extends JFrame {

	private final static int[]top10=new int[10];
	private String[] top10name;
	private static int[]s=null;
	private JTable table;
	private static final String newLine = System.getProperty("line.separator");
	private String name1;
	private String name2;
	private String name3;
	private String name4;
	private String name5;
	private String name6;
	private String name7;
	private String name8;
	private String name9;
	private String name10;
	private int count=0;

	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Leaderboard frame = new Leaderboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
		
		
	

	/**
	 * Create the frame.
	 * Reading and sorting of the scores and names files.
	 */
	public Leaderboard() {
		
		String[] splitted = new String[100];
		try{
			  // Open the file
			  FileInputStream fstream = new FileInputStream("scores.txt");
			  // Get the object of DataInputStream
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine = null;
			  //Read File Line By Line
			  	
			  	strLine = br.readLine();
			    splitted = strLine.split("-"); // here - is used as the delimiter

			  //Close the input stream
			  in.close();
			    }catch (Exception e){//Catch exception if any
			  System.out.println("Error: " + e.getMessage());
			}


		
		String[] splitted2 = new String[100];
		try{
			  // Open the file
			  FileInputStream fstream = new FileInputStream("names.txt");
			  // Get the object of DataInputStream
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine = null;
			  //Read File Line By Line
			  	
			  	strLine = br.readLine();
			    splitted2 = strLine.split("-"); // here - is used as the delimiter

			  //Close the input stream
			  in.close();
			    }catch (Exception e){//Catch exception if any
			  System.out.println("Error: " + e.getMessage());
			}
		
		
		
		String n[] = new String[100];
		
		int results[] = new int [100];
		
		//The contents of splitted arrays are entered into the scores and names arrays.
		for (int i = 0; i < splitted.length; i++) 
		{
		        results[i] = Integer.parseInt(splitted[i]);
		}
		for (int i = 0; i < splitted2.length; i++) 
		{
		        n[i] = splitted2[i];
		}
		
		//Sorting algorithm used to sort the scores and names arrays, selection sort was used to sort the score.
		for(int i=results.length-1;i>0;i--){
			int first=0;
			for(int x=1;x<=i;x++){
				if(results[x]<results[first]){
					first=x;
					
				}
			}
			int temp=results[first];
			String t=n[first];
			results[first]=results[i];
			n[first]=n[i];
			results[i]=temp;
			n[i]=t;
		}
		
		top10name=new String[10];
		
		for(int i=0;i<10;i++){
			top10name[i]=n[i];
		}		
		
		name1=top10name[0];
		name2=top10name[1];
		name3=top10name[2];
		name4=top10name[3];
		name5=top10name[4];
		name6=top10name[5];
		name7=top10name[6];
		name8=top10name[7];
		name9=top10name[8];
		name10=top10name[9];
		
		for(int i=0;i<10;i++){
			top10[i]=results[i];
		}
		
	
		getContentPane().setBackground(new Color(0, 0, 51));
		setForeground(new Color(0, 0, 51));
		getContentPane().setForeground(new Color(0, 0, 51));
		setTitle("Leaderboard");
		setSize(600,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		//format of the table from top player to the tenth.
		String[] columnNames={"Rank","Score"};
		Object[][]data={
				{"1."+name1,"$ "+top10[0]},
				{"2."+name2,"$ "+top10[1]},
				{"3."+name3,"$ "+top10[2]},
				{"4."+name4,"$ "+top10[3]},
				{"5."+name5,"$ "+top10[4]},
				{"6."+name6,"$ "+top10[5]},
				{"7."+name7,"$ "+top10[6]},
				{"8."+name8,"$ "+top10[7]},
				{"9."+name9,"$ "+top10[8]},
				{"10."+name10,"$ "+top10[9]},

		};
		getContentPane().setLayout(null);
		
		//dimensions and location of the table.
		table=new JTable(data,columnNames);
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));
		table.setForeground(new Color(255, 255, 255));
		table.setPreferredScrollableViewportSize(new Dimension(500,160));
		table.setFillsViewportHeight(true);
		table.setGridColor(new Color(0, 0, 51));
		table.setBackground(new Color(0, 0, 51));
		
		JScrollPane scrollpane=new JScrollPane(table);
		scrollpane.setBounds(40, 128, 502, 191);
		getContentPane().add(scrollpane);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
			}
		});
		btnNewButton.setBounds(196, 374, 130, 42);
		getContentPane().add(btnNewButton);
		
		JLabel lblGlobalLeaderboard = new JLabel("GLOBAL \r\nLEADERBOARD");
		lblGlobalLeaderboard.setFont(new Font("Miriam Fixed", Font.PLAIN, 40));
		lblGlobalLeaderboard.setForeground(new Color(255, 255, 255));
		lblGlobalLeaderboard.setBackground(new Color(255, 255, 255));
		lblGlobalLeaderboard.setBounds(83, 33, 452, 79);
		getContentPane().add(lblGlobalLeaderboard);
		
		
	}
	/**
	 * This method used to write scores achieved by players into a scores file and the scores are separated with a "-" in the file.
	 * @param msg-The score that needs to be added the scores file once the player is done playing
	 * 
	 */
	public static void addScore(int msg)  {
	    String fileName = "scores.txt";
	    PrintWriter pw = null;
	    File file = new File(fileName);
	    
	    //if the file does not exits create a new file with the name scores.
	    try {
	        if (!file.exists()) file.createNewFile();
	        pw = new PrintWriter(new FileOutputStream(fileName, true));
	        BufferedReader br=new BufferedReader(new FileReader("scores.txt"));
	        
	        //if file is empty append the score into the file normally(with out hyphen).
	        if(br.readLine()==null){
	        	pw.write(""+msg);
	        }
	        //if there is something in the file append with a dash so that the scores can be separated when the file is read.
	        else{
	        	pw.write("-"+msg);
	        }
	        
	        
	    } catch (IOException e) {
	        System.out.printf("Error: %s\n",e);
	    } finally {
	    	//dispose of the writer writer once done.
	        if (pw != null)try {
	            pw.flush();
	            pw.close();
	            
	            
	        }catch(Exception e){
	        	System.out.printf("Error: %s\n",e);
	        }
	    }
	}
	/**
	 * This method used to write name entered by players into a names file and the names are separated with a "-" in the file.
	 * @param name-The name that needs to be added the names file once the player has entered the name.
	 * 
	 */
	public static void addName(String name){
		String fileName = "names.txt";
	    PrintWriter pw = null;
	    File file = new File(fileName);
	    
	    try {
	    	//if the names file does not exist create a new one.
	        if (!file.exists()) file.createNewFile();
	        pw = new PrintWriter(new FileOutputStream(fileName, true));
	        BufferedReader br=new BufferedReader(new FileReader("names.txt"));
	        //if file is empty append the name to the file normally.
	        if(br.readLine()==null){
	        	pw.write(name);
	        }
	        //if there are names in the append with a dash so the names are separated by a hyphen.
	        else{
	        	pw.write("-"+name);
	        }
	        
	        
	    } catch (IOException e) {
	        System.out.printf("Error: %s\n",e);
	    } finally {
	        if (pw != null)try {
	            pw.flush();
	            pw.close();
	            
	            
	        }catch(Exception e){
	        	System.out.printf("Error: %s\n",e);
	        }
	    }
	}
	

	
	

	
	public void close(){
		this.setVisible(false);

	}
}