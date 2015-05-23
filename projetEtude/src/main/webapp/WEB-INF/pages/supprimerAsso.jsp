<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <!-- En-tête de la page -->
        <meta charset="utf-8" name="viewport" content="initial-scale=1.0"/>
        <title>HEI-Diary Suppression</title>
        <link rel="stylesheet" media="screen" href="css/responsive.css" type="text/css"/>
    </head>
	<body>
		<!-- Corps de la page -->
		<header id="entete">
			<h1 class="entete">HEI-Diary</h1>
		</header>
		<jsp:include page="menu.jsp">
			<jsp:param name="pageSelectionnee" value="lesAssos" />
		</jsp:include>
		<div class="clear"></div>
		<aside class="deconnexion">
			<a href="connexion?logout"><img id=deconnexion src="img/btnDeconnexion.jpg" alt="Déconnexion" title="Déconnexion"/></a>
		</aside>
		
		<h3 id="titre2">Etes-vous sur de vouloir supprimer ?</h3>
		<h2 id="asuppr">${commission.nomCommission}</h2>
			<form class="supprAsso" action="supprimerAsso" method="post">
				<input type="text" name="idcommission" id="idcommission" value="${commission.idcommission}"/>
				<input type="submit" name="trap1" id="trap" value="OUI" />
				<input type="submit" name="trap2" id="trap" value="NON" />
			</form>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>