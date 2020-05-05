package com.food.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.dao.CartDaoImplementation;
import com.food.dao.OrdersDaoImplementation;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	CartDaoImplementation cartDaoImpl = new CartDaoImplementation();
	OrdersDaoImplementation orderDaoImpl = new OrdersDaoImplementation();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		double totalBill = 0;
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		if(action != null && action.equals("placeorder")) {
			String foodQuantity[] = request.getParameterValues("foodQuantity");
			String foodPrice[] = request.getParameterValues("foodPrice");
			
			for(int i=0; i<foodQuantity.length; i++) {
				
				totalBill += Integer.parseInt(foodQuantity[i]) * Double.parseDouble(foodPrice[i]);
			}
			
			String user = (String)session.getAttribute("user");
			int i = orderDaoImpl.placeOrder(user, totalBill);
			
			if(i > 0) {
				cartDaoImpl.deleteFromCartByCustomerEmail(user);
				out.print("Added");
			} else {
				out.print("Failed");
			}
		}
	}

}
