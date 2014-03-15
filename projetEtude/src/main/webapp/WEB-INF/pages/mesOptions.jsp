<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <!-- En-tête de la page -->
        <meta charset="utf-8" />
        <title>HEI-Diary Mes options</title>
    </head>
	<body>
		<!-- Corps de la page -->
		<link rel="stylesheet" href="css/mesoptions.css">
		<script type="text/javascript" src="js/jquery.js" ></script>
		<script language="javascript" type="text/javascript" src="js/js.js"></script>
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
		<header id="entete">
			<h1>HEI-Diary</h1>
		</header>
		<jsp:include page="menu.jsp"/>
		<c:set var="pageSelectionnee" value="mesOptions" scope="request"></c:set>
		<aside class="deconnexion">
			<a href="connexion">Déconnexion</a>
		</aside>
		<h3 id="presentation">
			Cette page vous permet de sélectionner vos associations préférées, de les faire apparaître dans votre calendrier personnel et de synchroniser leurs événements sur votre smartphone!
		</h3>
		<!--cette section est pour tous les étudiants -->
		<section class="tous">
				<legend>Mes préférences</legend>
				<section id="choixbureau">	
					<label for="bureau">Choississez l'ensemble qui vous intéresse : </label>
					<select id="bureau" name="bureau">
						<option class="active" value="BDA">BDA</option>
						<option value="BDS">BDS</option>
						<option value="CapSo">Cap Solidaire</option>
						<option value="PES">PES</option>
						<option value="PET">PET</option>
					</select>
				</section>
				<form id="preference" action="mesOptions" method="post">
				<section id="asso">
					<div class="tab_contain"> 

						<div id="BDA" class="tab_cont">
							<c:forEach var="commission" items="${listCommBDA}">
							<input type="checkbox" name="${commission.nomCommission}" id="${commission.nomCommission}" /> <label for="${commission.nomCommission}">${commission.nomCommission}</label><br/>
							</c:forEach>
						</div>
						<div id="BDS" class="tab_cont">
							<c:forEach var="commission" items="${listCommBDS}">
							<input type="checkbox" name="${commission.nomCommission}" id="${commission.nomCommission}" /> <label for="${commission.nomCommission}">${commission.nomCommission}</label><br/>
							</c:forEach>
						</div>
						<div id="CapSo" class="tab_cont">
							<c:forEach var="commission" items="${listCommCap}">
							<input type="checkbox" name="${commission.nomCommission}" id="${commission.nomCommission}" /> <label for="${commission.nomCommission}">${commission.nomCommission}</label><br/>
							</c:forEach>
						</div>
						<div id="PES" class="tab_cont">
							<c:forEach var="commission" items="${listCommPES}">
							<input type="checkbox" name="${commission.nomCommission}" id="${commission.nomCommission}" /> <label for="${commission.nomCommission}">${commission.nomCommission}</label><br/>
							</c:forEach>
						</div>
						<div id="PET" class="tab_cont">
							<c:forEach var="commission" items="${listCommPET}">
							<input type="checkbox" name="${commission.nomCommission}" id="${commission.nomCommission}" /> <label for="${commission.nomCommission}">${commission.nomCommission}</label><br/>
							</c:forEach>
						</div>
					</div>	
				</section>
				
				
				
				
				
				
				<input type="reset" value="Réinitialiser"/>
				<input type="submit" value="Enregistrer"/>
			</form>
		</section>
		
		
		
		
		
		<section id="president">
			<a href="ajouterAsso"><input type="submit" value="Ajouter une association"/></a>
			<a href="listeModifAsso"><input type="submit" value="Modifier une association"/></a>
		</section>
		<footer>
			<div> Réalisation HEI </div>
		</footer>
	</body>
</html>