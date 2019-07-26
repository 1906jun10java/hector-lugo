package com.revature.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.DAO_Implementation.ReimbursementDAO_Implementation;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet({"/img"})
public class ImgServlet
  extends HttpServlet
{
  ReimbursementDAO_Implementation ri = new ReimbursementDAO_Implementation();
  
  public ImgServlet() {}
  
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Integer rID = Integer.valueOf(Integer.parseInt(req.getParameter("rID")));
    
    byte[] img = null;
    try {
      img = ri.getImg(rID.intValue());
      resp.getWriter().write(new ObjectMapper().writeValueAsString(img));
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }
  




  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException
  {
    doGet(req, resp);
  }
}