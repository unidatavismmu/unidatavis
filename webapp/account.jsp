<%@ page import="controller.Controller,java.util.ArrayList,models.University" %>
<html>
<head>
	<!-- Head defines title and links to CSS -->
	<title>Unidata - Account</title>
	<link href="css/styles.css" rel="stylesheet" type="text/css" />
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />

</head>

	<% if (Controller.loggedIn == false) {
		response.sendRedirect("http://localhost:8080/");
	%>
		<div class="alert alert-danger" role="alert">
			Please log in first!
		</div>
	<%

	}
	%>
		
	
	<!-- Includes other files (code containing the header and navbar which are the same on each page) -->
	<%@include  file="includes/header.jsp" %>
	<%@include  file="includes/navbar.jsp" %>

	<!-- Main body, area with account details form -->
	<div id="main">

		<!-- TODO: Use SQL to update account details -->
			
		<center><h1 id="black">My Account</h1></center>
		<br><hr><br>
		<center><h2>Saved Universities</h2></center>

		<br><hr><br>

		<center><h2>Update Account</h2></center>
		<form id="updateAccountForm" method="POST" action="/updateAccount">
			First Name<input type="text" placeholder="Enter first name" name="firstNameUpdate">
			Last Name<input type="text" placeholder="Enter last name" name="secondNameUpdate">
			Email<input type="text" placeholder="Enter email address" name="emailUpdate">
			<p>To save these settings, please enter your password</p>
			Password<input type="password" placeholder="Enter password" name="password">
			<input type="submit" value="Save">
		</form>

		<hr>
		<center><h2>Change Password</h2></center>
		<form id="updatePasswordForm" method="POST" action="/updatePassword">
			New Password<input type="password" placeholder="Enter new password" name="newPassword">
			Confirm New Password<input type="password" placeholder="Confirm Password" name="confirmNewPassword">
			<br>
			Current Password<input type="password" placeholder="Enter current password" name="currentPassword">
			<input type="submit" value="Save">
		</form>

		<br><hr><br>


			

	</div>

	<!-- Aside with account details -->
	<article>
		<h1>Username</h1>
		<a href="accountInfo">Account Info</a>
		<a href="savedUnis">Saved Unis</a>
	</article>

	<!-- Footer containing references and about information -- >
	<footer>
		<p>References go here</p>
	</footer>

</body>
</html>