<%@ page import="models.DAO,controller.Controller,java.util.ArrayList,models.University"%>
<html>
<head>
	<!-- Get the name of the uni -->
	<%
		String uniName = request.getParameter("uniName");
		DAO dao = new DAO();

		String uniID = request.getParameter("uniID");
		String newString = uniID.replaceAll("\\s+","");
		int uid = Integer.parseInt(newString);

		float degreeCompletion = dao.getDegreeCompletion(uniName.replaceAll("\\s+$", ""));
		System.out.println("Degree Completion: " + degreeCompletion);

		float goodHonours = dao.getGoodHonours(uniName.replaceAll("\\s+$", ""));
		System.out.println("Good Honours: " + goodHonours);
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


		    <center><div id="degreeCompletion">
				<h4>Degree Completion</h4>

				<canvas id="degreeCompletionChart" style="max-width: 500px;"></canvas>

	      		<br>

				<p><%out.println(degreeCompletion + "% of students complete degrees at " + uniName);%></p>
			</div></center>

			<center><div id="goodHonours">
				<h4>Good Honours</h4>

				<canvas id="goodHonoursChart" style="max-width: 500px;"></canvas>

	      		<br>

				<p><%out.println(goodHonours + "% of students graduate with a 2:1 degree or above at " + uniName);%></p>
			</div></center>



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

  <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
  <script type="text/javascript" src="js/popper.min.js"></script>
  <script type="text/javascript" src="js/bootstrap.min.js"></script>
  <script type="text/javascript" src="js/mdb.js"></script>

  <script>
  var ctx = document.getElementById("degreeCompletionChart").getContext('2d');
  var degreeCompletionChart = new Chart(ctx, {
    type: 'pie',
    data: {
      datasets: [{
        label: 'Degree Completion',
        data: [<% out.println(degreeCompletion); %>,<% out.println(100-degreeCompletion); %>],
        backgroundColor: [
          'rgba(119, 255, 51, 0.2)',
          'rgba(255, 99, 132, 0.2)'
        ],
        borderColor: [
          'rgba(119, 255, 51, 1)',
          'rgba(255,99,132,1)'
        ],
        borderWidth: 1
      }]
    }
  });

  var ctx = document.getElementById("goodHonoursChart").getContext('2d');
  var goodHonoursChart = new Chart(ctx, {
    type: 'pie',
    data: {
      datasets: [{
        label: 'Good Honours',
        data: [<% out.println(goodHonours); %>,<% out.println(100-goodHonours); %>],
        backgroundColor: [
          'rgba(119, 255, 51, 0.2)',
          'rgba(255, 99, 132, 0.2)'
        ],
        borderColor: [
          'rgba(119, 255, 51, 1)',
          'rgba(255,99,132,1)'
        ],
        borderWidth: 1
      }]
    }
  });
  </script>

</body>
</html>