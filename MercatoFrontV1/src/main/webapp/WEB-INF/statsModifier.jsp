<%@page import="model.*"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
<!DOCTYPE html>
<html>
	<head>
		<title>changement stats joueur</title>
		<meta charset="UTF-8"/>
	</head>
	
	<body>
		<form action="joueurStat" method="POST">
			<div class="table1">
				<table>
					<legend>ALORS ON CHANGE QUOI?</legend>
				</table>
			</div>
			<div class="table2">
				<table> 
					<tr>
						<td colspan="2"><h4>Offensive</h4></td>
					</tr>
					<tr>
						<td>Tir</td>	
						<td> 
							<input placeholder="${sessionScope.tir}" type="text" name="tir">
						</td>
					</tr>	
					<tr>
						<td>Precision</td> 	
						<td> 
							<input placeholder="${sessionScope.precision}" type="text" name="precision">
						</td>
					</tr> 	
					<tr>
						<td colspan="2"><h4>Général</h4></td>
					</tr>
					<tr>
						<td>Acceleration</td>
						<td>
							<input placeholder="${sessionScope.acceleration}" type="text" name="acceleeration">
						</td>
					</tr>	
					<tr>
						<td>Puissance</td>	
						<td> 
							<input placeholder="${sessionScope.puissance}" type="text" name="puissance">
						</td>						
					</tr>
					 <tr>
						<td colspan="2"><h4>Défensive</h4></td>
					</tr>
					<tr>
						<td>Tacle</td> 
						<td> 
							<input placeholder="${sessionScope.tacle}" type="text" name="tacle">
						</td>
					</tr>
					<tr>
						<td>Marquage</td>	
						<td> 
							<input placeholder="${sessionScope.marquage}" type="text" name="marquage">
						</td>
					</tr>
				</table>
				<input type="submit" value="Envoyer">
			</div>
		</form>
		<div class="table1">
			<table>
				<td><a href="joueur"><p>Retour au menu Joueur</p></a></td>
			</table>
		</div>
	</body>
</html>