<html>
<head>
	<!-- Head defines title and links to CSS -->
	<title>Title</title>
	<link href="../css/bootstrap.css" rel="stylesheet" type="text/css" />
	<link href="../css/styles.css" rel="stylesheet" type="text/css" />
</head>

<body>
		
	<!-- Website title, navigation and search bar are centered on the page -->
	
	<!-- Header includes title -->
	<header>
		<h1>Title</h1>
		<p><a href="createaccount.jsp">Create an account</a></p>
		<div id="loginForm">
			<form action="/processLogin.jsp">
				Username<input type="text" placeholder="" name="username">
				Password<input type="text" placeholder="" name="password">
				<input type="submit" value="Login">
			</form>
		</div>
	</header>

	<!-- Navigation links to different areas of the site -->
	<nav>
		<ul>
			<li><a href="index.jsp">Home</a></li>
			<li><a href="universities.jsp">Universities</a></li>
			<li><a href="subjects.jsp">Subjects</a></li>
			<li><form action="/results.jsp">
				<input type="text" placeholder="Type here..." name="searchQuery">
				<input type="submit" value="Search">
			</form></li>
		</ul>
	</nav>

	<!-- Main body -->
	<main>
			<h1>Manchester</h1>
			<p>General uni stats/charts go here?</p>
			<p>Then list of courses available at uni?</p>
			

	</main>

	<!-- Footer containing references and about information -- >
	<footer>
		<p>References go here</p>
	</footer>

</body>
</html>