<nav id="navigationOption" class="desktop">
			<ul>
				<li <%if("mesOptions".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %>><a href="mesOptions">Mes préférences</a></li>
				<li <%if("mesInfos".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %>><a href="mesInfos">Mes informations</a></li>
				<li <%if("espacePresident".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %>><a href="espacePresident">Espace président</a></li>
				<li <%if("configuration".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %>><a href="configuration">Configuration</a></li>
			</ul>
		</nav>