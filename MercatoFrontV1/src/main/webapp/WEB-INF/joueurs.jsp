
<%@page import="model.*"%>
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
			<div class="table1">
				<table>
					<legend>Voici les joueurs inscrits sur l'application</legend>
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
							    <td>${j.id_equipe}</td>
							    <td>${j.prix}</td>
						    </tr>
   						</c:forEach>
				</table>
			</div>
		</form>
			<div class="table2">
					<table>
						<td>
							<a href="joueurs"><p>Retour au menu Joueur</p></a>
						</td>
					</table>
				</div>
</body>
</html>