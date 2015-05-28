<div class="desktop">
	<nav id="navigationPres">
		<ul>
			<li <%if("espaceResp".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %>><a href="espaceResp">Mon association</a></li>
			<li <%if("ajouterEvent".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %>><a href="ajouterEvent">Créer un nouvel évènement</a></li>
		</ul>
	</nav>
</div>
		
<div class="mobile">		
	<select class="navPresMobile" name="menuPres" onchange="location = this.options[this.selectedIndex].value;">
		<option value="espaceResp" <%if("espaceResp".equals(request.getParameter("pageSelectionnee"))) {%> selected <% } %>>Mon association</option>
		<option value="ajouterEvent" <%if("ajouterEvent".equals(request.getParameter("pageSelectionnee"))) {%> selected <% } %>>Créer un nouvel évènement</option>
		
	</select>
	<div class="separation"></div>
</div>