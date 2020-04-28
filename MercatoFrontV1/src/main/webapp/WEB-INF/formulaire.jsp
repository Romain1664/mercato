
<%@page import="model.*"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Liste des joueurs</title>
	</head>
	<body>
		<form method="POST" action="joueurs">
			<input type="number" name="id_equipe"/>
				<p>Tape l'identifiant de ton équipe</p>
			<input type="submit" value="Envoyer" />
		</form>
			<div class="table2">
					<table>
						<td>
							<a href="joueurs"><p>Retour au menu Joueur</p></a>
						</td>
					</table>
				</div>
</body>
</html>