<div class="desktop">
	<nav id="navigationPres">
		<ul>
			<li <%if("espaceResp".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %>><a href="espaceResp">Mes associations</a></li>
			<li <%if("moderation".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %>><a href="moderation">Ev�nements mod�r�s</a></li>
		</ul>
	</nav>
</div>
		
<div class="mobile">		
	<select class="navPresMobile" name="menuPres" onchange="location = this.options[this.selectedIndex].value;">
		<option value="espaceResp" <%if("espaceResp".equals(request.getParameter("pageSelectionnee"))) {%> selected <% } %>>Mes associations</option>
		<option value="moderation" <%if("moderation".equals(request.getParameter("pageSelectionnee"))) {%> selected <% } %>>Ev�nements mod�r�s</option>
		
	</select>
	<div class="separation"></div>
</div>