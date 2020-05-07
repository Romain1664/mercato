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
	<div class="table1">
		<table>
			<legend>BIENVENUE SUR L'APPLICATION MERCATO</legend>
		</table>
	</div>
	<div class = "table2">
		<table>
			<tr>
				<td>Login</td>	
				<td>
					<input type="text" name="login" placeholder="Login">
				</td>
			</tr>
			<tr>
				<td>Nouveau password</td>	
				<td>
					<input type="password" name="nouveau password" placeholder="Nouveau password">
				</td>
			</tr>
				
			<tr>
				<td>		
					<input type="submit" value="Valider">
				</td>
			</tr>
		</table>
	</div>	
</form>


</body>
</html>