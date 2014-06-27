<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <!-- En-tête de la page -->
        <meta charset="utf-8" />
        <title>HEI-Diary Mes options</title>
    </head>
	<body>
		<!-- Corps de la page -->
		<link rel="stylesheet" href="css/mesoptions.css">
		<script type="text/javascript" src="js/jquery.js" ></script>
		<script language="javascript" type="text/javascript" src="js/js.js"></script>
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
		<header id="entete">
			<h1>HEI-Diary</h1>
		</header>
		<jsp:include page="menu.jsp"/>
		<c:set var="pageSelectionnee" value="mesOptions" scope="request"></c:set>
		<jsp:include page="${menuOption}.jsp"/>
		<c:set var="pageSelectionnee" value="mesInfos" scope="request"></c:set>
		<aside class="deconnexion">
			<a href="connexion?logout">Déconnexion</a>
		</aside>
		
		<!--cette section est pour tous les étudiants -->
		
			<h3 id="titre">Mes informations personnelles</h3>
			
	
		<footer>
			<div> Réalisation HEI </div>
		</footer>
	</body>
</html>