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
			<input type="hidden" value="modifStat" name="action">
		</form>
		
		<div id="table1">
			<table>
				<legend>ALORS ON CHANGE QUOI?</legend>
			</table>
		</div>

		
		</div>
	<div id="table2">
			<table>
				<tr> <h4>Offensive</h4> 
					<td>Tir</td>	
					<td> 
					<input placeholder="Tir" type="Tir">
					</td>
				</tr>	
					<td>Precision</td> 	
					<td> 
					<input placeholder="Precision" type="Precision">
					</td>
				</tr> 	
			</table>
		</div>
	<div id="table3">
			<table>
				<tr> <h4>Générale</h4> 
					<td>Acceleration</td>	
					<td> 
					<input placeholder="Acceleration" type="Acceleration">
					</td>
				</tr>	
					<td>Puissance</td>	
					<td> 
					<input placeholder="Puissance" type="Puissance">
					</td>						
				</tr>	
			</table>
		</div>
	<div id="table4">
			<table>
				<tr> <h4>Défense</h4> 
					<td>Tacle</td> 
					<td> 
					<input placeholder="Tacle" type="Tacle">
					</td>
				</tr>
					<td>Marquage</td>	
					<td> 
					<input placeholder="Marquage" type=Marquage">
					</td>
				</tr>
			</table>
		</div>
		<div id="table5">
			<table>
				<td>
					<a href="connection?action=se deconnecter"><p>Se déconnecter</p></a>
				</td>
			</table>
		</div>
	</form>
</body>
	
	
</body>
</html>