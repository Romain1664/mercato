<%@page import="model.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Menu Joueur</title>
	</head>
	<body>
	
		<form action="">
			<div class="table1">
				<table>
					<legend>Menu Joueur</legend>
				</table>
			</div>
	
			<div class="table2">
	
				<c:choose>
					<c:when test="${sessionScope.joueurInscrit=='N' }">
						<a href="joueur?action=inscription">Etre éligible Joueur</a>
						<br>
						<br>
					</c:when>
					<c:when test="${sessionScope.joueurInscrit=='Y' }">
						<!-- Button trigger modal -->
						<a href="#" data-href="" data-toggle="modal" data-target="#confirm-delete">Se désinscrire</a><br>
						<!-- Modal -->
						<div class="modal fade" id="confirm-delete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-hidden="true">&times;</button>
										<h4 class="modal-title" id="myModalLabel"></h4>
									</div>
									<div class="modal-body">
										<p>Voulez-vous vraiment ranger les crampons ?</p>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default" data-dismiss="modal">Pas maintenant ...</button>
										<a class="btn btn-danger btn-ok" href="joueur?action=desinscription">Retraite bien mérité</a>
									</div>
								</div>
							</div>
						</div>
						<br>
						<a href="joueur?action=statsAfficher">Afficher mes statistiques</a>
						<br>
						<br>
						<a href="joueur?action=statsModifier">Modifier mes statistiques</a>
						<br>
						<br>
					</c:when>
				</c:choose>
				<a href="joueur?action=joueurs">Afficher la liste des joueurs
					inscrits</a> <br> <br> <a href="connection">Se deconnecter</a>
			</div>
		</form>
	</body>
</html>