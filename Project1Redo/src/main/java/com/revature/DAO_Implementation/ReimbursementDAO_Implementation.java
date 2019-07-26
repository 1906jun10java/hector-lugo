package com.revature.DAO_Implementation;

import com.revature.DAO.ConnectionFactory;
import com.revature.DAO.ReimbursementDAO;
import com.revature.beans.Reimbursement;
import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;








public class ReimbursementDAO_Implementation
  implements ReimbursementDAO
{
  static final Logger log = Logger.getLogger(ReimbursementDAO_Implementation.class);
  
  public ReimbursementDAO_Implementation() {}
  
  public void addR(int employeeID, int managerID, String status, double amount, byte[] img) throws SQLException { Connection conn = ConnectionFactory.getConnection();
    String sql = "INSERT INTO REIMBURSEMENT (R_EMPLOYEE, R_MANAGER, STATUS,R_AMMOUNT,R_IMAGE) VALUES(?,?,?,?,?)";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setInt(1, employeeID);
    ps.setInt(2, managerID);
    ps.setString(3, status);
    ps.setDouble(4, amount);
    ps.setBytes(5, img);
    ps.executeQuery();
    
    log.info("New Request Made");
    
    ps.close();
    conn.close();
  }
  
  public byte[] getImg(int rID) throws SQLException
  {
    Connection conn = ConnectionFactory.getConnection();
    String sql = "SELECT R_IMAGE FROM Reimbursement WHERE R_ID=?";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setInt(1, rID);
    ResultSet rs = ps.executeQuery();
    
    InputStream imgIn = null;
    

    while (rs.next()) {
      imgIn = rs.getBinaryStream(1);
    }
    byte[] imgArray = null;
    try {
      if (imgIn != null) {
        imgArray = IOUtils.toByteArray(imgIn);
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    

    return imgArray;
  }
  
  public void updateR(int rID, String status) throws SQLException
  {
    Connection conn = ConnectionFactory.getConnection();
    
    String sql = "UPDATE Reimbursement SET STATUS= ? WHERE R_ID=?";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1, status);
    ps.setInt(2, rID);
    ps.executeQuery();
    ps.close();
    conn.close();
  }
  
  public List<Reimbursement> getSentR(int employeeID)
    throws SQLException
  {
    Connection conn = ConnectionFactory.getConnection();
    String sql = "SELECT * FROM Reimbursement WHERE EMPLOYEE_ID=?  ";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setInt(1, employeeID);
    ResultSet rs = ps.executeQuery();
    List<Reimbursement> myR = new ArrayList();
    Reimbursement r = null;
    while (rs.next())
    {

      r = new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getDouble(6));
      myR.add(r);
    }
    
    return myR;
  }
  
  public List<Reimbursement> getSentRPending(int employeeID) throws SQLException {
    Connection conn = ConnectionFactory.getConnection();
    String sql = "SELECT * FROM Reimbursement WHERE R_EMPLOYEE=? AND STATUS=0 ";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setInt(1, employeeID);
    ResultSet rs = ps.executeQuery();
    List<Reimbursement> myR = new ArrayList();
    Reimbursement r = null;
    while (rs.next())
    {

      r = new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getDouble(6));
      myR.add(r);
    }
    
    return myR;
  }
  
  public List<Reimbursement> getSentRResolved(int employeeID) throws SQLException {
    Connection conn = ConnectionFactory.getConnection();
    String sql = "SELECT * FROM Reimbursement WHERE R_EMPLOYEE=? AND STATUS!=0 ";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setInt(1, employeeID);
    ResultSet rs = ps.executeQuery();
    List<Reimbursement> myR = new ArrayList();
    Reimbursement r = null;
    while (rs.next())
    {

      r = new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getDouble(6));
      myR.add(r);
    }
    
    return myR;
  }
  
  public List<Reimbursement> getAllRequests() throws SQLException {
    Connection conn = ConnectionFactory.getConnection();
    String sql = "SELECT * FROM Reimbursement";
    PreparedStatement ps = conn.prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    List<Reimbursement> myR = new ArrayList();
    Reimbursement r = null;
    while (rs.next())
    {

      r = new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getDouble(6));
      myR.add(r);
    }
    
    return myR;
  }
  
  public List<Reimbursement> getMyEmployyesR(int managerID) throws SQLException
  {
    Connection conn = ConnectionFactory.getConnection();
    String sql = "SELECT * FROM Reimbursement WHERE MANAGER_ID=? AND STATUS=0  ";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setInt(1, managerID);
    ResultSet rs = ps.executeQuery();
    List<Reimbursement> myEmployeesR = new ArrayList();
    Reimbursement r = null;
    while (rs.next())
    {

      r = new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getDouble(6));
      myEmployeesR.add(r);
    }
    
    return myEmployeesR;
  }
  
  public List<Reimbursement> getAllResolvedRequests() throws SQLException
  {
    Connection conn = ConnectionFactory.getConnection();
    String sql = "{call REQUEST_INFO(?)}";
    CallableStatement cs = conn.prepareCall(sql);
    
    cs.registerOutParameter(1, -10);
    
    cs.execute();
    
    ResultSet rs = (ResultSet)cs.getObject(1);
    List<Reimbursement> resolved = new ArrayList();
    Reimbursement request = null;
    
    while (rs.next())
    {

      request = new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getString(5), 
        rs.getString(6));
      resolved.add(request);
    }
    conn.close();
    return resolved;
  }
  
  public void addR(int employeeID, int managerID, String status, double amount)
    throws SQLException
  {}
  
  public void addR(int employeeID, int managerID, String status, double amount, InputStream img)
    throws SQLException
  {}
}