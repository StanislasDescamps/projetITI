<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- En-tête de la page -->
        <meta charset="utf-8" />
        <title>Identification HEI-Diary</title>
    </head>
	<body>
		<!-- Corps de la page -->
		<link rel="stylesheet" href="css/connexion.css">
		<h1>Bienvenue sur HEI-Diary</h1>
		<form id="identification" action="connexion" method="post">
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
		<a href="creationProfil"><input id="creation" type="submit" value="Créer un profil"></a>		
	</body>
</html>