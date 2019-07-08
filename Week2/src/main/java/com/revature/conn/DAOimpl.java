package com.revature.conn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOimpl implements DAO {
	public static ConnFactory cF = ConnFactory.getInstance();

	@Override
	public void printInfo() throws SQLException{
		Connection conn = cF.getConnection();
		String sql="SELECT DEPARTMENT_NAME FROM DEPARTMENT";
		PreparedStatement ps;
			ps = conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString(1));
			}
			ps.close();
			conn.close();
	}

	@Override
	public void addEmployee(String fName, String lName, int DID, int salary,String email)throws SQLException {
		Connection conn = cF.getConnection();
		
		String sql="INSERT INTO EMPLOYEE VALUES(?,?,?,?,?,?)";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1,0);
		ps.setString(2, fName);
		ps.setString(3,lName);
		ps.setInt(4,DID);
		ps.setInt(5,salary);
		ps.setString(6,email);
		ps.executeQuery();
		ps.close();
		conn.close();
		
	}

}
