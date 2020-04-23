
<%@page import="model.*"%>
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
	<table>
		<tr>
			<td>Menu Manager</td>
		</tr>
	</table>
	
	
	<form method="POST" action="listeJoueursInscrits">
		<a href="">Afficher la liste des joueurs inscrits</a>
	</form>
	<br>
	<br>
	
	<form method="POST" action="budget">
		<a href="">Gerer son compte en banque</a>
	</form>
	<br>
	<br>
	
	
	<form method="POST" action="joueursEquipe">
		<a href="">Afficher les joueurs de son equipe</a>
	</form>
	<br>
	<br>
	
	
	<form method="POST" action="achatJoueur">
		<a href="">Acheter un joueur</a>
	</form>
	<br>
	<br>
	
	
	<form method="POST" action="vendreJoueur">
		<a href="">Vendre un joueur</a>
	</form>
	<br>
	<br>
	
	
	<form method="POST" action="deconnection">
		<a href="">Se deconnecter</a>
	</form>
</body>
</html>