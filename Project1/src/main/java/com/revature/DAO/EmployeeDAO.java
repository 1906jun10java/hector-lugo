package com.revature.DAO;

import java.sql.SQLException;

import com.revature.beans.Employees;

public interface EmployeeDAO {
	
	public abstract void addEmployee(int managerID, String name, String adress, int isManager)throws SQLException;
	
	public abstract void deleteEmployee(int employeeID)throws SQLException;
	
	public abstract void updateEmployee(int employeeID,String adress)throws SQLException;
	
	
	
	

}
