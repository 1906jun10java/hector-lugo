package com.revature.servlet;

import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.ParamPart;
import com.revature.DAO_Implementation.ReimbursementDAO_Implementation;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.IOUtils;










@WebServlet({"/add"})
public class AddRServlet
  extends HttpServlet
{
  public AddRServlet() {}
  
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException
  {
    doPost(req, resp);
  }
  
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException
  {
    HttpSession session = req.getSession(false);
    

    MultipartParser mp = new MultipartParser(req, 999999999);
    ReimbursementDAO_Implementation rd = new ReimbursementDAO_Implementation();
    
    ParamPart pp = (ParamPart)mp.readNextPart();
    FilePart fp = (FilePart)mp.readNextPart();
    

    double amount = Double.parseDouble(pp.getStringValue());
    Integer employeeID = (Integer)session.getAttribute("userID");
    InputStream imgIn = fp.getInputStream();
    

    byte[] imgArray = IOUtils.toByteArray(imgIn);
    
    Integer managerID = (Integer)session.getAttribute("managerID");
    String status = "0";
    

    try
    {
      rd.addR(employeeID.intValue(), managerID.intValue(), status, amount, imgArray);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }
}