<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <!-- En-tête de la page -->
        <meta charset="utf-8" name="viewport" content="initial-scale=1.0"/>
        <title>HEI-Diary Présentation</title>
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
				<jsp:param name="pageSelectionnee" value="lesAssos" />
			</jsp:include>
		</div>
		
		<div class="desktop">
			<jsp:include page="menu.jsp">
				<jsp:param name="pageSelectionnee" value="lesAssos" />
			</jsp:include>
		</div>
		
		<div class="clear"></div>
		<aside class="deconnexion">
			<a href="connexion?logout"><img id=deconnexion src="img/btnDeconnexion.jpg" alt="Déconnexion" title="Déconnexion"/></a>
		</aside>
		<h3 id="titre">Vous consultez :</h3>
		<c:if test="${commission.idpole==1}">
		<article class="entier" id="BDA">
			<img id="logo" src="${commission.logo}" alt="${commission.nomCommission}" title="${commission.nomCommission}"/>
			<article class="description">
				<h3 class="titrePresAsso">${commission.nomCommission}</h3>
				<div class="clear"></div>
				<div class="descriptionPresAsso">${commission.description}</div>
			</article>
			<div class="clear"></div>
			<article class="contact">
				<h3 id="responsable">Responsable de la commission</h3>
				<h5 class="nomResp">${etudiant.prenomEtudiant} ${etudiant.nomEtudiant}</h5>
				<h5 class="mailResp">${etudiant.email}</h5>
			</article>
		</article>
		</c:if>
		<c:if test="${commission.idpole==2}">
		<article class="entier" id="BDS">
			<img id="logo" src="${commission.logo}" alt="${commission.nomCommission}" title="${commission.nomCommission}"/>
			<article class="description">
				<h3 class="titrePresAsso">${commission.nomCommission}</h3>
				<div class="clear"></div>
				<div class="descriptionPresAsso">${commission.description}</div>
			</article>
			<div class="clear"></div>
			<article class="contact">
				<h3 id="responsable">Responsable de la commission</h3>
				<h5 class="nomResp">${etudiant.prenomEtudiant} ${etudiant.nomEtudiant}</h5>
				<h5 class="mailResp">${etudiant.email}</h5>
			</article>
		</article>
		</c:if>
		<c:if test="${commission.idpole==3}">
		<article class="entier" id="CapSo">
			<img id="logo" src="${commission.logo}" alt="${commission.nomCommission}" title="${commission.nomCommission}"/>
			<article class="description">
				<h3 class="titrePresAsso">${commission.nomCommission}</h3>
				<div class="clear"></div>
				<div class="descriptionPresAsso">${commission.description}</div>
			</article>
			<div class="clear"></div>
			<article class="contact">
				<h3 id="responsable">Responsable de la commission</h3>
				<h5 class="nomResp">${etudiant.prenomEtudiant} ${etudiant.nomEtudiant}</h5>
				<h5 class="mailResp">${etudiant.email}</h5>
			</article>
		</article>
		</c:if>
		<c:if test="${commission.idpole==4}">
		<article class="entier" id="PES">
			<img id="logo" src="${commission.logo}" alt="${commission.nomCommission}" title="${commission.nomCommission}"/>
			<article class="description">
				<h3 class="titrePresAsso">${commission.nomCommission}</h3>
				<div class="clear"></div>
				<div class="descriptionPresAsso">${commission.description}</div>
			</article>
			<div class="clear"></div>
			<article class="contact">
				<h3 id="responsable">Responsable de la commission</h3>
				<h5 class="nomResp">${etudiant.prenomEtudiant} ${etudiant.nomEtudiant}</h5>
				<h5 class="mailResp">${etudiant.email}</h5>
			</article>
		</article>
		</c:if>
		<c:if test="${commission.idpole==5}">
		<article class="entier" id="PET">
			<img id="logo" src="${commission.logo}" alt="${commission.nomCommission}" title="${commission.nomCommission}"/>
			<article class="description">
				<h3 class="titrePresAsso">${commission.nomCommission}</h3>
				<div class="clear"></div>
				<div class="descriptionPresAsso">${commission.description}</div>
			</article>
			<div class="clear"></div>
			<article class="contact">
				<h3 id="responsable">Responsable de la commission</h3>
				<h5 class="nomResp">${etudiant.prenomEtudiant} ${etudiant.nomEtudiant}</h5>
				<h5 class="mailResp">${etudiant.email}</h5>
			</article>
		</article>
		</c:if>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>