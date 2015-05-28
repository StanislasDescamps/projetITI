<div class="desktop">
	<nav id="navigationPres">
		<ul>
			<li <%if("configDroit".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %>><a href="administration">G�rer les droits</a></li>
			<li <%if("ajouterAsso".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %>><a href="ajouterAsso">Cr�er une nouvelle asso</a></li>
			<li <%if("listeModifAsso".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %>><a href="listeModifAsso">Modifier une asso</a></li>
			<li <%if("moderation".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %>><a href="moderation">Ev�nements mod�r�s</a></li>
		</ul>
	</nav>
</div>
<div class="mobile">		
	<select class="navPresMobile" name="menuPres" onchange="location = this.options[this.selectedIndex].value;">
		<option value="administration" <%if("configDroit".equals(request.getParameter("pageSelectionnee"))) {%> selected <% } %>>G�rer les droits</option>
		<option value="ajouterAsso" <%if("ajouterAsso".equals(request.getParameter("pageSelectionnee"))) {%> selected <% } %>>Cr�er une nouvelle asso</option>
		<option value="listeModifAsso" <%if("listeModifAsso".equals(request.getParameter("pageSelectionnee"))) {%> selected <% } %>>Modifier une asso</option>
		<option value="moderation" <%if("moderation".equals(request.getParameter("pageSelectionnee"))) {%> selected <% } %>>Ev�nements mod�r�s</option>
	</select>
	<div class="separation"></div>
</div>
