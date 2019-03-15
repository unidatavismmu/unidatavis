<!-- Navigation links to different areas of the site -->
	<nav>

		<ul style="padding-top:10px; padding-bottom:10px">

			<li><a href="index.jsp">Home</a></li>
			<li><a href="about.jsp">About</a></li>
			<li><a href="universities.jsp">Universities</a></li>
			<li><a href="courses.jsp">Courses</a></li>
			<% if (Controller.loggedIn == false) { %>
				<li><a href="#" onclick="document.getElementById('id02').style.display='block'" style="width:auto;">Register</a></li>
				<li><a href="#" onclick="document.getElementById('id01').style.display='block'" style="width:auto;">Login</a></li>
			<% } else { %>
				<li><a href="account.jsp">Account</a></li>
				<li><a href="logout">Logout</a></li>
			<% } %>

		</ul>

	</nav>