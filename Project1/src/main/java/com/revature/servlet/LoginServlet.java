package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.DAO_Implementation.EmployeeImplementation;
import com.revature.beans.Employees;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("Login.html").forward(req, resp);
	}

	/*
	 * doPost: this method will handle all POST requests made to this servlet
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		EmployeeImplementation ei=new EmployeeImplementation();
		Employees user=null;
		String managerName=null;
		try {
			user=ei.retrieveEmployee(req.getParameter("username"), req.getParameter("password"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(user==null) {
			session.setAttribute("problem", "invalid credentials");
			
			resp.sendRedirect("login");
		}
		
		else {
			 try {
				managerName=ei.retrieveEmployeeManagerName(user.getManagerID());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.setAttribute("userID",user.getEmployeeID());
			session.setAttribute("managerID", user.getManagerID());
			session.setAttribute("userName",user.getName());
			session.setAttribute("userAddress", user.getAddress());
			session.setAttribute("isManager", user.getIsManager());
			session.setAttribute("managerName",managerName);
			session.setAttribute("problem", null);
			resp.sendRedirect("profile");
			
			
		}
		//System.out.println(user);
		
		
	}

}