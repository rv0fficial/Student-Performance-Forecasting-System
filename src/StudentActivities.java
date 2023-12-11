import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import net.proteanit.sql.DbUtils;
import java.awt.Font;

//import tables
//Separately added
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class StudentActivities extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void StudentActivitiesmain() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentActivities frame = new StudentActivities();
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
	public StudentActivities() {
		
		connection = SqlConnection.dbConnector();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 437);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(314, 61, 434, 233);
		contentPane.add(scrollPane);
		
		JLabel lblStudentActivities = new JLabel("Student Activities");
		lblStudentActivities.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblStudentActivities.setBounds(304, 11, 171, 34);
		contentPane.add(lblStudentActivities);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblStudentId.setBounds(10, 61, 105, 34);
		contentPane.add(lblStudentId);
		
		JLabel lblStudentAge = new JLabel("Student Age");
		lblStudentAge.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblStudentAge.setBounds(10, 100, 105, 34);
		contentPane.add(lblStudentAge);
		
		JLabel lblNameOfClub = new JLabel("Name Of Club Joined");
		lblNameOfClub.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNameOfClub.setBounds(10, 140, 180, 34);
		contentPane.add(lblNameOfClub);
		
		JLabel lblIdOfClub = new JLabel("ID Of Club Joined");
		lblIdOfClub.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblIdOfClub.setBounds(10, 175, 180, 34);
		contentPane.add(lblIdOfClub);
		
		textField = new JTextField();
		textField.setBounds(200, 70, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(200, 109, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(200, 149, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(200, 184, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnLoadTable = new JButton("Student Activities");
		btnLoadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					
					//create a connection between db and code
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop","root","");
					String sqlq = "SELECT * FROM activity";
					
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
		btnLoadTable.setBounds(29, 254, 183, 28);
		contentPane.add(btnLoadTable);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					String query = "insert into activity(SID,Age,Club,CID) values (?,?,?,?)";
					PreparedStatement stmt =  connection.prepareStatement(query);
					stmt.setString(1, textField.getText());
					stmt.setString(2, textField_1.getText());
					stmt.setString(3, textField_2.getText());
					stmt.setString(4, textField_3.getText());
					//stmt.setString(5, textFieldEmail.getText());

					
					stmt.execute();
					
					JOptionPane.showMessageDialog(null, "Data Saved..");

					stmt.close();
					
				}catch(Exception sv ){
					sv.printStackTrace();
				}
				
				
				
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSave.setBounds(349, 305, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					String query = "Update activity set SID='"+textField.getText()+"' ,Age='"+textField_1.getText()+"' ,Club='"+textField_2.getText() +"' ,CID = '"+textField_3.getText()+"' where SID='"+textField.getText()+"' ";
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
		btnUpdate.setBounds(460, 305, 115, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				try {
					String query = "Delete from activity where SID='"+textField.getText()+"' ";
					
					
					PreparedStatement stmt =  connection.prepareStatement(query);
					
					
					stmt.execute();
					
					JOptionPane.showMessageDialog(null, "Data updated..");

					stmt.close();
					
				}catch(Exception del ){
					del.printStackTrace();}
				
				
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDelete.setBounds(593, 305, 106, 23);
		contentPane.add(btnDelete);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			
				Sport sprt = new Sport();
				sprt.Sportmain();
				
				
			
			}
		});
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNext.setBounds(659, 355, 89, 23);
		contentPane.add(btnNext);
		
		///selected
		table = new JTable();
		scrollPane.setViewportView(table);
		
	}

}
