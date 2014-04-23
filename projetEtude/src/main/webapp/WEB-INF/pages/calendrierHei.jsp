<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <!-- En-tête de la page -->
        <meta charset="utf-8" />
        <title>HEI-Diary Calendrier HEI</title>
    </head>
	<body>
		<!-- Corps de la page -->
		<link rel="stylesheet" href="css/calendrier1.css">
		<header id="entete">
			<h1>HEI-Diary</h1>
		</header>
		<jsp:include page="menu.jsp"/>
		<c:set var="pageSelectionnee" value="calendrierHei" scope="request"></c:set>
		<aside class="deconnexion">
			<a href="connexion?logout">Déconnexion</a>
		</aside>
		<!--  <section class="choix1">
			<form id="choix" action="calendrierHei" method="get">
					<input type="radio" id="liste" name="box1" value="liste" checked>
					<label for="formatListe">Liste</label>
					<input type="radio" id="semaine" name="box1" value="semaine">
					<label for="formatSemaine">Semaine</label>
			</form>
		</section>-->
		
		<c:forEach var="evenement" items="${listeEventEntiere}">
		<section class="${evenement.dateDebut}">
			<h2><fmt:formatDate value="${evenement.dateDebut}" pattern="dd MMMM yyyy"/></h2>
				<article id="${evenement.nomPole}" class="resume">
					<img src="${evenement.image}"/>
					<h2>${evenement.titreEvent}</h2>
					<p>Par la commission : ${evenement.nomCommission}</p>
					<article class="description">
						<p>${evenement.descriptionEvent} </p>
						<p>Lieu : ${evenement.lieu}</p>
						<p id="horaire">Début : <fmt:formatDate value="${evenement.dateDebut}" pattern="dd MMMM yyyy HH:mm"/></p>
						<p id="horaire">Fin : <fmt:formatDate value="${evenement.dateFin}" pattern="dd MMMM yyyy HH:mm"/></p>
					</article>
				</article>
		</section>
		</c:forEach>
		
		<footer>
			<div>Réalisation HEI</div>
		</footer>
	</body>
</html>	