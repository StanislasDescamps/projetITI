<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <!-- En-tête de la page -->
        <meta charset="utf-8" />
        <title>HEI-Diary Mes options</title>
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
		<h3 id="presentation">
			Cette page vous permet de sélectionner vos associations préférées, de les faire apparaître dans votre calendrier personnel et de synchroniser leurs événements sur votre smartphone!
		</h3>
		<!--cette section est pour tous les étudiants -->
		<section class="tous">
			<form id="preference" action="mesOptions">
				<legend>Mes préférences</legend>
				<section id="choixbureau">
					<label for="bureau">Choississez l'ensemble qui vous intéresse : </label>
					<select id="bureau" name="bureau">
						<option value="">--Pôle--</option>
						<option value="BDA">BDA</option>
						<option value="BDS">BDS</option>
						<option value="CapSo">Cap Solidaire</option>
						<option value="PES">PES</option>
						<option value="PET">PET</option>
					</select>
				</section>
				<section id="asso">
					<input type="checkbox" name="rock hei" id="rock" /> <label for="rock">Rock HEI</label><br/>
					<input type="checkbox" name="Lasauce" id="lasauce" /> <label for="lasauce">La Sauce</label><br/>
					<input type="checkbox" name="heivolution" id="heivolution" /> <label for="heivolution">HEI'volution</label><br/>
					<input type="checkbox" name="rugby" id="rugby" /> <label for="rugby">Rugby</label><br/>
				</section>
				<input type="reset" value="Réinitialiser"/>
				<input type="submit" value="Enregistrer"/>
			</form>
		</section>
		<section id="president">
			<a href="ajouterAsso"><input type="submit" value="Ajouter une association"/></a>
			<a href="modifierAsso"><input type="submit" value="Modifier une association"/></a>
		</section>
		<footer>
			<div> Réalisation HEI </div>
		</footer>
	</body>
</html>