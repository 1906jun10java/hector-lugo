package com.revature.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.DAO_Implementation.ReimbursementDAO_Implementation;
import com.revature.beans.Reimbursement;
import com.revature.services.RequestServices;


@WebServlet("/updateRequest")
public class UpdateRequestServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String status= (req.getParameter("status"));
		Integer rID= Integer.parseInt(req.getParameter("rID"));
		
		RequestServices rs= new RequestServices();
		
		rs.updateRequest(status, rID);
		
		
		
		
		
		
		
	}//
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}


