import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Color;

import net.proteanit.sql.DbUtils;
import java.awt.Font;

//import tables
//Separately added
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sport extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void Sportmain() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sport frame = new Sport();
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
	public Sport() {
		
		connection = SqlConnection.dbConnector();
		
		getContentPane().setBackground(Color.GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 456);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(363, 52, 403, 233);
		getContentPane().add(scrollPane);
		
		JLabel lblSport = new JLabel("Sport");
		lblSport.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblSport.setBounds(363, 11, 54, 30);
		getContentPane().add(lblSport);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblStudentId.setBounds(10, 63, 104, 14);
		getContentPane().add(lblStudentId);
		
		JLabel lblStudentName = new JLabel("Student Name");
		lblStudentName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblStudentName.setBounds(10, 105, 136, 14);
		getContentPane().add(lblStudentName);
		
		JLabel lblParticipatedStudentId = new JLabel("Participated Student Code");
		lblParticipatedStudentId.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblParticipatedStudentId.setBounds(10, 147, 247, 14);
		getContentPane().add(lblParticipatedStudentId);
		
		JLabel lblParticipatedSportId = new JLabel("Participated Sports");
		lblParticipatedSportId.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblParticipatedSportId.setBounds(10, 177, 207, 29);
		getContentPane().add(lblParticipatedSportId);
		
		JLabel lblAchievement = new JLabel("Achievement");
		lblAchievement.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAchievement.setBounds(10, 224, 155, 14);
		getContentPane().add(lblAchievement);
		
		textField = new JTextField();
		textField.setBounds(267, 63, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(267, 105, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(267, 147, 86, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(267, 184, 86, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(267, 224, 86, 20);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

				try {
					String query = " insert into sport(SID,Name,Scode,Sport,Achievement) values (?,?,?,?,?)";
					PreparedStatement stmt =  connection.prepareStatement(query);
					stmt.setString(1, textField.getText());
					stmt.setString(2, textField_1.getText());
					stmt.setString(3, textField_2.getText());
					stmt.setString(4, textField_3.getText());
					stmt.setString(5, textField_4.getText());

					
					stmt.execute();
					
					JOptionPane.showMessageDialog(null, "Data Saved..");

					stmt.close();
					
				}catch(Exception sv ){
					sv.printStackTrace();
				}
				
				
				
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSave.setBounds(328, 296, 89, 23);
		getContentPane().add(btnSave);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					String query = "Update sport set SID='"+textField.getText()+"' ,Name='"+textField_1.getText()+"' ,Scode='"+textField_2.getText()+"' ,Sport='"+textField_3.getText()+"' ,Achievement='"+textField_4.getText()+"' where SID='"+textField.getText()+"' ";
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
		btnUpdate.setBounds(443, 299, 115, 23);
		getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				try {
					String query = "Delete from sport where SID='"+textField.getText()+"' ";
					
					
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
		btnDelete.setBounds(581, 299, 106, 23);
		getContentPane().add(btnDelete);
		
		JButton btnLoadTable = new JButton("Student Details");
		btnLoadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
try {
					
					//create a connection between db and code
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop","root","");
					String sqlq = "SELECT * FROM sport";
					
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
		btnLoadTable.setBounds(40, 266, 183, 28);
		getContentPane().add(btnLoadTable);
		
		///selected
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
