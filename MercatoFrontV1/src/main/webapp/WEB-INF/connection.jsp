<%@page import="model.*"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Accueil Connection</title>
	</head>
	
	<body>
		<form method="POST" action="connection?action=identification">
			<div class="table1">
				<table>
					<legend>BIENVENUE SUR L'APPLICATION MERCATO</legend>
				</table>
			</div>
		
			<div class="table2">
				<table>
					<tr>
						<td>Login</td>	
						<td> 
							<input type="text" name="login" value="${sessionScope.login}" placeholder="login">
						</td>
					</tr>
					<tr>
						<td>Mot de passe</td> 
						<td>
							<input type="password" name="password" placeholder="password">
						</td>
					</tr>
					<tr>
						<td>
							<c:if test ="${sessionScope.isConnect=='N' }">
								<div id="error">Login/Password invalides</div>
							</c:if>	
							<input type="submit" value="Valider">							
						</td>
					</tr>					
				</table>
			<br>
			<a href="inscription">S'inscrire</a>
			<a href="connection?action=reset">Mot de passe perdu</a>		
			</div>
		</form>
	</body>
</html>