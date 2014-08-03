<%@page import="hei.model.*, hei.metier.*" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <!-- En-tête de la page -->
        <meta charset="utf-8" />
        <title>HEI-Diary Ajouter un évènement</title>
        <link rel="stylesheet" media="screen" href="css/responsive.css" type="text/css"/>
    </head>
	<body>
		<!-- Corps de la page -->
		<header id="entete">
			<h1 class="entete">HEI-Diary</h1>
		</header>
		<jsp:include page="menu.jsp"/>
		<div class="clear"></div>
		<jsp:include page="${menuOption}">
			<jsp:param name="pageSelectionnee" value="espacePresident"/>
		</jsp:include>
		<c:set var="pageSelectionnee" value="mesOptions" scope="request"></c:set>
		<aside class="deconnexion">
			<a href="connexion?logout"><img id=deconnexion src="img/btnDeconnexion.jpg" alt="Déconnexion" title="Déconnexion"/></a>
		</aside>
		<h3 id="titre">Ajouter un évènement</h3>
		<jsp:include page="menuEspacePres.jsp">
			<jsp:param name="pageSelectionnee" value="ajouterEvent"/>
		</jsp:include>
		<div class="clear"></div>
		<form class="ajoutEvent" action="ajouterEvent" method="post">
			<legend>Nouvel évènement</legend></br>
			
			<section class="commissionNewEvent">
				Votre commission est ${commission.nomCommission}
			</section>
			
			<section class="titreNewEvent">
				<label for="nomEvent">Titre de l'évènement :</label>
				<input type="text" name="nomEvent" id="nomEvent" placeholder="Titre de l'évènement" required/></br>
			</section>
			<section class="dateNewEvent">
				<label for="dateDebut">Date de début de l'évènement :</label>
				<input type="date" name="dateDebut" id="dateDebut" required/>
				<label for="heureDebut">Heure de début de l'évènement :</label>
				<input type="time" name="heureDebut" id="heureDebut" required/>
				</br>
				<label for="dateFin">Date de fin de l'évènement :</label>
				<input type="date" name="dateFin" id="dateFin" required />
				<label for="heureFin">Heure de fin de l'évènement :</label>
				<input type="time" name="heureFin" id="heureFin" required/>
			<!-- <i id="precision">Si vous ne sélectionnez aucune heure de fin, celle-ci comptera une heure supplémentaire par défaut</i> -->
			</section>
			<div class="clear"></div>
			<section class="lieuNewEvent">
				<label id="lieuNewEvent" for="lieu">Lieu : </label>
				<input type="text" name="lieu"/>
			</section>	
			<section class="descriptionNewEvent">	
				<textarea name="description" id="descriptionNewEvent" placeholder="Description de l'évènement" rows="10" cols="50" required></textarea>
			</section>
			<div class="clear"></div>
			<section id="bouton">
				<input type="reset" value="Réinitialiser"/>
				<input type="submit" value="Enregistrer"/>
			</section>
		</form>	
		
		<div style="position:relative;top:-300px;left:700px;width:300px;">
		<%
		 if(request.getAttribute("ErrorTime")!=null) {
	           out.print((String)request.getAttribute("ErrorTime"));
	       }
		if(request.getAttribute("ErrorDate")!=null) {
	           out.print((String)request.getAttribute("ErrorDate"));
	       }
		%></div>
		
		<footer>
			<div> Réalisation HEI </div>
		</footer>
	</body>
</html>