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
import com.food.pojo.Cart;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	CartDaoImplementation cartDaoImpl = new CartDaoImplementation();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		boolean flag;
		List<Cart> cartList = new ArrayList<>();
		
		String action = request.getParameter("action");
		
		String emailId = (String)session.getAttribute("user");
		
		if(action != null && action.equals("addtocart")) {
			int foodId = Integer.parseInt(request.getParameter("id"));
			
			int foodQuantity = 1;
			
			Cart cart = new Cart(foodId, foodQuantity, emailId);
			flag = cartDaoImpl.addToCart(cart);
			
			if(flag == true) {
				cartList = cartDaoImpl.searchFromCartByCustomerEmail(emailId);
				session.setAttribute("cartlist", cartList);
				response.sendRedirect("CartList.jsp");
			} else {
				out.print("Failed");
			}
		}
		else if(action != null && action.equals("delete")) {
			int cartId = Integer.parseInt(request.getParameter("id"));
			flag = cartDaoImpl.deleteFromCartById(cartId);
			
			if(flag == true) {
				cartList = cartDaoImpl.searchFromCartByCustomerEmail(emailId);
				session.setAttribute("cartlist", cartList);
				response.sendRedirect("CartList.jsp");
			}
			else {
				out.print("Failed");
			}
			
		}
		else {
			cartList = cartDaoImpl.searchFromCartByCustomerEmail(emailId);
			session.setAttribute("cartlist", cartList);
			response.sendRedirect("CartList.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
