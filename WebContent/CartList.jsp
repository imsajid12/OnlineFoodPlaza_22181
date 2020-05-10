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
	if(!cartList.isEmpty()) {
%>

<form action="OrderServlet" method="POST">
<input type="hidden" name="action" value="placeorder">
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
		<td><input type="number" name="foodQuantity" id="foodquantity" value="<%= cart.getQuantity() %>"></td>
		<td><%= cart.getFoodCategory() %></td>
		<td><%= cart.getCustomerEmail() %></td>
		<td><input type="text" name="foodPrice" id="foodprice" value="<%= cart.getFoodPrice() %>" readonly></td>
		<td><a href="CartServlet?action=delete&id=<%= cart.getCartId() %>">Delete</a></td>
	</tr>
	<% } %>
	</table>
	<input type="submit" value="Place Order">
	<% }
		else if(cartList.isEmpty()) 
	{
	%>
	<b>No items added yet....</b>
	<% } %>
</form>


<jsp:include page="Footer.jsp"></jsp:include>

<script src="jquery-3.5.0.min.js"></script>
<script src="jquery.validate.min.js"></script>
<script>
$("#foodquantity").change(function(){
	//alert("Hi");
	let foodQuantity = document.getElementById("foodquantity").value;
	const foodPrice = document.getElementById("foodprice").value;
	
	let pricePerPiece = foodPrice;
	
	console.log("foodQuantity : " + foodQuantity);
	console.log("foodPrice : " + foodPrice);
	
	console.log("pricePerPiece : " + pricePerPiece);
	
	if(foodQuantity > 0 || foodQuantity !== "") {
		document.getElementById("foodprice").value = foodQuantity*foodPrice;
	}
	else {
		alert("Hi");
	}
	
});
</script>

</body>
</html>