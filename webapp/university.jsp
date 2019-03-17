<%@ page import="models.DAO,controller.Controller,java.util.ArrayList,models.University"%>
<html>
<head>
	<!-- Get the name of the uni -->
	<%
		String uniName = request.getParameter("uniName");
	%>

	<!-- Head defines title and links to CSS -->
	<title><% out.println(uniName); %> - Unidata</title>
	<link href="css/styles.css" rel="stylesheet" type="text/css" />
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />

</head>

<body>
		
	<!-- Includes other files (code containing the header and navbar which are the same on each page) -->
	<%@include  file="includes/header.jsp" %>
	<%@include  file="includes/navbar.jsp" %>

	<%
		DAO dao = new DAO();
		String uniID = request.getParameter("uniID");
		String newString = uniID.replaceAll("\\s+","");
		int uid = Integer.parseInt(newString);
		ArrayList<String> courseNames = new ArrayList<String>();
		courseNames = models.DAO.getAllCoursesOfferedByUni(uid);
		String courseName;

		String uniString = uniName.replaceAll("\\s+$", "");

		String description = dao.getDescription(uniString);

	%>

	<!-- Main body -->
	<div id="main">
		<center><h1 id="heading"><%out.println(uniName);%></h1></center>

		<br><hr><br>
		
		<p><% out.println(description);%></p>

		<% if (Controller.loggedIn == true) { %>
		    <form method="post" action="/saveUni">
		    	<input type="hidden" name="uniName" value="<%out.println(uniName);%>"/>
		      	<button class="btn btn-primary" type="submit">Save</button>
		    </form>
	    <% } %>

		<br><hr><br>

		<center><h4>Courses offered:</h4></center>
			<%

				for (int i=0;i<courseNames.size();i++) {
					courseName = courseNames.get(i);
			%>
					<form action="course-at-uni.jsp" method="POST">
						<input type="hidden" name="uniName" value="<%out.println(uniName);%>"/>
						<input type="hidden" name="courseName" value="<%out.println(courseName);%>"/>
					  	<button class="btn btn-primary" type="submit"><% out.println(courseName); %></button>
				  	</form>
			<%
				}
			%>

			<br>
		
	</div>

</body>
</html>