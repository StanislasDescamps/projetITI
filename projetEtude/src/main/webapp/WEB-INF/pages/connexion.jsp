<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- En-tête de la page -->
        <meta charset="utf-8" />
        <title>Identification HEI-Diary</title>
    </head>
	<body style="font-family: arial, sans-serif, 1em;background-image: url(../img/background-ident.jpg);height:600;width:1130;background-attachment:fixed;">
		<!-- Corps de la page 
		<link rel="stylesheet" href="css/connexion.css">-->
		<h1 style="position:relative; left:450px;color: red;">Bienvenue sur HEI-Diary</h1>
		<%
       if(request.getAttribute("loginError")!=null) {
           out.print((String)request.getAttribute("loginError"));
       }else{
           out.print("Merci de vous connecter !");
       }
   %>
		<form id="identification" action="connexion" method="post" style="position:fixed;top: 380px;right: 70px;background-color:white;">
			<fieldset>
				<legend>Identifiez-vous</legend>
				<label for="mail">Mon adresse email :</label>
				<input type="text" name="mail" id="mail"required/>
				<br/>
				<label for="pass"> Mon mot de passe :</label>
				<input type="password" name="pass" id="pass"required />
				<br/>
				<input type="submit" value="Connexion"/>
				<a href="">Mot de passe oublié</a>
			</fieldset>	
		</form>
		<a href="creationProfil"><input id="creation" type="submit" value="Créer un profil" style="position: relative;top: 420px;left:750px;"></a>		
	</body>
</html>