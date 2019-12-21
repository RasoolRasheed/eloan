<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Loan Hub</title>
<link rel="icon" type="image/png" href="resources/openarc.jpg">
<link type="text/css" rel="stylesheet" href="resources/index.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css" />
</head>
<body>
<p>
	<font color="green">${success}</font>
</p>
	<div class="container">
		<div class="card card-container">
			<img id="profile-img" class="profile-img-card"
				src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
			<p id="profile-name" class="profile-name-card"></p>
			<form action="loginProcess.do" method="POST" class="form-signin">
				<span id="reauth-email" class="reauth-email"></span>
				<input type="text" id="username" name="username" class="form-control"placeholder="Email address" required autofocus>
				<input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
				<p>
					<font color="red">${error}</font>
				</p>
				<div id="remember" class="checkbox">
					<label> <input type="checkbox" value="remember-me">
						Remember me
					</label>
				</div>
				<button class="btn btn-lg btn-primary btn-block btn-signin"
					type="submit">Sign in</button>
			</form>
			<!-- /form  -->
			<a href="goToRegister.do" class="forgot-password"> Signup here</a>
		</div>
	</div>
</body>
</html>