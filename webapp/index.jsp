<html>
<head>
	<!-- Head defines title and links to CSS -->
	<title>Title</title>
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
	<link href="css/styles.css" rel="stylesheet" type="text/css" />
</head>

<body>
		
	<!-- Header includes title -->
	<header>
		<h1>Title</h1>
		<% 
		//if (session.getAttribute("loggedin").equals(true) || ) {
		%>
			<p><a href="account.jsp">Account</a></p>
			<p><a href="logout">Logout</a></p>
		<%
		//} else {
		%>
			<p><a href="register.jsp">Register</a></p>
			<p><a href="login.jsp">Login</a></p>
		<%
		//}
		%>
	</header>

	<!-- Navigation links to different areas of the site -->
	<nav>
		<ul>
			<li><a href="index.jsp">Home</a></li>
			<li><a href="universities.jsp">Universities</a></li>
			<li><a href="courses.jsp">Courses</a></li>
		</ul>
	</nav>

	<!-- Main body, large area with search bar -->
	<main>

		<!-- TODO: Use SQL for a search bar -->
			
		<form action="/results.jsp">
			<input type="text" placeholder="Type here..." name="searchQuery">
			<input type="submit" value="Search">
		</form>
			

	</main>

	<!-- Footer containing references and about information -- >
	<footer>
		<p>References go here</p>
	</footer>

</body>
</html>