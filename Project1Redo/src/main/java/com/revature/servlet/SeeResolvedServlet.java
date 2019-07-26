package com.revature.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.DAO_Implementation.ReimbursementDAO_Implementation;
import com.revature.beans.Reimbursement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/resolved"})
public class SeeResolvedServlet extends HttpServlet
{
  public SeeResolvedServlet() {}
  
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
  {
    javax.servlet.http.HttpSession session = req.getSession(false);
    
    ReimbursementDAO_Implementation rd = new ReimbursementDAO_Implementation();
    
    Integer userID = Integer.valueOf(Integer.parseInt(req.getParameter("userID")));
    


    List<Reimbursement> myResolved = null;
    try {
      myResolved = rd.getSentRResolved(userID.intValue());
      resp.getWriter().write(new ObjectMapper().writeValueAsString(myResolved));
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