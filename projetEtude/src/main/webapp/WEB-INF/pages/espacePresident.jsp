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
		<link rel="stylesheet" href="css/header_body_footer.css">
		<link rel="stylesheet" href="css/navigation.css">
		<link rel="stylesheet" href="css/espacePres.css">
		<script type="text/javascript" src="js/jquery.js" ></script>
		<script language="javascript" type="text/javascript" src="js/js.js"></script>
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
		<header id="entete">
			<h1>HEI-Diary</h1>
		</header>
		<jsp:include page="menu.jsp">
			<jsp:param name="pageSelectionnee" value="mesOptions" />
		</jsp:include>
		<aside class="deconnexion">
			<a href="connexion?logout"><img id=deconnexion src="img/btnDeconnexion.jpg" alt="Déconnexion" title="Déconnexion"/></a>
		</aside>
		<jsp:include page="${menuOption}">
			<jsp:param name="pageSelectionnee" value="espacePresident"/>
		</jsp:include>
		<jsp:include page="menuEspacePres.jsp"/>
		<c:set var="pageSelectionnee" value="espacePresident" scope="request"></c:set>
		
		<!--cette section est pour tous les présidents -->
		
			<h3 id="titre">Espace président</h3>
			
		<section class="espacePres" id="newEvent">
			<a href="listeModifAsso"><input type="submit" value="Ajouter un événement"/></a>
		</section>
		<section class="espacePres" id="modifEvent">
			<a href="listeModifAsso"><input type="submit" value="Modifier un événement"/></a>
		</section>
		<section class="espacePres" id="modifAsso">
			<a href="listeModifAsso"><input type="submit" value="Modifier une association"/></a>
		</section>
	
		<footer>
			<div> Réalisation HEI </div>
		</footer>
	</body>
</html>