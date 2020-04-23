<%@page import="model.*"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
<!DOCTYPE html>
<html>
<head>


<meta charset="UTF-8">
<title>Connection</title>
</head>
<body>
	<table>
		<tr>
			<td>Connection</td>
		</tr>
	</table>
	<form method="POST" action="connection?action=inscription">
		<input type="text" name="login" value="${sessionScope.login}" placeholder="login">
		<input type="text" name="password" placeholder="password">
		
		<c:if test ="${sessionScope.isConnect=='N' }">
		<div id="error">Login/Password invalides</div>
		</c:if>
		<input type="submit" value="Valider">	
	</form>
	
	
	
	
		<a href="inscription">S'inscrire</a>

	
	
	
	
		<a href="connection?action=reset">Mot de passe perdu</a>
	
	
</body>
</html>