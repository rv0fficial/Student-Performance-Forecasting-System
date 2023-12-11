
import java.awt.BorderLayout;
import java.awt.EventQueue;

//import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.print.DocFlavor.STRING;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import javax.swing.ImageIcon;

//import javax.swing.*;

//import static javax.swing.JOptionPane.showMessageDialog; //popup box
//import javax.swing.DefaultComboBoxModel; //import sql library

//import com.mysql.jdbc.Connection;
//import java.sql.DriverManager;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JPasswordField pass;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					//remove border of the frame
					//frame.setUndecorated(true);
					
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
	public Login() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 819, 488);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLoginPage = new JLabel("Login Page");
		lblLoginPage.setBackground(Color.WHITE);
		lblLoginPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginPage.setFont(new Font("Times New Roman", Font.BOLD, 37));
		lblLoginPage.setBounds(430, 11, 304, 88);
		contentPane.add(lblLoginPage);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(363, 110, 129, 28);
		contentPane.add(lblNewLabel);
		
		user = new JTextField();
		user.setBounds(373, 148, 221, 38);
		contentPane.add(user);
		user.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(363, 197, 129, 28);
		contentPane.add(lblNewLabel_1);
		
		pass = new JPasswordField();
		pass.setBounds(373, 229, 221, 38);
		contentPane.add(pass);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				
				try {
					//create a connection between db and code
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop","root","");

					Statement stmt =  conn.createStatement();
			
					String sql = "SELECT * FROM admin WHERE UserName='"+ user.getText() +"'and Password='"+ pass.getText()+"'";
					//System.out.println("******* sql = "+sql);

					ResultSet rs = stmt.executeQuery(sql);
					
					if(rs.next()) { 
					
						JOptionPane.showMessageDialog(null, "Login succsecully...");
				
						//frame.dispose();
						//open the Login frame
						StudentDetails sd = new StudentDetails();
						sd.StudentDetailsmain();
						//frame.dispose();
					}
					
					else {
						
						JOptionPane.showMessageDialog(null, "Invalid username or Password...");
					}
						
				} catch(Exception lo) {System.out.println(lo);} 
				
				
				/*
				Connection connection=null;

				connection = SqliteConnection.dbConnector();
				try {
					
					String quary = "select * from tblogin where UserName=? and Password=?";
					PreparedStatement pat = connection.prepareStatement(quary);
					pat.setString(0, user.getText());
					pat.setString(1, pass.getText());
					
					ResultSet rs = pat.executeQuery();
					int count = 0;
					while(rs.next()) {
						
						count= count+1;
						
					}
					if(count == 1){
						JOptionPane.showInternalMessageDialog(null, "Login succsecully...");
					}
					else if(count>1) {
						JOptionPane.showInternalMessageDialog(null, "Login succsecully...");
					}
					else {
						JOptionPane.showInternalMessageDialog(null, "Login succsecully...");
					}
					rs.close();
					pat.close();
					
				}catch (Exception nlog) {
					// TODO: handle exception
					JOptionPane.showInternalMessageDialog(null, "Login succsecully...");
				}*/
				
				/*try {
					Class.forName("com.mysql.jdbc.Driver");
					String url="jdbc:mysql://localhost:3306/oop";
					String name="root";
					String paswrd="";
					
					Connection conn = DriverManager.getConnection(url,name,paswrd);

					Statement stmt =  conn.createStatement();
					
					String sql = "SELECT * FROM admin WHERE UserName='"+ user.getText() +"'and Password '"+ pass.getText()+"'" ;
					
					ResultSet rs = stmt.executeQuery(sql);
					if(rs.next()) 
						JOptionPane.showInternalMessageDialog(null, "Login succsecully...");
						
					else 
						JOptionPane.showInternalMessageDialog(null, "Invalid username or Password...");
					
						
				} catch(Exception lo) {System.out.println(lo);} */	
				
				
			}
		});
		
		btnNewButton.setBounds(592, 324, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CANCEL");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
		
		btnNewButton_1.setToolTipText("CANCEL");
		btnNewButton_1.setBounds(693, 324, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(-1, 0, 364, 438);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Login.class.getResource("/Bimages/177750_3d-computer-wallpapers-desktop-backgrounds_1920x1200_h.jpg")));
		label.setBounds(0, 11, 364, 299);
		panel.add(label);
		
		JLabel lblNewLabel_2 = new JLabel("Student Performance ");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Showcard Gothic", Font.BOLD, 25));
		lblNewLabel_2.setBounds(10, 321, 354, 46);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Forecasting System");
		lblNewLabel_3.setFont(new Font("Showcard Gothic", Font.BOLD, 25));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(61, 368, 293, 33);
		panel.add(lblNewLabel_3);
		
	}
}