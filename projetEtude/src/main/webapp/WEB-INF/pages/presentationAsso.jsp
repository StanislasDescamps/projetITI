<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <!-- En-tête de la page -->
        <meta charset="utf-8" />
        <title>HEI-Diary Présentation</title>
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
		<aside class="retour">
			<a href="lesAssos">Retour</a>
		</aside>
		<h3 id="titre">Vous consultez :</h3>
			<article class="presentation" id="pet">
				<img src="img/heivolution.jpg" alt="pet" title="pet"/>
				<h3>HEI'volution</h3>
				<div id="description">
				Description Description Description Description Description Description Description Description 
				Description Description Description Description Description Description Description Description 
				Description Description Description Description Description Description Description Description 
				Description Description Description Description Description Description Description Description 
				Description Description Description Description Description Description Description Description 
				</div>
			</article>
			<article class="contact">
				<h3 id="responsable">Responsable de la commission</h3>
				<h4> Amandine Chemouny </h4>
			</article>
		<footer>
			<div> Réalisation HEI </div>
		</footer>
	</body>
</html>