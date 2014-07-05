<nav id="navigationPres">
			<ul>
				<li <%if("configDroit".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %>><a href="configuration">Gérer les droits</a></li>
				<li <%if("ajouterAsso".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %>><a href="ajouterAsso">Créer une nouvelle asso</a></li>
				<li <%if("modifierAsso".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %>><a href="modifierAsso">Modifier une asso</a></li>
			</ul>
		</nav>