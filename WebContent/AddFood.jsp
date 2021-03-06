<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <title>Add Food</title>
  </head>
  <body>
  <jsp:include page="Header.jsp"></jsp:include>
    <form action="FoodServlet" method="POST">
    	<input type="hidden" name="action" value="addFood">
    	<center>
    		<fieldset>
    			<legend>Add Food</legend>
    			<table>
    				<tr>
    					<td>Food Name: </td><td><input type="text" name="foodname"></td>
    				</tr>
    				<tr>
    					<td>Food Category: </td><td><input type="text" name="foodcat"></td>
    				</tr>
    				<tr>
    					<td>Food Image: </td><td><input type="text" name="foodimage"></td>
    				</tr>
    				<tr>
    					<td>Food Price: </td><td><input type="text" name="foodprice"></td>
    				</tr>
    				<tr>
    					<td><input type="submit" value="Add Food"></td>
    					<td><input type="reset" value="Cancel"></td>
    				</tr>
    			</table>
    		</fieldset>
    	</center>
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