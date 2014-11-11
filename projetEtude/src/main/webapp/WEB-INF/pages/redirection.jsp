<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- En-tête de la page -->
        <meta charset="utf-8" />
        <title>HEI-Diary Redirection</title>
        <link rel="stylesheet" media="screen" href="css/responsive.css" type="text/css"/>
    </head>
	<body>
		<!-- Corps de la page -->
	
		<header id="entete">
			<h1 class="entete">HEI-Diary</h1>
		</header>
		<jsp:include page="menu.jsp">
			<jsp:param name="pageSelectionnee" value="mesOptions" />
		</jsp:include>
		
		<img id="erreurConnexion" src="img/boutonOups.jpg" alt="Erreur" title="Erreur"/>
		<h3 class="posTextRedirect"> Vous n'avez pas les droits pour acéder à cette page, veuillez vous rediriger vers une de vos pages accessibles</h3>
		
		
		<footer>
			<div>Réalisation HEI</div>
		</footer>
	</body>
</html>	