<%@page import="fr.formation.model.*"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html	xmlns:th="http://www.thymeleaf.org"
		th:replace="~{layout.html :: layout(~{::title}, ~{::body})}">
		
	<head>
		<title>Accueil Connection</title>
	</head>
	
	<body class="body1">
		<form method="POST" action="connection">
			<div class="table1">
				<table>
					<tr>
						<td>BIENVENUE SUR L'APPLICATION MERCATO</td>
					</tr>
				</table>
			</div>
		
			<div class="table2">
				<table>
					<tr>
						<td>Login</td>	
						<td><input type="text" name="login" th:value="${login}" placeholder="Login"></td>
					</tr>
					<tr>
						<td>Mot de passe</td> 
						<td><input type="password" name="password" placeholder="Password"></td>
					</tr>
				</table>
				
				<input type="submit" value="Valider">		
								
				<span class="error" th:if="${error!=null}" th:text="${error}"></span>
				<span class="valid" th:if="${message!=null}" th:text="${message}"></span>					
			<br>
			<a href="inscription">S'inscrire</a>
			<a href="reset_password">Mot de passe perdu</a>		
			</div>
		</form>
	</body>
</html>