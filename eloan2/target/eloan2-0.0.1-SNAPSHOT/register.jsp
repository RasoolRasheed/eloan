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
<link rel="javascript" src="resources/ajaxJquery.js">
<title>Register</title>
<style>
form {
	width: 60%;
	margin: 60px auto;
	background: #efefef;
	padding: 60px 120px 80px 120px;
	text-align: center;
	-webkit-box-shadow: 2px 2px 3px rgba(0, 0, 0, 0.1);
	box-shadow: 2px 2px 3px rgba(0, 0, 0, 0.1);
}

label {
	display: block;
	position: relative;
	margin: 40px 0px;
}

.input {
	width: 100%;
	padding: 10px;
	background: white;
	border: none;
	outline: none;
}

.label-active {
	top: -3em;
}

button {
	display: inline-block;
	padding: 12px 24px;
	background: rgb(220, 220, 220);
	font-weight: bold;
	color: rgb(120, 120, 120);
	border: none;
	outline: none;
	border-radius: 3px;
	cursor: pointer;
	transition: ease .3s;
}

button:hover {
	background: #8BC34A;
	color: #ffffff;
}


table#userTbl tbody  tr {
    cursor : pointer;
}
</style>
<%@page import="java.sql.*"%>
<%@page import=" java.security.*"%>
<%@page import="javax.crypto.*"%>
<%!
private static String algorithm = "DESede";
        private static Key key = null;
        private static Cipher cipher = null;
 private static byte[] encrypt(String password)throws Exception {
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] inputBytes = password.getBytes();
            return cipher.doFinal(inputBytes);
        }
%>
<script>

var pickedup;
var a;
$(document).ready(function() { 

	function addRowHandlers() {
	    var table = document.getElementById("userTbl");
	    var rows = table.getElementsByTagName("tr");
	    for (i = 0; i < rows.length; i++) {
	        var currentRow = table.rows[i];
	        var createClickHandler = 
	            function(row) 
	            {
	                return function() { 
                          var cell1 = row.getElementsByTagName("td")[0];
                          var cell2 = row.getElementsByTagName("td")[1];
                          var cell3 = row.getElementsByTagName("td")[2];
                          var id = cell1.innerHTML;
                          var username = cell2.innerHTML;
                          var password = cell3.innerHTML;
                          /* alert("id:" + id);
                          alert("id:" + username + password); */
                         document.getElementById("username").value=username;
                          document.getElementById("id").value=id;
                          document.getElementById("password").value=password;
                          var btn = document.getElementById("addbtn")
                          	btn.disabled = true;
                   };
	            };
	        currentRow.onclick = createClickHandler(currentRow);
	    }
	}
	window.onload = addRowHandlers();
	 getUser();
	});
	
	function createUser() {
		console.log("sa");
		var firstname = $('#fname').val();
		var lastname = $('#lname').val();
		var nic = $('#nic').val();
		var contactno = $('#contactno').val();
		var username = $('#username').val();
		var password = $('#password').val();
		var data = {
				firstname : firstname,
				lastname : lastname,
				nic : nic,
				contactno : contactno,	
				username :username,
				password :password
		};
		$.ajax({
			type : 'POST',
			url : 'createUser.do',
			data : data,
			success : function(data) {
				}

		});
	};
	function  getUser(){
	        $.ajax({
	          type:'get',
	          url: 'viewUser.do',
	          success:function(msg){
	        	  var ParsedJSON = JSON.parse(msg);
	           }
	        
	        });
	    }
    
	function updateRecord(){
        	var username1 = $('#username').val();
	        var password1 = $('#password').val();
	        var id1 = $('#id').val();
      
        $.ajax({
	          type:'get',
	          url: 'updateUser.do',
	          data:{
		    		id:id1,
		          username :username1,
		          password :password1
		          },
	          success:function(msg){
		          alert(msg);
	          }
		          });
	    }
	function deleteRecord(){
        //alert("del");
        var data = {id :$('#id').val()}
        $('#id').val()= ${user.id};
        console.log($('#id').val());

		}
</script>
</head>
<body>
	<div id="success"></div>
	<form action="" method="post">
		<table id="regTable" class="table">
			<h1 style="text-align: left">Registration</h1>
			</br>
			<tr>
				<td><input type="hidden" path="id" id="id" name="id"></td>
			</tr>
			<tr>
				<td>First Name:</td>
				<td><input type="text" name="fname" id="fname"
					class="input" required></td>
				<td><div id="error1"></div></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lname" id="lname"
					class="input"></td>
				<td><div id="error1"></div></td>
			</tr>
			<tr>
				<td>NIC no:</td>
				<td><input type="text" name="nic" id="nic"
					class="input"></td>
				<td><div id="error1"></div></td>
			</tr>
			<tr>
				<td>Contact No:</td>
				<td><input type="number" name="contactno" id="contactno"
					class="input"></td>
				<td><div id="error1"></div></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td><!-- <input type="radio" name="gender" id="gender" value="M"
					class="input">M<input type="radio" name="gender" id="gender"
					class="input" value="F">F</td>
				<td><div id="error1"></div> --></td>
			</tr>
			<tr>
				<td>User Name:</td>
				<td><input type="text" name="username" id="username"
					class="input"></td>
				<td><div id="error1"></div></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" id="password"
					class="input"></td>
				<td><div id="error2"></div></td>
			</tr>
			<tr>
				<td></td>
				
			</tr>
			
			<tr>
				<td></td>
				<td><button type="button"  id="addbtn" class="btn btn-primary" onclick="createUser()">Create</button></td>
				<td><button type="button" onclick="updateRecord()">Update</button></td>
				
			</tr>
		</table>
	</form>
<h1>User Details</h1>
	<table id="userTbl" class="table table-hover">
		<tr>
			<th>User_ID</th>
			<th>username</th>
			<th>password</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${viewUser}" var="user">
		<tbody>
			<tr>
				<td>${user.id}</td>
				<td>${user.username}</td>
				<td>${user.password}</td>
 				<td><a  class="btn btn-info btn-sm" role="button" href="<c:url value='/remove/${user.id}.do' />" ><span class="glyphicon glyphicon-trash"></span>Delete</a></td>
<!-- 				<td><button id="{user.id}" type="button" onclick="deleteRecord()">del</button></td> -->
			</tr>
		</tbody>
		</c:forEach>
	</table>

</body>
</html>