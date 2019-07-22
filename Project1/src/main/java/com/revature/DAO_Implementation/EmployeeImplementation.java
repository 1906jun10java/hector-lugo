package com.revature.DAO_Implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.DAO.ConnectionFactory;
import com.revature.DAO.EmployeeDAO;
import com.revature.beans.Employees;

public class EmployeeImplementation implements EmployeeDAO {
	

	@Override
	public void addEmployee(int managerID, String name, String address, int isManager)throws SQLException {
		
		Connection conn = ConnectionFactory.getConnection();
		
		String sql="INSERT INTO EMPLOYEES VALUES(?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1,0);
		ps.setString(2, name);
		ps.setString(3,address);
		ps.setInt(4,isManager);
		ps.executeQuery();
		ps.close();
		conn.close();

	}

	@Override
	public void deleteEmployee(int employeeID)throws SQLException {
		

	}

	@Override
	public void updateEmployee(int employeeID,String adress)throws SQLException {
		Connection conn = ConnectionFactory.getConnection();
		String sql= "UPDATE EMPLOYEES SET EMPLOYEE_ADDRESS= ? WHERE EMPLOYEE_ID=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(2,employeeID);
		ps.setString(1, adress);
		ps.executeQuery();
		ps.close();
		conn.close();
		
		
		

	}
	//public Employees(int employeeID, int managerID, String name, String address, int isManager)
	public Employees retrieveEmployee(String username,String password)throws SQLException {
		Connection conn = ConnectionFactory.getConnection();
		String sql= "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_USERNAME=? AND EMPLOYEE_PASSWORD=? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet rs=ps.executeQuery();
		
		
		
		Employees user=null;
		while(rs.next()) {
			
			user=new Employees(rs.getInt(1),rs.getInt(4),rs.getString(2),rs.getString(3),rs.getInt(5));
		}
		conn.close();
		return user;
		
	}
	
	public  List<Employees> retrieveMyEmployee(int managerID)throws SQLException {
		Connection conn = ConnectionFactory.getConnection();
		String sql= "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_MANAGER=?  ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, managerID);
		
		ResultSet rs=ps.executeQuery();
		
		
		
		List<Employees> myEmployees=new ArrayList<>();
		Employees user=null;
		while(rs.next()) {
			
			user=new Employees(rs.getInt(1),rs.getInt(4),rs.getString(2),rs.getString(3),rs.getInt(5));
			myEmployees.add(user);
		}
		conn.close();
		return myEmployees;
		
	}
	
	
	public String retrieveEmployeeManagerName(int managerID)throws SQLException {
		Connection conn = ConnectionFactory.getConnection();
		String sql= "SELECT EMPLOYEE_NAME FROM EMPLOYEES WHERE EMPLOYEE_MANAGER=? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, managerID);
		
		ResultSet rs=ps.executeQuery();
		
		String managerName=null;
		while(rs.next()) {
			managerName=rs.getString(1);
			
		}
		conn.close();
		return managerName;
		
	}



}
