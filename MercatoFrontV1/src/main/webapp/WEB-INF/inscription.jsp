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
	<table>
		<tr>
			<td>S'inscrire</td>
		</tr>
	</table>
	<form method="POST" action="inscription?action=inscription">
		<input type="text" name="login" value="${sessionScope.login}" placeholder="login">
		<input type="text" name="password" placeholder="password">
		<select>
            <option value="manager">manager</option>
            <option value="joueur">joueur</option>
        </select>
		
		<input type="submit" value="Valider">	
	</form>
	
	
	
	
</body>
</html>