<%@page import="hei.model.*, hei.metier.*" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <!-- En-tête de la page -->
        <meta charset="utf-8" />
        <title>HEI-Diary Ajouter une asso</title>
    </head>
	<body>
		<!-- Corps de la page -->
		<header id="entete">
			<link rel="stylesheet" href="css/header_body_footer.css">
			<link rel="stylesheet" href="css/navigation.css">
			<link rel="stylesheet" href="css/mesoptions.css">
			<link rel="stylesheet" href="css/espacePres.css">
			<h1>HEI-Diary</h1>
		</header>
		<jsp:include page="menu.jsp"/>
		<c:set var="pageSelectionnee" value="mesOptions" scope="request"></c:set>
		<aside class="deconnexion">
			<a href="connexion?logout"><img id=deconnexion src="img/btnDeconnexion.jpg" alt="Déconnexion" title="Déconnexion"/></a>
		</aside>
		<jsp:include page="${menuOption}">
			<jsp:param name="pageSelectionnee" value="configuration"/>
		</jsp:include>
		
		<h3 id="titre">Ajouter une association</h3>
				
		<jsp:include page="menuConfig.jsp">
			<jsp:param name="pageSelectionnee" value="ajouterAsso"/>
		</jsp:include>
		
		<form class="ajoutAsso" action="ajouterAsso" method="post">
			<legend>Nouvelle association</legend></br>
			<section id="nom">
				<label for="nomAsso">Nom de l'association :</label>
				<input type="text" name="nomAsso" id="nomAsso" placeholder=" Nom de l'association" required/></br>
				<label for="referent">Mail de l'étudiant référent:</label>
				<input type="text" name="referent" id="referent" placeholder=" etudiant.référent@hei.fr" required/></br>
			</section>
			<section id="logo">
				<label for="logo">Logo :</label>
				<input type="file" name="logo" id="logo" required/></br>
			</section>
			<section id="bureau">
				<select id="bureau" name="bureau" >
						<option value=" ">--Pôle Associé--</option>
						<option value="BDA">BDA</option>
						<option value="BDS">BDS</option>
						<option value="CapSo">Cap Solidaire</option>
						<option value="PES">PES</option>
						<option value="PET">PET</option>
				</select></br>
			</section>
			<section id="description">
				<textarea name="description" id="description" placeholder="Description de l'association" rows="10" cols="50" required></textarea>
			</section>
			<section id="bouton">
				<input type="reset" value="Réinitialiser"/>
				<input type="submit" value="Enregistrer"/>
			</section>
		</form>	
		
		<div style="position:relative;top:-300px;left:700px;width:300px;">
		<%
		 if(request.getAttribute("ErrorEtudiant")!=null) {
	           out.print((String)request.getAttribute("ErrorEtudiant"));
	       }
		 if(request.getAttribute("ErrorComm")!=null) {
	           out.print((String)request.getAttribute("ErrorComm"));
	       }
		if(request.getAttribute("ErrorChamps")!=null) {
	           out.print((String)request.getAttribute("ErrorChamps"));
	       }
		if(request.getAttribute("ErrorImage")!=null) {
	           out.print((String)request.getAttribute("ErrorImage"));
	       }
		%>
		</div>
		<footer>
			<div>Réalisation HEI</div>
		</footer>
	</body>
</html>