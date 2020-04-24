<%@page import="model.*"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>

<html>


	<head>
	<meta charset="UTF-8">
		<title>Inscription Joueur</title>
			<meta charset="UTF-8"/>
	</head>

<body>
	<form action="">
		<div id="table1">
			<table>
				<legend>ENTRE TES STATISTIQUES</legend>
		
			</table>
		</div>
	<div id="table2">
	
	<form action="joueurStat?entreeStat" method="POST">
	<input type="hidden" value="entreeStat" name="action">

	</form>
			<table>
			
					<td>Nom</td>	
						<td> 
							<input placeholder="Nom" type="Nom" required>
						</td>
				</tr>
					<td>Prenom</td> 
						<td>
							<input placeholder="Prenom" type="Prenom" required >
						</td>
				</tr>		
					<td>Age</td>	
						<td> 
							<input placeholder="Age" type="Age"required>
						</td>
				</tr>
					<td>Poste</td> 
						<td>
							<input placeholder="Poste" type="Poste" required >
						</td>
				</tr>
					<td>Tir</td>	
						<td> 
							<input placeholder="Tir" type="Tir" required>
						</td>
				</tr>	
					<td>Precision</td> 
						<td>
							<input placeholder="Precision" type="Precision" required >
						</td>
				</tr>
					<td>Acceleration</td>	
						<td> 
							<input placeholder="Acceleration" type="Acceleration" required>
						</td>
				</tr>	
					<td>Puissance</td>	
						<td> 
							<input placeholder="Puissance" type="Puissance" required>
						</td>
				</tr>	
					<td>Tacle</td> 
						<td>
							<input placeholder="Tacle" type="Tacle" required >
						</td>
				</tr>
					<td>Marquage</td>	
						<td> 
							<input placeholder="Marquage" type="Marquage" required>
						</td>
				</tr>
					
					<td>Prix</td> 
						<td>
							<input placeholder="Prix" type="Prix" required >
						</td>
				</tr>	
			</table>
			<input type="submit" value="envoyer">
		</div>
		<div id="table3">
			<table>
				<td id="td2">
					<a href="file:///C:/Users/Modeste/Desktop/Mercato/PageAccueil.html"><p>Se déconnecter</p></a>
				</td>
			</table>
		</div>
	</form>
</body>

</html>

<html>
<head>

