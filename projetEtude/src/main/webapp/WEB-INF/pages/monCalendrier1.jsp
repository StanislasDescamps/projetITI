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
			<a href="connexion">Deconnexion</a>
		</aside>
		<section class="choix">
			<form class="choix">
				<input type="radio" id="liste" name="liste" value="liste">Liste
				<input type="radio" id="semaine" name="semaine" value="semaine">Semaine
			</form>
		</section>
		<section class="aujourdhui">
			<h2>Aujourd'hui</h2>
			<article class="entier">	
				<article id="bda" class="resume">
					<img src="img/bda.jpg" alt="bda" title="bda"/>
					<h2>Salon gastronomique</h2>
					<p>Viens découvrir les saveurs de l'espagne</p>
				</article>
				<article class="description">
					<p> Du blabla rien que du blabla uniquement du blabla Du blabla rien que du blabla uniquement du blabla Du blabla rien que du blabla uniquement du blabla Du blabla rien que du blabla uniquement du blabla Du blabla rien que du blabla uniquement du blabla</p>
				</article>
				<aside>
					<a class="btn" id="showHideForm">Voir plus</a> 
				</aside>
			</article>
		</section>
		<footer>
			<div> Réalisation HEI </div>
		</footer>
	</body>
</html>