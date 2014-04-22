<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <!-- En-tête de la page -->
        <meta charset="utf-8" />
        <title>HEI-Diary Mon calendrier</title>
    </head>
	<body>
		<!-- Corps de la page -->
		<link rel="stylesheet" href="css/calendrier1.css">
		<header id="entete">
			<h1>HEI-Diary</h1>
		</header>
		<jsp:include page="menu.jsp"/>
		<c:set var="pageSelectionnee" value="monCalendrier1" scope="request"></c:set>
		<aside class="deconnexion">
			<a href="connexion?logout">Deconnexion</a>
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
		<section class="${evenement.dateDebut}">
			<h2>${evenement.dateDebut}</h2>
			
			
				<article id="${pole}" class="resume">
					<img src="${logo}"/>
			<c:forEach var="commission" items="${listeCommEvent}">
					<h2>${commission}</h2>
			</c:forEach>
					<p>${evenement.titreEvent}</p>
					<article class="description">
						<p>${evenement.descriptionEvent} </p>
						<p>${evenement.lieu}</p>
						<p>Horaire : </p>
					</article>
				</article>
			
		</section>
		</c:forEach>
		<footer>
			<div> Réalisation HEI </div>
		</footer>
	</body>
</html>