<nav id="navigationPres">
			<ul>
				<li <%if("espaceResp".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %>><a href="espaceResp">Mon association</a></li>
				<li <%if("ajouterEvent".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %>><a href="ajouterEvent">Cr�er un nouvel �v�nement</a></li>
			</ul>
		</nav>