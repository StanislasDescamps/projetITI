<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- En-tête de la page -->
        <meta charset="utf-8" />
        <title>HEI-Diary Calendrier HEI</title>
        <link rel="stylesheet" media="screen" href="css/responsive.css" type="text/css"/>
    </head>
	<body>
		<!-- Corps de la page -->
	
		<header id="entete">
			<h1 class="entete">HEI-Diary</h1>
		</header>
		<jsp:include page="menu.jsp">
			<jsp:param name="pageSelectionnee" value="calendrierHei" />
		</jsp:include>
		
		<h3> Vous n'avez pas les droits pour acéder à cette page, veuillez vous rediriger vers une de vos pages accessible</h3>
		
		
		<footer>
			<div>Réalisation HEI</div>
		</footer>
	</body>
</html>	