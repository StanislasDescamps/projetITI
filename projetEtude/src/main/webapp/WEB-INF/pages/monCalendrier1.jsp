<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <!-- En-tête de la page -->
        <meta charset="utf-8" />
        <title>HEI-Diary Mon calendrier</title>
    </head>
	<body>
		<!-- Corps de la page -->
		<link rel="stylesheet" href="css/header_body_footer.css">
		<link rel="stylesheet" href="css/navigation.css">
		<link rel="stylesheet" href="css/calendrier.css">
		<header id="entete">
			<h1>HEI-Diary</h1>
		</header>
		<jsp:include page="menu.jsp">
			<jsp:param name="pageSelectionnee" value="monCalendrier1" />
		</jsp:include>
		<aside class="deconnexion">
			<a href="connexion?logout"><img id=deconnexion src="img/btnDeconnexion.jpg" alt="Déconnexion" title="Déconnexion"/></a>
		</aside>
		<!--  <section class="choix1">
			<form id="choix" action="calendrierHei" method="get">
					<input type="radio" id="liste" name="box1" value="liste" checked>
					<label for="formatListe">Liste</label>
					<input type="radio" id="semaine" name="box1" value="semaine">
					<label for="formatSemaine">Semaine</label>
			</form>
		</section>-->
		<c:forEach var="evenement" items="${listeEventPerso}">
		<section class="${evenement.debut}">
			<h2><fmt:formatDate value="${evenement.debut}" pattern="dd MMMM yyyy"/></h2>
				<article id="${evenement.nomPole}" class="resume">
					<img src="${evenement.image}"/>
					<h2>${evenement.titreEvent}</h2>
					<p id="nomCom">Par la commission : ${evenement.nomCommission}</p>
					<article class="description">
						<p id="description">${evenement.descriptionEvent} </p>
						<p id="lieu">Lieu : ${evenement.lieu}</p>
						<p id="horaire">Début : <fmt:formatDate value="${evenement.debut}" pattern="dd MMMM yyyy"/>  ${evenement.heureDebut}</p>
						<p id="horaire">Fin : <fmt:formatDate value="${evenement.fin}" pattern="dd MMMM yyyy"/>  ${evenement.heureFin}</p>
					</article>
					<form id="ajout" action="monCalendrier1" method="post">
						<input id="idEvent" name="idEvent" type="text" value="${evenement.idEvenement}"/>
						<input type="submit" name="synchroniser"value="Synchroniser" />
					</form>
				</article>
		</section>
		</c:forEach>
		<footer>
			<div> Réalisation HEI </div>
		</footer>
	</body>
</html>