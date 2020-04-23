<%@page import="model.*"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
<!DOCTYPE html>
<html>
<head>


<meta charset="UTF-8">
<title>Stats JSP</title>
</head>
<body>
	
	Vos stats
	<form action="joueurStat" method="POST">
	<input type="hidden" action="modifStat">
		<!--  Afficher tous vos champs, readOnly sur ceux non modifiables-->
	</form>
	
	
</body>
</html>