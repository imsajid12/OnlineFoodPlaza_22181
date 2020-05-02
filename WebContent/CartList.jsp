<%@page import="java.util.ArrayList"%>
<%@page import="com.food.pojo.Cart"%>
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
<jsp:include page="Header.jsp"></jsp:include>

<%
	List<Cart> cartList = (List<Cart>)session.getAttribute("cartlist");
%>

<table>
	<tr>
		<th>Cart Id</th>
		<th>Food Id</th>
		<th>Food Name</th>
		<th>Quantity</th>
		<th>Food Category</th>
		<th>Customer Email</th>
		<th>Food Price</th>
		<th>Action</th>
	</tr>
	
	<% for(Cart cart : cartList) { %>
	<tr>
		<td><%= cart.getCartId() %></td>
		<td><%= cart.getFoodId() %></td>
		<td><%= cart.getFoodName() %></td>
		<td><input type="number" value="<%= cart.getQuantity() %>"></td>
		<td><%= cart.getFoodCategory() %></td>
		<td><%= cart.getCustomerEmail() %></td>
		<td><%= cart.getFoodPrice() %></td>
		<td><a href="CartServlet?action=delete&id=<%= cart.getCartId() %>">Delete</a></td>
	</tr>
	<% } %>
</table>

<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>