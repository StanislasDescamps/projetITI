<nav id="navigationOption">
			<ul>
				<li <%if("mesOptions".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %>><a href="mesOptions">Pr�f�rences</a></li>
				<li <%if("mesInfos".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %>><a href="mesInfos">Informations</a></li>
				<li <%if("administration".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %>><a href="administration">Administration</a></li>
			</ul>
		</nav>