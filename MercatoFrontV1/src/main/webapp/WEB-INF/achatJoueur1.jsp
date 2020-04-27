<%@page import="model.*"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
<!DOCTYPE html>
<html>
<head>
		<title>Achat Joueur 1</title>
			<meta charset="UTF-8"/>
	</head>

<body>
	<form action="">
		<div class="table1">
			<table>
				<legend>L'EMIR VEUT GAGNER LA CHAMPION'S LEAGUE: 
				<br> Qui sera ta nouvelle pépite?</legend>
			</table>
		</div>
		<div class="table2">
			<table>Afficher la liste des joueurs libres	</table>
		</div>
		
		<form method="POST" action="AcheterJoueur">
			<div class="table3">
				<table>
				 <td>
					<p>Achat joueur</p> (MENU DEROULANT?)
						
					</td> 
				</table>
				<input type="submit">
			</div>
		</form>
		
		<div class="table4">
			<table>
				<td>
					<a href="manager"><p>Retour au menu Manager</p></a>
				</td>
			</table>
		</div>

	
</body>
</html>