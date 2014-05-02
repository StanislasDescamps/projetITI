<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- En-tête de la page -->
        <meta charset="utf-8" />
        <title>Identification HEI-Diary</title>
    </head>
	<body style="font-family: arial, sans-serif, 1em;height:800;width:1280;">
		<!-- Corps de la page 
		<link rel="stylesheet" href="css/connexion.css">-->
		<h1 style="position:relative; left:450px;color: red;width:400px;margin-right:0px;margin-left:0px;">Bienvenue sur HEI-Diary</h1>
		<%
       if(request.getAttribute("loginError")!=null) {
           out.print((String)request.getAttribute("loginError"));
       }else{
           out.print("Merci de vous connecter !");
       }
   %>
		<form id="identification" action="connexion" method="post" style="position:relative;top:20px;left:450px;margin: 10px;width:400px;height:150px;">
			<fieldset>
				<legend>Identifiez-vous</legend>
				<label for="mail">Mon adresse email :</label>
				<input type="text" name="mail" id="mail"required/>
				<br/>
				<label for="pass"> Mon mot de passe :</label>
				<input type="password" name="pass" id="pass"required />
				<br/>
				<input type="submit" name="connexion" value="Connexion"/>
				
			</fieldset>	
		</form>
		<form id="mdpoublie" action="connexion" method="post" style="position:relative;top:0px;left:450px;margin: 10px;width:400px;height:100px;">
			<fieldset>
				<legend>Mot de passe oublié</legend>
				<label for="mailmdp">Mon adresse email :</label>
				<input type="text" name="mailmdp" id="mailmdp"required/>
				<input type="submit" name="mdpoublie" value="Envoyer mon mot de passe"/>
			</fieldset>
		</form>
		<%
       if(request.getAttribute("mailError")!=null) {
           out.print((String)request.getAttribute("mailError"));
       }
   %>
		<a href="creationProfil"><input id="creation" type="submit" value="Créer un profil" style="position: relative;top: 0px;left:750px;"></a>		
	</body>
</html>