<%@page import="hei.model.*, hei.metier.*" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <!-- En-tête de la page -->
        <meta charset="utf-8" />
        <title>HEI-Diary Modifier une asso</title>
    </head>
	<body>
		<!-- Corps de la page -->
		<link rel="stylesheet" href="css/header_body_footer.css">
		<link rel="stylesheet" href="css/navigation.css">
		<link rel="stylesheet" href="css/mesoptions.css">
		<header id="entete">
			<h1>HEI-Diary</h1>
		</header>
		<jsp:include page="menu.jsp"/>
		<c:set var="pageSelectionnee" value="mesOptions" scope="request"></c:set>
		<aside class="deconnexion">
			<a href="connexion?logout"><img id=deconnexion src="img/btnDeconnexion.jpg" alt="Déconnexion" title="Déconnexion"/></a>
		</aside>
		<c:if test="${noMenu==false}">
			<jsp:include page="${menuOption}">
				<jsp:param name="pageSelectionnee" value="administration"/>
			</jsp:include>
		
			<h3 id="titre">Modifier une association</h3>
			
			<jsp:include page="menuConfig.jsp">
				<jsp:param name="pageSelectionnee" value="listeModifAsso"/>
			</jsp:include>
		</c:if>
		<c:if test="${noMenu==true}">
			<jsp:include page="${menuOption}">
				<jsp:param name="pageSelectionnee" value="espaceResp"/>
			</jsp:include>
			<h3 id="titre">Modifier mon association</h3>
		</c:if>
		
		
		<form class="ajoutAsso" action="modifierAsso" method="post">
			<legend>${commission.nomCommission}</legend></br>
			<section id="nom">
				<input type="text" name="idcommission" id="idcommission" value="${commission.idcommission}"required/>
				<label for="nomAsso">Nom de l'association :</label>
				<input type="text" name="nomAsso" id="nomAsso" value="${commission.nomCommission}" required/></br>
			</section>
			<section id="responsable">
				<label for="responsable">President de l'association :</label>
				<input type="text" name="mailResp" id="mailResp" value=" ${etudiant.email}" required/></br>
			</section>
			<section id="logo">
				<label for="logo">Logo :</label>
				<input type="file" name="logo" id="logo" value="${commission.logo}"/></br>
			</section>
			<section id="bureau">
				<select id="bureau" name="bureau">
						<option value="">--Pôle Associé--</option>
						<option value="1" <c:if test="${commission.idpole==1}"> selected="selected" </c:if>>BDA</option>
						<option value="2" <c:if test="${commission.idpole==2}"> selected="selected" </c:if>>BDS</option>
						<option value="3" <c:if test="${commission.idpole==3}"> selected="selected" </c:if>>Cap Solidaire</option>
						<option value="4" <c:if test="${commission.idpole==4}"> selected="selected" </c:if>>PES</option>
						<option value="5" <c:if test="${commission.idpole==5}"> selected="selected" </c:if>>PET</option>
				</select></br>
			</section>
			<section id="description">
				<textarea name="description" id="description" rows="10" cols="50" required></textarea>
			</section>
			<section id="bouton">
				<input type="reset" value="Réinitialiser"/>
				<input type="submit" value="Enregistrer"/>
			</section>
		</form>	
		
		<div style="position:relative;top:-300px;left:700px;width:300px;">
		<%
		 if(request.getAttribute("ErrorEtudiant2")!=null) {
	           out.print((String)request.getAttribute("ErrorEtudiant2"));
	       }
		if(request.getAttribute("ErrorChamps")!=null) {
	           out.print((String)request.getAttribute("ErrorChamps"));
	       }
		%></div>
		
		<footer>
			<div>Réalisation HEI</div>
		</footer>
	</body>
</html>