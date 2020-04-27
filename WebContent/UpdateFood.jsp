<%@page import="com.food.pojo.Food"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Food</title>
</head>
<body>
<%
	Food food = (Food)session.getAttribute("food");
%>
	<form action="FoodServlet" method="POST">
	<input type="hidden" name="action" value="updateFood">
    	<center>
    		<fieldset>
    			<legend>Update Food</legend>
    			<table>
    				<tr>
    					<td>Food Id: </td><td><input type="text" name="foodid" value="<%= food.getFoodId() %>" readonly></td>
    				</tr>
    				<tr>
    					<td>Food Name: </td><td><input type="text" name="foodname" value="<%= food.getFoodName() %>"></td>
    				</tr>
    				<tr>
    					<td>Food Category: </td><td><input type="text" name="foodcat" value="<%= food.getFoodCategory() %>"></td>
    				</tr>
    				<tr>
    					<td>Food Image: </td><td><input type="text" name="foodimage" value="<%= food.getFoodImage() %>"></td>
    				</tr>
    				<tr>
    					<td>Food Price: </td><td><input type="text" name="foodprice" value="<%= food.getFoodPrice() %>"></td>
    				</tr>
    				<tr>
    					<td><input type="submit" value="Update Food"></td>
    					<td><input type="reset" value="Cancel"></td>
    				</tr>
    			</table>
    		</fieldset>
    	</center>
    </form>
    
   <!-- <script
  src="https://code.jquery.com/jquery-3.5.0.min.js"
  integrity="sha256-xNzN2a4ltkB44Mc/Jz3pT4iU1cmeR0FkXs4pru/JxaQ="
  crossorigin="anonymous"></script>
   -->
  <script src="jquery-3.5.0.min.js"></script>
	<script src="jquery.validate.min.js"></script>
	
	<script>
    	$(document).ready(function() {
    		$("form").validate({
    			rules : {
    				foodid : {
    					required: true
    				},
    				foodname :
    					{
    						required: true
    					},
    				foodcat :
    					{
    						required: true
    					},
    				foodimage :
    					{
    						required: true
    					},
    				foodprice :
    					{
    						required: true
    					},
    			}
    		})
    	});
    </script>
</body>
</html>