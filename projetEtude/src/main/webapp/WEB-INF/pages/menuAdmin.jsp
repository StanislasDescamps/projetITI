<nav id="navigationOption" class="desktop">
			<ul>
				<li <%if("mesOptions".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %>><a href="mesOptions">Mes pr�f�rences</a></li>
				<li <%if("mesInfos".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %>><a href="mesInfos">Mes informations</a></li>
				<li <%if("administration".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %>><a href="administration">Administration</a></li>
			</ul>
		</nav>