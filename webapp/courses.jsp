<%@ page import="controller.Controller,java.util.ArrayList,models.University" %>
<html>
<head>
	<!-- Head defines title and links to CSS -->
	<title>Unidata - Course List</title>
	<link href="css/styles.css" rel="stylesheet" type="text/css" />
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />

</head>
		
	
<!-- Header includes title and links to login / logout -->
	<header>

		<a href="index.jsp" style="text-decoration:none"><center><h1>Unidata</h1></center></a>
		
		<div id="id02" class="modal2">
  			<span onclick="document.getElementById('id02').style.display='none'" class="close2" title="Close Modal2">&times;</span>
  	
  			<form class="modal-content2" action="register">

    			<div class="container">

			      <h1>Register</h1>
			      <p>Please fill in this form to create an account.</p>

			      <hr>
		  
				  <label for="username"><b>Username</b></label>
			      <input type="text" placeholder="Enter Name" name="username" required>
				  
			      <label for="email"><b>Email</b></label>
			      <input type="text" placeholder="Enter Email" name="email" required>

			      <label for="password"><b>Password</b></label>
			      <input type="password" placeholder="Enter Password" name="password" required>

      			  <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>

      				<div class="clearfix">
        				<button type="button" onclick="document.getElementById('id02').style.display='none'" class="cancelbtn2">Cancel</button>
       					<button type="submit" class="registerButton">Register</button>
      				</div>
    			</div>
  			</form>
		</div>
			
		<div id="id01" class="modal">
  			<form  method="post" class="modal-content animate" action="login">
				<div class="imgcontainer">
					<span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
				</div>
		
				<div class="container">
				    <label for="username"><b>Username</b></label>
				    <input type="text" placeholder="Enter Username" name="username" required>

				    <label for="password"><b>Password</b></label>
				    <input type="password" placeholder="Enter Password" name="password" required>
				        
				    <button type="submit">Login</button>
    			</div>

    			<div class="container" style="background-color:#f1f1f1">
      				<button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
      				<span class="password">Forgot <a href="#">password?</a></span>
    			</div>

			</form>

		</div>

	<script>
	// Get the modal
	var modal = document.getElementById('id02');

	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
	  if (event.target == modal) {
	    modal.style.display = "none";
	  }
	}
	</script>


	</header>

	<!-- Navigation links to different areas of the site -->
	<nav>

		<ul style="padding-top:10px; padding-bottom:10px">

			<li><a href="index.jsp">Home</a></li>
			<li><a href="universities.jsp">Universities</a></li>
			<li><a href="courses.jsp">Courses</a></li>
			<% if (Controller.loggedIn == false) { %>
				<li><a href="#" onclick="document.getElementById('id02').style.display='block'" style="width:auto;">Register</a></li>
				<li><a href="#" onclick="document.getElementById('id01').style.display='block'" style="width:auto;">Login</a></li>
			<% } else { %>
				<li><a href="account.jsp">Account</a></li>
				<li><a href="logout">Logout</a></li>
			<% } %>

		</ul>

	</nav>

	<!-- Main body, area with list of unis -->
	<main>
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

	</main>

	<!-- Footer containing references and about information -- >
	<footer>
		<p>References go here</p>
	</footer>

</body>
</html>