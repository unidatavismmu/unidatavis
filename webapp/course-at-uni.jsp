<%@ page import="controller.Controller,java.util.ArrayList,models.University,java.util.Map,java.util.HashMap,java.util.List,com.google.gson.Gson,com.google.gson.JsonObject,models.DAO" %>

<%
	String uniName = request.getParameter("uniName");
	String courseName = request.getParameter("courseName");

	DAO dao = new DAO();
	float studentSatisfaction = dao.getStudentSatisfaction(uniName.replaceAll("\\s+$", ""),courseName.replaceAll("\\s+$", ""));
	System.out.println("Student satisfaction: " + studentSatisfaction);

	float researchQuality = dao.getResearchQuality(uniName.replaceAll("\\s+$", ""),courseName.replaceAll("\\s+$", ""));
	System.out.println("Research Quality: " + researchQuality);

  float entryStandards = dao.getEntryStandards(uniName.replaceAll("\\s+$", ""),courseName.replaceAll("\\s+$", ""));
  System.out.println("Entry Standards: " + entryStandards);
  float avgEntryStandards = dao.getAverageEntryStandards(uniName.replaceAll("\\s+$", ""),courseName.replaceAll("\\s+$", ""));
  System.out.println("Avg Entry Standards: " + avgEntryStandards);

%>

<html>
<head>
	<!-- Head defines title and links to CSS -->
	<title><% out.println(courseName + " at " + uniName + " - Unidata"); %></title>
	<link href="css/styles.css" rel="stylesheet" type="text/css" />
  	<link href="css/bootstrap.css" rel="stylesheet">
  	<link href="css/mdb.css" rel="stylesheet">

</head>

<body>
		
	<!-- Includes other files (code containing the header and navbar which are the same on each page) -->
	<%@include  file="includes/header.jsp" %>
	<%@include  file="includes/navbar.jsp" %>

	<!-- Main body -->
	<div id="main">

		<br>
		<center><h2 id="black"><%out.println(courseName + " at " + uniName);%></h2></center>

    <hr>

		<br>
		<div class="wrapper">

		<div id="studentSatisfaction">
			<h4>Student Satisfaction</h4>

			<canvas id="studentSatisfactionChart" style="max-width: 500px;"></canvas>

      <br>

			<p><%out.println(studentSatisfaction + "/5 students are satisfied with " + courseName + " at " + uniName);%></p>
		</div>

		<div id="researchQuality">
			<h4 style="padding-left:75px;">Research Quality</h4>

			<canvas id="researchQualityChart" style="max-width: 500px;"></canvas>

      <br>

			<p><%out.println("Research Quality for " + courseName + " at " + uniName + " is rated " + researchQuality + "/4.");%></p>

		</div>
		</div>

    <br><hr><br>
    
      <center><div id="entryStandards">
        <center><h4>Entry Standards</h4></center>

        <canvas id="entryStandardsChart" style="max-width: 500px;"></canvas>
        
        <br>

        <%
          String higherOrLower;
          if (avgEntryStandards > entryStandards) {
            higherOrLower = "lower";
          } else {
            higherOrLower = "higher";
          }
        %>

        <p><%out.println(uniName + " has " + higherOrLower + " entry standards than the average " + courseName + " course.");%></p>
 
      </div></center>

    <br>

	</div>

  <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
  <script type="text/javascript" src="js/popper.min.js"></script>
  <script type="text/javascript" src="js/bootstrap.min.js"></script>
  <script type="text/javascript" src="js/mdb.js"></script>

  <script>
  var ctx = document.getElementById("studentSatisfactionChart").getContext('2d');
  var studentSatisfactionChart = new Chart(ctx, {
    type: 'pie',
    data: {
      datasets: [{
        label: 'Student Satisfaction',
        data: [<% out.println(studentSatisfaction); %>,<% out.println(5-studentSatisfaction); %>],
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

  var ctx = document.getElementById("researchQualityChart").getContext('2d');
  var researchQualityChart = new Chart(ctx, {
    type: 'pie',
    data: {
      datasets: [{
        label: 'Research Quality',
        data: [<% out.println(researchQuality); %>,<% out.println(4-researchQuality); %>],
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

  var ctx = document.getElementById("entryStandardsChart").getContext('2d');
  var myChart = new Chart(ctx, {
    type: 'bar',
    data: {
      labels: ["Average", "This Course"],
      datasets: [{
        label: 'UCAS Points',
        data: [<% out.println(avgEntryStandards); %>,<% out.println(entryStandards); %>],
        backgroundColor: [
          'rgba(255, 99, 132, 0.2)',
          'rgba(54, 162, 235, 0.2)'
        ],
        borderColor: [
          'rgba(255,99,132,1)',
          'rgba(54, 162, 235, 1)'
        ],
        borderWidth: 1
      }]
    }
  });

</script>


</script>

</body>
</html>