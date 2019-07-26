package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;












@WebServlet({"/updateRequest"})
public class UpdateRequestServlet
  extends HttpServlet
{
  public UpdateRequestServlet() {}
  
  protected void doGet(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
    throws ServletException, IOException
  {
    throw new Error("Unresolved compilation problems: \n\tRequestServices cannot be resolved to a type\n\tRequestServices cannot be resolved to a type\n");
  }
  



  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException
  {
    doGet(req, resp);
  }
}