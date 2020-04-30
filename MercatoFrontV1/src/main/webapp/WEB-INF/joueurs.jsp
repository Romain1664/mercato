
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
		<div class="table3">
			<form method="GET" action="joueurs">
				<legend>Voici les joueurs inscrits sur l'application</legend>
				<table class="table">
					<thead>
						<tr align="center">
							<th scope="col">id</th>
							<th scope="col">Nom</th>
							<th scope="col">Prenom</th>
							<th scope="col">Age</th>
							<th scope="col">Poste</th>
							<th scope="col">Tir</th>
							<th scope="col">Precision</th>
							<th scope="col">Accélération</th>
							<th scope="col">Puissance</th>
							<th scope="col">Tacle</th>
							<th scope="col">Marquage</th>
							<th scope="col">Id_Equipe</th>
							<th scope="col">Prix</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${joueurs}" var="j">
							<tr align="center">
								<td>${j.id}</td>
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
					</tbody>
				</table>
			</form>
		</div>
		<div class="table2">
			<c:choose>
					<c:when test="${sessionScope.typeAccount=='Joueur' }">
						<a href="joueur"><p>Retour au menu Joueur</p></a>
						<br>
						<br>
					</c:when>
					<c:when test="${sessionScope.typeAccount=='Manager' }">
					<a href="manager"><p>Retour au menu Manager</p></a>
					</c:when>
			</c:choose>
			
			
		</div>
	</body>
</html>