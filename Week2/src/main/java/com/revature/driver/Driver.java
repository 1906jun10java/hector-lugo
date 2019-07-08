package com.revature.driver;

import java.sql.SQLException;

import com.revature.conn.DAOimpl;

public class Driver {

	public static void main(String[] args) {
	DAOimpl imple=new DAOimpl();
	try {
		imple.printInfo();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	String fname="Hector";
	String lname="Lugo";
	int DID=1;
	int salary=50;
	String mail=null;
			
	
	try {
		imple.addEmployee(fname, lname, DID, salary,mail);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}

}
