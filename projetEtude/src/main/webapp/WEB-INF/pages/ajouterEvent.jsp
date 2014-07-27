<%@page import="hei.model.*, hei.metier.*" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <!-- En-tête de la page -->
        <meta charset="utf-8" />
        <title>HEI-Diary Ajouter un évènement</title>
    </head>
	<body>
		<!-- Corps de la page -->
		<header id="entete">
			<link rel="stylesheet" href="css/header_body_footer.css">
			<link rel="stylesheet" href="css/navigation.css">
			<link rel="stylesheet" href="css/mesoptions.css">
			<link rel="stylesheet" href="css/espacePres.css">
			<h1>HEI-Diary</h1>
		</header>
		<jsp:include page="menu.jsp"/>
		<c:set var="pageSelectionnee" value="mesOptions" scope="request"></c:set>
		<aside class="deconnexion">
			<a href="connexion?logout"><img id=deconnexion src="img/btnDeconnexion.jpg" alt="Déconnexion" title="Déconnexion"/></a>
		</aside>
		<jsp:include page="${menuOption}">
			<jsp:param name="pageSelectionnee" value="espacePresident"/>
		</jsp:include>
		<h3 id="titre">Ajouter un évènement</h3>
		
		<jsp:include page="menuEspacePres.jsp">
			<jsp:param name="pageSelectionnee" value="ajouterEvent"/>
		</jsp:include>
		
		<form class="ajoutEvent" action="ajouterEvent" method="post">
			<legend>Nouvel évènement</legend></br>
			
			<section id="commission">
				Votre commission est ${commission.nomCommission}
			</section>
			
			<section id="nom">
				<label for="nomEvent">Titre de l'évènement :</label>
				<input type="text" name="nomEvent" id="nomEvent" placeholder="Titre de l'évènement" required/></br>
			</section>
			<section id="dateEvent">
				<label for="dateDebut">Date de début de l'évènement :</label>
				<input type="date" name="dateDebut" id="dateDebut" required/>
				<label for="heureDebut">Heure de début de l'évènement :</label>
				<input type="time" name="heureDebut" id="heureDebut" required/>
				
				<label for="dateFin">Date de fin de l'évènement :</label>
				<input type="date" name="dateFin" id="dateFin" required />
				<label for="heureFin">Heure de fin de l'évènement :</label>
				<input type="time" name="heureFin" id="heureFin" required/>
			<!-- <i id="precision">Si vous ne sélectionnez aucune heure de fin, celle-ci comptera une heure supplémentaire par défaut</i> -->
			</section>
			<section id="description">
				<label for="lieu">Lieu :</label>
				<input type="text" name="lieu" id="lieu"/>
				<textarea name="description" id="description" placeholder="Description de l'évènement" rows="10" cols="50" required></textarea>
			</section>
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