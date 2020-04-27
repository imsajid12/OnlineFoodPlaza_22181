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

import com.food.dao.CustomerDaoImplementation;
import com.food.pojo.Customer;

@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	CustomerDaoImplementation customerDaoImpl = new CustomerDaoImplementation();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		boolean flag;
		HttpSession session = request.getSession();
		List<Customer> customerList = new ArrayList<>();
		
		String action = request.getParameter("action");
		if(action != null && action.equals("delete")) {
			int customerId = Integer.parseInt(request.getParameter("id"));
			flag = customerDaoImpl.deleteCustomer(customerId);
			
			if(flag == true) {
				customerList = customerDaoImpl.showAllCustomer();
				session.setAttribute("clist", customerList);
				response.sendRedirect("CustomerList.jsp");
			}
			else {
				out.print("Failed");
			}
		}
		else if(action != null && action.equals("update")) {
			int customerId = Integer.parseInt(request.getParameter("id"));
			Customer customer = customerDaoImpl.searchCustomerById(customerId);
			
			session.setAttribute("customer", customer);
			response.sendRedirect("UpdateCustomer.jsp");
		}
		else {
			customerList = customerDaoImpl.showAllCustomer();
			session.setAttribute("clist", customerList);
			response.sendRedirect("CustomerList.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		boolean flag;
		String customerName, customerEmail, customerPassword, customerContact, customerAddress;
		HttpSession session = request.getSession();
		List<Customer> customerList = new ArrayList<>();
		int customerId;
		
		String action = request.getParameter("action");
		
		if(action != null && action.equals("addCustomer")) {
			customerName = request.getParameter("customername");
			customerEmail = request.getParameter("customeremail");
			customerPassword = request.getParameter("customerpassword");
			customerContact = request.getParameter("customercontactno");
			customerAddress = request.getParameter("customeraddress");
			
			Customer customer = new Customer(customerName, customerEmail, customerPassword, customerContact, customerAddress);
			flag = customerDaoImpl.addCustomer(customer);
			
			if(flag) {
				customerList = customerDaoImpl.showAllCustomer();
				session.setAttribute("clist", customerList);
				response.sendRedirect("CustomerList.jsp");
			}
			else {
				out.print("Failed");
			}
		}
		else if(action != null && action.equals("updateCustomer")) {
			customerId = Integer.parseInt(request.getParameter("customerid"));
			customerName = request.getParameter("customername");
			customerEmail = request.getParameter("customeremail");
			customerPassword = request.getParameter("customerpassword");
			customerContact = request.getParameter("customercontactno");
			customerAddress = request.getParameter("customeraddress");
			
			Customer customer = new Customer(customerId, customerName, customerEmail, customerPassword, customerContact, customerAddress);
			flag = customerDaoImpl.updateCustomer(customer);
			
			if(flag) {
				customerList = customerDaoImpl.showAllCustomer();
				session.setAttribute("clist", customerList);
				response.sendRedirect("CustomerList.jsp");
			}
			else {
				out.print("Failed");
			}
		}
	}

}
