<nav id="navigationPres">
			<ul>
				<li <%if("espacePresident".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %>><a href="espacePresident">Mon association</a></li>
				<li <%if("ajouterEvent".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %>><a href="ajouterEvent">Créer un nouvel évènement</a></li>
			</ul>
		</nav>