<%@ page import="java.util.ArrayList,models.University,java.io.InputStreamReader,java.io.BufferedReader" %>
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


	<!-- Main body -->
	<main>
		<%
			String uniName = request.getParameter("uniName");
		%>
		<h1>List of courses offered: <%out.println(uniName);%></h1>
			<%

			String uniID = request.getParameter("uniID");
			String newString = uniID.replaceAll("\\s+","");
			int uid = Integer.parseInt(newString);

			ArrayList<String> courseNames = new ArrayList<String>();
			courseNames = models.DAO.getAllCoursesOfferedByUni(uid);
			String courseName;

			for (int i=0;i<courseNames.size();i++) {
				courseName = courseNames.get(i);
			%>
			<br>
			<%
				out.println(courseName);
			}
			%>
			

	</main>

	<!-- Footer containing references and about information -- >
	<footer>
		<p>References go here</p>
	</footer>

</body>
</html>