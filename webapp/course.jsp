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
			String courseName = request.getParameter("courseName");
		%>
		<h1><%out.println(courseName);%></h1>

		<br>

		<h2>List of universities that offer this course:</h2>
			<%
				ArrayList<University> uniList = new ArrayList<University>();
				uniList = models.DAO.getAllUnisThatOfferCourse(courseName);
				University uni;
				String uniName;

				for (int i=0;i<uniList.size();i++) {
					uni = uniList.get(i);
					uniName = uni.getUniversity_name();
			%>
					<form action="course-at-uni.jsp" method="POST">
						<input type="hidden" name="uniName" value="<%out.println(uniName);%>"/>
						<input type="hidden" name="courseName" value="<%out.println(courseName);%>"/>
					  	<button type="submit"><% out.println(uniName); %></button>
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