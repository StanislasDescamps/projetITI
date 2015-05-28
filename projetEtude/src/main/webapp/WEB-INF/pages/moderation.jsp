<%@page import="hei.model.*, hei.metier.*" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <!-- En-tête de la page -->
        <meta charset="utf-8" name="viewport" content="initial-scale=1.0"/>
        <title>HEI-Diary Evénements modérés</title>
        <link rel="stylesheet" media="screen" href="css/responsive.css" type="text/css"/>
        <script type="text/javascript" src="js/jquery.js" ></script>
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<script type="text/javascript" src="js/jsmenu.js"></script>
		<script src="http://code.jquery.com/jquery-latest.js"></script>
		<script src="http://jquery-ui.googlecode.com/svn/tags/latest/ui/jquery.effects.core.js"></script>
		<script src="http://jquery-ui.googlecode.com/svn/tags/latest/ui/jquery.effects.slide.js"></script>
    </head>
	<body>
		<!-- Corps de la page -->
		<header id="entete">
			<h1 class="entete">HEI-Diary</h1>
		</header>
		<div class="mobile">
			<div class="mobile_menu">&equiv;</div>
			<jsp:include page="menu.jsp">
				<jsp:param name="pageSelectionnee" value="mesOptions" />
			</jsp:include>
		</div>
		
		<div class="desktop">
			<jsp:include page="menu.jsp">
				<jsp:param name="pageSelectionnee" value="mesOptions" />
			</jsp:include>
		</div>
		<div class="clear"></div>
		<jsp:include page="${menuOption}">
			<jsp:param name="pageSelectionnee" value="administration"/>
		</jsp:include>
		
		<c:set var="pageSelectionnee" value="mesOptions" scope="request"></c:set>
		<aside class="deconnexion">
			<a href="connexion?logout"><img id=deconnexion src="img/btnDeconnexion.jpg" alt="Déconnexion" title="Déconnexion"/></a>
		</aside>
		<h3 class="desktop" id="titre">Evénements modérés</h3>
		
		<c:if test="${statut==3}">		
			<jsp:include page="menuConfig.jsp">
				<jsp:param name="pageSelectionnee" value="moderation"/>
			</jsp:include>
		</c:if>
		<c:if test="${statut==2}">		
			<jsp:include page="menuEspaceRespPole.jsp">
				<jsp:param name="pageSelectionnee" value="moderation"/>
			</jsp:include>
		</c:if>
		<div class="clear"></div>
		
		<c:forEach var="evenement" items="${listeEventModere}">		
			<article id="${evenement.nomPole}" class="resume">
					<img class="imgCal"src="${evenement.image}"/>
					<article class="description">
						<h2 class="titreEvent">${evenement.titreEvent}</h2>
						<p id="nomCom">Par la commission : ${evenement.nomCommission}</p>
						<div class="clear"></div>
						<p id="description">${evenement.descriptionEvent} </p>
						<p id="lieu">Lieu : ${evenement.lieu}</p>
						<div class="desktop">
							<p id="horaire"> Début : <fmt:formatDate value="${evenement.debut}" pattern="dd MMMM yyyy"/>  ${evenement.hDebut} </br>
						Fin : <fmt:formatDate value="${evenement.fin}" pattern="dd MMMM yyyy"/>  ${evenement.hFin}</p>
						</div>
						<div class="mobile">
							<p id="horaire"> De : ${evenement.hDebut}</br>
						A : <c:if test="${evenement.debut != evenement.fin}"><fmt:formatDate value="${evenement.fin}" pattern="dd MMMM yyyy"/></c:if>  ${evenement.hFin}</p>
						</div>
					</article>
					<c:if test="${statut==3}">
						<div class="posModeration desktop">
							<a href=""> <!--javascript fonction  -->Annuler la modération</a></br>    
							<a href="supprimerEvent?idevenement=${evenement.idEvenement}">Supprimer l'événement</a>
						</div>
					</c:if>
					<div class="clear"></div>
			</article>
		</c:forEach>
		
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>