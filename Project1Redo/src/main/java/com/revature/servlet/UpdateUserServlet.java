package com.revature.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.DAO_Implementation.EmployeeImplementation;
import com.revature.beans.Employees;
import com.revature.services.employeeUpdate;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@javax.servlet.annotation.WebServlet({"/userUpdate"})
public class UpdateUserServlet extends HttpServlet
{
  public UpdateUserServlet() {}
  
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
  {
    doPost(req, resp);
  }
  

  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException
  {
    EmployeeImplementation ei = new EmployeeImplementation();
    HttpSession session = req.getSession(false);
    
    Integer userID = (Integer)session.getAttribute("userID");
    System.out.println(userID);
    
    if (req.getParameter("address") != null)
    {
      String newAddress = req.getParameter("address");
      try {
        ei.updateEmployee(userID.intValue(), newAddress);
        
        session.setAttribute("userAddress", newAddress);
        
        int userId = Integer.parseInt(session.getAttribute("userID").toString());
        int managerId = Integer.parseInt(session.getAttribute("managerID").toString());
        String name = session.getAttribute("userName").toString();
        String address = session.getAttribute("userAddress").toString();
        int isManager = Integer.parseInt(session.getAttribute("isManager").toString());
        String mamagerName = session.getAttribute("managerName").toString();
        String email = session.getAttribute("email").toString();
        


        Employees u = new Employees(userId, managerId, name, address, isManager, mamagerName, email);
        
        resp.getWriter().write(new ObjectMapper().writeValueAsString(u));
      }
      catch (SQLException e) {
        e.printStackTrace();
      }
      

    }
    else if (req.getParameter("oldPassword") != null)
    {
      String oldPassword = req.getParameter("oldPassword");
      String newPassword = req.getParameter("newPassword");
      employeeUpdate eu = new employeeUpdate();
      try {
        eu.updatePassword(userID.intValue(), oldPassword, newPassword);
      }
      catch (SQLException e) {
        e.printStackTrace();
      }
      

    }
    else if (req.getParameter("email") != null) {
      String newEmail = req.getParameter("email");
      try
      {
        session.setAttribute("email", newEmail);
        
        ei.updateEmployeeEmail(userID.intValue(), newEmail);
        int userId = Integer.parseInt(session.getAttribute("userID").toString());
        int managerId = Integer.parseInt(session.getAttribute("managerID").toString());
        String name = session.getAttribute("userName").toString();
        String address = session.getAttribute("userAddress").toString();
        int isManager = Integer.parseInt(session.getAttribute("isManager").toString());
        String mamagerName = session.getAttribute("managerName").toString();
        String email = session.getAttribute("email").toString();
        


        Employees u = new Employees(userId, managerId, name, address, isManager, mamagerName, email);
        
        resp.getWriter().write(new ObjectMapper().writeValueAsString(u));
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
    }
  }
}