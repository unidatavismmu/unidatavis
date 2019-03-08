<html>
<head>
	<!-- Head defines title and links to CSS -->
	<title>Title</title>
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
	<link href="css/styles.css" rel="stylesheet" type="text/css" />
</head>

<body>
		
	<!-- Website title, navigation and search bar are centered on the page -->
	
	<!-- Header includes title -->
		<header>
		<h1>Title</h1>
		<p><a href="register.jsp">Register</a></p>
		<p><a href="login.jsp">Login</a></p>
	</header>

	<!-- Navigation links to different areas of the site -->
	<nav>
		<ul>
			<li><a href="index.jsp">Home</a></li>
			<li><a href="universities.jsp">Universities</a></li>
			<li><a href="courses.jsp">Courses</a></li>
			<li><form action="/results.jsp">
				<input type="text" placeholder="Type here..." name="searchQuery">
				<input type="submit" value="Search">
			</form></li>
		</ul>
	</nav>

	<!-- Main body, area with account details form -->
	<main>

		<!-- TODO: Use SQL to update account details -->
			
		<h1>Account Info</h1>
		<form action="/updateAccount.jsp">
			First Name<input type="text" placeholder="" name="firstName">
			Last Name<input type="text" placeholder="" name="lastName">
			Email<input type="text" placeholder="" name="email">
			Telephone<input type="text" placeholder="" name="telephone">
			Company Name<input type="text" placeholder="" name="companyName">
			<hr>
			<p>To save these settings, please enter your password</p>
			Password<input type="text" placeholder="" name="password">
			<input type="submit" value="Save Settings">
		</form>
			

	</main>

	<!-- Aside with account details -->
	<article>
		<h1>Username</h1>
		<a href="accountInfo">Account Info</a>
		<a href="savedUnis">Saved Unis</a>
	</article>

	<!-- Footer containing references and about information -- >
	<footer>
		<p>References go here</p>
	</footer>

</body>
</html>