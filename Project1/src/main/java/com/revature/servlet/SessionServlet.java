package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Employees;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		
		if (session != null && session.getAttribute("userID") != null) {
			try {//
				
				int userId = Integer.parseInt(session.getAttribute("userID").toString());
				int managerId=Integer.parseInt(session.getAttribute("managerID").toString());
				String name = session.getAttribute("userName").toString();
				String address = session.getAttribute("userAddress").toString();
				int isManager = Integer.parseInt(session.getAttribute("isManager").toString());
				String mamagerName=session.getAttribute("managerName").toString();
				//
				
				Employees u = new Employees(userId, managerId, name, address, isManager,mamagerName);
				//
				resp.getWriter().write((new ObjectMapper()).writeValueAsString(u));
			} catch (Exception e) {
				e.printStackTrace();
				resp.getWriter().write("{\"session\":null}");
			}
		}
		
		else {
			
			resp.getWriter().write("{\"session\":null}");
		}
	}//
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
