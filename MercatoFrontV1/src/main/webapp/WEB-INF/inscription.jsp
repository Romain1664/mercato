<%@page import="model.*"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
<!DOCTYPE html>
<html>
<head>


<meta charset="UTF-8">
<title>S'inscrire</title>
</head>
<body>

	<form method="POST" action="inscription?action=inscription">
		
		<div class="table1">
			<table>
				<legend>BIENVENUE SUR L'APPLICATION MERCATO</legend>
			</table>
		</div>
		
		<div class="table2">
			<legend>S'inscrire</legend>
			
			<table>
				<tr>
					<td>Login</td>	
					<td> 
						<input Required type="text" name="login" value="${sessionScope.login}" placeholder="login">
					</td>
				</tr>
				<tr>
					<td>Mot de passe</td> 
					<td>
						<input Required type="password" name="password" placeholder="password">
					</td>
				</tr>
				<tr>
					<td>Type de compte ?</td>	
					<td>
						<select name="type">
			            	<option value="manager">joueur</option>
			            	<option value="joueur">manager</option>
			        	</select>
					</td>
				</tr>
			</table>
			<br>
			<input type="submit" value="Valider"/>
		</div>
	</form>	
	
</body>
</html>