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


@WebServlet({"/allResolved"})
public class AllResolvedRequestsServlet
  extends HttpServlet
{
  public AllResolvedRequestsServlet() {}
  
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException
  {
    ReimbursementDAO_Implementation rd = new ReimbursementDAO_Implementation();
    




    List<Reimbursement> allResolvedResolved = null;
    try {
      allResolvedResolved = rd.getAllResolvedRequests();
      resp.getWriter().write(new ObjectMapper().writeValueAsString(allResolvedResolved));
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