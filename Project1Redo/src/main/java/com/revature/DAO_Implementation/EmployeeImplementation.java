package com.revature.DAO_Implementation;

import com.revature.DAO.ConnectionFactory;
import com.revature.DAO.EmployeeDAO;
import com.revature.beans.Employees;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class EmployeeImplementation
  implements EmployeeDAO
{
  public EmployeeImplementation() {}
  
  public void addEmployee(int managerID, String name, String address, int isManager, String email)
    throws SQLException
  {
    Connection conn = ConnectionFactory.getConnection();
    
    String sql = "INSERT INTO EMPLOYEES VALUES(?,?,?,?,?)";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setInt(1, 0);
    ps.setString(2, name);
    ps.setString(3, address);
    ps.setInt(4, isManager);
    ps.setString(5, email);
    ps.executeQuery();
    ps.close();
    conn.close();
  }
  

  public void deleteEmployee(int employeeID)
    throws SQLException
  {}
  
  public void updateEmployee(int employeeID, String adress)
    throws SQLException
  {
    Connection conn = ConnectionFactory.getConnection();
    String sql = "UPDATE EMPLOYEES SET EMPLOYEE_ADDRESS= ? WHERE EMPLOYEE_ID=?";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setInt(2, employeeID);
    ps.setString(1, adress);
    ps.executeQuery();
    ps.close();
    conn.close();
  }
  
  public void updateEmployeeEmail(int employeeID, String email) throws SQLException
  {
    Connection conn = ConnectionFactory.getConnection();
    String sql = "UPDATE EMPLOYEES SET EMPLOYEE_EMAIL= ? WHERE EMPLOYEE_ID=?";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setInt(2, employeeID);
    ps.setString(1, email);
    ps.executeQuery();
    ps.close();
    conn.close();
  }
  
  public void updateEmployeePassWord(int employeeID, String password) throws SQLException
  {
    Connection conn = ConnectionFactory.getConnection();
    String sql = "UPDATE EMPLOYEES SET EMPLOYEE_PASSWORD= ? WHERE EMPLOYEE_ID=?";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setInt(2, employeeID);
    ps.setString(1, password);
    ps.executeQuery();
    ps.close();
    conn.close();
  }
  

  public Employees retrieveEmployee(String username, String password)
    throws SQLException
  {
    Connection conn = ConnectionFactory.getConnection();
    String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_USERNAME=? AND EMPLOYEE_PASSWORD=? ";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1, username);
    ps.setString(2, password);
    ResultSet rs = ps.executeQuery();
    
    Employees user = null;
    while (rs.next())
    {
      user = new Employees(rs.getInt(1), rs.getInt(4), rs.getString(2), rs.getString(3), rs.getInt(5), rs.getString(8));
    }
    

    conn.close();
    
    return user;
  }
  
  public Employees retrieveEmployeeByID(int userID, String password) throws SQLException
  {
    Connection conn = ConnectionFactory.getConnection();
    String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID=? AND EMPLOYEE_PASSWORD=? ";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setInt(1, userID);
    ps.setString(2, password);
    ResultSet rs = ps.executeQuery();
    Employees user = null;
    while (rs.next())
    {
      user = new Employees(rs.getInt(1), rs.getInt(4), rs.getString(2), rs.getString(3), rs.getInt(5), 
        rs.getString(8));
    }
    conn.close();
    return user;
  }
  
  public List<Employees> retrieveMyEmployee(int managerID) throws SQLException
  {
    Connection conn = ConnectionFactory.getConnection();
    String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_MANAGER=?  ";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setInt(1, managerID);
    
    ResultSet rs = ps.executeQuery();
    
    List<Employees> myEmployees = new ArrayList();
    Employees user = null;
    while (rs.next())
    {
      user = new Employees(rs.getInt(1), rs.getInt(4), rs.getString(2), rs.getString(3), rs.getInt(5), 
        rs.getString(8));
      myEmployees.add(user);
    }
    conn.close();
    return myEmployees;
  }
  
  public String retrieveEmployeeManagerName(int managerID) throws SQLException
  {
    Connection conn = ConnectionFactory.getConnection();
    String sql = "SELECT EMPLOYEE_NAME FROM EMPLOYEES WHERE EMPLOYEE_ID=? ";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setInt(1, managerID);
    
    ResultSet rs = ps.executeQuery();
    
    String managerName = null;
    while (rs.next()) {
      managerName = rs.getString(1);
    }
    
    conn.close();
    return managerName;
  }
  
  public List<Employees> getAllEmployeesWithEmailAndManagerInfo() throws SQLException
  {
    Connection conn = ConnectionFactory.getConnection();
    String sql = "{call Employee_Manager(?)}";
    CallableStatement cs = conn.prepareCall(sql);
    
    cs.registerOutParameter(1, -10);
    
    cs.execute();
    
    ResultSet rs = (ResultSet)cs.getObject(1);
    List<Employees> allEmployees = new ArrayList();
    Employees user = null;
    
    while (rs.next())
    {
      user = new Employees(rs.getString(1), rs.getString(2), rs.getString(3));
      allEmployees.add(user);
    }
    conn.close();
    return allEmployees;
  }
}