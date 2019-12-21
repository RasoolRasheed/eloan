<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<!-- DATA TABLES -->
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
<title>Client</title>
<style>
table#lsts tbody  tr {
	cursor: pointer;
}
</style>
<script>
	var pickedup,AddORModify;
	$(document).ready(function() {
			getClient();
			$("#lsts tbody tr").on("click", function(event) {
				// Define Action
				AddORModify == "Add"
				// get the values from table
				$('#exampleModalLabel').text("Update client");
				$("#clientCode").prop("readonly", true);
				$("#clientCode").val($(this).find("td").eq(0).html());
				$("#Salutation").val($(this).find("td").eq(1).html());
				$("#Initials").val($(this).find("td").eq(2).html());				$("#firstName").val($(this).find("td").eq(3).html());
				$("#lastName").val($(this).find("td").eq(4).html());
				$("#NIC").val($(this).find("td").eq(5).html());
				$("#initialsinFull").val($(this).find("td").eq(6).html());
				$("#contactNo").val($(this).find("td").eq(7).html());
				$("#addressLine01").val($(this).find("td").eq(8).html());
				$("#addressLine02").val($(this).find("td").eq(9).html());
				$("#addressLine03").val($(this).find("td").eq(10).html());
				$("#addressLine04").val($(this).find("td").eq(11).html());
				$("#postalCode").val($(this).find("td").eq(12).html());
				$("#Gender").val($(this).find("td").eq(13).html());
				$('#AddModModal').modal('show');				
			});
	});

	function createClient() {
		var data = {
			clientCode:$('#clientCode').val(),
			 NIC : $('#NIC').val(),
			 salutation : $('#Salutation').val(),
			 initials : $('#Initials').val(),
			 initialsinFull : $('#initialsinFull').val(),
			 firstName : $('#firstName').val(),
			 lastName : $('#lastName').val(),
			 contactNo : $('#contactNo').val(),
			 addressLine01 : $('#addressLine01').val(),
			 addressLine02 : $('#addressLine02').val(),
			 addressLine03 : $('#addressLine03').val(),
			 addressLine04 : $('#addressLine04').val(),
			 postalCode : $('#postalCode').val(),
			 gender : $('#Gender').val()
		 };
		 if(AddORModify == "Add"){
			 $.ajax({
					type : 'post',
					url : 'createClient.do',
					data : data,
					success : function(data) {
						var ParsedJSON = JSON.parse(data);
						if (ParsedJSON.error1 || ParsedJSON.error2 ) {
							$('#error1').html(
									"<p class='successmsg' style='color:red'>"
											+ ParsedJSON.error1 + "</p>");
							$('#error2').html(
									"<p class='successmsg' style='color:red'>"
											+ ParsedJSON.error2 + "</p>");
							
						} else if(ParsedJSON.error){
							$('#error').html(
									"<p class='successmsg' style='color:red'>"
											+ ParsedJSON.error + "</p>");
							prepareAddModel();
						}else {
							$('#AddModModal').modal('hide');
							location.reload();
							//$('#success').html("<p class='successmsg' style='color:red'>" + ParsedJSON.success + "</p>");
						}
					}
				});
			 
		}else{
			$.ajax({
				type : 'GET',
				url : 'updateClient.do',
				data : data,
				success : function(data) {
					var ParsedJSON = JSON.parse(data);
					if (ParsedJSON.error1 || ParsedJSON.error2 ) {
						$('#error1').html(
								"<p class='successmsg' style='color:red'>"
										+ ParsedJSON.error1 + "</p>");
						$('#error2').html(
								"<p class='successmsg' style='color:red'>"
										+ ParsedJSON.error2 + "</p>");
						
					} else if(ParsedJSON.error){
						$('#error').html(
								"<p class='successmsg' style='color:red'>"
										+ ParsedJSON.error + "</p>");
						prepareAddModel();
					}else {
						$('#AddModModal').modal('hide');
						location.reload();
						//$('#success').html("<p class='successmsg' style='color:red'>" + ParsedJSON.success + "</p>");
					}
				}
			});		
	 }	
	}

	function allowOnlyNumber(evt) {
		var charCode = (evt.which) ? evt.which : event.keyCode
		if (charCode > 31 && (charCode < 48 || charCode > 57))
			return false;
		return true;
	}
	function validateNIC(value) {
		var NIC = $('#NIC').val();
		var regex = /^([0-9]{9}[x|X|v|V]|[0-9]{12})$/g;
		regex.replace(NIC, "");
		return value;
	}
	function getClient() {
		$.ajax({
			type : 'get',
			dataType : 'JSON',
			url : 'viewClient.do',
			success : function(msg) {
				//console.log(msg);
				//msg = JSON.parse(msg);
				alert(msg);
				// drawTable("stypetbl",msg['listSecurityTypes']);
			}
		});
	}

	function updateClient() {
		var data = {
				 NIC : $('#NIC').val(),
				 salutation : $('#Salutation').val(),
				 initials : $('#Initials').val(),
				 initialsinFull : $('#initialsinFull').val(),
				 firstName : $('#firstName').val(),
				 lastName : $('#lastName').val(),
				 contactNo : $('#contactNo').val(),
				 addressLine01 : $('#addressLine01').val(),
				 addressLine02 : $('#addressLine02').val(),
				 addressLine03 : $('#addressLine03').val(),
				 addressLine04 : $('#addressLine04').val(),
				 postalCode : $('#postalCode').val(),
				 gender : $('#Gender').val()
			 };
		 
		$.ajax({
			type : 'get',
			url : 'updateClient.do',
			data : {data},
			success : function(msg) {
				alert(msg);
				location.reload();
			}
		});
	}

	function deleteRecord() {
		var sno = $('#sno').val();
		console.log($('#sno').val());
		$.ajax({
			type : 'get',
			url : 'removeLStatus.do',
			data : {
				sno : sno
			},
			success : function(msg) {
				alert("delete");
				location.reload();

			}
		});

	}
	function prepareAddModel() {
		AddORModify = "Add"; /* global var */

		$('#exampleModalLabel').text("Add Client Details Here");
		$('#clientCode').val("");
		$('#NIC').val("");
		$('#Salutation').val("");
		$('#Initials').val("");
		$('#initialsinFull').val("");
		$('#firstName').val(""); 
		$('#lastName').val("");
		$('#contactNo').val("");
		$('#addressLine01').val("");
		$('#addressLine02').val("");
		$('#addressLine03').val("");
		$('#addressLine04').val("");
		$('#PostalCode').val("");
		$('#Gender').val("");
		$("#clientCode").prop("readonly", true);
		$('#AddModModal').modal('show');

	}
</script>

</head>
<body>

	<div id="success"></div>
	<div id="error3"></div>

	<table id="stypetbl"></table>
	<form action="" method="post">
		<table id="regTable">
			<h4 style="text-align: left">Client Details</h4>
			<button class="btn btn-primary btn-sm" type="button"
				onclick="prepareAddModel();">Add New Client</button>
			</br>

		</table>
	</form>

	<div id="stypetbl"></div>
	<table id="lsts" height="200px;" class="table table-hover">
		<tr>
			<th width="60">Salutation</th>
			<th width="80">First Name</th>
			<th width="80">Last Name</th>
			<th width="120">NIC</th>
			<th width="80">ContactNo</th>
			<th width="120">Address1</th>
			<th width="100">Address2</th>
			<th width="80">Modify</th>

		</tr>
		<c:forEach items="${viewClns}" var="cln">
			<tbody>
				<tr>
					<td style="display: none;">${cln.clientCode}</td>
					<td style="display: none;">${cln.salutation}</td>
					<td>${cln.initials}</td>
					<td>${cln.firstName}</td>
					<td>${cln.lastName}</td>
					<td>${cln.NIC}</td>
					<td style="display: none;">${cln.initialsinFull}</td>
					<td>${cln.contactNo}</td>
					<td>${cln.addressLine01}</td>
					<td>${cln.addressLine02}</td>
					<td style="display: none;">${cln.addressLine03}</td>
					<td style="display: none;">${cln.addressLine04}</td>
					<td style="display: none;">${cln.postalCode}</td>
					<td style="display: none;">${cln.gender}</td>
					<td><a class="btn btn-info btn-sm" onclick="updateClient();"
						href="#' />">Update</a></td>
					<%-- <td><a class="btn btn-info btn-sm"
						onclick="return confirm('Are you sure you want to delete this item?');"
						href="<c:url value='/delete/${delete.id}.do' />">Delete</a></td> --%>
				</tr>
			</tbody>
		</c:forEach>
	</table>
	<!-- Add Modal content-->
	<form action="" id="form_addmodify" role="form">
		<div class="modal fade" id="AddModModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<strong><h2 class="modal-title" id="exampleModalLabel"></h2></strong>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<table class="tg">
							<div id="error"></div>
							<tr>
								<td class="tg-0lax">Client Code:</td>
								<td class="tg-0lax"><input type="text"
									class="form-control input-sm" id="clientCode" name="clientCode"
									value="" style="width: 250px;" placeholder="Client Code" /></td>

							</tr>
							<tr>
								<td class="tg-0lax">NIC: <font color="red">*</font></td>
								<td class="tg-0lax"><input type="text"
									class="form-control input-sm" id="NIC" name="NIC" value=""
									style="width: 250px;" /></td>
								<!--onblur="validateNIC();"  -->
								<td><div id="error1"></div></td>
							</tr>
							<tr>
								<td class="tg-0lax">Salutation: <font color="red">*</font></td>
								<td class="tg-0lax"><input type="text"
									class="form-control input-sm" id="Salutation" name="Salutation"
									value="" style="width: 250px;" /></td>
							</tr>
							<tr>
								<td class="tg-0lax">Initial: <font color="red">*</font></td>
								<td class="tg-0lax"><input type="text"
									class="form-control input-sm" id="Initials" name="Initials"
									value="" style="width: 250px;" /></td>
							</tr>
							<tr>
								<td class="tg-0lax">Full Initials:</td>
								<td class="tg-0lax"><input type="text"
									class="form-control input-sm" id="initialsinFull"
									name="initialsinFull" value="" style="width: 250px;" /></td>
							</tr>
							<tr>
								<td class="tg-0lax">First Name: <font color="red">*</font></td>
								<td class="tg-0lax"><input type="text"
									class="form-control input-sm" id="firstName" name="firstName"
									value="" style="width: 250px;" /></td>
								<div id="error1"></div>
							</tr>
							<tr>
								<td class="tg-0lax">Last Name: <font color="red">*</font></td>
								<td class="tg-0lax"><input type="text"
									class="form-control input-sm" id="lastName" name="lastName"
									value="" style="width: 250px;" /></td>
							</tr>
							<tr>
								<td class="tg-0lax">ContactNo: <font color="red">*</font></td>
								<td class="tg-0lax"><input type="text"
									class="form-control input-sm" id="contactNo" name="contactNo"
									value=""  onkeypress="return allowOnlyNumber(event);" style="width: 250px;" /></td>
							</tr>
							<tr>
								<td class="tg-0lax">AddressLine1:<font color="red">*</font>
								</td>
								<td class="tg-0lax"><input type="text"
									class="form-control input-sm" id="addressLine01"
									name="addressLine01" value="" style="width: 250px;" /></td>
							</tr>
							<tr>
								<td class="tg-0lax">AddressLine2:</td>
								<td class="tg-0lax"><input type="text"
									class="form-control input-sm" id="addressLine02"
									name="addressLine02" value="" style="width: 250px;" /></td>
							</tr>
							<tr>
								<td class="tg-0lax">AddressLine3:</td>
								<td class="tg-0lax"><input type="text"
									class="form-control input-sm" id="addressLine03"
									name="addressLine03" value="" style="width: 250px;" /></td>
							</tr>
							<tr>
								<td class="tg-0lax">AddressLine4:</td>
								<td class="tg-0lax"><input type="text"
									class="form-control input-sm" id="addressLine04"
									name="addressLine04" value="" style="width: 250px;" /></td>
							</tr>
							<tr>
								<td class="tg-0lax">Postal Code: <font color="red">*</font></td>
								<td class="tg-0lax"><input type="text"
									class="form-control input-sm" id="postalCode" name="postalCode"
									value="" style="width: 250px;" /></td>
							</tr>
							<tr>
								<td class="tg-0lax">Gender:</td>
								<td class="tg-0lax"><input type="text"
									class="form-control input-sm" id="Gender" name="Gender"
									value="" style="width: 250px;" /></td>
							</tr>


						</table>
						<div id="responceviewer"></div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">
							<span aria-hidden="true" class="glyphicon glyphicon-remove"></span>&nbsp;Close
						</button>
						<button type="button" class="btn btn-primary"
							onclick="createClient();">
							<span aria-hidden="true" class="glyphicon glyphicon-floppy-save"></span>&nbsp;Save
							changes
						</button>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>