package com.revature.DAO;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Reimbursement;

public interface ReimbursementDAO {
	
	public void addR(int employeeID,int managerID,String status,double amount)throws SQLException ;
	
	public void updateR(int rID,String status)throws SQLException ;
	
	public List<Reimbursement> getSentR(int employeeID)throws SQLException ;
	
	public List<Reimbursement> getMyEmployyesR(int employeeID)throws SQLException ;

}
