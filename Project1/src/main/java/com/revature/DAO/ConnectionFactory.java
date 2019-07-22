package com.revature.DAO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

	public static Connection getConnection() throws SQLException {
		
		Connection c = null;
		try {
		Properties prop = new Properties();
		//InputStream in = ConnectionFactory.class.getClassLoader().getResourceAsStream("database.properties");
		//prop.load(in);
		
		
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
			//c = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("pass"));
			c=DriverManager.getConnection("jdbc:oracle:thin:@database-1.cgxtkozssptn.us-east-2.rds.amazonaws.com:1521:HectorS","admin", "EatShitDie666");
		} catch(ClassNotFoundException ex) {
			System.out.println("unable to load driver class!");
		//	ex.printStackTrace();
			
		}/* catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		return c;
	}
}
	