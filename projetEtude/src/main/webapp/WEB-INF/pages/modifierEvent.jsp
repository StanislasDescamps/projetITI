<%@page import="hei.model.*, hei.metier.*" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <!-- En-tête de la page -->
        <meta charset="utf-8" />
        <title>HEI-Diary Modifier une asso</title>
    </head>
	<body>
		<!-- Corps de la page -->
		<link rel="stylesheet" href="css/header_body_footer.css">
		<link rel="stylesheet" href="css/navigation.css">
		<link rel="stylesheet" href="css/mesoptions.css">
		<header id="entete">
			<h1>HEI-Diary</h1>
		</header>
		<jsp:include page="menu.jsp"/>
		<c:set var="pageSelectionnee" value="mesOptions" scope="request"></c:set>
		<aside class="deconnexion">
			<a href="connexion?logout"><img id=deconnexion src="img/btnDeconnexion.jpg" alt="Déconnexion" title="Déconnexion"/></a>
		</aside>
		<jsp:include page="${menuOption}">
			<jsp:param name="pageSelectionnee" value="espacePresident"/>
		</jsp:include>
				
		<h3 id="titre">Modifier un évènement</h3>
		
		
		<jsp:include page="menuEspacePres.jsp">
			<jsp:param name="pageSelectionnee" value="modifierEvent"/>
		</jsp:include>
		
		
		<footer>
			<div> Réalisation HEI </div>
		</footer>
	</body>
</html>