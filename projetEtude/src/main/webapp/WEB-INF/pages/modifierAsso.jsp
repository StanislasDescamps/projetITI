<%@page import="hei.model.*, hei.metier.*" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <!-- En-tête de la page -->
        <meta charset="utf-8" name="viewport" content="initial-scale=1.0"/>
        <title>HEI-Diary Modifier une asso</title>
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
		
		<div class="clear"></div>
		<c:if test="${noMenu==false}">
			<jsp:include page="${menuOption}">
				<jsp:param name="pageSelectionnee" value="administration"/>
			</jsp:include>
			<aside class="deconnexion">
				<a href="connexion?logout"><img id=deconnexion src="img/btnDeconnexion.jpg" alt="Déconnexion" title="Déconnexion"/></a>
			</aside>
			<div class="clear"></div>
			<h3 id="titre">Modifier une association</h3>
			
			<jsp:include page="menuConfig.jsp">
				<jsp:param name="pageSelectionnee" value="listeModifAsso"/>
			</jsp:include>
		</c:if>
		<c:if test="${noMenu==true}">
			<jsp:include page="${menuOption}">
				<jsp:param name="pageSelectionnee" value="espaceResp"/>
			</jsp:include>
			<aside class="deconnexion">
				<a href="connexion?logout"><img id=deconnexion src="img/btnDeconnexion.jpg" alt="Déconnexion" title="Déconnexion"/></a>
			</aside>
			<div class="clear"></div>
			<h3 id="titre">Modifier mon association</h3>
		</c:if>
		
		
		<form class="ajoutAsso" action="modifierAsso" method="post">
			<legend>Vous modifiez l'association : ${commission.nomCommission}</legend></br>
			<section id="nom">
				<input type="text" name="idcommission" id="idcommission" value="${commission.idcommission}"required/>
				<label for="nomAsso">Nom de l'association :</label>
				<input type="text" name="nomAsso" id="nomAsso" value="${commission.nomCommission}" required/></br>
			</section>
			<section id="responsable">
				<label for="responsable">Président de l'association :</label>
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
			<div class="clear"></div>
			<section class="descriptionAsso">
				<textarea name="description" rows="10" cols="50" required></textarea>
			</section>
			<div class="clear"></div>
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
		
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>