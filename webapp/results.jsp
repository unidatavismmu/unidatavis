<%@ page import="controller.Controller,java.util.ArrayList,models.University" %>
<html>
<head>

	<!-- Head defines title and links to CSS -->
	<title>Results - Unidata</title>
	<link href="css/styles.css" rel="stylesheet" type="text/css" />
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />

</head>

<body>
		
	<!-- Includes other files (code containing the header and navbar which are the same on each page) -->
	<%@include  file="includes/header.jsp" %>
	<%@include  file="includes/navbar.jsp" %>

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