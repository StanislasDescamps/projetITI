<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <!-- En-tête de la page -->
        <meta charset="utf-8" />
        <title>HEI-Diary Mes options</title>
        <link rel="stylesheet" media="screen" href="css/responsive.css" type="text/css"/>
    </head>
	<body>
		<!-- Corps de la page -->
		<script type="text/javascript" src="js/jquery.js" ></script>
		<script language="javascript" type="text/javascript" src="js/js.js"></script>
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
		<header id="entete">
			<h1 class="entete">HEI-Diary</h1>
		</header>
		<jsp:include page="menu.jsp">
			<jsp:param name="pageSelectionnee" value="mesOptions" />
		</jsp:include>
		<div class="clear"></div>
		<jsp:include page="${menuOption}">
			<jsp:param name="pageSelectionnee" value="espacePresident"/>
		</jsp:include>
		<aside class="deconnexion">
			<a href="connexion?logout"><img id=deconnexion src="img/btnDeconnexion.jpg" alt="Déconnexion" title="Déconnexion"/></a>
		</aside>
		<div class="clear"></div>
		
				
		<!--cette section est pour tous les présidents -->
		
			<h3 id="titre">Espace président</h3>
			
		<jsp:include page="menuEspacePres.jsp">
			<jsp:param name="pageSelectionnee" value="espacePresident"/>
		</jsp:include>
		<div class="clear"></div>
		<h3 id="titre2">Vous êtes président de :</h3>
		
			<article class="entier" id="BDA">
				<img id="logo" src="${commission.logo}" alt="${commission.nomCommission}" title="${commission.nomCommission}"/>
				<h3 class="titreAsso">${commission.nomCommission}</h3>
				<div id="descriptionAssoPres">${commission.description}</div>
				<div class="clear"></div>
				<article class="events">
					<div>Vos évènements :</div>
					<c:forEach var="evenement" items="${listEvent}">
						<h4 class="titreEventPres">${evenement.titreEvent}</h4>
						<p id="horaire">Début : <fmt:formatDate value="${evenement.debut}" pattern="dd MMMM yyyy"/>  ${evenement.hDebut}
						Fin : <fmt:formatDate value="${evenement.fin}" pattern="dd MMMM yyyy"/>  ${evenement.hFin}</p>
						<a href="modifierEvent?idevenement=${evenement.idEvenement}">Modifier</a>    <a href="supprimerEvent?idevenement=${evenement.idEvenement}">Supprimer</a>
					</c:forEach>
				</article>
				<div class="clear"></div>
			</article>
		
	
		<footer>
			<div> Réalisation HEI </div>
		</footer>
	</body>
</html>