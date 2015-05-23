<%@page import="hei.model.*, hei.metier.*" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <!-- En-tête de la page -->
        <meta charset="utf-8" name="viewport" content="initial-scale=1.0"/>
        <title>HEI-Diary Modifier un évènement</title>
        <link rel="stylesheet" media="screen" href="css/responsive.css" type="text/css"/>
    </head>
	<body>
		<!-- Corps de la page -->
		
		<header id="entete">
			<h1 class="entete">HEI-Diary</h1>
		</header>
		<jsp:include page="menu.jsp">
			<jsp:param name="pageSelectionnee" value="mesOptions" />
		</jsp:include>
		<div class="clear"></div>
		<jsp:include page="${menuOption}">
			<jsp:param name="pageSelectionnee" value="espaceResp"/>
		</jsp:include>
		<aside class="deconnexion">
			<a href="connexion?logout"><img id=deconnexion src="img/btnDeconnexion.jpg" alt="Déconnexion" title="Déconnexion"/></a>
		</aside>
		<h3 id="titre">Modifier un évènement</h3>
		
		<form class="ajoutEvent" action="modifierEvent" method="post">
			<legend>Vous modifiez l'événement : ${evenement.titreEvent}</legend></br>
						
			<section class="titreNewEvent">
				<label for="nomEvent">Titre de l'évènement :</label>
				<input type="text" name="nomEvent" id="nomEvent"  value="${evenement.titreEvent}" required/></br>
			</section>
			<section class="dateNewEvent">
				<div class="blocDate1">
					<label for="dateDebut" class="dateDebut">Date de début de l'évènement :</label>
					<input type="date" name="dateDebut" id="dateDebut" value="${evenement.dateDebut}" required/>
				</div>
				<div class="blocDate2">
					<label for="dateFin" class="dateFin">Date de fin de l'évènement :</label>
					<input type="date" name="dateFin" id="dateFin" value="${evenement.dateFin}" required/>
				</div>
				<div class="blocDate1">
					<label for="heureDebut" class="heureDebut">Heure de début de l'évènement :</label>
					<input type="time" name="heureDebut" id="heureDebut" value="${evenement.heureDebut}" required/>
				</div>
				<div class="blocDate2">
					<label for="heureFin" class="heureFin">Heure de fin de l'évènement :</label>
					<input type="time" name="heureFin" id="heureFin" value="${evenement.heureFin}" required/>
				</div>
				<!--  <i id="precision">Si vous ne sélectionnez aucune heure de fin, celle-ci comptera une heure supplémentaire par défaut</i>-->
			</section>
			<div class="clear"></div>
			<section class="lieuNewEvent">
				<label id="lieuNewEvent" for="lieu">Lieu : </label>
				<input type="text" name="lieu" value="${evenement.lieu}"/>
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
		
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>