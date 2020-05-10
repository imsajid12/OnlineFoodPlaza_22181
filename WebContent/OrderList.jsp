<%@page import="com.food.pojo.Orders"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Orders List</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>

<%
	List<Orders> orderList = (List<Orders>)session.getAttribute("orderList");
	if(!orderList.isEmpty()) {
		System.out.print(orderList.size());
%>

<form action="OrderServlet" method="POST">
<input type="hidden" name="action" value="placeorder">
	<table>
	<tr>
		<th>Order Id</th>
		<th>Customer Email</th>
		<th>Total Price</th>
		<th>Order Status</th>
		<th>Order Date</th>
		<th>Action</th>
	</tr>
	
	<% for(Orders order : orderList) { %>
	<tr>
		<td><%= order.getOrderId() %></td>
		<td><%= order.getCustomerEmail() %></td>
		<td><%= order.getTotalPrice() %></td>
		<td><%= order.getOrderStatus() %></td>
		<td><%= order.getOrderDate() %></td>
		<td><a href="OrderServlet?action=delete&id=<%= order.getOrderId() %>">Delete</a></td>
	</tr>
	<% } %>
	</table>
	<!-- <input type="submit" value="Cancel Order"> -->
	<% }
		else if(orderList.isEmpty()) 
	{
	%>
	<b>No items added yet....</b>
	<% } %>
</form>


<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>