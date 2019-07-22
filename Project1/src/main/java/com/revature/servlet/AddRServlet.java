package com.revature.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.DAO_Implementation.ReimbursementDAO_Implementation;
import com.revature.beans.Reimbursement;

@WebServlet("/add")
public class AddRServlet extends HttpServlet {
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		
		ReimbursementDAO_Implementation rd=new ReimbursementDAO_Implementation();
		
		double amount=Double.parseDouble(req.getParameter("amount"));
		Integer employeeID = (Integer) session.getAttribute("userID");
		Integer managerID=(Integer) session.getAttribute("managerID");
		String status="0";
		
		try {
			rd.addR(employeeID, managerID, status, amount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
