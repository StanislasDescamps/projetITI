<nav id="navigationPres">
			<ul>
				<li <%if("espaceResp".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %>><a href="espaceResp">Mes associations</a></li>
				<li <%if("moderation".equals(request.getParameter("pageSelectionnee"))) {%> class="active" <% } %>><a href="moderation">Ev�nements mod�r�s</a></li>
			</ul>
		</nav>