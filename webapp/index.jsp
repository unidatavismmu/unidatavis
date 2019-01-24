<html>
<head>
	<!-- Head defines title and links to CSS -->
	<title>Website Title</title>
	<!-- TODO: Link to CSS -->
</head>

<body>

	<!-- Top of page: Login button -->
	<!-- TODO: Popup using bootstrap for login -->
	<div class="login">
		<a href="">Login</a>
	</div>
		
	<!-- Website title, navigation and list of unis are centered on the page -->
	<center>
	
		<!-- Header includes title -->
		<header>
			<h1>Website Title</h1>
		</header>

		<!-- Navigation links to different areas of the site -->
		<nav>
			<ul>
				<li><a href="">Home</a></li>
				<li><a href="university.jsp">Universities</a></li>
				<li><a href="course.jsp">Courses</a></li>
				<li><form action="/results.jsp">
					<input type="text" placeholder="Search" name="searchQuery">
					<input type="submit" value="Search">
				</form></li>
			</ul>
		</nav>

		<!-- Main body, large area with uni rankings -->
		<main>

			<!-- TODO: Use SQL to get a list of uni rankings -->

		</main>

		<!-- Footer containing references and about information -- >
		<footer>
			<p>References go here</p>
		</footer>

	</center>
</body>
</html>
