<nav id="navigationPres">
			<ul>
				<li <%if("configDroit".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %>><a href="administration">G�rer les droits</a></li>
				<li <%if("ajouterAsso".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %>><a href="ajouterAsso">Cr�er une nouvelle asso</a></li>
				<li <%if("listeModifAsso".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %>><a href="listeModifAsso">Modifier une asso</a></li>
				<li <%if("moderation".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %>><a href="moderation">Ev�nements mod�r�s</a></li>
			</ul>
		</nav>