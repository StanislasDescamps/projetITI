
<nav id="navigation" class="invisible">
			<ul id="menu">
				<li <%if("monCalendrier1".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %> ><a href="monCalendrier1">Mon calendrier</a></li>
				<li <%if("calendrierHei".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %> ><a href="calendrierHei">Calendrier HEI</a></li>
				<li <%if("mesOptions".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %> ><a href="mesOptions">Mes options</a></li>
				<li <%if("lesAssos".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %> ><a href="lesAssos">Contact</a></li>
				<li class=${pageSelectionnee=='test'?'active':'inactive'}><a href="test">Test</a></li>
				<li class="mobile"><a href="connexion?logout">D�connexion</a></li>
			</ul>
		</nav>