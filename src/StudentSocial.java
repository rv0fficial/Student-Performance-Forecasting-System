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


public class StudentSocial extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldID;
	private JTextField textField_1Name;
	private JTextField textField_2Club;
	private JTextField textField_3Year;
	private JTextField textField_4Posi;

	/**
	 * Launch the application.
	 */
	public static void StudentSocialmain() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentSocial frame = new StudentSocial();
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
	public StudentSocial() {
		
		connection = SqlConnection.dbConnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 438);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Social Activities");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(253, 11, 197, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblSudentId = new JLabel("Sudent ID");
		lblSudentId.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblSudentId.setBounds(10, 63, 121, 30);
		contentPane.add(lblSudentId);
		
		JLabel lblSudentName = new JLabel("Sudent Name");
		lblSudentName.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblSudentName.setBounds(10, 106, 121, 30);
		contentPane.add(lblSudentName);
		
		JLabel lblNameOfClub = new JLabel("Name Of Club Joined");
		lblNameOfClub.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNameOfClub.setBounds(10, 147, 170, 30);
		contentPane.add(lblNameOfClub);
		
		JLabel lblMembershipYears = new JLabel("Membership Years");
		lblMembershipYears.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblMembershipYears.setBounds(10, 188, 170, 30);
		contentPane.add(lblMembershipYears);
		
		JLabel lblPositionsHeld = new JLabel("Positions Held");
		lblPositionsHeld.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblPositionsHeld.setBounds(10, 229, 121, 30);
		contentPane.add(lblPositionsHeld);
		
		textFieldID = new JTextField();
		textFieldID.setBounds(190, 70, 86, 20);
		contentPane.add(textFieldID);
		textFieldID.setColumns(10);
		
		textField_1Name = new JTextField();
		textField_1Name.setBounds(190, 113, 86, 20);
		contentPane.add(textField_1Name);
		textField_1Name.setColumns(10);
		
		textField_2Club = new JTextField();
		textField_2Club.setBounds(190, 154, 86, 20);
		contentPane.add(textField_2Club);
		textField_2Club.setColumns(10);
		
		textField_3Year = new JTextField();
		textField_3Year.setBounds(190, 195, 86, 20);
		contentPane.add(textField_3Year);
		textField_3Year.setColumns(10);
		
		textField_4Posi = new JTextField();
		textField_4Posi.setBounds(190, 236, 86, 20);
		contentPane.add(textField_4Posi);
		textField_4Posi.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(314, 53, 428, 230);
		contentPane.add(scrollPane);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					
					String query = " insert into social(SID,Name,Club,Year,Positions) values (?,?,?,?,?)";
					PreparedStatement stmt =  connection.prepareStatement(query);
					stmt.setString(1, textFieldID.getText());
					stmt.setString(2, textField_1Name.getText());
					stmt.setString(3, textField_2Club.getText());
					stmt.setString(4, textField_3Year.getText());
					stmt.setString(5, textField_4Posi.getText());

					
					stmt.execute();
					
					JOptionPane.showMessageDialog(null, "Data Saved..");

					stmt.close();
					
				}catch(Exception sv ){
					sv.printStackTrace();
				}
				
				
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSave.setBounds(314, 294, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

				try {
					String query = "Update social set SID='"+textFieldID.getText()+"' ,Name='"+textField_1Name.getText()+"' ,Club='"+textField_2Club.getText()+"' ,Year='"+textField_3Year.getText()+"' ,Positions='"+textField_4Posi.getText()+"' where SID='"+textFieldID.getText()+"' ";
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
		btnUpdate.setBounds(428, 297, 115, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					String query = "Delete from social where SID='"+textFieldID.getText()+"' ";
					
					
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
		btnDelete.setBounds(567, 297, 106, 23);
		contentPane.add(btnDelete);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				StudentActivities SA = new StudentActivities();
				SA.StudentActivitiesmain();
				
				
			}
		});
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNext.setBounds(622, 356, 89, 23);
		contentPane.add(btnNext);
		
		JButton btnLoadTable = new JButton("Social Activities");
		btnLoadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					
					//create a connection between db and code
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop","root","");
					String sqlq = "SELECT * FROM social";
					
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
		btnLoadTable.setBounds(10, 273, 183, 28);
		contentPane.add(btnLoadTable);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
	}

}
