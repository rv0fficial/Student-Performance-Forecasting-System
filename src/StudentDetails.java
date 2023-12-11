import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;
import java.awt.Font;
import javax.swing.JTextField; //import tables
	
//Separately added
	import javax.swing.*;
	import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class StudentDetails extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldSID;
	private JTextField textFieldName;
	private JTextField textFieldSurname;
	private JTextField textFieldAge;
	private JTextField textFieldEmail;
	

	/**
	 * Launch the application.
	 */
	public static void StudentDetailsmain() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentDetails frame = new StudentDetails();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	Connection connection = null;
	private JTable table;
	
	/**
	 * Create the frame.
	 */
	public StudentDetails() {
		
		connection = SqlConnection.dbConnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 776, 499);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLoadTable = new JButton("Student Details");
		btnLoadTable.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLoadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					//create a connection between db and code
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop","root","");
					String sqlq = "SELECT * FROM studentinfo";
					
					PreparedStatement stmt =  conn.prepareStatement(sqlq);
					ResultSet rs = stmt.executeQuery();

					table.setModel(DbUtils.resultSetToTableModel(rs));
				
					//System.out.println("******* sql = "+sql);
					/*if(rs.next()) { 
						JOptionPane.showMessageDialog(null, "Login succsecully...");
					}
					else {
						JOptionPane.showMessageDialog(null, "Invalid username or Password...");
					}*/
						
				} catch(Exception lo) {System.out.println(lo);} 
			}
		});
		
		btnLoadTable.setBounds(42, 289, 183, 28);
		contentPane.add(btnLoadTable);
		
		JLabel lblNewLabel_1 = new JLabel("SID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 74, 58, 36);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblUsername = new JLabel("First name ");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUsername.setBounds(10, 105, 100, 45);
		contentPane.add(lblUsername);
		
		JLabel lblLastName = new JLabel("Last name ");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLastName.setBounds(10, 143, 98, 45);
		contentPane.add(lblLastName);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAge.setBounds(10, 188, 47, 45);
		contentPane.add(lblAge);
		
		JLabel lblUsername_3 = new JLabel("Email");
		lblUsername_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUsername_3.setBounds(10, 233, 106, 45);
		contentPane.add(lblUsername_3);
		
		textFieldSID = new JTextField();
		textFieldSID.setBounds(126, 74, 145, 20);
		contentPane.add(textFieldSID);
		textFieldSID.setColumns(10);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(126, 120, 143, 20);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldSurname = new JTextField();
		textFieldSurname.setColumns(10);
		textFieldSurname.setBounds(126, 158, 143, 20);
		contentPane.add(textFieldSurname);
		
		textFieldAge = new JTextField();
		textFieldAge.setColumns(10);
		textFieldAge.setBounds(126, 203, 143, 20);
		contentPane.add(textFieldAge);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(126, 248, 143, 20);
		contentPane.add(textFieldEmail);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					String query = " insert into StudentInfo(SID,Name,Surname,Age,Email) values (?,?,?,?,?)";
					PreparedStatement stmt =  connection.prepareStatement(query);
					stmt.setString(1, textFieldSID.getText());
					stmt.setString(2, textFieldName.getText());
					stmt.setString(3, textFieldSurname.getText());
					stmt.setString(4, textFieldAge.getText());
					stmt.setString(5, textFieldEmail.getText());

					
					stmt.execute();
					
					JOptionPane.showMessageDialog(null, "Data Saved..");

					stmt.close();
					
				}catch(Exception sv ){
					sv.printStackTrace();
				}
				
				
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSave.setBounds(287, 361, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					String query = "Update studentinfo set SID='"+textFieldSID.getText()+"' ,name='"+textFieldName.getText()+"' ,surname='"+textFieldSurname.getText()+"' ,age='"+textFieldAge.getText()+"' ,email='"+textFieldEmail.getText()+"' where SID='"+textFieldSID.getText()+"' ";
					PreparedStatement stmt =  connection.prepareStatement(query);
					
					stmt.execute();
					
					JOptionPane.showMessageDialog(null, "Data updated..");

					stmt.close();
					
				}catch(Exception up ){
					up.printStackTrace();
				}
				
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnUpdate.setBounds(390, 361, 115, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					String query = "Delete from studentinfo where SID='"+textFieldSID.getText()+"' ";
					
					
					PreparedStatement stmt =  connection.prepareStatement(query);
					
					
					stmt.execute();
					
					JOptionPane.showMessageDialog(null, "Data updated..");

					stmt.close();
					
				}catch(Exception del ){
					del.printStackTrace();
				}
				
				
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDelete.setBounds(515, 361, 106, 23);
		contentPane.add(btnDelete);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				StudentResults SR = new StudentResults();
				SR.StudentResultsmain();
				
				
			}
		});
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNext.setBounds(661, 411, 89, 23);
		contentPane.add(btnNext);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(281, 61, 469, 289);
		contentPane.add(scrollPane);
	
		
		///selected
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblStudentDetails = new JLabel("Student Details");
		lblStudentDetails.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblStudentDetails.setBounds(268, 11, 137, 39);
		contentPane.add(lblStudentDetails);
		
	}
}
