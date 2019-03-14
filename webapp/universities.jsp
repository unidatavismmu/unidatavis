<%@ page import="controller.Controller,java.util.ArrayList,models.University" %>
<html>
<head>
	<!-- Head defines title and links to CSS -->
	<title>Universities - Unidata</title>
	<link href="css/styles.css" rel="stylesheet" type="text/css" />
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />

</head>
		
	<!-- Includes other files (code containing the header and navbar which are the same on each page) -->
	<%@include  file="includes/header.jsp" %>
	<%@include  file="includes/navbar.jsp" %>

	<!-- Main body, area with list of unis -->
	<div id="main">
		<center><h1 id="heading">Universities</h1></center>

		<br><hr><br>

		<%
			ArrayList<University> uniList = new ArrayList<University>();
			uniList = models.DAO.getAllUniversities();
			String uniName;
			int uniID;

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

	</div>

</body>
</html>