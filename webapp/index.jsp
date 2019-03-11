<html>
<head>
	<!-- Head defines title and links to CSS -->
	<title>Title</title>
	<link href="css/styles.css" rel="stylesheet" type="text/css" />
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />

</head>

<body>
		
	<!-- Header includes title and links to login / logout -->
	<header>
		<h1>Unidata</h1>
		
		<button onclick="document.getElementById('id02').style.display='block'"
		style ="width:auto;">Register</button>

		<div id="id02" class="modal2">
  			<span onclick="document.getElementById('id02').style.display='none'" class="close2" title="Close Modal2">&times;</span>
  			
  			<form class="modal-content2" action="register">
    		<div class="container">
		      <h1>Register</h1>
		      <p>Please fill in this form to create an account.</p>
		      <hr>
	  
			  <label for="name"><b>Username</b></label>
		      <input type="text" placeholder="Enter Name" name="username" required>
			  
		      <label for="email"><b>Email</b></label>
		      <input type="text" placeholder="Enter Email" name="email" required>

		      <label for="psw"><b>Password</b></label>
		      <input type="password" placeholder="Enter Password" name="password" required>

      <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>

      <div class="clearfix">
        <button type="button" onclick="document.getElementById('id02').style.display='none'" class="cancelbtn2">Cancel</button>
        <button type="submit" class="signupbtn">Register</button>
      </div>
    </div>
  </form>
</div>
			<button onclick="document.getElementById('id01').style.display='block'"
			style ="width:auto;">Login</button>
			
		<div id="id01" class="modal">
  
			<form class="modal-content animate" action="/action_page.php">
			<div class="imgcontainer">
			<span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
	  
		</div> <!--classimagecontainer-->
		
		 
	  <div class="container">
      <label for="uname"><b>Username</b></label>
      <input type="text" placeholder="Enter Username" name="uname" required>

      <label for="psw"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="psw" required>
        
      <button type="submit">Login</button>
      <label>
        <input type="checkbox" checked="checked" name="remember"> Remember me
      </label>
    </div>

    <div class="container" style="background-color:#f1f1f1">
      <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
      <span class="psw">Forgot <a href="#">password?</a></span>
    </div>

	</form><!-- processLogin form-->

	</div><!--login form div-->


	</header>

	<!-- Navigation links to different areas of the site -->
	<nav>

		<ul>

			<li><a href="index.jsp">Home</a></li>

			<li><a href="universities.jsp">Universities</a></li>

			<li><a href="courses.jsp">Subjects</a></li>

		</ul>

	</nav>

	<!-- Main body, large area with search bar -->
	<main>
			
		<div class="searchForm" >
	
		<li><form action="/results.jsp">

			<input type="text" placeholder="Type here..." name="searchQuery">

			<input type="submit" value="Search">

		</form></li>
		
	</div>
			

	</main>

	<!-- Footer containing references and about information -- >
	<footer>
		<p>References go here</p>
	</footer>

</body>
</html>