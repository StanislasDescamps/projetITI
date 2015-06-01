<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <!-- En-tête de la page -->
        <meta charset="utf-8" name="viewport" content="initial-scale=1.0"/>
        <title>HEI-Diary Mes infos</title>
        <link rel="stylesheet" media="screen" href="css/responsive.css" type="text/css"/>
    </head>
	<body>
		<!-- Corps de la page -->
		<script type="text/javascript" src="js/jquery.js" ></script>
		<script  type="text/javascript" src="js/js.js"></script>
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<script type="text/javascript" src="js/jsmenu.js"></script>
		<script src="http://code.jquery.com/jquery-latest.js"></script>
		<script src="http://jquery-ui.googlecode.com/svn/tags/latest/ui/jquery.effects.core.js"></script>
		<script src="http://jquery-ui.googlecode.com/svn/tags/latest/ui/jquery.effects.slide.js"></script>
		
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
		
		<div class="clear"></div>
		<jsp:include page="${menuOption}">
			<jsp:param name="pageSelectionnee" value="mesInfos"/>
		</jsp:include>
		<aside class="deconnexion">
			<a href="connexion?logout"><img id=deconnexion src="img/btnDeconnexion.jpg" alt="Déconnexion" title="Déconnexion"/></a>
		</aside>
		<div class="clear"></div>
		
		<!--cette section est pour tous les étudiants -->
		
			<h3 class="desktop" id="titre">Mes informations personnelles</h3>
			
		<div style="position:relative;margin-top:10px;left:700px;width:300px;color:green;">
		<%
		 if(request.getAttribute("ModifOk")!=null) {
	           out.print((String)request.getAttribute("ModifOk"));
	       }
		%></div>	
		<h2 id="bjr">Bonjour ${etudiant.prenomEtudiant} ${etudiant.nomEtudiant}</h2>
			<section class="mesInfos">
				<form class="mesInfos" method="post" action="mesInfos"> 
					<div>Votre adresse email actuelle : ${etudiant.email}</div>
					<label for="newEmail">Entrez votre nouvelle adresse email</label>
					<input type="text" name="newEmail" id="newEmail" class="tailleInput" required/></br>
					<input type="submit" value="Modifier" name="modifEmail"/>
				</form>
			
		<div style="position:relative;top:-20px;right:150px;width:400px;color:red;">
		<%
		 if(request.getAttribute("ModifMailKo")!=null) {
	           out.print((String)request.getAttribute("ModifMailKo"));
	       }
		%></div>
			
				<form class="mesInfos" method="post" action="mesInfos"> 
					<label for="newMdp1">Entrez votre nouveau mot de passe</label>
					<input type="password" name="newMdp1" id="newMdp1" class="tailleInput" required/></br>
					<label for="newMdp2">Confirmez votre nouveau mot de passe</label>
					<input type="password" name="newMdp2" id="newMdp2" class="tailleInput" required/></br>
					<input type="submit" value="Modifier" name="modifMdp"/>
				</form>
				
		<div style="position:relative;top:-20px;right:150px;width:300px;color:red;">
		<%
		 if(request.getAttribute("ModifMdpKo")!=null) {
	           out.print((String)request.getAttribute("ModifMdpKo"));
	       }
		%></div>
			</section>
			
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>