<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- En-tête de la page -->
        <meta charset="utf-8"/>
        <title>Création du profil</title>
    </head>
	<body>
		<!-- Corps de la page -->
		<link rel="stylesheet" href="css/creationProfil.css">
		<h1 id="titre1">HEI-Diary</h1>
		<h1 id="titre2">Bienvenue sur HEI-Diary</h1>
		<h2>L'application qui vous tient informé</h2>
		<h3>Première étape : Création du profil</h3>
		
		<%
		 if(request.getAttribute("loginError")!=null) {
	           out.print((String)request.getAttribute("loginError"));
	       }
		%>
		
		<form id="creationProfil" action="creationProfil" method="post">
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
	</body>
</html>