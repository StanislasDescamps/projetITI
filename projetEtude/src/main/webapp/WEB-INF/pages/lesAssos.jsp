<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <!-- En-tête de la page -->
        <meta charset="utf-8" />
        <title>HEI-Diary Les Assos</title>
    </head>
	<body>
		<!-- Corps de la page -->
		<link rel="stylesheet" href="css/lesassos.css">
		<header id="entete">
			<h1>HEI-Diary</h1>
		</header>
		<jsp:include page="menu.jsp"/>
		<c:set var="pageSelectionnee" value="lesAssos" scope="request"></c:set>
		<aside class="deconnexion">
			<a href="connexion">Déconnexion</a>
		</aside>
		<h3 id="titre">Consulter une association</h3>
		<form id="preference" action="mesOptions">
				<section id="choixbureau">
					<label for="bureau">Choississez votre pôle : </label>
					<select id="bureau" name="bureau">
						<option value="">--Pôle--</option>
						<option value="BDA">BDA</option>
						<option value="BDS">BDS</option>
						<option value="CapSo">Cap Solidaire</option>
						<option value="PES">PES</option>
						<option value="PET">PET</option>
					</select>
				</section>
		</form>
		<section class="listAsso">
			<article class="asso" id="pet">
				<img src="img/heivolution.jpg" alt="pet" title="pet"/>
				<h3>HEI'volution</h3>
			</article>
			<article class="asso" id="bds">
				<img src="img/rock.jpg" alt="rock" title="rockHei"/>
				<h3>Club Rock HEI</h3>
			</article>
		</section>
		<footer>
			<div> Réalisation HEI </div>
		</footer>
	</body>
</html>