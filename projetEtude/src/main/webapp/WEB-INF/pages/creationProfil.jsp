<%@page import="hei.model.*, hei.metier.*" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- En-tête de la page -->
        <meta charset="utf-8"/>
        <title>Création du profil</title>
    </head>
	<body style="font-family: arial, sans-serif, 1em;">
		<!-- Corps de la page 
		<link rel="stylesheet" href="css/creationProfil.css">-->
		<h1 style="position:relative; left:550px;color: red;margin:10px;width:200px;"id="titre1">HEI-Diary</h1>
		<h1 style="position:relative; left:450px;color: red;margin: 10px;width:600px;" id="titre2">Bienvenue sur HEI-Diary</h1>
		<h2 style="position:relative; left:450px;color: blue;padding:10px 0px 10px 0px;width:600px;margin: 10px;">L'application qui vous tient informé</h2>
		<h3 style="position:relative; left:490px;width:600px;margin: 10px;">Première étape : Création du profil</h3>
				
		<form id="creationProfil" action="creationProfil" method="post" style="position:relative;top:20px;left:450px;margin: 10px;width:400px;height:200px;">
			<fieldset>
				<legend>Profil</legend>
					<label for="nom">Nom :</label>
					<input type="text" name="nom" id="nom"required/>
				<br/>
					<label for="prenom">Prénom :</label>
					<input type="text" name="prenom" id="prenom"required/>
				<br/>
					<label for="mail">Adresse email :</label>
					<input type="text" name="mail" id="mail"required/>
				<br/>
					<input type="submit" value="Enregistrer" id="btn"/>
			</fieldset>
		</form>
		
		<div style="position:relative;left:400px;max-width:800px;"><%
		 if(request.getAttribute("loginError")!=null) {
	           out.print((String)request.getAttribute("loginError"));
	       }
		%></div>
	</body>
</html>