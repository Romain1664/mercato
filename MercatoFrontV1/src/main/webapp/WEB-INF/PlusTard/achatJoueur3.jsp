<%@page import="model.*"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Achat Joueur3</title>
</head>
<body>

<form method="POST" action="joueurAcheter">
	<h4> prenom_joueur nom_joueur fait désormais parti de ton équipe</h4>


<form method="POST" action="listeJoueursLibre">
		VEUX TU UN AUTRE JOUEUR?
	</form>
	<br>
	
	<form method="POST" action="AcheterJoueur">
		<p>Achat joueur</p> "id_joueur"	<input type="submit">
	</form>
		<table>
				<tr>
					<td> 
						<p id="P1"> Oui c'est l'émir qui paye </br>
						<input type="radio" name="HO"></p>
						<p id="P2"> Non avec lui ça suffit pour gagner</br>
						<input type="radio" name="HO"></p>  
					</td>
			</table>
		</div>
	
</body>
</html>