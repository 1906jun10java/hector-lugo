package com.revature.conn;

import java.sql.SQLException;

public interface DAO {
	
	public void printInfo() throws SQLException;
	
	public void addEmployee(String fName,String lName,int DID,int salary, String mail)throws SQLException;

}
