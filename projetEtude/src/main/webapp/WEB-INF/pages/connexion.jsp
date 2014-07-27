<%@page import="hei.model.*, hei.metier.*" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- En-tête de la page -->
        <meta charset="utf-8" />
        <title>Identification HEI-Diary</title>
    </head>
	<body style="font-family: Arial, Helvetica;">
		<!-- Corps de la page 
		<link rel="stylesheet" href="css/connexion.css">-->
		<h1 style="text-align:center;color: red;width:100%;margin:0 auto;">Bienvenue sur HEI-Diary</h1>
		
		
		<form id="identification" action="connexion" method="post" style="float:left;margin: 30px 30% 10px 30%;width:40%;height:150px;">
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
		
		<div style="margin-left: 30%;max-height: 20px;max-width: 30%;">
		<%
       if(request.getAttribute("loginError")!=null) {
           out.print((String)request.getAttribute("loginError"));
       }else{
           out.print("Merci de vous connecter !");
       }
   %>
   </div>
   
   <a href="creationProfil"><input id="creation" type="submit" value="Créer un profil" style="margin:0 30% 0 0;float:right;"></a>
   
		<form id="mdpoublie" action="connexion" method="post" style="float:left;margin: 30px 30% 10px 30%;width:40%;height:100px;">
			<fieldset>
				<legend>Mot de passe oublié</legend>
				<label for="mailmdp">Mon adresse email :</label>
				<input type="text" name="mailmdp" id="mailmdp"required/>
				<input type="submit" name="passoublie" value="Envoyer mon mot de passe"/>
			</fieldset>
		</form>
		<div style="position:relative;top:20px;left:300px;max-width:900px;">
		<%
       if(request.getAttribute("mailError")!=null) {
           out.print((String)request.getAttribute("mailError"));
       }
		if(request.getAttribute("mailEnvoye")!=null) {
	           out.print((String)request.getAttribute("mailEnvoye"));
	       }
   %>
   </div>
			
	</body>
</html>