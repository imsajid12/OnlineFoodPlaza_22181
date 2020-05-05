<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Tea and Meal - Free CSS Template</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
	<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%
	String admin = (String)session.getAttribute("admin");
String user = (String)session.getAttribute("user");
%>
<!--  Free CSS Template by TemplateMo.com  --> 
<div id="templatemo_container">
	<div id="templatemo_header">
    	<div id="site_title"></div>
    </div> <!-- end of header -->
    
    <div id="templatemo_menu">
    <% if(admin == null && user != null) { %>
        <ul>
        	<li class="current"><a href="#"><b>Home</b></a></li>
            <li><a href="FoodServlet"><b>Food Menu</b></a></li>
            <li><a href="CustomerServlet"><b>Edit Profile</b></a></li>
            <li><a href="ChangePassword.jsp"><b>Change Password</b></a></li>
            <li><a href="LoginServlet"><b>Log Out</b></a></li>
            <li><a href="CartServlet"><b>Cart</b></a></li>
            <li ><a href="#"><b>Contact</b></a></li>
        </ul>
       <% } %> 
       <% if(admin != null && user == null) { %>
        <ul>
        	<li class="current"><a href="#"><b>Home</b></a></li>
            <li><a href="FoodServlet"><b>Food Menu</b></a></li>
            <li><a href="AddFood.jsp"><b>Add Food</b></a></li>
            <li><a href="FoodServlet"><b>Update Food</b></a></li>
            <li><a href="ChangePassword.jsp"><b>Change Password</b></a></li>
            <li><a href="LoginServlet"><b>Log Out</b></a></li>
            <li ><a href="#"><b>Contact</b></a></li>
        </ul>
       <% } %>
       <% if(admin == null && user == null) { %>
        <ul>
        	<li class="current"><a href="#"><b>Home</b></a></li>
            <li><a href="FoodServlet"><b>Food Menu</b></a></li>
            <li><a href="AddCustomer.jsp"><b>Register</b></a></li>
            <li><a href="Login.jsp"><b>Log In</b></a></li>
            <li ><a href="#"><b>Contact</b></a></li>
        </ul>
       <% } %>
       <% if(admin != null && user != null) { %>
        <ul>
            <li><a href="LoginServlet"><b>Log Out</b></a></li>
        </ul>
       <% } %> 
    </div> <!-- end of menu -->
</html>