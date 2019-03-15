<%@ page import="controller.Controller,java.util.ArrayList,models.University,java.io.InputStreamReader,java.io.BufferedReader" %>
<html>
<head>

	<%
		String courseName = request.getParameter("courseName");
	%>
	<!-- Head defines title and links to CSS -->
	<title><% out.println(courseName); %> - Unidata</title>
	<link href="css/styles.css" rel="stylesheet" type="text/css" />
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />

</head>

<body>
	
	<!-- Includes other files (code containing the header and navbar which are the same on each page) -->
	<%@include  file="includes/header.jsp" %>
	<%@include  file="includes/navbar.jsp" %>


	<!-- Main body -->
	<div id="main">
		<center><h1 id="heading"><%out.println(courseName);%></h1></center>

		<br><hr><br>

		<center><h4>Universities that offer this course:</h4></center>
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
					  	<button class="btn btn-primary" type="submit"><% out.println(uniName); %></button>
				  	</form>
			<%
				}
			%>
			

	</div>

	<!-- Footer containing references and about information -- >
	<footer>
		<p>References go here</p>
	</footer>

</body>
</html>