package com.revature.DAO_Implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.DAO.ConnectionFactory;
import com.revature.DAO.ReimbursementDAO;
import com.revature.beans.Reimbursement;

public class ReimbursementDAO_Implementation implements ReimbursementDAO {
	

	@Override
	public void addR(int employeeID, int managerID, String status, double amount)throws SQLException  {
		Connection conn = ConnectionFactory.getConnection();
		String sql="INSERT INTO REIMBURSEMENT (R_EMPLOYEE, R_MANAGER, STATUS,R_AMMOUNT) VALUES(?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1,employeeID);
		ps.setInt(2,managerID);
		ps.setString(3, status);
		ps.setDouble(4, amount);
		ps.executeQuery();
		ps.close();
		conn.close();
		
	}

	@Override
	public void updateR(int rID, String status) throws SQLException {
		Connection conn = ConnectionFactory.getConnection();
		
		String sql="UPDATE Reimbursement SET STATUS= ? WHERE R_ID=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, status);
		ps.setInt(2, rID);
		ps.executeQuery();
		ps.close();
		conn.close();
		
	}

	@Override
	public List<Reimbursement> getSentR(int employeeID)throws SQLException  {
		Connection conn = ConnectionFactory.getConnection();
		String sql= "SELECT * FROM Reimbursement WHERE EMPLOYEE_ID=?  ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, employeeID);
		ResultSet rs=ps.executeQuery();
		List<Reimbursement> myR=new ArrayList<>();
		Reimbursement r=null;
		while(rs.next()) {
			//Reimbursement(int rID, int employeeID, int managerID, String status, double amount)
			r=new Reimbursement(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getDouble(6));
			myR.add(r);
		}
		
		return myR;
	}
	
	public List<Reimbursement> getSentRPending(int employeeID)throws SQLException  {
		Connection conn = ConnectionFactory.getConnection();
		String sql= "SELECT * FROM Reimbursement WHERE R_EMPLOYEE=? AND STATUS=0 ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, employeeID);
		ResultSet rs=ps.executeQuery();
		List<Reimbursement> myR=new ArrayList<>();
		Reimbursement r=null;
		while(rs.next()) {
			//Reimbursement(int rID, int employeeID, int managerID, String status, double amount)
			r=new Reimbursement(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getDouble(6));
			myR.add(r);
		}
		
		return myR;
	}

	@Override
	public List<Reimbursement> getMyEmployyesR(int managerID) throws SQLException {
		Connection conn = ConnectionFactory.getConnection();
		String sql= "SELECT * FROM Reimbursement WHERE MANAGER_ID=? AND STATUS=0  ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, managerID);
		ResultSet rs=ps.executeQuery();
		List<Reimbursement> myEmployeesR=new ArrayList<>();
		Reimbursement r=null;
		while(rs.next()) {
			//Reimbursement(int rID, int employeeID, int managerID, String status, double amount)
			r=new Reimbursement(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getDouble(6));
			myEmployeesR.add(r);
		}
		
		return myEmployeesR;
	}

}
