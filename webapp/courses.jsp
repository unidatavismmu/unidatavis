<%@ page import="controller.Controller,java.util.ArrayList,models.University" %>
<html>
<head>

	<!-- Head defines title and links to CSS -->
	<title>Unidata - Course List</title>
	<link href="css/styles.css" rel="stylesheet" type="text/css" />
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />

</head>
		
	<!-- Includes other files (code containing the header and navbar which are the same on each page) -->
	<%@include  file="includes/header.jsp" %>
	<%@include  file="includes/navbar.jsp" %>

	<!-- Main body, area with list of unis -->
	<div id="main">
		<h1>Courses:</h1>
		
		<%
			ArrayList<String> courseList = new ArrayList<String>();
			courseList = models.DAO.getAllCourseNames();
			String courseName;
	
			for (int i=0;i<courseList.size();i++) {
			courseName = courseList.get(i);
		%>
				<form action="course.jsp" method="POST">
					<input type="hidden" name="courseName" value="<%out.println(courseName);%>"/>
				  	<button type="submit"><%out.println(courseName);%></button>
			  	</form>
		<%
			}
		%>
		</a>

	</div>

	<!-- Footer containing references and about information -- >
	<footer>
		<p>References go here</p>
	</footer>

</body>
</html>