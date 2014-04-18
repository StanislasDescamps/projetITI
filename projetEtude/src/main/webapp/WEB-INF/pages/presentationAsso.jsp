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
			<a href="connexion?logout">Déconnexion</a>
		</aside>
		<aside class="retour">
			<a href="lesAssos">Retour</a>
		</aside>
		<h3 id="titre">Vous consultez :</h3>
		<c:forEach var="commission" items="${commission}">
			<article>
				<img src="${commission.logo}" alt="${commission.nomCommission}" title="${commission.nomCommission}"/>
				<h3>${commission.nomCommission}</h3>
				<div id="description">
				${commission.description}
				</div>
			</article>
			</c:forEach>
			<c:forEach var="etudiant" items="${etudiant}">
			<article class="contact">
				<h3 id="responsable">Responsable de la commission</h3>
				<h4>${etudiant.prenomEtudiant} ${etudiant.nomEtudiant}</h4>
			</article>
			</c:forEach>
		<footer>
			<div> Réalisation HEI </div>
		</footer>
	</body>
</html>