<%@ page import="controller.Controller" %>
<html>
<head>
	<!-- Head defines title and links to CSS -->
	<title>Home - Unidata</title>
	<link href="css/styles.css" rel="stylesheet" type="text/css" />
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
	<link rel="shortcut icon" type="image/png" href="/favicon.png"/>

</head>

<body>
		
	<!-- Includes other files (code containing the header and navbar which are the same on each page) -->
	<%@include  file="includes/header.jsp" %>
	<%@include  file="includes/navbar.jsp" %>

	<!-- Main body, large area with search bar -->
	<main>
			
		<div class="searchForm" >
		
				<form action="/results.jsp">

					<input type="text" placeholder="Type here..." name="searchQuery">
					<input class="btn btn-primary" type="submit" value="Search">

				</form>
		
		</div>
			
	</main>

</body>
</html>