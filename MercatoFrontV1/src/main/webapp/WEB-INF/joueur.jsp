
<%@page import="model.*"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu Joueur</title>
</head>
<body>

	<form action="">
		<div class="table1">
			<table>
				<legend>Menu Joueur</legend>
			</table>
		</div>

		<div class="table2">

			<c:choose>
				<c:when test ="${sessionScope.joueurInscrit=='N' }">
					<a href="joueur?action=inscription">Etre éligible Joueur</a> 
					<br><br>
				</c:when>
				<c:when test ="${sessionScope.joueurInscrit=='Y' }">
					<a href="joueur?action=desinscription">Se desinscrire</a> 
					<br><br> 
					<a href="joueur?action=statsAfficher">Afficher mes statistiques</a>
					<br> <br> 
					<a href="joueur?action=statsModifier">Modifier mes statistiques</a>
					<br> <br> 
				</c:when>
			</c:choose>	
			<a href="joueur?action=joueurs">Afficher la liste des joueurs inscrits</a>
			<br> <br> 
			<a href="connection">Se	deconnecter</a>

		</div>
	</form>
</body>
</html>