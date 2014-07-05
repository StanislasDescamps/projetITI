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
		<link rel="stylesheet" href="css/mesoptions.css">
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
			<jsp:param name="pageSelectionnee" value="mesInfos"/>
		</jsp:include>
		
		<!--cette section est pour tous les étudiants -->
		
			<h3 id="titre">Mes informations personnelles</h3>
			
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
					<input type="text" name="newEmail" id="newEmail" required/></br>
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
					<input type="password" name="newMdp1" id="newMdp1" required/></br>
					<label for="newMdp2">Confirmez votre nouveau mot de passe</label>
					<input type="password" name="newMdp2" id="newMdp2" required/></br>
					<input type="submit" value="Modifier" name="modifMdp"/>
				</form>
				
		<div style="position:relative;top:-20px;right:150px;width:300px;color:red;">
		<%
		 if(request.getAttribute("ModifMdpKo")!=null) {
	           out.print((String)request.getAttribute("ModifMdpKo"));
	       }
		%></div>
			</section>
			
		<footer>
			<div> Réalisation HEI </div>
		</footer>
	</body>
</html>