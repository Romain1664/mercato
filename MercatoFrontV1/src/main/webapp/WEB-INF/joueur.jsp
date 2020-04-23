
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
	<table>
		<tr>
			<td>Menu Joueur</td>
		</tr>
	</table>
	
	
		<a href="joueur?action=inscription">Etre éligible Joueur</a>
	
	<br>
	<br>
	
	
	
		<a href="joueur?action=desinscription">Se desinscrire</a>

	<br>
	<br>
	
	
	
		<a href="joueur?action=stats">Afficher / Modifier mes statistiques</a>
	
	
	<br>
	<br>
	
	
	
		<a href="joueurs">Afficher la liste des joueurs inscrits</a>
	
	<br>
	<br>
	
	
	
		<a href="connection">Se deconnecter</a>
	
	
	
</body>
</html>