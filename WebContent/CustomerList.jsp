<%@page import="java.util.ArrayList"%>
<%@page import="com.food.pojo.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
		List<Customer> customerList = new ArrayList<>();
		customerList = (List<Customer>)session.getAttribute("clist");
	%>
	
	<table border="1px">
		<tr>
			<th>Customer Id</th>
			<th>Customer Name</th>
			<th>Customer Email</th>
			<th>Customer Password</th>
			<th>Customer Contact</th>
			<th>Customer Address</th>
			<th colspan="2">Action</th>
		</tr>
		
		<%
			for(Customer customer : customerList) {
				
		%>
		
		<tr>
			<td><%= customer.getCustomerId() %></td>
			<td><%= customer.getCustomerName() %></td>
			<td><%= customer.getCustomerEmail() %></td>
			<td><%= customer.getCustomerPassword() %></td>
			<td><%= customer.getCustomerContact() %></td>
			<td><%= customer.getCustomerAddress() %></td>
			<td><a href="CustomerServlet?action=delete&id=<%= customer.getCustomerId() %>">Delete</a></td>
			<td><a href="CustomerServlet?action=update&id=<%= customer.getCustomerId() %>">Update</a></td>
		</tr>
		
		<%
		//end of for each loop
			}
		%>
</body>
</html>