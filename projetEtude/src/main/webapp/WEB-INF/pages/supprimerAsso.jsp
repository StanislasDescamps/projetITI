<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <!-- En-tête de la page -->
        <meta charset="utf-8" />
        <title>HEI-Diary Suppression</title>
    </head>
	<body>
		<!-- Corps de la page -->
		<link rel="stylesheet" href="css/mesoptions.css">
		<header id="entete">
			<h1>HEI-Diary</h1>
		</header>
		<jsp:include page="menu.jsp"/>
		<c:set var="pageSelectionnee" value="lesAssos" scope="request"></c:set>
		<aside class="deconnexion">
			<a href="connexion?logout">Déconnexion</a>
		</aside>
		<aside class="retour">
			<a href="listeModifAsso">Retour</a>
		</aside>
		<h3 id="titre2">Etes-vous sur de vouloir supprimer ?</h3>
		<h2 id="asuppr">${commission.nomCommission}</h2>
			<form class="supprAsso" action="supprimerAsso" method="post">
				<input type="text" name="idcommission" id="idcommission" value="${commission.idcommission}"/>
				<input type="submit" name="trap1" id="trap" value="OUI" />
				<input type="submit" name="trap2" id="trap" value="NON" />
			</form>
		<footer>
			<div> Réalisation HEI </div>
		</footer>
	</body>
</html>