<nav id="navigationPres">
			<ul>
				<li <%if("configDroit".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %>><a href="configuration">G�rer les droits</a></li>
				<li <%if("ajouterAsso".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %>><a href="ajouterAsso">Cr�er une nouvelle asso</a></li>
				<li <%if("modifierAsso".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %>><a href="modifierAsso">Modifier une asso</a></li>
			</ul>
		</nav>