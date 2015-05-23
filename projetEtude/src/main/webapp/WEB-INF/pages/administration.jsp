<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <!-- En-tête de la page -->
        <meta charset="utf-8" name="viewport" content="initial-scale=1.0"/>
        <title>HEI-Diary Administration</title>
        <link rel="stylesheet" media="screen" href="css/responsive.css" type="text/css"/>
        <link rel="stylesheet" href="css/csstest.css" type="text/css"/>
    </head>
	<body>
		<!-- Corps de la page -->
		<script type="text/javascript" src="js/jquery.js" ></script>
		<script language="javascript" type="text/javascript" src="js/js2.js"></script>
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
		<header id="entete">
			<h1 class="entete">HEI-Diary</h1>
		</header>
		<jsp:include page="menu.jsp">
			<jsp:param name="pageSelectionnee" value="mesOptions" />
		</jsp:include>
		<div class="clear"></div>
		<jsp:include page="${menuOption}">
			<jsp:param name="pageSelectionnee" value="administration"/>
		</jsp:include>
		<aside class="deconnexion">
			<a href="connexion?logout"><img id=deconnexion src="img/btnDeconnexion.jpg" alt="Déconnexion" title="Déconnexion"/></a>
		</aside>
		<div class="clear"></div>
		
		<!--cette section est pour tous les administrateurs -->
		
			<h3 id="titre">Configuration</h3>
			
			
		<jsp:include page="menuConfig.jsp">
			<jsp:param name="pageSelectionnee" value="configDroit"/>
		</jsp:include>
		<div class="clear"></div>
			
		<c:forEach var="etudiant" items="${listEtudiant}">
		
			<form class="gestionDroits" action="configuration" method="post">
			<section class="line">
				<h4 class="nomEtudiant">${etudiant.prenomEtudiant} ${etudiant.nomEtudiant}</h4>
				<select class="droits" name="droits" >
						<option value="0" <c:if test="${etudiant.idDroit==0}"> selected="selected" </c:if>>Etudiant</option>
						<option value="1" id="presidentSelected" <c:if test="${etudiant.idDroit==1}"> selected="selected" </c:if>>Président</option>
						<option value="2" id="respPoleSelected" <c:if test="${etudiant.idDroit==2}"> selected="selected" </c:if>>Responsable pole</option>
						<option value="3" <c:if test="${etudiant.idDroit==3}"> selected="selected" </c:if>>Administrateur</option>
				</select>
				<select class="assignationCommission cache" name="assignationCommission">
					<c:forEach var="commission" items="${listeComm}">
						<option value="${commission.idcommission}">${commission.nomCommission}</option>
					</c:forEach>
				</select>
				<select class="assignationPole cache" name="assignationPole">
					<c:forEach var="pole" items="${listePole}">
						<option value="${pole.idPole}">${pole.nomPole}</option>
					</c:forEach>
				</select>
			</section>
			<section class="line">
				<h5 class="mailEtudiant">${etudiant.email}</h5>
				<input type="text" name="idEtudiant" id="idEtudiant" value="${etudiant.idEtudiant}"/>
				<input id="btnValider" name="btnValider" type="submit" value="Valider"/>
			</section>
			</form>
		</c:forEach>
			
			
				
		<footer>
			<div> Réalisation HEI </div>
		</footer>
	</body>
</html>