<%@page import="hei.model.*, hei.metier.*" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- En-tête de la page -->
        <meta charset="utf-8" name="viewport" content="initial-scale=1.0"/>
        <title>Création du profil</title>
        <link rel="stylesheet" media="screen" href="css/responsive.css" type="text/css"/>
        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
    </head>
	<body style="font-family: Arial, Helvetica;">
		<!-- Corps de la page -->
		<div class="ententeCreation mobile">
			<div class="retour" onclick="window.history.go(-1); return false;"></div>
			<h1 class="titreBienvenue2">Bienvenue sur HEI-Diary</h1>
		</div>
		<h1 class="titreBienvenue desktop">Bienvenue sur HEI-Diary</h1>
				
		<form id="creationProfil" action="creationProfil" method="post" class="identification">
			<fieldset>
				<legend>Création du profil</legend>
					<label for="nom">Nom :</label>
					<input type="text" name="nom" id="nom" class="inputConnexion" required/>
				<br/>
					<label for="prenom">Prénom :</label>
					<input type="text" name="prenom" id="prenom" class="inputConnexion" required/>
				<br/>
					<label for="mail">Adresse email :</label>
					<input type="text" name="mail" id="mail" class="inputConnexion" required/>
				<br/>
					<input type="submit" value="Enregistrer" id="btn"/>
			</fieldset>
		</form>
		
		<div class="clear"></div>
		<div class="messageCreationProfil">
		<%
		 if(request.getAttribute("loginError")!=null) {
	           out.print((String)request.getAttribute("loginError"));
	       }
		if(request.getAttribute("mailEnvoye")!=null) {
	           out.print((String)request.getAttribute("mailEnvoye"));
	       }
		if(request.getAttribute("ErrorMail")!=null) {
	           out.print((String)request.getAttribute("ErrorMail"));
	       }
		%>
		</div>
		
		<div class="clear"></div>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>