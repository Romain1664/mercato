<%@page import="fr.formation.model.*"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
<!DOCTYPE html>
<html>
	<head>
		<title>changement stats joueur</title>
		<meta charset="UTF-8"/>
	</head>
	
	<body class="body5">
		<div class="table1">
			<legend>ALORS ON CHANGE QUOI?</legend>
		</div>
		<div class="table2">
			<form action="joueurStat?action=modifStat" method="POST">
				<table> 
					<tr>
						<td colspan="2"><h4>Offensive</h4></td>
					</tr>
					<tr>
						<td>Tir</td>	
						<td> 
							<input value="${sessionScope.tir}" type="text" name="tir">
						</td>
					</tr>	
					<tr>
						<td>Precision</td> 	
						<td> 
							<input value="${sessionScope.precision}" type="text" name="precision">
						</td>
					</tr> 	
					<tr>
						<td colspan="2"><h4>Général</h4></td>
					</tr>
					<tr>
						<td>Acceleration</td>
						<td>
							<input value="${sessionScope.acceleration}" type="text" name="acceleration">
						</td>
					</tr>	
					<tr>
						<td>Puissance</td>	
						<td> 
							<input value="${sessionScope.puissance}" type="text" name="puissance">
						</td>						
					</tr>
					 <tr>
						<td colspan="2"><h4>Défensive</h4></td>
					</tr>
					<tr>
						<td>Tacle</td> 
						<td> 
							<input value="${sessionScope.tacle}" type="text" name="tacle">
						</td>
					</tr>
					<tr>
						<td>Marquage</td>	
						<td> 
							<input value="${sessionScope.marquage}" type="text" name="marquage">
						</td>
					</tr>
				</table>
				<input type="submit" value="Envoyer">
			</form>
		</div>
		<div class="table1">
			<table>
				<td><a href="joueur"><p>Retour au menu Joueur</p></a></td>
			</table>
		</div>
	</body>
</html>