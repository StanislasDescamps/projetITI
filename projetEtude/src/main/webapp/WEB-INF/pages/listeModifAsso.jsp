<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <!-- En-tête de la page -->
        <meta charset="utf-8" name="viewport" content="initial-scale=1.0"/>
        <title>HEI-Diary Modifier une asso</title>
        <link rel="stylesheet" media="screen" href="css/responsive.css" type="text/css"/>
        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
        <script type="text/javascript" src="js/jquery.js" ></script>
		<script type="text/javascript" src="js/jsTab.js"></script>
		<script type="text/javascript" src="js/jsAsso.js"></script>
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
		<jsp:include page="${menuOption}">
			<jsp:param name="pageSelectionnee" value="administration"/>
		</jsp:include>
		<aside class="deconnexion">
			<a href="connexion?logout"><img id=deconnexion src="img/btnDeconnexion.jpg" alt="Déconnexion" title="Déconnexion"/></a>
		</aside>
		<div class="clear"></div>
		
		<h3 class="desktop" id="titre">Modifier une association</h3>
		
		<jsp:include page="menuConfig.jsp">
			<jsp:param name="pageSelectionnee" value="listeModifAsso"/>
		</jsp:include>
		
		<section class="tous">
			<ul class="tabs"> 
				<li class="active" rel="tab1"> BDA</li>
				<li rel="tab2"> BDS</li>
				<li rel="tab3"> CapSo</li>
				<li rel="tab4"> PES</li>
				<li rel="tab5"> PET</li>
			</ul>
		
			<div class="tab_container"> 
	
				<div id="tab1" class="tab_content"> 
					<ul class="taille15">
						<c:forEach var="commission" items="${listeComm}">
							<c:if test="${commission.idpole==1}">
							<li style="list-style-type:none; "><div class="nomComListMod">${commission.nomCommission}</div> <a href="modifierAsso?idcommission=${commission.idcommission}" class="btnModif">Modifier</a>    <div id="${commission.idcommission}" class="btnSuppr">Supprimer</div></li>
							</c:if>
						</c:forEach>
					</ul>
				</div><!-- #tab1 -->
				<div id="tab2" class="tab_content"> 
					<ul class="taille15">
						<c:forEach var="commission" items="${listeComm}">
							<c:if test="${commission.idpole==2}">
							<li style="list-style-type:none; "><div class="nomComListMod">${commission.nomCommission}</div> <a href="modifierAsso?idcommission=${commission.idcommission}" class="btnModif">Modifier</a>    <div id="${commission.idcommission}" class="btnSuppr">Supprimer</div></li>
							</c:if>
						</c:forEach>
					</ul>
				</div><!-- #tab2 -->
				<div id="tab3" class="tab_content"> 
					<ul class="taille15">
						<c:forEach var="commission" items="${listeComm}">
							<c:if test="${commission.idpole==3}">
							<li style="list-style-type:none; "><div class="nomComListMod">${commission.nomCommission}</div> <a href="modifierAsso?idcommission=${commission.idcommission}" class="btnModif">Modifier</a>    <div id="${commission.idcommission}" class="btnSuppr">Supprimer</div></li>
							</c:if>
						</c:forEach>
					</ul>
				</div><!-- #tab3 -->
				<div id="tab4" class="tab_content"> 
					<ul class="taille15">
						<c:forEach var="commission" items="${listeComm}">
							<c:if test="${commission.idpole==4}">
							<li style="list-style-type:none; "><div class="nomComListMod">${commission.nomCommission}</div> <a href="modifierAsso?idcommission=${commission.idcommission}" class="btnModif">Modifier</a>    <div id="${commission.idcommission}" class="btnSuppr">Supprimer</div></li>
							</c:if>
						</c:forEach>
					</ul>
				</div><!-- #tab4 -->
				<div id="tab5" class="tab_content"> 
					<ul class="taille15">
						<c:forEach var="commission" items="${listeComm}">
							<c:if test="${commission.idpole==5}">
							<li style="list-style-type:none; "><div class="nomComListMod">${commission.nomCommission}</div> <a href="modifierAsso?idcommission=${commission.idcommission}" class="btnModif">Modifier</a>    <div id="${commission.idcommission}" class="btnSuppr">Supprimer</div></li>
							</c:if>
						</c:forEach>
					</ul>
				</div><!-- #tab5 --> 
	     
			</div> <!-- .tab_container --> 
		</section>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>