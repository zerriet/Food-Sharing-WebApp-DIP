<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="LoginRegister" method="post">
		<table
			style="background-image: url('https://static.abbottnutrition.com/cms-prod/abbottfamily.com.sg/img/Article%201%20banner_tcm150-71042.jpg'); width: 500px;  height: 200px; margin-left: 20px; margin-left: 20px;">
			<tr>
				<td><h3 style="color: red;">${message}</h3>
					<h3 style="color: green;">${SuccessMessage}</h3></td>
			</tr>
			<tr>
				<td><h3 style="color: Red;">Recipe Login Page</h3></td>
				<td></td>
			</tr>
			<tr>
				<td>UserName :</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="password1"></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="login"></td>
				<td><a href="register.jsp">Registration</a></td>
			</tr>
		</table>
	</form>
</body>
</html>