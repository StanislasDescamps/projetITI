<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <!-- En-tête de la page -->
        <meta charset="utf-8" name="viewport" content="initial-scale=1.0"/>
        <title>HEI-Diary Mes options</title>
        <link rel="stylesheet" media="screen" href="css/responsive.css" type="text/css"/>
    </head>
	<body>
		<!-- Corps de la page -->
		<script type="text/javascript" src="js/jquery.js" ></script>
		<script type="text/javascript" src="js/js.js"></script>
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<script type="text/javascript" src="js/jsmenu.js"></script>
		<script src="http://code.jquery.com/jquery-latest.js"></script>
		<script src="http://jquery-ui.googlecode.com/svn/tags/latest/ui/jquery.effects.core.js"></script>
		<script src="http://jquery-ui.googlecode.com/svn/tags/latest/ui/jquery.effects.slide.js"></script>
		
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
			<jsp:param name="pageSelectionnee" value="mesOptions"/>
		</jsp:include>
		<aside class="deconnexion deconnexion2">
			<a href="connexion?logout"><img id=deconnexion src="img/btnDeconnexion.jpg" alt="Déconnexion" title="Déconnexion"/></a>
		</aside>
		<div class="clear"></div>
		<!--cette section est pour tous les étudiants -->
		
		<h3 id="titre">Mes préférences</h3>
			
		<h3 id="presentation">
			Cette page vous permet de sélectionner vos associations préférées et de les faire apparaître dans votre calendrier personnel! 
		</h3>
			<section class="tous">
				<!--  <label for="bureau" class="labelExpliChoix">Choississez l'ensemble qui vous intéresse : </label> -->
			<ul class="tabs"> 
				<li class="active" rel="tab1"> BDA</li>
				<li rel="tab2"> BDS</li>
				<li rel="tab3"> CapSo</li>
				<li rel="tab4"> PES</li>
				<li rel="tab5"> PET</li>
			</ul>
			<form id="preferences" method="post" action="mesOptions">
				<div class="tab_container"> 
			<div id="tab1" class="tab_content"> 
				<ul class="listeAssoTab">
					<c:forEach var="commission" items="${listeComm}">
						<c:if test="${commission.idpole==1}">
						<li> <input type="checkbox" name="commission" id="${commission.nomCommission}" value="${commission.idcommission}"/> <label for="${commission.nomCommission}">${commission.nomCommission}</label></li><br/>
						</c:if>
					</c:forEach>
				</ul>
			</div><!-- #tab1 -->
			<div id="tab2" class="tab_content"> 
				<ul class="listeAssoTab">
					<c:forEach var="commission" items="${listeComm}">
						<c:if test="${commission.idpole==2}">
						<li> <input type="checkbox" name="commission" id="${commission.nomCommission}" value="${commission.idcommission}"/> <label for="${commission.nomCommission}">${commission.nomCommission}</label></li><br/>
						</c:if>
					</c:forEach>
				</ul>
			</div><!-- #tab2 -->
			<div id="tab3" class="tab_content"> 
				<ul class="listeAssoTab">
					<c:forEach var="commission" items="${listeComm}">
						<c:if test="${commission.idpole==3}">
						<li> <input type="checkbox" name="commission" id="${commission.nomCommission}" value="${commission.idcommission}" /> <label for="${commission.nomCommission}">${commission.nomCommission}</label></li><br/>
						</c:if>
					</c:forEach>
				</ul>
			</div><!-- #tab3 -->
			<div id="tab4" class="tab_content"> 
				<ul class="listeAssoTab">
					<c:forEach var="commission" items="${listeComm}">
						<c:if test="${commission.idpole==4}">
						<li> <input type="checkbox" name="commission" id="${commission.nomCommission}" value="${commission.idcommission}"/> <label for="${commission.nomCommission}">${commission.nomCommission}</label></li><br/>
						</c:if>
					</c:forEach>
				</ul>
			</div><!-- #tab4 -->
			<div id="tab5" class="tab_content"> 
				<ul class="listeAssoTab">
					<c:forEach var="commission" items="${listeComm}">
						<c:if test="${commission.idpole==5}">
						<li> <input type="checkbox" name="commission" id="${commission.nomCommission}" value="${commission.idcommission}"/> <label for="${commission.nomCommission}">${commission.nomCommission}</label></li><br/>
						</c:if>
					</c:forEach>
				</ul>
			</div><!-- #tab5 --> 
     
		</div> <!-- .tab_container --> 
								
				<input type="submit" name="reinitialiser" value="Réinitialiser tout"/>
				<input type="submit" name="enregistrer" value="Ajouter mes nouveaux choix"/>
			</form>
		</section>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>