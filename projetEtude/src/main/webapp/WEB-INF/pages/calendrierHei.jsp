<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
			<a href="connexion">Déconnexion</a>
		</aside>
		<section class="choix1">
			<form id="choix" action="calendrierHei" method="get">
					<input type="radio" id="liste" name="box1" value="liste" checked>
					<label for="formatListe">Liste</label>
					<input type="radio" id="semaine" name="box1" value="semaine">
					<label for="formatSemaine">Semaine</label>
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
			</article>
		</section>
		<section class="demain">
			<h2>Demain</h2>
			<article class="entier">	
				<article id="pet" class="resume">
					<img src="img/heivolution.jpg" alt="pet" title="pet"/>
					<h2>Conférence HEI'volution</h2>
					<p>Les éoliennes et leur bien-fait</p>
				</article>
				<article class="description">
					<p> Du blabla rien que du blabla uniquement du blabla Du blabla rien que du blabla uniquement du blabla Du blabla rien que du blabla uniquement du blabla Du blabla rien que du blabla uniquement du blabla Du blabla rien que du blabla uniquement du blabla</p>
				</article>
			</article>
		</section>
		<section class="semaineX">
			<h2>Mercredi</h2>
			<article class="entier">	
				<article id="bds" class="resume">
					<img src="img/rock.jpg" alt="bds" title="bds"/>
					<h2>Soirée Rock</h2>
					<p>Retrouve les plus gros tubes des années 80 </p>
				</article>
				<article class="description">
					<p> Du blabla rien que du blabla uniquement du blabla Du blabla rien que du blabla uniquement du blabla Du blabla rien que du blabla uniquement du blabla Du blabla rien que du blabla uniquement du blabla Du blabla rien que du blabla uniquement du blabla</p>
				</article>
			</article>
		</section>
		<footer>
			<div>Réalisation HEI</div>
		</footer>
	</body>
</html>	