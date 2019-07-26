package com.revature.servlet;

import com.revature.DAO_Implementation.EmployeeImplementation;
import com.revature.beans.Employees;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;





@WebServlet({"/login"})
public class LoginServlet
  extends HttpServlet
{
  static Logger logger = Logger.getLogger(LoginServlet.class);
  
  private static final long serialVersionUID = 1L;
  

  public LoginServlet() {}
  

  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException
  {
    req.getRequestDispatcher("Login.html").forward(req, resp);
  }
  



  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException
  {
    HttpSession session = req.getSession();
    EmployeeImplementation ei = new EmployeeImplementation();
    Employees user = null;
    String managerName = null;
    try {
      user = ei.retrieveEmployee(req.getParameter("username"), req.getParameter("password"));
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    if (user == null) {
      session.setAttribute("problem", "invalid credentials");
      
      resp.sendRedirect("login");
    }
    else
    {
      try {
        managerName = ei.retrieveEmployeeManagerName(user.getManagerID());
      }
      catch (SQLException e) {
        e.printStackTrace();
      }
      session.setAttribute("userID", Integer.valueOf(user.getEmployeeID()));
      session.setAttribute("managerID", Integer.valueOf(user.getManagerID()));
      session.setAttribute("userName", user.getName());
      session.setAttribute("userAddress", user.getAddress());
      session.setAttribute("isManager", Integer.valueOf(user.getIsManager()));
      session.setAttribute("email", user.getEmail());
      session.setAttribute("managerName", managerName);
      session.setAttribute("problem", null);
      logger.info(user.getName() + " has logged in");
      resp.sendRedirect("profile");
    }
  }
}