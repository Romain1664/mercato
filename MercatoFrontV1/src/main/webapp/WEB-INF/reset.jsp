<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reset password</title>
</head>
<body>

<form method="POST" action="connection?action=reset">

		<input type="text" name="login" placeholder="login">
		<input type="text" name="nouveau password" placeholder="nouveau password">
		
		
		<input type="submit" value="Valider">	
	</form>


</body>
</html>