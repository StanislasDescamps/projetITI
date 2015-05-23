<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <!-- En-tête de la page -->
        <meta charset="utf-8" name="viewport" content="initial-scale=1.0"/>
        <title>HEI-Diary Liste des participants</title>
        <link rel="stylesheet" media="screen" href="css/responsive.css" type="text/css"/>
    </head>
	<body>
		<!-- Corps de la page -->
		<script type="text/javascript" src="js/jquery.js" ></script>
		<script language="javascript" type="text/javascript" src="js/js.js"></script>
		<header id="entete">
			<h1 class="entete">HEI-Diary</h1>
		</header>
		<jsp:include page="menu.jsp">
			<jsp:param name="pageSelectionnee" value="mesOptions" />
		</jsp:include>
		<div class="clear"></div>
		<aside class="deconnexion">
			<a href="connexion?logout"><img id=deconnexion src="img/btnDeconnexion.jpg" alt="Déconnexion" title="Déconnexion"/></a>
		</aside>
		<div class="clear"></div>
		
		<!--cette section est pour tous les administrateurs -->
		
	
			<c:if test="${nbParticipant<=1}">
				<h3 id="titrePart">Participant de l'événement</h3>
				<c:if test="${nbParticipant==0}">
					<p class="nomParticipant">Aucun participant.</p>
				</c:if>
			</c:if>
			<c:if test="${nbParticipant>1}">
				<h3 id="titrePart">Participants de l'événement</h3>
			</c:if>
			<c:forEach var="etudiant" items="${listParticipant}">
				<h4 class="nomParticipant">${etudiant.nomEtudiant} ${etudiant.prenomEtudiant}</h4>			
			</c:forEach>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>