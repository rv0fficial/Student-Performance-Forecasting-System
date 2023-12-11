import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

//import javax.swing.*;
//import java.sql.*;


import net.proteanit.sql.DbUtils;
import java.awt.Font;
import javax.swing.JTextField; //import tables
	
//Separately added
	import javax.swing.*;
	import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class StudentAesthetic extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldID;
	private JTextField textField_1Name;
	private JTextField textField_2AAT;
	private JTextField textField_3NOEP;
	private JTextField textField_4NOAW;

	/**
	 * Launch the application.
	 */
	
	public static void StudentAesthaeticmain() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentAesthetic frame = new StudentAesthetic();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//
	Connection connection = null;
	private JTable table;
	/**
	 * Create the frame.
	 */
	public StudentAesthetic() {
		
		//
		connection = SqlConnection.dbConnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 777, 440);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblS = new JLabel("Student Aesthetic Activities Performance");
		lblS.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblS.setBounds(219, 11, 330, 33);
		contentPane.add(lblS);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblStudentId.setBounds(10, 53, 120, 33);
		contentPane.add(lblStudentId);
		
		JLabel lblStudentName = new JLabel("Student Name");
		lblStudentName.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblStudentName.setBounds(10, 85, 120, 33);
		contentPane.add(lblStudentName);
		
		JLabel lblAestheticActivityType = new JLabel("Aesthetic Activity Type");
		lblAestheticActivityType.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblAestheticActivityType.setBounds(10, 116, 191, 33);
		contentPane.add(lblAestheticActivityType);
		
		JLabel lblNumOfEvents = new JLabel("Num Of Events Participated ");
		lblNumOfEvents.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNumOfEvents.setBounds(10, 149, 223, 33);
		contentPane.add(lblNumOfEvents);
		
		JLabel lblNumberOfAwards = new JLabel("Number Of Awards Won");
		lblNumberOfAwards.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNumberOfAwards.setBounds(10, 184, 202, 33);
		contentPane.add(lblNumberOfAwards);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(346, 55, 405, 231);
		contentPane.add(scrollPane);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					String query1 = " insert into aesthetic(SID,Name,Activity,Event,Award) values (?,?,?,?,?)";
					PreparedStatement stmt =  connection.prepareStatement(query1);
					stmt.setString(1, textFieldID.getText());
					stmt.setString(2, textField_1Name.getText());
					stmt.setString(3, textField_2AAT.getText());
					stmt.setString(4, textField_3NOEP.getText());
					stmt.setString(5, textField_4NOAW.getText());

					
					stmt.execute();
					
					JOptionPane.showMessageDialog(null, "Data Saved..");

					stmt.close();
					
				}catch(Exception sv ){
					sv.printStackTrace();
				}
				
				
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSave.setBounds(354, 307, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				try {
					String query = "Update aesthetic set SID='"+textFieldID.getText()+"' ,Name='"+textField_1Name.getText()+"' ,Activity='"+textField_2AAT.getText()+"' ,Event='"+textField_3NOEP.getText()+"' ,Award='"+textField_4NOAW.getText()+"' where SID='"+textFieldID.getText()+"' ";
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
		btnUpdate.setBounds(467, 307, 115, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				try {
					String query = "Delete from aesthetic where SID='"+textFieldID.getText()+"' ";
					
					
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
		btnDelete.setBounds(592, 307, 106, 23);
		contentPane.add(btnDelete);
		
		textFieldID = new JTextField();
		textFieldID.setBounds(233, 61, 86, 20);
		contentPane.add(textFieldID);
		textFieldID.setColumns(10);
		
		textField_1Name = new JTextField();
		textField_1Name.setColumns(10);
		textField_1Name.setBounds(233, 93, 86, 20);
		contentPane.add(textField_1Name);
		
		textField_2AAT = new JTextField();
		textField_2AAT.setColumns(10);
		textField_2AAT.setBounds(233, 124, 86, 20);
		contentPane.add(textField_2AAT);
		
		textField_3NOEP = new JTextField();
		textField_3NOEP.setColumns(10);
		textField_3NOEP.setBounds(233, 157, 86, 20);
		contentPane.add(textField_3NOEP);
		
		textField_4NOAW = new JTextField();
		textField_4NOAW.setColumns(10);
		textField_4NOAW.setBounds(233, 193, 86, 20);
		contentPane.add(textField_4NOAW);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				StudentSocial  SS = new StudentSocial();
				SS.StudentSocialmain();
				
			}
		});
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNext.setBounds(662, 363, 89, 23);
		contentPane.add(btnNext);
		
		JButton btnLoadTable = new JButton("Aesthetic Activities");
		btnLoadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				try {
					
					//create a connection between db and code
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop","root","");
					String sqlq = "SELECT * FROM aesthetic";
					
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
		btnLoadTable.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLoadTable.setBounds(20, 228, 183, 28);
		contentPane.add(btnLoadTable);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
