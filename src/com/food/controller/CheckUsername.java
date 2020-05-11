package com.food.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.utility.DBConnection;

/**
 * Servlet implementation class CheckUsername
 */
@WebServlet("/CheckUsername")
public class CheckUsername extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String customerEmail = request.getParameter("customeremail");
		Connection con = DBConnection.getConnection();
		PrintWriter out = response.getWriter();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM Customer WHERE customerEmail = ?");
			ps.setString(1, customerEmail);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				out.print("Already exist!!!");
			}else {
				out.print("");
			}
		}catch(Exception ex) {
			System.out.println(ex);
		}
	}

}
