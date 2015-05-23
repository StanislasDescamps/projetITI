<%@page import="hei.model.*, hei.metier.*" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- En-tête de la page -->
        <meta charset="utf-8" name="viewport" content="initial-scale=1.0"/>
        <title>Création du profil</title>
    </head>
	<body style="font-family: arial, Helvetica;">
		<!-- Corps de la page 
		<link rel="stylesheet" href="css/creationProfil.css">-->
		<h1 style="text-align:center;color: red;width:100%;margin:10px auto;" id="titre1">HEI-Diary</h1>
		<h1 style="text-align:center;color: red;width:100%;margin:0 auto;" id="titre2">Bienvenue sur HEI-Diary</h1>
		<h2 style="text-align:center;color: blue;margin:10px auto;width:50%;">L'application qui vous tient informé</h2>
		<h3 style="text-align:center; margin:10px auto;width:50%;">Première étape : Création du profil</h3>
				
		<form id="creationProfil" action="creationProfil" method="post" style="float:left;margin: 30px 30% 10px 30%;width:40%;height:100px;">
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
		
		<div style="position:relative;left:400px;max-width:800px;">
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
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>