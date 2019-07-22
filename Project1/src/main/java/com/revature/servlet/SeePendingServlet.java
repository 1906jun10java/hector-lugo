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
import com.revature.beans.Employees;
import com.revature.beans.Reimbursement;

@WebServlet("/pending")
public class SeePendingServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		
		ReimbursementDAO_Implementation rd= new ReimbursementDAO_Implementation();
		
		Integer userID= Integer.parseInt(req.getParameter("userID"));
		
		
		//Integer userID= (Integer) session.getAttribute("userID");
		List<Reimbursement> myPending=null;
		try {
			myPending=rd.getSentRPending(userID);
			resp.getWriter().write((new ObjectMapper()).writeValueAsString(myPending));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}//
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
