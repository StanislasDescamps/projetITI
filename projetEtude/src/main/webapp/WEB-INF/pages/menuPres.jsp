<nav id="navigationOption">
			<ul>
				<li <%if("mesOptions".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %>><a href="mesOptions">Mes pr�f�rences</a></li>
				<li <%if("mesInfos".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %>><a href="mesInfos">Mes informations</a></li>
				<li <%if("espacePresident".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %>><a href="espacePresident">Espace pr�sident</a></li>
			</ul>
		</nav>