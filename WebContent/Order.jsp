<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>

<c:if test="${placeorder != null}">
	<p>Your order has been placed successfully<br> Order details are as follows</p>
	
	<table>
		<tr><th> Order Id</th> <td> ${placeorder.orderId}</td> </tr>
		<tr><th> Total Bill</th> <td> ${placeorder.totalPrice}</td> </tr>
		<tr><th> Status</th> <td> ${placeorder.orderStatus}</td> </tr>
		<tr><th> Date</th> <td> ${placeorder.orderDate}</td> </tr>
	</table>
</c:if>

<marquee>Thanks for visiting!!!</marquee>

<c:if test="${placeorder == null}">
<p>Order is not placed</p>
</c:if>

<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>