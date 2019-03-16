<%@ page import="controller.Controller,java.util.ArrayList,models.University" %>
<html>
<head>

	<!-- Head defines title and links to CSS -->
	<title>Course List - Unidata</title>
	<link href="css/styles.css" rel="stylesheet" type="text/css" />
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />

</head>
		
	<!-- Includes other files (code containing the header and navbar which are the same on each page) -->
	<%@include  file="includes/header.jsp" %>
	<%@include  file="includes/navbar.jsp" %>

	<!-- Main body, area with list of unis -->
	<div id="main">
		<center><h1 id="heading">Courses</h1></center>

		<br><hr><br>
		
		<%
			ArrayList<String> courseList = new ArrayList<String>();
			courseList = models.DAO.getAllCourseNames();
			String courseName;
	
			for (int i=0;i<courseList.size();i++) {
			courseName = courseList.get(i);
		%>
				<form action="course.jsp" method="POST">
					<input type="hidden" name="courseName" value="<%out.println(courseName);%>"/>
				  	<button class="btn btn-primary" type="submit"><%out.println(courseName);%></button>
			  	</form>
		<%
			}
		%>

		<br>

	</div>

</body>
</html>