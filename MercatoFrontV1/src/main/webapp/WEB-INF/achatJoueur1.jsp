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
		<div id="table1">
			<table>
				<legend>L'EMIR VEUT GAGNER LA CHAMPION'S LEAGUE: 
				<br> Qui sera ta nouvelle pépite?</legend>
			</table>
		</div>
		<div id="table2">
			<table>Afficher la liste des joueurs libres	</table>
		</div>
		
		<form method="POST" action="AcheterJoueur">
			<div id="table3">
				<table>
				 <td>
					<p>Achat joueur</p> (MENU DEROULANT?)
						<c:forEach items="${joueur}" var="j">
								<tr> 
									<td>${p.nom}</td>
									<td>${p.prenom}</td>
									<td>${p.age}</td>
								</tr>      
						    </c:forEach>
					</td> 
				</table>
				<input type="submit">
			</div>
		</form>

	
</body>
</html>