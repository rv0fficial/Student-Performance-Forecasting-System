import java.awt.EventQueue;

import javax.swing.*;
import java.sql.*;
import java.text.MessageFormat;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentResults {

	private JFrame frame;
	private JTextField jtxtPS;
	private JTextField jtxtOOP;
	private JTextField jtxtDSA;
	private JTextField jtxtRS;
	private JTextField jtxtAE;
	private JTextField jtxtDE;
	private JTextField jtxtStudent;
	private JTextField jtxtTotalScore;
	private JTextField jtxtAverage;
	private JTextField jtxtRanking;
	private JTable table;

	private JTextArea jtxtTranscript;
	
	
	Connection conn = null; 
	PreparedStatement pst = null;
	ResultSet rs = null;
	DefaultTableModel model = new DefaultTableModel();
	
	/**
	 * Launch the application.
	 */

	public void updateTable() {

		conn = SqlConnection.dbConnector();
		if(conn != null) {
																									 
			String sql = "Select StudentID, PS, OOP, DSA, RS, AE, DE, TotalScore, Average, Ranking from marks";
			try {
				pst = conn.prepareStatement(sql);
				rs = pst.executeQuery();
				Object[] columnData = new Object[10];
				
				while(rs.next()) {
					columnData [0] = rs.getString("StudentID");
					columnData [1] = rs.getString("PS");
					columnData [2] = rs.getString("OOP");
					columnData [3] = rs.getString("DSA");
					columnData [4] = rs.getString("RS");
					columnData [5] = rs.getString("AE");
					columnData [6] = rs.getString("DE");
					columnData [7] = rs.getString("TotalScore");
					columnData [8] = rs.getString("Average");
					columnData [9] = rs.getString("Ranking");
					
			
					
					model.addRow(columnData);
				}
			} catch(Exception e){
				JOptionPane.showMessageDialog(null, e);
			}
			
		}
	}
		
	
	public static void StudentResultsmain() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StudentResults window = new StudentResults();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

	/**
	 * Create the application.
	 */
	public StudentResults() {
		initialize();
		
		conn = SqlConnection.dbConnector();
		
		
		Object col[] = {"Student ID","PS","OOP", "DSA", "RS", "AE", "DE", "Total Score", "Average", "Ranking"};
		model.setColumnIdentifiers(col);
		table.setModel(model);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				StudentAesthetic SA = new StudentAesthetic();
				SA.StudentAesthaeticmain();
				
				
				
			}
		});
		btnNext.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNext.setBounds(1139, 618, 89, 49);
		frame.getContentPane().add(btnNext);
		updateTable();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.BLACK, 11));
		panel.setBackground(Color.GRAY);
		panel.setBounds(91, 33, 573, 296);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblStudentId = new JLabel("PS");
		lblStudentId.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblStudentId.setBounds(22, 26, 116, 31);
		panel.add(lblStudentId);
		
		JLabel lblOop = new JLabel("OOP");
		lblOop.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblOop.setBounds(22, 59, 116, 31);
		panel.add(lblOop);
		
		JLabel lblDsa = new JLabel("DSA");
		lblDsa.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDsa.setBounds(22, 97, 116, 31);
		panel.add(lblDsa);
		
		JLabel lblRs = new JLabel("RS");
		lblRs.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRs.setBounds(22, 139, 116, 31);
		panel.add(lblRs);
		
		JLabel lblAe = new JLabel("AE");
		lblAe.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAe.setBounds(22, 181, 116, 31);
		panel.add(lblAe);
		
		JLabel lblDe = new JLabel("DE");
		lblDe.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDe.setBounds(22, 223, 116, 31);
		panel.add(lblDe);
		
		JLabel lblStudentId_6 = new JLabel("Student ID");
		lblStudentId_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblStudentId_6.setBounds(335, 37, 116, 31);
		panel.add(lblStudentId_6);
		
		JLabel lblTotalScore = new JLabel("Total Score");
		lblTotalScore.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTotalScore.setBounds(335, 130, 116, 31);
		panel.add(lblTotalScore);
		
		JLabel lblAverage = new JLabel("Average");
		lblAverage.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAverage.setBounds(335, 162, 116, 31);
		panel.add(lblAverage);
		
		JLabel lblRanking = new JLabel("Ranking");
		lblRanking.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRanking.setBounds(335, 193, 116, 31);
		panel.add(lblRanking);
		
		jtxtPS = new JTextField();
		jtxtPS.setBounds(143, 34, 86, 20);
		panel.add(jtxtPS);
		jtxtPS.setColumns(10);
		
		jtxtOOP = new JTextField();
		jtxtOOP.setBounds(143, 67, 86, 20);
		panel.add(jtxtOOP);
		jtxtOOP.setColumns(10);
		
		jtxtDSA = new JTextField();
		jtxtDSA.setBounds(143, 105, 86, 20);
		panel.add(jtxtDSA);
		jtxtDSA.setColumns(10);
		
		jtxtRS = new JTextField();
		jtxtRS.setBounds(143, 147, 86, 20);
		panel.add(jtxtRS);
		jtxtRS.setColumns(10);
		
		jtxtAE = new JTextField();
		jtxtAE.setBounds(143, 189, 86, 20);
		panel.add(jtxtAE);
		jtxtAE.setColumns(10);
		
		jtxtDE = new JTextField();
		jtxtDE.setBounds(143, 231, 86, 20);
		panel.add(jtxtDE);
		jtxtDE.setColumns(10);
		
		jtxtStudent = new JTextField();
		jtxtStudent.setBounds(450, 45, 86, 20);
		panel.add(jtxtStudent);
		jtxtStudent.setColumns(10);
		
		jtxtTotalScore = new JTextField();
		jtxtTotalScore.setEditable(false);
		jtxtTotalScore.setBounds(450, 138, 86, 20);
		panel.add(jtxtTotalScore);
		jtxtTotalScore.setColumns(10);
		
		jtxtAverage = new JTextField();
		jtxtAverage.setEditable(false);
		jtxtAverage.setBounds(450, 170, 86, 20);
		panel.add(jtxtAverage);
		jtxtAverage.setColumns(10);
		
		jtxtRanking = new JTextField();
		jtxtRanking.setEditable(false);
		jtxtRanking.setBounds(450, 201, 86, 20);
		panel.add(jtxtRanking);
		jtxtRanking.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.BLACK, 10));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(698, 33, 544, 296);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JTextArea jtxtTranscript = new JTextArea();
		jtxtTranscript.setBounds(10, 11, 524, 274);
		panel_1.add(jtxtTranscript);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.BLACK, 10));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(91, 340, 1151, 267);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1131, 245);
		panel_2.add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		
		
		
		
		//========================================================Buttons of the application===================================
		
		JButton btnStudentResult = new JButton("Student result");
		btnStudentResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				double[] R = new double[8];
				R[0] = Double.parseDouble(jtxtPS.getText());
				R[1] = Double.parseDouble(jtxtOOP.getText());
				R[2] = Double.parseDouble(jtxtDSA.getText());
				R[3] = Double.parseDouble(jtxtRS.getText());
				R[4] = Double.parseDouble(jtxtAE.getText());
				R[5] = Double.parseDouble(jtxtDE.getText());
				
				//finding the average
				R[6] = (R[0]+ R[1] + R[2]+ R[3]+ R[4]+ R[5]) / 6;
				//finding the total score
				R[7] = (R[0]+ R[1] + R[2]+ R[3]+ R[4]+ R[5]);
				
				String Average = String.format("%.0f", R[6]);
				jtxtAverage.setText(Average);
				
				String TotalScore = String.format("%.0f", R[7]);
				jtxtTotalScore.setText(TotalScore);
				
				if(R[7] >= 500 )
				{
					jtxtRanking.setText("1st");
				}
				else if(R[7] >= 400 )
				{
					jtxtRanking.setText("2st");
				}
				else if(R[7] >= 300 )
				{
					jtxtRanking.setText("3st");
				}
				
				String sql = "INSERT INTO marks(StudentID, PS, OOP, DSA, RS, AE, DE, "
						+ "TotalScore, Average, Ranking) VALUES(?,?,?,?,?,?,?,?,?,?)"; 
				
				try {
					pst = conn.prepareStatement(sql);
					pst.setString(1, jtxtStudent.getText());
					pst.setString(2, jtxtPS.getText());
					pst.setString(3, jtxtOOP.getText());
					pst.setString(4, jtxtDSA.getText());
					pst.setString(5, jtxtRS.getText());
					pst.setString(6, jtxtAE.getText());
					pst.setString(7, jtxtDE.getText());
					pst.setString(8, jtxtTotalScore.getText());
					pst.setString(9, jtxtAverage.getText());
					pst.setString(10, jtxtRanking.getText());
					
					//pst.setString(1, jtxtStudent.getText());
					pst.execute();
					
					rs.close();
					pst.close();
					
				}catch (Exception ev) {
					JOptionPane.showMessageDialog(null, "System update completed..");
					
				}
				

				
				//===============================================database design on table =========================================
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[]{
				jtxtStudent.getText(),
				jtxtPS.getText(),
				jtxtOOP.getText(),
				jtxtDSA.getText(),
				jtxtRS.getText(),
				jtxtAE.getText(),
				jtxtDE.getText(),
				jtxtTotalScore.getText(),
				jtxtAverage.getText(),
				jtxtRanking.getText(),
				});
				
				if(table.getSelectedRow()==-1) {
					if(table.getRowCount()==0) {
						JOptionPane.showMessageDialog(null, "member update confirmed","Student database system",
							 JOptionPane.OK_OPTION);
						}
					}

				
				
			}
		});
		btnStudentResult.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnStudentResult.setBounds(54, 618, 161, 49);
		frame.getContentPane().add(btnStudentResult);
		
		JButton btnTranscript = new JButton("Transcript");
		btnTranscript.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				jtxtTranscript.setText("");
				jtxtTranscript.append("Student Result Recording system\n"
						 +"============================================\n"
						 +"PS:\t\t\t"+jtxtPS.getText()
						 +"\nOOP:\t\t"+jtxtOOP.getText()
						 +"\nDSA:\t\t"+jtxtDSA.getText()						 
						 +"\nRS:\t\t"+jtxtRS.getText()
						 +"\nAE:\t\t"+jtxtAE.getText()
						 +"\nDE:\t\t"+jtxtDE.getText()
						 +"\n====================================\n"
						 +"\nTotal Score:\t\t"+jtxtTotalScore.getText()
						 +"\nAverage:\t\t"+jtxtAverage.getText()
						 +"\nRanking:\t\t"+jtxtRanking.getText()+"\n");
				
				
			}
		});
		btnTranscript.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnTranscript.setBounds(262, 618, 132, 49);
		frame.getContentPane().add(btnTranscript);
		
		JButton btnP = new JButton("Print");
		btnP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				MessageFormat header = new MessageFormat("Printing in process");
				MessageFormat footer = new MessageFormat("Page {0,number,integer}");
				
				try {
					table.print();
				}catch (java.awt.print.PrinterException ev) {
					// TODO: handle exception
					System.err.format("NO Printer found", ev.getMessage());
				}
				
				
				
			}
		});
		btnP.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnP.setBounds(440, 618, 121, 49);
		frame.getContentPane().add(btnP);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				 DefaultTableModel model = (DefaultTableModel) table.getModel();		
				if(table.getSelectedRow()==-1) {
					if(table.getRowCount()==0) {
						JOptionPane.showMessageDialog(null, "No data to delete..",
								"student result system", JOptionPane.OK_OPTION);
					}else {
						JOptionPane.showMessageDialog(null, "select a row to delete",
								"Student result system",JOptionPane.OK_OPTION);
					}
				
				}else {
					model.removeRow(table.getSelectedRow());
				
				
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDelete.setBounds(609, 618, 132, 49);
		frame.getContentPane().add(btnDelete);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				JTextField temp = null;
				for(Component c:panel.getComponents()) {
					if(c.getClass().toString().contains("javax.swing.JTextField")) {
						temp =(JTextField)c;
						temp.setText(null);
					}
				}
				jtxtTranscript.setText(null);
				//jcmbCourseCode.setSelectedIndex(0);
				
				
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnReset.setBounds(794, 618, 132, 49);
		frame.getContentPane().add(btnReset);
		
		JButton btnEx = new JButton("Exit");
		btnEx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				frame =  new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit","Student Performance Forecasting System",
						JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION){
					System.exit(0);
				}
				
				
			}
		});
		btnEx.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnEx.setBounds(976, 618, 121, 49);
		frame.getContentPane().add(btnEx);
		frame.setBounds(0, 0, 1292, 734);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
