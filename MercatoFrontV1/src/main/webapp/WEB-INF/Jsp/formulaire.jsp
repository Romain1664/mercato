
<%@page import="fr.formation.model.*"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Liste des joueurs</title>
	</head>
	<body class="body0">
		<form method="POST" action="joueurs">
			<input type="number" name="id_equipe"/>
				<p>Tape l'identifiant de ton équipe</p>
			<input type="submit" value="Envoyer" />
		</form>
			<div class="table2">
				<table>
					<td>
						<a href="manager"><p>Retour au menu Manager</p></a>
					</td>
				</table>
			</div>
	</body>
</html>