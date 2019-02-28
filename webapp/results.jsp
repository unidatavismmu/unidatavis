<%@ page import="java.util.ArrayList,models.University" %>
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

	<!-- Main body, area with list of unis -->
	<main>

		<%
			String searchQuery = request.getParameter("searchQuery");
    	%>
			<!-- TODO: get list of unis based on search results -->
		<h2>Search Results:

			<%
				out.println(searchQuery);
			%></h2>
			
			<%
				ArrayList<University> uniList = new ArrayList<University>();
				uniList = models.DAO.searchUniversities(searchQuery);
				String uniName;
			%>
			<%
				for (University u : uniList) {
				uniName = u.getUniversity_name();
			%>
			<br>
			<a href="universities/<%out.println(uniName.toLowerCase());%>.jsp">
			<%
				out.println(uniName);
			}
			%>
			</a>
				

	</main>

	<!-- Footer containing references and about information -- >
	<footer>
		<p>References go here</p>
	</footer>

</body>
</html>