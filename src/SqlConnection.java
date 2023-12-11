import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;

import javax.swing.JOptionPane;

//Separately added
import javax.swing.*;
import java.sql.*;


public class SqlConnection {

	public static Connection dbConnector() {
		try {

			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop","root","");
			//JOptionPane.showMessageDialog(null, "Database Connected..");
			
			return conn;
			
			//Statement stmt =  conn.createStatement();
			//ResultSet rs = stmt.executeQuery(sql);			
			} catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);} 
			return null;
		}
}
