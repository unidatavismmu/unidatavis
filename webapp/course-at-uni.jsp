<%@ page import="controller.Controller,java.util.ArrayList,models.University,java.util.Map,java.util.HashMap,java.util.List" %>
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
		
	<!-- Includes other files (code containing the header and navbar which are the same on each page) -->
	<%@include  file="includes/header.jsp" %>
	<%@include  file="includes/navbar.jsp" %>


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