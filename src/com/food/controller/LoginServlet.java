package com.food.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.dao.LoginDaoImplementation;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    LoginDaoImplementation loginDaoImpl = new LoginDaoImplementation();
    boolean flag;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		//To logout user
		session.invalidate();
		response.sendRedirect("index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String userName, password, type, action;
		
		action = request.getParameter("action");
		type = request.getParameter("type");
		userName = request.getParameter("username");
		password = request.getParameter("password");
		
		if(action != null && action.equals("login")) {
			if(type != null && type.equals("admin")) {
				flag = loginDaoImpl.adminLogin(userName, password);
				
				if(flag == true) {
					session.setAttribute("admin", userName);
					response.sendRedirect("index.jsp");
				}
				else {
					request.setAttribute("status", "Incorrect emailid or password");
					RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
					rd.include(request, response);
				}
			}
			else if(type != null && type.equals("user")) {
				flag = loginDaoImpl.userLogin(userName, password);
				
				if(flag == true) {
					session.setAttribute("user", userName);
					response.sendRedirect("index.jsp");
				}
				else {
					request.setAttribute("status", "Incorrect emailid or password");
					RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
					rd.include(request, response);
				}
			}
			else {
				request.setAttribute("status", "Select type");
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				rd.include(request, response);
			}
		}
		else if(action != null && action.equals("changePassword")) {
			if(type.equals("admin")) {
				flag = loginDaoImpl.adminChangePassword(userName, password);
				
				if(flag == true) {
					out.print("Password Changed");
				}
				else {
					out.print("Failed");
				}
			}
			else if(type != null && type.equals("user")) {
				flag = loginDaoImpl.userChangePassword(userName, password);
				
				if(flag == true) {
					out.print("Password Changed");
				}
				else {
					out.print("Failed");
				}
			}
		}
		
		
	}

}
