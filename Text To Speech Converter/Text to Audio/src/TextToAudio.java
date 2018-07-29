import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.Statement;
import java.sql.Connection;
import java.util.Scanner;

public class TextToAudio extends JFrame {
	String s1;
	JTextArea textArea;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TextToAudio frame = new TextToAudio();
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
	public TextToAudio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 445);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setForeground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Text To Audio Converter");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel.setForeground(SystemColor.activeCaption);
		lblNewLabel.setBounds(217, 11, 246, 39);
		contentPane.add(lblNewLabel);
		
		  textArea = new JTextArea();
		textArea.setBounds(10, 154, 335, 164);
		contentPane.add(textArea);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Text Here");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1.setBounds(25, 120, 212, 23);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
	
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				@SuppressWarnings("resource")
				Scanner inputScanner = new Scanner(System.in);
 				
 
				
				TextToSpeechConvertor ttsc = new TextToSpeechConvertor();
			
 
			
				 s1 = textArea.getText();
				
				ttsc.speak(textArea.getText());
				
				System.out.println("Input String "+textArea.getText());

			
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(TextToAudio.class.getResource("/images/speaker.png")));
		btnNewButton.setBounds(355, 211, 80, 48);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				try{
					
					 MyDb db = new MyDb();
			         
			         
			          Connection con = db.getCon();
			          java.sql.Statement stmt =   con.createStatement();
			  
     
			             System.out.println("Okayyy" + s1);

			            
			         	stmt.execute("insert into textdata(textarea) values('"+s1+"')");
 
			             System.out.println("StringText Area" + s1);
			          
			  
			       
			        

				}catch (Exception e2) {
					// TODO: handle exception
					System.out.println(e2);
				}
				
				
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(TextToAudio.class.getResource("/images/database.png")));
		btnNewButton_1.setBounds(125, 323, 89, 73);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Save To Database");
		lblNewLabel_2.setForeground(SystemColor.textHighlight);
		lblNewLabel_2.setBounds(236, 345, 109, 23);
		contentPane.add(lblNewLabel_2);
	}

	protected void speak(String inputText) {
		// TODO Auto-generated method stub
		
	}
}
