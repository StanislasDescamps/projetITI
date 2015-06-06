<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <!-- En-tête de la page -->
        <meta charset="utf-8" name="viewport" content="initial-scale=1.0"/>
        <title>HEI-Diary Espace Resp</title>
        <link rel="stylesheet" media="screen" href="css/responsive.css" type="text/css"/>
        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
        <script type="text/javascript" src="js/jquery.js" ></script>
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
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
		<jsp:include page="${menuOption}">
			<jsp:param name="pageSelectionnee" value="espaceResp"/>
		</jsp:include>
		<aside class="deconnexion">
			<a href="connexion?logout"><img id=deconnexion src="img/btnDeconnexion.jpg" alt="Déconnexion" title="Déconnexion"/></a>
		</aside>
		<div class="clear"></div>
		
				
		<!--cette section est pour tous les présidents -->
		
			<h3 class="desktop" id="titre">Espace Resp'</h3>
		<c:if test="${statut==1}">
			<jsp:include page="menuEspaceRespComm.jsp">
				<jsp:param name="pageSelectionnee" value="espaceResp"/>
			</jsp:include>
			<div class="clear"></div>
			<h3 class="taille15" id="titre2">Vous êtes président de :</h3>
			
				<article class="entier <c:if test="${commission.idpole==1}"> BDA</c:if><c:if test="${commission.idpole==2}"> BDS</c:if><c:if test="${commission.idpole==3}">CapSo</c:if><c:if test="${commission.idpole==4}">PES</c:if><c:if test="${commission.idpole==1}"> PET</c:if>">
					<img id="logo" src="${commission.logo}" alt="${commission.nomCommission}" title="${commission.nomCommission}"/>
					<h3 class="titreAsso">${commission.nomCommission}</h3>
					<div id="descriptionAssoPres">${commission.description}</div>
					<a href="modifierAsso?idcommission=${commission.idcommission}" class="modifAsso">Modifier mon asso</a>
					<div class="clear"></div>
					<article class="events">
						<div class="labelArticle">Vos évènements :</div>
						<c:forEach var="evenement" items="${listEvent}">
							<h4 class="titreEventPres">${evenement.titreEvent}</h4>
							<p id="horaire">Début : <fmt:formatDate value="${evenement.debut}" pattern="dd MMMM yyyy"/>  ${evenement.hDebut}
							Fin : <fmt:formatDate value="${evenement.fin}" pattern="dd MMMM yyyy"/>  ${evenement.hFin}</p>
							<div class="posModSuppr">
								<a href="modifierEvent?idevenement=${evenement.idEvenement}" class="btnModif">Modifier</a>    <a href="supprimerEvent?idevenement=${evenement.idEvenement}" class="btnSuppr">Supprimer</a>
								<a href="listeParticipation?idevenement=${evenement.idEvenement}" class="btnVoir">Voir participants</a>
							</div>
						</c:forEach>
					</article>
					<div class="clear"></div>
				</article>
			</c:if>
			
			<c:if test="${statut==2}">
				<jsp:include page="menuEspaceRespPole.jsp">
					<jsp:param name="pageSelectionnee" value="espaceResp"/>
				</jsp:include>
				<div class="clear"></div>
				<h3 id="titre2">Vous êtes responsable du pôle : ${pole.nomPole}</h3>
				
				<article class="entier ${pole.nomPole}">
					<c:forEach var="commission" items="${listeCommission}">
						<img id="logo" src="${commission.logo}" alt="${commission.nomCommission}" title="${commission.nomCommission}"/>
						<h3 class="titreAsso">${commission.nomCommission}</h3>
						<div class="posModSuppr">
							<a href="modifierAsso?idcommission=${commission.idcommission}" class="btnModif">Modifier cette asso</a>
						</div>
						<div class="clear"></div>
					</c:forEach>	
				</article>
			</c:if>
	
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>