<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <!-- En-tête de la page -->
        <meta charset="utf-8" name="viewport" content="initial-scale=1.0"/>
        <title>HEI-Diary Les Assos</title>
        <link rel="stylesheet" media="screen" href="css/responsive.css" type="text/css"/>
    </head>
	<body>
		<!-- Corps de la page -->
		<header id="entete">
			<h1 class="entete">HEI-Diary</h1>
		</header>
		<jsp:include page="menu.jsp">
			<jsp:param name="pageSelectionnee" value="lesAssos" />
		</jsp:include>
		<div class="clear"></div>
		<aside class="deconnexion">
			<a href="connexion?logout"><img id=deconnexion src="img/btnDeconnexion.jpg" alt="Déconnexion" title="Déconnexion"/></a>
		</aside>
		<div class="clear"></div>
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
				<img id="presentation2" src="${commission.logo}" alt="${commission.nomCommission}" title="${commission.nomCommission}"/>
				<h3 class="nomAssoContact"><a href="presentationAsso?idcommission=${commission.idcommission}">${commission.nomCommission}</a></h3>
			</article>
			</c:if>
			<div class="clear"></div>
			<c:if test="${commission.idpole==2}">
			<article class="asso" id="BDS">
				<img id="presentation2" src="${commission.logo}" alt="${commission.nomCommission}" title="${commission.nomCommission}"/>
				<h3 class="nomAssoContact"><a href="presentationAsso?idcommission=${commission.idcommission}">${commission.nomCommission}</a></h3>
			</article>
			</c:if>
			<div class="clear"></div>
			<c:if test="${commission.idpole==3}">
			<article class="asso" id="CapSo">
				<img id="presentation2" src="${commission.logo}" alt="${commission.nomCommission}" title="${commission.nomCommission}"/>
				<h3 class="nomAssoContact"><a href="presentationAsso?idcommission=${commission.idcommission}">${commission.nomCommission}</a></h3>
			</article>
			</c:if>
			<div class="clear"></div>
			<c:if test="${commission.idpole==4}">
			<article class="asso" id="PES">
				<img id="presentation2" src="${commission.logo}" alt="${commission.nomCommission}" title="${commission.nomCommission}"/>
				<h3 class="nomAssoContact"><a href="presentationAsso?idcommission=${commission.idcommission}">${commission.nomCommission}</a></h3>
			</article>
			</c:if>
			<div class="clear"></div>
			<c:if test="${commission.idpole==5}">
			<article class="asso" id="PET">
				<img id="presentation2" src="${commission.logo}" alt="${commission.nomCommission}" title="${commission.nomCommission}"/>
				<h3 class="nomAssoContact"><a href="presentationAsso?idcommission=${commission.idcommission}">${commission.nomCommission}</a></h3>
			</article>
			</c:if>
			<div class="clear"></div>
		</c:forEach>	
		</section>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>