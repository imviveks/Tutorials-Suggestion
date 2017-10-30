<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Form</title>
<link href="bootstrap.css" type="text/css" rel="style">

</head>
<body><br><br><br>
<center><h1>Login</h1></center>
<form action ="UserLoginController1" method="post">
<table align="center">
<tr>
<th align="right">User ID:</th>
<td><input type="text" name="userid"></td>
</tr>
<th align="right">User Password:</th>
<td><input type="password" name="userPassword"></td>
</tr>
<tr>
<td colspan="2" align="right"><input type="submit" value="Log In" class="btn btn-primary"></td>
</tr>
</table>
  <!--  User ID:<input type="text" name="userid"/><br/>
   User Password:<input type="password" name="userPassword"/></br>
   <input type="submit" value="Login"/> -->
</form>
</body>
</html>