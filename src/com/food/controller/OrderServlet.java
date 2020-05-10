package com.food.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.dao.CartDaoImplementation;
import com.food.dao.OrdersDaoImplementation;
import com.food.pojo.Orders;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	CartDaoImplementation cartDaoImpl = new CartDaoImplementation();
	OrdersDaoImplementation orderDaoImpl = new OrdersDaoImplementation();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		List<Orders> orders = new ArrayList<>();
		String user = (String) session.getAttribute("user");
		
		orders = orderDaoImpl.showMyOrder(user);
		session.setAttribute("orderList", orders);
		response.sendRedirect("OrderList.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		double totalBill = 0;
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		List<Orders> orders = new ArrayList<>();
		String user = (String) session.getAttribute("user");
		
		if(action != null && action.equals("placeorder")) {
			String foodQuantity[] = request.getParameterValues("foodQuantity");
			String foodPrice[] = request.getParameterValues("foodPrice");
			
			for(int i=0; i<foodQuantity.length; i++) {
				
				totalBill += Integer.parseInt(foodQuantity[i]) * Double.parseDouble(foodPrice[i]);
			}
			
			//String user = (String)session.getAttribute("user");
			int i = orderDaoImpl.placeOrder(user, totalBill);
			
			if(i > 0) {
				cartDaoImpl.deleteFromCartByCustomerEmail(user);
				out.print("Order Placed");
				
				
				 orders = orderDaoImpl.showMyOrder(user); 
				 session.setAttribute("orderList", orders); 
				 response.sendRedirect("OrderList.jsp");
			} else {
				out.print("Failed");
				response.sendRedirect("CartList.jsp");
			}
		}
		else {
			orders = orderDaoImpl.showMyOrder(user);
			session.setAttribute("orderList", orders);
			response.sendRedirect("OrderList.jsp");
		}
	}

}
