<nav id="navigationPres">
			<ul>
				<li <%if("espaceResp".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %>><a href="espaceResp">Mon association</a></li>
				<li <%if("ajouterEvent".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %>><a href="ajouterEvent">Créer un nouvel évènement</a></li>
			</ul>
		</nav>