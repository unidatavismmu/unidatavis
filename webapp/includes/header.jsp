<!-- Header file includes the code for the header (this is the same on every page) -->

<!-- Header includes title and links to login / logout -->
<header>

		<!-- Page header with site name and link to home page. -->
		<a href="index.jsp" style="text-decoration:none"><center><h1>Unidata</h1></center></a>
		
		<!-- Div containing the modal for the registration form. -->
		<div id="id02" class="modal2">
  			<span onclick="document.getElementById('id02').style.display='none'" class="close2" title="Close Modal2">&times;</span>

  			<!-- Registration form -->
  			<form method="post" class="modal-content2" action="register">
    			<div class="container">

			      <center><h3>Unidata</h3></center>
			      <p>Please fill in this form to create an account.</p>

			      <hr>
		  
		  		  <!-- Inputs for the form -->
				  <label for="username"><b>Username</b></label>
			      <input type="text" placeholder="Enter Name" name="username" required>
				  
			      <label for="email"><b>Email</b></label>
			      <input type="text" placeholder="Enter Email" name="emailAddress" required>

			      <label for="firstName"><b>First Name</b></label>
			      <input type="text" placeholder="Enter First Name" name="firstName" required>

			      <label for="lastName"><b>Last Name</b></label>
			      <input type="text" placeholder="Enter Last Name" name="lastName" required>

			      <label for="password"><b>Password</b></label>
			      <input type="password" placeholder="Enter Password" name="password" required>

      			  <p>By creating an account you agree to our <a href="about.jsp" style="color:dodgerblue">Terms & Privacy</a>.</p>

      				<div class="clearfix">
        				<button type="button" onclick="document.getElementById('id02').style.display='none'">Cancel</button>
       					<button type="submit" class="registerButton">Register</button>
      				</div>
    			</div>
  			</form>
		</div>
			
		<div id="id01" class="modal">
			<span onclick="document.getElementById('id01').style.display='none'" class="close2" title="Close Modal2">&times;</span>

  			<form  method="post" class="modal-content2" action="login">
				<div class="container">
			        <center><h3>Unidata</h3></center>
			      	<p>Please fill in this form to log in.</p>

				    <label for="username"><b>Username</b></label>
				    <input type="text" placeholder="Enter Username" name="username" required>

				    <label for="password"><b>Password</b></label>
				    <input type="password" placeholder="Enter Password" name="password" required>
				    
				<div class="clearfix">    
				    <button type="submit">Login</button>
				    <button type="button" onclick="document.getElementById('id01').style.display='none'">Cancel</button>
    			</div>

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

	var modal1 = document.getElementById('id01');

	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
	  if (event.target == modal1) {
	    modal1.style.display = "none";
	  }
	}
	</script>


</header>