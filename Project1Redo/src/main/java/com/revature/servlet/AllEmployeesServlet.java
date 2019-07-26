package com.revature.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.DAO_Implementation.EmployeeImplementation;
import com.revature.beans.Employees;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/allEmployees"})
public class AllEmployeesServlet extends HttpServlet
{
  public AllEmployeesServlet() {}
  
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
  {
    javax.servlet.http.HttpSession session = req.getSession(false);
    
    EmployeeImplementation ei = new EmployeeImplementation();
    
    List<Employees> allEmployees = null;
    try
    {
      allEmployees = ei.getAllEmployeesWithEmailAndManagerInfo();
      resp.getWriter().write(new ObjectMapper().writeValueAsString(allEmployees));
    }
    catch (SQLException e) {
      e.printStackTrace();
    }
  }
  

  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException
  {
    doGet(req, resp);
  }
}