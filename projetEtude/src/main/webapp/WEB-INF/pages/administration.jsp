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
		<link rel="stylesheet" href="css/header_body_footer.css">
		<link rel="stylesheet" href="css/navigation.css">
		<link rel="stylesheet" href="css/configuration.css">
		<script type="text/javascript" src="js/jquery.js" ></script>
		<script language="javascript" type="text/javascript" src="js/js.js"></script>
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
		<header id="entete">
			<h1>HEI-Diary</h1>
		</header>
		<jsp:include page="menu.jsp">
			<jsp:param name="pageSelectionnee" value="mesOptions" />
		</jsp:include>
		<aside class="deconnexion">
			<a href="connexion?logout"><img id=deconnexion src="img/btnDeconnexion.jpg" alt="Déconnexion" title="Déconnexion"/></a>
		</aside>
		<jsp:include page="${menuOption}">
			<jsp:param name="pageSelectionnee" value="configuration"/>
		</jsp:include>
		
		
		<!--cette section est pour tous les administrateurs -->
		
			<h3 id="titre">Configuration</h3>
			
			
		<jsp:include page="menuConfig.jsp">
			<jsp:param name="pageSelectionnee" value="configDroit"/>
		</jsp:include>
			
		<c:forEach var="etudiant" items="${listEtudiant}">
		
			<form class="gestionDroits" action="configuration" method="post">
			<h4>${etudiant.prenomEtudiant} ${etudiant.nomEtudiant}</h4>
				<h5>${etudiant.email}</h5>
			<section id="droits">
				<select id="droits" name="droits" >
						<option value="0" <c:if test="${etudiant.idDroit==0}"> selected="selected" </c:if>>Etudiant</option>
						<option value="1" <c:if test="${etudiant.idDroit==1}"> selected="selected" </c:if>>Président</option>
						<option value="2" <c:if test="${etudiant.idDroit==2}"> selected="selected" </c:if>>Administrateur</option>
				</select></br>
			</section>
			<input type="text" name="idEtudiant" id="idEtudiant" value="${etudiant.idetudiant}"/>
			<input id="btnValider" name="btnValider" type="submit" value="Valider"/>
			</form>
		</c:forEach>
			
			
				
		<footer>
			<div> Réalisation HEI </div>
		</footer>
	</body>
</html>