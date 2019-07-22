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
import com.revature.DAO_Implementation.EmployeeImplementation;
import com.revature.beans.Employees;
import com.revature.beans.Reimbursement;

@WebServlet("/employeeList")
public class SeeMyEmployeesServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		
		EmployeeImplementation ei= new EmployeeImplementation();
		Integer userID= (Integer) session.getAttribute("userID");
		List<Employees> myEmployees=null;
		
		try {
			myEmployees=ei.retrieveMyEmployee(userID);
			resp.getWriter().write((new ObjectMapper()).writeValueAsString(myEmployees));
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
