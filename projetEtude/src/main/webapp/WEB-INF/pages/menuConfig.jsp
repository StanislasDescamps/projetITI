<nav id="navigationPres">
			<ul>
				<li <%if("configDroit".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %>><a href="administration">Gérer les droits</a></li>
				<li <%if("ajouterAsso".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %>><a href="ajouterAsso">Créer une nouvelle asso</a></li>
				<li <%if("listeModifAsso".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %>><a href="listeModifAsso">Modifier une asso</a></li>
			</ul>
		</nav>