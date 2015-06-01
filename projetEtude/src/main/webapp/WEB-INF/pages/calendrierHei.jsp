<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <!-- En-tête de la page -->
        <meta charset="utf-8" name="viewport" content="initial-scale=1.0"/>
        <title>HEI-Diary Calendrier HEI</title>
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
				<jsp:param name="pageSelectionnee" value="calendrierHei" />
			</jsp:include>
		</div>
		
		<div class="desktop">
			<jsp:include page="menu.jsp">
				<jsp:param name="pageSelectionnee" value="calendrierHei" />
			</jsp:include>
		</div>
		
		<div class="clear"></div>
		<aside class="deconnexion">
			<a href="connexion?logout"><img id=deconnexion src="img/btnDeconnexion.jpg" alt="Déconnexion" title="Déconnexion"/></a>
		</aside>
		<div class="clear"></div>
		<!--  <section class="choix1">
			<form id="choix" action="calendrierHei" method="get">
					<input type="radio" id="liste" name="box1" value="liste" checked>
					<label for="formatListe">Liste</label>
					<input type="radio" id="semaine" name="box1" value="semaine">
					<label for="formatSemaine">Semaine</label>
			</form>
		</section>-->
		
		<c:forEach var="evenement" items="${listeEventEntiere}">
		<section id="${evenement.debut}">
			<h2 class="dateEvent"><fmt:formatDate value="${evenement.debut}" pattern="dd MMMM yyyy"/></h2>
				<article class="resume ${evenement.nomPole}">
					
					<div class="imgPlusBtn">
						<img class="imgCalHei"src="${evenement.image}" alt="${evenement.nomCommission}" title="${evenement.nomCommission}"/>
						<div class="btnParticipation" id="${evenement.idEvenement}"></div>
					</div>
					<h2 class="titreEvent">${evenement.titreEvent}</h2>
					<article class="touteDescription unpacked" id="${evenement.idEvenement}">
						<article class="description" id="description_${evenement.idEvenement}">
							<p id="nomCom">Par : ${evenement.nomCommission}</p>
							<div class="clear"></div>
							<p id="description">${evenement.descriptionEvent} </p>
							<p id="lieu">Lieu : ${evenement.lieu}</p>
						</article>
						<div class="btnScroll_${evenement.idEvenement} down"></div>
						<article class="horaire">
							<div class="desktop"><p id="horaire"> Début : <fmt:formatDate value="${evenement.debut}" pattern="dd MMMM yyyy"/>  ${evenement.hDebut} </br>
							Fin : <fmt:formatDate value="${evenement.fin}" pattern="dd MMMM yyyy"/>  ${evenement.hFin}</p></div>
							<div class="mobile"><p id="horaire"> De : ${evenement.hDebut}</br>
							A : <c:if test="${evenement.debut != evenement.fin}"><fmt:formatDate value="${evenement.fin}" pattern="dd MMMM yyyy"/></c:if>  ${evenement.hFin}</p>
							</div>
						</article>
					</article>
					<c:if test="${statut==3}">
						<div class="posModSuppr desktop">
							<a href="modifierEvent?idevenement=${evenement.idEvenement}">Modifier</a></br>    
							<a href="supprimerEvent?idevenement=${evenement.idEvenement}">Supprimer</a>
						</div>
					</c:if>
					<c:if test="${statut==2}">
						<div class="posModSuppr desktop">
							<a href="modererEvent?idevenement=${evenement.idEvenement}">Modérer</a></br>    
						</div>
					</c:if> 
					<!-- <form id="ajout" action="calendrierHei" method="post">
						<input id="idEvent" name="idEvent" type="text" value="${evenement.idEvenement}"/>
						<input type="submit" name="synchroniser"value="Synchroniser" />
					</form> -->
					<div class="clear"></div>
				</article>
				<div class="clear"></div>	
		</section>
		</c:forEach>
		
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>	