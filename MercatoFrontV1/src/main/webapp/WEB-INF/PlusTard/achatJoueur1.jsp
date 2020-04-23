<%@page import="model.*"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Achat Joueur1</title>
</head>
<body>
<form method="POST" action="listeJoueursLibre">
		<a href="">Afficher la liste des joueurs libres</a>
	</form>
	<c:forEach items="${joueur}"var="j">
				<c:if test="${p.prenom!='jordan'}">
					<tr> 
						<td>${p.nom}</td>
						<td>${p.prenom}</td>
						<td>${p.age}</td>
					</tr>      
				</c:if>
    </c:forEach>
	
	
	<form method="POST" action="AcheterJoueur">
		<p>Achat joueur</p> "id_joueur"	<input type="submit">
	</form>
	<br>
	<br>
	
	
</body>
</html>