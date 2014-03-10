<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <!-- En-tête de la page -->
        <meta charset="utf-8" />
        <title>HEI-Diary Modifier une asso</title>
    </head>
	<body>
		<!-- Corps de la page -->
		<link rel="stylesheet" href="css/mesoptions.css">
		<header id="entete">
			<h1>HEI-Diary</h1>
		</header>
		<jsp:include page="menu.jsp"/>
		<c:set var="pageSelectionnee" value="mesOptions" scope="request"></c:set>
		<aside class="deconnexion">
			<a href="connexion">Déconnexion</a>
		</aside>
		<aside class="retour">
			<a href="mesOptions">Retour</a>
		</aside>
		<h3 id="titre">Modifier une association</h3>
		<form class="ajoutAsso" action="ajouterAsso" method="post">
			<legend>--Nom de l'asso à modifier--</legend></br>
			<section id="nom">
				<label for="nomAsso">Nom de l'association :</label>
				<input type="text" name="nomAsso" id="nomAsso" placeholder=" Nom de l'association"/></br>
			</section>
			<section id="logo">
				<label for="logo">Logo :</label>
				<input type="file" name="logo" id="logo"/></br>
			</section>
			<section id="bureau">
				<select id="bureau" name="bureau">
						<option value="">--Pôle Associé--</option>
						<option value="BDA">BDA</option>
						<option value="BDS">BDS</option>
						<option value="CapSo">Cap Solidaire</option>
						<option value="PES">PES</option>
						<option value="PET">PET</option>
				</select></br>
			</section>
			<section id="description">
				<textarea name="description" id="description" placeholder="Description de l'association" rows="10" cols="50"></textarea>
			</section>
			<section id="bouton">
				<input type="reset" value="Réinitialiser"/>
				<input type="submit" value="Enregistrer"/>
			</section>
		</form>	
		<footer>
			<div>Réalisation HEI</div>
		</footer>
	</body>
</html>