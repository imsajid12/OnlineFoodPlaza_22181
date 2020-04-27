<%@page import="com.food.pojo.Food"%>
<%@page import="java.util.ArrayList"%>
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
		List<Food> foodList = new ArrayList<>();
		foodList = (List<Food>)session.getAttribute("flist");
	%>
	
	<table border="1px">
		<tr>
			<th>Food Id</th>
			<th>Food Name</th>
			<th>Food Category</th>
			<th>Food Price</th>
			<th>Food Image</th>
			<th colspan="2">Action</th>
		</tr>
		
		<%
			for(Food food : foodList) {
				
		%>
		
		<tr>
			<td><%= food.getFoodId() %></td>
			<td><%= food.getFoodName() %></td>
			<td><%= food.getFoodCategory() %></td>
			<td><%= food.getFoodPrice() %></td>
			<td><%= food.getFoodImage() %></td>
			<td><a href="FoodServlet?action=delete&id=<%= food.getFoodId() %>">Delete</a></td>
			<td><a href="FoodServlet?action=update&id=<%= food.getFoodId() %>">Update</a></td>
		</tr>
		
		<%
		//end of for each loop
			}
		%>
	</table>
</body>
</html>