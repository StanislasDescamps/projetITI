<div class="desktop">
	<nav id="navigationPres">
		<ul>
			<li <%if("configDroit".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %>><a href="administration">Gérer les droits</a></li>
			<li <%if("ajouterAsso".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %>><a href="ajouterAsso">Créer une nouvelle asso</a></li>
			<li <%if("listeModifAsso".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %>><a href="listeModifAsso">Modifier une asso</a></li>
			<li <%if("moderation".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %>><a href="moderation">Evénements modérés</a></li>
		</ul>
	</nav>
</div>
<div class="mobile">		
	<select class="navPresMobile" name="menuPres" onchange="location = this.options[this.selectedIndex].value;">
		<option value="administration" <%if("configDroit".equals(request.getParameter("pageSelectionnee"))) {%> selected <% } %>>Gérer les droits</option>
		<option value="ajouterAsso" <%if("ajouterAsso".equals(request.getParameter("pageSelectionnee"))) {%> selected <% } %>>Créer une nouvelle asso</option>
		<option value="listeModifAsso" <%if("listeModifAsso".equals(request.getParameter("pageSelectionnee"))) {%> selected <% } %>>Modifier une asso</option>
		<option value="moderation" <%if("moderation".equals(request.getParameter("pageSelectionnee"))) {%> selected <% } %>>Evénements modérés</option>
	</select>
	<div class="separation"></div>
</div>
