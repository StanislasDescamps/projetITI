<nav id="navigationPres">
			<ul>
				<li <%if("espacePresident".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %>><a href="espacePresident">Mon association</a></li>
				<li <%if("ajouterEvent".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %>><a href="ajouterEvent">Cr�er un nouvel �v�nement</a></li>
			</ul>
		</nav>