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

		<%
			String searchQuery = request.getParameter("searchQuery");
    	%>
			<!-- TODO: get list of unis based on search results -->
		<h2>Search Results:

			<%
				out.println(searchQuery);
			%></h2>
			
			<h3>Universities</h3>
			<%
				ArrayList<University> uniList = new ArrayList<University>();
				uniList = models.DAO.searchUniversities(searchQuery);
				String uniName;
				int uniID;
			%>
			<%
				for (University u : uniList) {
				uniName = u.getUniversity_name();
				uniID = u.getUniversity_id();
			%>
				<form action="university.jsp" method="POST">
					<input type="hidden" name="uniID" value="<%out.println(uniID);%>"/>
					<input type="hidden" name="uniName" value="<%out.println(uniName);%>"/>
				  	<button type="submit">
				  		<%
						if (uniList.size() == 0) {
							out.println("No universities found.");
						} else {
							out.println(uniName);
						}
						%>
					</button>
			  	</form>

			<%
				}
			%>
			</a>

			<h3>Courses</h3>
			<%
				ArrayList<String> courseList = new ArrayList<String>();
				courseList = models.DAO.searchCourses(searchQuery);
				String courseName;
			%>
			<%
				for (int i=0;i<courseList.size();i++) {
				courseName = courseList.get(i);
			%>
				<form action="course.jsp" method="POST">
					<input type="hidden" name="courseName" value="<%out.println(courseName);%>"/>
				  	<button type="submit">
				  		<%
						if (courseList.size() == 0) {
							out.println("No courses found.");
						} else {
							out.println(courseName);
						}
						%>
					</button>
			  	</form>
			<%
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