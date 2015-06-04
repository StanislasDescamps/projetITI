<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <!-- En-tête de la page -->
        <meta charset="utf-8" name="viewport" content="initial-scale=1.0"/>
        <title>HEI-Diary Evénements modérés</title>
        <link rel="stylesheet" media="screen" href="css/responsive.css" type="text/css"/>
        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
        <script type="text/javascript" src="js/jquery.js" ></script>
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<script type="text/javascript" src="js/jsmenu.js"></script>
		<script type="text/javascript" src="js/jsCalendrier.js"></script>
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
		
		<c:if test="${nbModeration==0}">
			<p class="nomParticipant">Aucune modération.</p>
		</c:if>
		
		<c:forEach var="evenement" items="${listeEventModere}">		
			<article class="resume ${evenement.nomPole}">
				<img class="imgCal"src="${evenement.image}"/>
				<h2 class="titreEvent">${evenement.titreEvent}</h2>
				<article class="touteDescription unpacked" id="${evenement.idEvenement}">
					<article class="description" id="description_${evenement.idEvenement}">
						<p id="nomCom">Par : ${evenement.nomCommission}</p>
						<p id="description">${evenement.descriptionEvent} </p>
						<p id="lieu">Lieu : ${evenement.lieu}</p>
					</article>
					<div class="btnScroll_${evenement.idEvenement} down"></div>
					<article class="horaire">
						<div id="horaire"> Début : <fmt:formatDate value="${evenement.debut}" pattern="dd MMMM yyyy"/></br>
						  ${evenement.hDebut} </br>
							Fin : <fmt:formatDate value="${evenement.fin}" pattern="dd MMMM yyyy"/></br>
						  ${evenement.hFin}</div>
					</article>
				</article>
				<div class="clear"></div>
				<c:if test="${statut==3}">
					<div class="posModeration desktop">
						<div class="btnModOk" id="${evenement.idEvenement}">Retirer la modération</div>    
						<div id="${evenement.idEvenement}" class="btnSuppr">Supprimer l'événement</div>
					</div>
					<div class="posModeration mobile">
						<div class="btnModOk" id="${evenement.idEvenement}">Autoriser</div> 
						<div id="${evenement.idEvenement}" class="btnSuppr">Supprimer</div>
					</div>
				</c:if>	
				
				
			</article>
		</c:forEach>
		
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>