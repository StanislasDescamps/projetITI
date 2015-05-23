<%@page import="hei.model.*, hei.metier.*" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- En-tête de la page -->
        <meta charset="utf-8" name="viewport" content="initial-scale=1.0"/>
        <title>Identification HEI-Diary</title>
        <link rel="stylesheet" media="screen" href="css/responsive.css" type="text/css"/>
    </head>
	<body style="font-family: Arial, Helvetica;">
		<!-- Corps de la page 
		<link rel="stylesheet" href="css/connexion.css">-->
		<h1 class="titreBienvenue">Bienvenue sur HEI-Diary</h1>
		
		
		<form class="identification" action="connexion" method="post">
			<fieldset>
				<legend>Identifiez-vous</legend>
				<label for="mail">Mon adresse email :</label>
				<input class="inputConnexion" type="text" name="mail" id="mail" required/>
				<br/>
				<label for="pass"> Mon mot de passe :</label>
				<input  class="inputConnexion" type="password" name="pass" id="pass"required />
				<br/>
				<input type="submit" name="connexion" value="Connexion" class="bouton_submit"/>
			</fieldset>	
		</form>
		<div class="clear"></div>
		<div class="errorConnexion1">
		<%
       if(request.getAttribute("loginError")!=null) {
           out.print((String)request.getAttribute("loginError"));
       }
   		%>
   		</div>
   
  		<a href="creationProfil" class="creerProfil" ><input id="creation" type="submit" value="Créer un profil"></a>
   
		<form id="mdpoublie" action="connexion" method="post" class="mdpOublie">
			<fieldset>
				<legend>Mot de passe oublié</legend>
				<label for="mailmdp">Mon adresse email :</label>
				<input type="text" name="mailmdp" id="mailmdp" class="inputConnexion" required/>
				<input type="submit" name="passoublie" value="Envoyer mon mot de passe" class="bouton_submit"/>
			</fieldset>
		</form>
		<div class="clear"></div>
		<div class="errorConnexion2">
		<%
       if(request.getAttribute("mailError")!=null) {
           out.print((String)request.getAttribute("mailError"));
       }
		if(request.getAttribute("mailEnvoye")!=null) {
	           out.print((String)request.getAttribute("mailEnvoye"));
	       }
   			%>
   		</div>
		<div class="clear"></div>
		<footer>
			<div>Réalisation HEI</div>
		</footer>
	</body>
</html>