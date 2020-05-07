<%@page import="fr.formation.model.*"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>S'inscrire</title>
</head>
<body class="body2">

	<script>
		function showDiv1 (element)
		{
			if (element.value == "manager") {
		    document.getElementById("hidden_div1").style.display =  'block' ;
		    showDiv2(document.getElementById("choix"));
			} else if (element.value == "joueur") {
			document.getElementById("hidden_div1").style.display =  'none' ;
			document.getElementById("hidden_div2").style.display =  'none' ;
			}
		}
		function showDiv2(element)
		{
			if (element.value == "oui") {
				document.getElementById("hidden_div2").style.display =  'block' ;
			} else if (element.value == "non") {
				document.getElementById("hidden_div2").style.display =  'none' ;
			}
		}
	</script>


	<form method="POST" action="inscription?action=inscription">
		
		<div class="table1">
			<table>
				<tr>
					<td>BIENVENUE SUR L'APPLICATION MERCATO</td>
				</tr>
			</table>
		</div>
		
		<div class="table2">
			<div class="table1">
				<table>
					<tr>
						<td>S'inscrire</td>
					</tr>
				</table>
			</div>
			
			<table>
				<tr>
					<td>Login</td>	
					<td> 
						<input Required type="text" name="login" value="${sessionScope.login}" placeholder="login">
					</td>
				</tr>
				<tr>
					<td>Mot de passe</td> 
					<td>
						<input Required type="password" name="password" placeholder="password">
					</td>
				</tr>
				<tr>
					<td>Type de compte ?</td>	
					<td>
						<select name="type" id="type" onchange="showDiv1(this)">
			            	<option value="joueur">Joueur</option>
			            	<option value="manager">Manager</option>
			        	</select>
					</td>
				</tr>
			</table>
		</div>
		<div id="hidden_div1" class="table2">	
			<table>
				<tr>
					<td>Créer son équipe</td>
					<td>	
						<select name="choix" id="choix" onchange="showDiv2(this)">
			            	<option value="non">Non</option>
			            	<option value="oui">Oui</option>

			        	</select>
					</td>
				</tr>
			</table>
		</div>	
		<div id="hidden_div2" class="table2">
			<table>
				<tr>
					<td>Nom d'équipe</td>
					<td>	
						<input Required type="text" name="nom_equipe" placeholder="Nom d'equipe">
					</td>
				</tr>
				<tr>
					<td>Budget de l'équipe</td>
					<td>
						<input Required type="text" name="budget" placeholder="Budget de l'équipe">
					</td>
				</tr>
			</table>
		</div>
		<input type="submit" value="Valider"/>
	</form>	
	
</body>
</html>