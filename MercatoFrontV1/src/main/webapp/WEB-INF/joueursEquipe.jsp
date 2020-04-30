
<%@page import="fr.formation.model.*"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>Liste des joueurs</title>
	</head>
	
	<body>
		<form method="GET" action="joueurs">
			<div class="table3">
				<table>
					<legend>Voici la liste des joueurs de ton équipe</legend>
					<c:forEach items="${joueurs}" var="j">
						<tr>
						   	<td>${j.nom}</td>
						    <td>${j.prenom}</td>
						    <td>${j.age}</td>
						    <td>${j.poste}</td>
						    <td>${j.tir}</td>
						    <td>${j.precision}</td>
						    <td>${j.acceleration}</td>
						    <td>${j.puissance}</td>
						    <td>${j.tacle}</td>
						    <td>${j.marquage}</td>							   
						    <td>${j.prix}</td>
						</tr>
   					</c:forEach>
				</table>
			</div>
		</form>
		<div class="table2">
			<table>
				<td>
					<a href="manager"><p>Retour au menu Manager</p></a>
				</td>
			</table>
		</div>
		
	</body>
	
</html>