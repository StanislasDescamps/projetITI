<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
				
		<!--cette section est pour tous les présidents -->
		
			<h3 id="titre">Espace président</h3>
			
		<jsp:include page="menuEspacePres.jsp">
			<jsp:param name="pageSelectionnee" value="espacePresident"/>
		</jsp:include>
		<h3 id="titre2">Vous êtes président de :</h3>
		
			<article class="entier" id="BDA">
				<img id="logo" src="${commission.logo}" alt="${commission.nomCommission}" title="${commission.nomCommission}"/>
				<h3>${commission.nomCommission}</h3>
				<div id="description">${commission.description}</div>
				<article class="events">
					<c:forEach var="evenement" items="${listEvent}">
						<h4>${evenement.titreEvent}</h4>
						<p id="horaire">Début : <fmt:formatDate value="${evenement.debut}" pattern="dd MMMM yyyy"/>  ${evenement.hDebut}</p>
						<p id="horaire">Fin : <fmt:formatDate value="${evenement.fin}" pattern="dd MMMM yyyy"/>  ${evenement.hFin}</p>
						<form id="actionEvent" action="espacePresident" method="post">
							<input name="idEvent" value="${evenement.idEvenement}" style="display:none;"/>
							<input type="submit" name="modifier" value="Modifier"/>
							<input type="submit" name="supprimer" value="Supprimer"/>
						</form>
					</c:forEach>
				</article>
				
			</article>
		
	
		<footer>
			<div> Réalisation HEI </div>
		</footer>
	</body>
</html>