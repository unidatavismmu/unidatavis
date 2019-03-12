<%@ page import="java.util.ArrayList,models.University,java.util.Map,java.util.HashMap,java.util.List" %>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>
 
<%
Gson gsonObj = new Gson();
Map<Object,Object> map = null;
List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
 
map = new HashMap<Object,Object>(); map.put("x", 10); map.put("y", 31); list.add(map);
map = new HashMap<Object,Object>(); map.put("x", 20); map.put("y", 65); list.add(map);
map = new HashMap<Object,Object>(); map.put("x", 30); map.put("y", 40); list.add(map);
map = new HashMap<Object,Object>(); map.put("x", 40); map.put("y", 84); list.add(map);
map = new HashMap<Object,Object>(); map.put("x", 50); map.put("y", 68); list.add(map);

 
String dataPoints = gsonObj.toJson(list);
%>
<html>
<head>
	<!-- Head defines title and links to CSS -->
	<title>Title</title>
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
	<link href="css/styles.css" rel="stylesheet" type="text/css" />



<script type="text/javascript">
	window.onload = function() { 
	 
	var chart = new CanvasJS.Chart("chartContainer", {
		animationEnabled: true,
		exportEnabled: true,
		title: {
			text: "Simple Column Chart with Index Labels"
		},
		data: [{
			type: "column",
			indexLabelFontColor: "#5A5757",
			indexLabelPlacement: "outside",
			dataPoints: <%out.print(dataPoints);%>
		}]
	});
	chart.render();
	 
	}
</script>
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
			String uniName = request.getParameter("uniName");
			String courseName = request.getParameter("courseName");

		%>
		<h1><%out.println(courseName + " at " + uniName);%></h1>

		<br>

		<h2>Statistics:</h2>

		<div id="chartContainer" style="height: 370px; width: 100%;"></div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
	</main>

	<!-- Footer containing references and about information -- >
	<footer>
		<p>References go here</p>
	</footer>

</body>
</html>