package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

@WebServlet({"/logout"})
public class LogoutServlet
  extends HttpServlet
{
  static final Logger log = Logger.getLogger(LogoutServlet.class);
  
  public LogoutServlet() {}
  
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
  {
    HttpSession session = req.getSession(false);
    
    log.info(session.getAttribute("userName") + " has logged out");
    
    if (session != null) {
      session.invalidate();
    }
    
    resp.sendRedirect("login");
  }
  
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException
  {
    doGet(req, resp);
  }
}