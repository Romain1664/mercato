
<%@page import="fr.formation.model.*"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu Manager</title>
</head>
<body>

	<form action="">
		<div class="table1">
			<table>
				<legend>Menu Manager</legend>
			</table>
		</div>

		<div class="table2">

			<a href="joueurs?action=Tous">Afficher la liste des joueurs inscrits</a>
			<br>
			<br> 
			<a href="manager?action=gestionBudget">Gerer son compte en banque</a>
			<br>
			<br>
			<a href="joueurs?action=Equipe">Afficher les joueurs de son equipe</a>
			<br>
			<br>
			<a href="manager?action=achatJoueur1">Acheter un joueur</a>
			<br>
			<br>
			<a href="manager?action=venteJoueur1">Vendre un joueur</a>
			<br>
			<br>
			<a href="connection">Se deconnecter</a>
		</div>
	</form>
</body>
</html>

