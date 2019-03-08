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
			<li><a href="courses.jsp">Courses</a></li>
			<li><form action="/results.jsp">
				<input type="text" placeholder="Type here..." name="searchQuery">
				<input type="submit" value="Search">
			</form></li>
		</ul>
	</nav>

	<!-- Main body, area with list of unis -->
	<main>
		<h1>Courses:</h1>
		
		<%
			ArrayList<String> courseList = new ArrayList<String>();
			courseList = models.DAO.getAllCourseNames();
			String courseName;
		%>
		<%
			for (int i=0;i<courseList.size();i++) {
			courseName = courseList.get(i);
		%>
		<br>
		<a href="universities/<%out.println(courseName.toLowerCase());%>.jsp">
		<%
			out.println(courseName);
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