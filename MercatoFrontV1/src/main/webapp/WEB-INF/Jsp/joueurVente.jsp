<%@page import="fr.formation.model.*"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vente Joueur1</title>
</head>
<body class="body0">
	<div class="table1">
		<table>
			<legend>Le Quatar veut faire des économies : On vire qui Coach ???</legend>
		</table>
	</div>
	<div class="table3">
		<legend>Voici vous joueurs Monsieur : qui voulez-vous jeter aux lions ?</legend>
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
	</div>
	<div class="table3">
		<form method="GET" action="joueurs"> <!-- FAUT VOIR OU CETTE PAGE MENE -->
			<table>
				<tr>
					<td>Qui est le maillon faible ?</td>
					<td>
						<select name="joueurAchat">
							<c:forEach items="${joueurs}" var="j">
								<option value="${j.id}">${j.nom} ${j.prenom}</option>
							</c:forEach>
						</select>
					</td>
					<td><input type="submit" value="Valider"></td>
				</tr>
			</table>
		</form>
	</div>
	<div class="table4">
		<table>
			<tr>
				<td><a href="manager">Retour au menu Manager</a></td>
			</tr>
		</table>
	</div>
</body>

</html>