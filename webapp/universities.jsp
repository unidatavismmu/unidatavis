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

	<!-- Main body, area with list of unis -->
	<main>
		<h1>Universities:</h1>
		
		<%
			ArrayList<University> uniList = new ArrayList<University>();
			uniList = models.DAO.getAllUniversities();
			String uniName;
			int uniID;
		%>
		<%
			for (University u : uniList) {
				uniName = u.getUniversity_name();
				uniID = u.getUniversity_id();
				System.out.println(uniID);

		%>
				<form action="university.jsp" method="POST">
				<input type="hidden" name="uniID" value="<%out.println(uniID);%>"/>
				<input type="hidden" name="uniName" value="<%out.println(uniName);%>"/>
			  	<button type="submit"><%out.println(uniName);%></button>
			  	</form>
		<%

			}
		%>

	</main>

	<!-- Footer containing references and about information -- >
	<footer>
		<p>References go here</p>
	</footer>

</body>
</html>