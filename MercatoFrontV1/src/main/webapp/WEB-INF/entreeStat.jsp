<%@page import="model.*"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>


<meta charset="UTF-8">
<title>S'inscrire</title>
</head>
<body>



	<form action="joueurStat" method="POST">
		<input type="hidden" value="entreeStat" name="action">

	</form>


	<input type="text" name="nom" placeholder="Nom">
	<input type="text" name="prenom" placeholder="Personne">
	<input type="text" name="age" placeholder="Age">
	<input type="text" name="poste" placeholder="Poste">
	<input type="text" name="tir" placeholder="Statistique de tir">
	<input type="text" name="precision"
		placeholder="Statistique de précision">
	<input type="text" name="acceleration"
		placeholder="Statistique d'accelération">
	<input type="text" name="puissance"
		placeholder="Statistique de puissance">
	<input type="text" name="tacle" placeholder="Statistique de tacle">
	<input type="text" name="marquage"
		placeholder="Statistique de marquage">
	<input type="text" name="prix" placeholder="Prix d'achat">


</body>
</html>