<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
		<link rel="stylesheet" href="css/mesoptions.css">
		<header id="entete">
			<h1>HEI-Diary</h1>
		</header>
		<jsp:include page="menu.jsp"/>
		<c:set var="pageSelectionnee" value="mesOptions" scope="request"></c:set>
		<aside class="deconnexion">
			<a href="connexion?logout">Déconnexion</a>
		</aside>
		<aside class="retour">
			<a href="listeModifAsso">Retour</a>
		</aside>
		<h3 id="titre">Modifier une association</h3>
		<form class="ajoutAsso" action="modifierAsso" method="post">
			<legend>${commission.nomCommission}</legend></br>
			<section id="nom">
				<input type="text" name="idcommission" id="idcommission" value="${commission.idcommission}"required/>
				<label for="nomAsso">Nom de l'association :</label>
				<input type="text" name="nomAsso" id="nomAsso" placeholder=" Nom de l'association" required/></br>
			</section>
			<section id="responsable">
				<label for="responsable">President de l'association :</label>
				<input type="text" name="mailResp" id="mailResp" placeholder=" ${etudiant.email}" required/></br>
			</section>
			<section id="logo">
				<label for="logo">Logo :</label>
				<input type="file" name="logo" id="logo"/></br>
			</section>
			<section id="bureau">
				<select id="bureau" name="bureau">
						<option value="">--Pôle Associé--</option>
						<option value="1">BDA</option>
						<option value="2">BDS</option>
						<option value="3">Cap Solidaire</option>
						<option value="4">PES</option>
						<option value="5">PET</option>
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
		
		<%
		 if(request.getAttribute("ErrorEtudiant2")!=null) {
	           out.print((String)request.getAttribute("ErrorEtudiant2"));
	       }
		%>
		
		<footer>
			<div>Réalisation HEI</div>
		</footer>
	</body>
</html>