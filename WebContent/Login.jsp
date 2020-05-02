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
	<form action="LoginServlet" method="POST">
	<input type="hidden" name="action" value="login">
	<fieldset>
		<%
	String status = (String)request.getAttribute("status");
	if(status != null)
		out.print("<b style = 'color: red'>"  + status + "</b>");
%>
		<legend>Log In</legend>
		<table>
			<tr>
				<td>Select</td>
				<td>
					<select name="type">
						<option selected disabled>---Select---</option>
						<option value="admin">Admin</option>
						<option value="user">User</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>Username : </td><td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Password : </td><td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login"></td>
				<td><input type="submit" value="Cancel"></td>
			</tr>
		</table>
		</fieldset>
	</form>

<jsp:include page="Footer.jsp"></jsp:include>	
	
	<script src="jquery-3.5.0.min.js"></script>
	<script src="jquery.validate.min.js"></script>
	
	<script>
    	$(document).ready(function() {
    		$("form").validate({
    			rules : {
    				username : {
    					required: true
    				},
    				password :
    					{
    						required: true
    					},
    			}
    		})
    	});
    </script>
</body>
</html>