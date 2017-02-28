<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Hello World!!

	<div style="color: #0000FF; background-color: lightblue">
		<h3>LOGIN</h3>
		<form action="http://localhost:8080/javaee/rest/login/do" method="post">
			Username: <input type="text" name="user"> <br> 
			Password: <input type="password" name="pwd"> <br> 
			<input	type="submit" value="Login">
		</form>
	</div>


</body>
</html>