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
					<tr><h4>Offensive</h4> 
						<td>Tir</td>	
						<td> 
							<input placeholder="Tir" type="text" name="tir">
						</td>
					</tr>	
					<tr>
						<td>Precision</td> 	
						<td> 
							<input placeholder="Precision" type="text" name="precision">
						</td>
					</tr> 	
				</table>
			</div>
			<div class="table2">
				<table>
					<tr> <h4>Générale</h4> 
						<td>Acceleration</td>	
						<td> 
							<input placeholder="Acceleration" type="text" name="acceleeration">
						</td>
					</tr>	
					<tr>
						<td>Puissance</td>	
						<td> 
							<input placeholder="Puissance" type="text" name="puissance">
						</td>						
					</tr>	
				</table>
			</div>
			<div class="table2">
				<table>
					<tr> <h4>Défense</h4> 
						<td>Tacle</td> 
						<td> 
						<input placeholder="Tacle" type="text" name="tacle">
						</td>
					</tr>
					<tr>
						<td>Marquage</td>	
						<td> 
						<input placeholder="Marquage" type="text" name="marquage">
						</td>
					</tr>
				</table>
			</div>
		<div class="table2">
			<a href=joueur><p>Retourner au menu joueur</p></a>
		</div>
		</form>
	</body>
</html>