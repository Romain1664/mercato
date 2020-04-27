<%@page import="model.*"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Affichage statistiques Joueur</title>

</head>

<body>

	<form action="joueur" method="POST">
		<input type="hidden" action="stats">

		<div class="table1">
			<table>
				<legend>Voila tes statistiques mon champion</legend>
			</table>
		</div>
		<div class="table2">
			<table>
				<tr>
					<td colspan="2"><h4>Offensive</h4></td>
				</tr>
				<tr>
					<td>Tir : ${sessionScope.tir}</td>
				</tr>
				<tr>
					<td>Precision : ${sessionScope.precision}</td>
				</tr>
				<tr>
					<td colspan="2"><h4>Général</h4></td>
				</tr>
				<tr>
					<td>Acceleration : ${sessionScope.acceleration}</td>
				</tr>
				<tr>
					<td>Puissance : ${sessionScope.puissance}</td>
				</tr>
				<tr>
					<td colspan="2"><h4>Défensive</h4></td>
				</tr>
				<tr>
					<td>Tacle : ${sessionScope.tacle}</td>
				</tr>
				<tr>
					<td>Marquage : ${sessionScope.marquage}</td>
				</tr>
			</table>
		</div>
		<div class="table1">
			<table>
				<td><a href="joueur"><p>Retour au menu Joueur</p></a></td>
			</table>
		</div>
	</form>
</body>
	
	
</body>
</html>