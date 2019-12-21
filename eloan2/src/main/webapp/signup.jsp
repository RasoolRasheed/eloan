<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Register</title>
<script>

	$(document).ready(function() {
		
	});

	function createUser() {
		
		var firstname = $('#fname').val();
		var lastname = $('#lname').val();
		var nic = $('#nic').val();
		var contactno = $('#contactno').val();
		var username = $('#username').val();
		var password = $('#password').val();
		//var hashpass = $.MD5($('#password').val());

		var gender = $("input[name='gender']:checked").val();
		//alert(encrypt(password));

		var data = {
			firstname : firstname,
			lastname : lastname,
			nic : nic,
			gender:gender,
			contactno : contactno,
			username : username,
			password : password
		};
		$.ajax({
			type : 'POST',
			url : 'createUser.do',
			data : data,
			success : function(data) {
				var ParsedJSON = JSON.parse(data);
				//alert(ParsedJSON.contactError);
				//alert(ParsedJSON.success);

				if (ParsedJSON.contactError || ParsedJSON.error2) {
					$('#contactError').html(
							"<p class='successmsg' style='color:red'>"
									+ ParsedJSON.contactError + "</p>");
					$('.error2').html(
							"<p class='successmsg' style='color:red'>"
									+ ParsedJSON.error2 + "</p>");
				} else {
					alert(ParsedJSON.success);
					location.reload();
				} 
			}
		});
	}

	function getUser() {
		//alert("getstd");
		$.ajax({
			type : 'get',
			url : 'viewUser.do',
			success : function(msg) {
				//alert("tble k");
				var ParsedJSON = JSON.parse(msg);

			}

		});
	}

	function updateRecord() {
		var username1 = $('#username').val();
		var password1 = $('#password').val();
		var id1 = $('#id').val();

		$.ajax({
			type : 'get',
			url : 'updateUser.do',
			data : {
				id : id1,
				username : username1,
				password : password1
			},
			success : function(msg) {
				alert(msg);
			}
		});
	}
	function deleteRecord() {
		//alert("del");
		var data = {
			id : $('#id').val()
		}
		$('#id').val() = $
		{
			user.id
		}
		;
		console.log($('#id').val());
		/*  $.ajax({
		     type:'get',
		     url:'remove/${user.id}.do',
		     data :data,                
		     success:function(msg){
		         alert("delete");
		         var ParsedJSON = JSON.parse(msg);

		     }
		 }); */

	}
</script>
</head>

<body>

<div class="container">

<div id="success"></div>
	<br>
<!-- 	<img alt="loanhubLogo"  width="auto" height="50px" src="resources/logo.png"> -->
	<p class="text-center">${serverTime}		
	</p>
	<hr>
	<div class="row justify-content-center">
		<div class="col-md-6">
			<div class="card">
				<header class="card-header"> <a href=""
					class="float-right btn btn-outline-primary mt-1">Log in</a>
				<h4 class="card-title mt-2">Sign up</h4>
				</header>
				<article class="card-body">
				<form>
					<div class="form-row">
						<div class="col form-group">
							<label>First name<font color="red">*</font></label> <input type="text" id="fname"
								name="fname" class="form-control" placeholder="">
								<div class="error2"></div>
						</div>
						<!-- form-group end.// -->
						<div class="col form-group">
							<label>Last name<font color="red">*</font></label> <input type="text" name="lname" id="lname" class="form-control"
								placeholder=" ">
								<div class="error2"></div>
						</div>
						<!-- form-group end.// -->
					</div>
					<!-- form-row end.// -->
					<div class="form-group">
						<label>Email address<font color="red">*</font></label> <input type="email"
							class="form-control" placeholder="" name="username" name="username" id="username"> <small
							class="form-text text-muted">We'll never share your email
							with anyone else.</small>
					</div>
					<div class="error2"></div>
					<!-- form-group end.// -->
					<div class="form-group">
						<label class="form-check form-check-inline"> <input
							class="form-check-input" type="radio"  name="gender" id="gender"
							value="male" checked="checked"> <span class="form-check-label">
								Male </span>
						</label> <label class="form-check form-check-inline"> <input
							class="form-check-input" type="radio" id="gender"name="gender"
							value="female"> <span class="form-check-label">
								Female</span>
						</label>
					</div>
					<!-- form-group end.// -->
					<div class="form-row">
						<div class="form-group col-md-6">
							<label>Contact No<font color="red">*</font></label> <input type="text" class="form-control" name="contactno" id="contactno">
							<div id="contactError"></div>
						</div>
						<div class="form-group col-md-6">
							<label>NIC <font color="red">*</font></label> <input type="text" class="form-control" name="nic" id="nic">
							<div class="error2"></div>
						</div>
						
					</div>
					<!-- form-row.// -->
					<div class="form-group">
						<label>Create password<font color="red">*</font></label> <input class="form-control" name="password" id="password"
							type="password">
						<div class="error2"></div>
					</div>
					
					<!-- form-group end.// -->
					<div class="form-group">
						<button type="button" onclick="createUser();" class="btn btn-primary btn-block">
							Register</button>
					</div>
					<!-- form-group// -->
					<small class="text-muted">By clicking the 'Sign Up' button,
						you confirm that you accept our <br> Terms of use and Privacy
						Policy.
					</small>
				</form>
				</article>
				<!-- card-body end .// -->
				<div class="border-top card-body text-center">
					Have an account? <a href="logout.do">Log In</a>
				</div>
			</div>
			<!-- card.// -->
		</div>
		<!-- col.//-->

	</div>
	<!-- row.//-->


</div>
<!--container end.//-->
</body>
</html>