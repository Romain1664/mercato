<%@page import="model.*"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>

<html>


	<head>
		<meta charset="UTF-8">
		<title>Inscription Joueur</title>
	</head>

	<body>
		<div class="table1">
			<table>
				<legend>ENTRE TES STATISTIQUES</legend>
			</table>
		</div>
		
		<div class="table2">
			<form action="joueurStat?action=entreeStat" method="POST">
				<table>
					<tr>
						<td>Nom</td>	
						<td> 
							<input placeholder="Nom" type="Text" name="nom" required>
						</td>
					</tr>
					<tr>
						<td>Prenom</td> 
						<td>
							<input placeholder="Prenom" type="Text" name="prenom" required >
						</td>
					</tr>	
					<tr>
						<td>Age</td>	
						<td> 
							<input placeholder="Age" type="Text" name="age"required>
						</td>
					</tr>
					<tr>
						<td>Poste</td> 
						<td>
							<input placeholder="Poste" type="Text" name="poste" required >
						</td>
					</tr>
					<tr>
						<td>Tir</td>	
						<td> 
							<input placeholder="Tir" type="Text" name="tir" required>
						</td>
					</tr>	
					<tr>
						<td>Precision</td> 
						<td>
							<input placeholder="Precision" type="Text" name="precision" required >
						</td>
					</tr>
					<tr>
						<td>Acceleration</td>	
						<td> 
							<input placeholder="Acceleration" type="Text" name="acceleration" required>
						</td>
					</tr>	
					<tr>
						<td>Puissance</td>	
						<td> 
							<input placeholder="Puissance" type="Text" name="puissance" required>
						</td>
					</tr>	
					<tr>
						<td>Tacle</td> 
						<td>
							<input placeholder="Tacle" type="Text" name="tacle" required >
						</td>
					</tr>
					<tr>
						<td>Marquage</td>	
						<td> 
							<input placeholder="Marquage" type="Text" name="marquage" required>
						</td>
					</tr>
					<tr>	
						<td>Prix</td> 
						<td>
							<input placeholder="Prix" type="Text" name="prix" required >
						</td>
					</tr>	
				</table>
				<input type="submit" value="Envoyer">
			</form>	
		</div>
		<div class="table2">
			<table>
				<td>
					<a href="joueur"><p>Retour au menu Joueur</p></a>
				</td>
			</table>
		</div>
	</body>

</html>


