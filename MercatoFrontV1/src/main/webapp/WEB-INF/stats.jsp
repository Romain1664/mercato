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
	
	<div id="table1">
		<table>
			<legend>Voila tes statistiques mon champion</legend>
		</table>
	</div>
	<div id="table2">
			<table>
				<tr> <h4>Offensive</h4> 
					<td>Tir</td>	
					</td>
				</tr>	
					<td>Precision</td> 	
					
				</tr> 	
			</table>
		</div>
	<div id="table3">
			<table>
				<tr> <h4>Générale</h4> 
					<td>Acceleration</td>	
				</tr>	
					<td>Puissance</td>	
				</tr>	
			</table>
		</div>
	<div id="table4">
			<table>
				<tr> <h4>Défense</h4> 
					<td>Tacle</td> 
				</tr>
					<td>Marquage</td>						
				</tr>
			</table>
		</div>
		<div id="table5">
			<table>
				<td>
					<a href="joueur"><p>Retour au menu Joueur</p></a>
				</td>
			</table>
		</div>
	</form>
</body>

</html>