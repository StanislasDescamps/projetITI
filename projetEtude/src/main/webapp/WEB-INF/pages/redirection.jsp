<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- En-tête de la page -->
        <meta charset="utf-8" name="viewport" content="initial-scale=1.0"/>
        <title>HEI-Diary Redirection</title>
        <link rel="stylesheet" media="screen" href="css/responsive.css" type="text/css"/>
        <script type="text/javascript" src="js/jquery.js" ></script>
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<script type="text/javascript" src="js/jsmenu.js"></script>
		<script src="http://code.jquery.com/jquery-latest.js"></script>
		<script src="http://jquery-ui.googlecode.com/svn/tags/latest/ui/jquery.effects.core.js"></script>
		<script src="http://jquery-ui.googlecode.com/svn/tags/latest/ui/jquery.effects.slide.js"></script>
    </head>
	<body>
		<!-- Corps de la page -->
	
		<header id="entete">
			<h1 class="entete">HEI-Diary</h1>
		</header>
		
		<div class="mobile">
			<div class="mobile_menu">&equiv;</div>
			<jsp:include page="menu.jsp">
				<jsp:param name="pageSelectionnee" value="mesOptions" />
			</jsp:include>
		</div>
		
		<div class="desktop">
			<jsp:include page="menu.jsp">
				<jsp:param name="pageSelectionnee" value="mesOptions" />
			</jsp:include>
		</div>
		
		<img id="erreurConnexion" src="img/boutonOups.jpg" alt="Erreur" title="Erreur"/>
		<h3 class="posTextRedirect"> Vous n'avez pas les droits pour acéder à cette page, veuillez vous rediriger vers une de vos pages accessibles</h3>
		
		
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>	