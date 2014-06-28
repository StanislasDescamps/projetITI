<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <!-- En-tête de la page -->
        <meta charset="utf-8" />
        <title>HEI-Diary Les Assos</title>
    </head>
	<body>
		<!-- Corps de la page -->
		<link rel="stylesheet" href="css/lesassos.css">
		<header id="entete">
			<h1>HEI-Diary</h1>
		</header>
		<jsp:include page="menu.jsp"/>
		<c:set var="pageSelectionnee" value="lesAssos" scope="request"></c:set>
		<aside class="deconnexion">
			<a href="connexion?logout"><img id=deconnexion src="img/btnDeconnexion.jpg" alt="Déconnexion" title="Déconnexion"/></a>
		</aside>
		<h3 id="titre">Consulter une association</h3>
		
		<!--  <form id="preference" action="mesOptions">
				<section id="choixbureau">
					<label for="bureau">Choississez votre pôle : </label>
					<select id="bureau" name="bureau">
						<option value="">--Pôle--</option>
						<option value="BDA">BDA</option>
						<option value="BDS">BDS</option>
						<option value="CapSo">Cap Solidaire</option>
						<option value="PES">PES</option>
						<option value="PET">PET</option>
					</select>
				</section> 
		</form>-->
		
		<section class="listAsso">
		<c:forEach var="commission" items="${listeComm}">
			<c:if test="${commission.idpole==1}">
			<article class="asso" id="BDA">
				<img id="presentation" src="${commission.logo}" alt="${commission.nomCommission}" title="${commission.nomCommission}"/>
				<h3><a href="presentationAsso?idcommission=${commission.idcommission}">${commission.nomCommission}</a></h3>
			</article>
			</c:if>
			<c:if test="${commission.idpole==2}">
			<article class="asso" id="BDS">
				<img id="presentation" src="${commission.logo}" alt="${commission.nomCommission}" title="${commission.nomCommission}"/>
				<h3><a href="presentationAsso?idcommission=${commission.idcommission}">${commission.nomCommission}</a></h3>
			</article>
			</c:if>
			<c:if test="${commission.idpole==3}">
			<article class="asso" id="CapSo">
				<img id="presentation" src="${commission.logo}" alt="${commission.nomCommission}" title="${commission.nomCommission}"/>
				<h3><a href="presentationAsso?idcommission=${commission.idcommission}">${commission.nomCommission}</a></h3>
			</article>
			</c:if>
			<c:if test="${commission.idpole==4}">
			<article class="asso" id="PES">
				<img id="presentation" src="${commission.logo}" alt="${commission.nomCommission}" title="${commission.nomCommission}"/>
				<h3><a href="presentationAsso?idcommission=${commission.idcommission}">${commission.nomCommission}</a></h3>
			</article>
			</c:if>
			<c:if test="${commission.idpole==5}">
			<article class="asso" id="PET">
				<img id="presentation" src="${commission.logo}" alt="${commission.nomCommission}" title="${commission.nomCommission}"/>
				<h3><a href="presentationAsso?idcommission=${commission.idcommission}">${commission.nomCommission}</a></h3>
			</article>
			</c:if>
		</c:forEach>	
		</section>
		<footer>
			<div> Réalisation HEI </div>
		</footer>
	</body>
</html>