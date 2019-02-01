<html>
<head>
	<!-- Head defines title and links to CSS -->
	<title>Website Title</title>
	<!-- TODO: Link to CSS -->
</head>

<body>
		
	<!-- Website title, navigation and list of unis are centered on the page -->
	<center>
	
		<!-- Header includes title -->
		<header>
			<h1>Website Title</h1>
		</header>

		<!-- Navigation links to different areas of the site -->
		<nav>
			<ul>
				<li><a href="index.jsp">Home</a></li>
				<li><a href="universities.jsp">Universities</a></li>
				<li><a href="courses.jsp">Courses</a></li>
				<li><form action="/results.jsp">
					<input type="text" placeholder="Search" name="searchQuery">
					<input type="submit" value="Search">
				</form></li>
				<!-- TODO: Popup using bootstrap for login -->
				<li><a href="">Login</a></li>
			</ul>
		</nav>

		<!-- Main body, uni list -->
		<main>

			<!-- TODO: Use SQL to get a list of unis -->

		</main>

		<!-- Footer containing references and about information -- >
		<footer>
			<p>References go here</p>
		</footer>

	</center>
</body>
</html>
