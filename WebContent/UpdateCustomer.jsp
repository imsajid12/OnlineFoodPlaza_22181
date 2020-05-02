<%@page import="com.food.pojo.Customer"%>
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
	Customer customer = (Customer)session.getAttribute("customer");
%>
	<form action="CustomerServlet" method="POST">
	<input type="hidden" name="action" value="updateCustomer">
		<table>
		<tr>
				<td>Customer Id: </td><td><input type="number" name="customerid" value="<%= customer.getCustomerId() %>" readonly></td>
			</tr>
			<tr>
				<td>Customer Name: </td><td><input type="text" name="customername" value="<%= customer.getCustomerName() %>"></td>
			</tr>
			<tr>
				<td>Customer EmailId: </td><td><input type="email" name="customeremail" value="<%= customer.getCustomerEmail() %>"></td>
			</tr>
			<tr>
				<td>Customer Password: </td><td><input type="text" name="customerpassword" value="<%= customer.getCustomerPassword() %>"></td>
			</tr>
			<tr>
				<td>Customer Contact No: </td><td><input type="number" name="customercontactno" value="<%= customer.getCustomerContact() %>"></td>
			</tr>
			<tr>
				<td>Customer Address: </td><td><textarea rows="4" col="50" name="customeraddress"><%= customer.getCustomerAddress() %></textarea></td>
			</tr>
			<tr>
    					<td><input type="submit" value="Update Customer"></td>
    					<td><input type="reset" value="Cancel"></td>
    		</tr>
		</table>
	</form>
	
<jsp:include page="Footer.jsp"></jsp:include>
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
				customerid : {
					required: true
				},
				customername : {
					required: true
				},
				customeremail :
					{
						required: true
					},
				customerpassword :
					{
						required: true
					},
				customercontactno :
					{
						required: true
					},
					customeraddress :
					{
						required: true
					}
			}
		})
	});
	</script>
</body>
</html>