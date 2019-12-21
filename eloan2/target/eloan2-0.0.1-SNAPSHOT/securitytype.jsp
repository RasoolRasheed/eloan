<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Bootstrap CDN -->
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<!-- DATA TABLES -->
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">

<title>Security Types</title>
<style>
table#styType tbody  tr {
	cursor: pointer;
}
</style>
<script>
	var pickedup;
	$(document).ready(function() {
		$("#styType tbody tr").on("click", function(event) {

			// get back to where it was before if it was selected :
			$("#id").val($(this).find("td").eq(0).html());
			$("#stc").val($(this).find("td").eq(1).html());
			$("#description").val($(this).find("td").eq(2).html());
			var btn = document.getElementById("addbtn")
			btn.disabled = true;
		});
		getStyType();
	});

	function createStype() {
		var data = {
			stc : $('#stc').val(),
			description : $('#description').val()
		};
			$.ajax({	
			type : 'post',
			url : 'createSecurityTypes.do',
			data : data,
			success : function(data) {
				var ParsedJSON = JSON.parse(data);

				if (ParsedJSON.error1 || ParsedJSON.error2) {
					$('#error1').html(
							"<p class='successmsg' style='color:red'>"
									+ ParsedJSON.error1 + "</p>");
					$('#error2').html(
							"<p class='successmsg' style='color:red'>"
									+ ParsedJSON.error2 + "</p>");
				} else {
					$('#success').html(
							"<p class='successmsg' style='color:green'>"
									+ ParsedJSON.success + "</p>");
					$('#success').fadeOut(5000);

					}
				}
			});
	}
	
	function getStyType() {
		$.ajax({
			type : 'get',
			url : 'viewStype.do',
			success : function(msg) {
				//alert(msg);
				console.log(msg);
			}
		});
	}

	function updateRecord() {
		var stc = $('#stc').val();
		var description = $('#description').val();
		var id1 = $('#id').val();
		$.ajax({
			type : 'get',
			url : 'updateSecurityTypes.do',
			data : {
				id : id1,
				stc : stc,
				description : description
			},
			success : function(msg) {
				alert(msg);
				location.reload();
			}
		});
	}

	function deleteRecord() {
		var id3 = $('#id').val();
		console.log($('#id').val());
		$.ajax({
			type : 'get',
			url : 'removeStype.do',
			data : id3,
			success : function(msg) {
				//alert("delete");
				var ParsedJSON = JSON.parse(msg);

			}
		});

	}
</script>
</head>
<body>
	<div id="success"></div>
	<div id="error3"></div>
	<table id="stypetbl"></table>
	<form action="" method="post">
		<table id="regTable">
			<h4 style="text-align: left">Security Types</h4>
			</br>
			<tr>
				<td><input type="hidden" path="id" id="id" name="id"></td>
			</tr>			<tr>
				<td>Security type Code:</td>
				<td><input type="text" name="stc" id="stc" class="input"></td>
				<td><div id="error1"></div></td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><input type="text" name="description" id="description"
					class="input"></td>
				<td><div id="error2"></div></td>
			</tr>
			<tr>
				<td></td>
				<td><button type="button" class="btn btn-success btn-sm"
						onclick="createStype()" id="addbtn">Save</button> 
				<!-- 	<td><button type="button" class="btn btn-primary" onclick="createUser()">Create</button></td> -->
					<button type="button" class="btn btn-primary btn-sm"
						onclick="updateRecord()">Update</button> 
				<!-- 	<button type="button" class="btn btn-primary" onclick="deleteRecord()">Delete</button></td> -->
			</tr>
		</table>
	</form>
	<div id="stypetbl"></div>
	<table id="styType" class="table table-hover">
		<thead>
			<tr>
				<th>S.No</th>
				<th>Security Code</th>
				<th>Description</th>
				<th>Delete</th>
			</tr>
		</thead>
		<c:forEach items="${viewSecurityType}" var="stype">
			<tbody>
				<tr>
					<td>${stype.id}</td>
					<td>${stype.stc}</td>
					<td>${stype.description}</td>
					<td><a class="btn btn-info btn-sm"
						onclick="return confirm('Are you sure you want to delete this item?');"
						href="<c:url value='/removeStype/${stype.id}.do' />">Delete</a></td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
</body>
</html>