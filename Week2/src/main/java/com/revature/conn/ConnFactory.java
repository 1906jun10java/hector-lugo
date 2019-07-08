package com.revature.conn;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnFactory {

	private static ConnFactory cF = new ConnFactory();
	
	private ConnFactory() {
		//super();
	}
	
	public static synchronized ConnFactory getInstance() {
		if(cF == null) {
			cF = new ConnFactory();
		}
		return cF;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		
		Properties props = new Properties();
		try {
			props.load(new FileReader("database.properties"));
			//We can read in a file, in this case we made a databse.properties file and are passing it in
			//via a Properties object (which uses a file reader to read the actual file).
			
			Class.forName(props.getProperty("driver"));
			conn = DriverManager.getConnection(props.getProperty("url"), 
					props.getProperty("username"), props.getProperty("password"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
}