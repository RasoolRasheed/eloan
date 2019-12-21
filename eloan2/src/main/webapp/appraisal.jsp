<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<!-- Ajax -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!--  bootstrap -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<!-- DATA TABLES -->
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.18/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.18/css/jquery.dataTables.min.css">

<title>Appraisal</title>
<style>
table#styType tbody  tr {
	cursor: pointer;
}
</style>
<script>
	var a;
	$(document).ready(function() {
		$("#apslTbl tbody tr").on("click", function(event) {
			// get back to where it was before if it was selected :
			$("#applicationNo").val($(this).parent().find("td").eq(0).html());
			$("#TCNo").val($(this).find("td").eq(2).html());
			$("#clientCode").val($(this).find("td").eq(1).html());
		});
		$('#cnl').click(function() {
			$(this).parents('apslTbl').attr('a');
		});
	});

	$(function() {
		$('#element').on('click', function(e) {
			Custombox.open({
				target : '#testmodal-1',
				effect : 'fadein'
			});
			e.preventDefault();
		});
	});
	function modelShow(TCNo) {
		$('#modal').modal('show');
		var a = TCNo;
		$('#tcNo').val(a);

	}
	function initiateApp(appNo, clientCode, TCNo) {
		var data = {
			applicationNo : appNo,
			clientCode : clientCode,
			TCNo : TCNo
		};
		var a = appNo;
		console.log(TCNo);
		$.ajax({
			type : 'post',
			url : 'initiateApp.do',
			data : {
				applicationNo : appNo,
				clientCode : clientCode,
				TCNo : TCNo
			},
			success : function(data) {
				alert(data);
				var ParsedJSON = JSON.parse(data);
				$('#success').html(
						"<p class='successmsg' style='color:green'>"
								+ ParsedJSON[0].success + "</p>");
				$('#success').fadeOut(5000);
			}
		});
	}

	function prepaymentCharge(applicationNo) {
		var data = {
			applicationNo : appNo
		};
		var a = appNo;
		console.log(TCNo);
		$.ajax({
			type : 'post',
			url : 'initiateApp.do',
			data : {
				applicationNo : appNo,
				clientCode : clientCode,
				TCNo : TCNo
			},
			success : function(data) {
				var ParsedJSON = JSON.parse(data);
				$('#success').html(
						"<p class='successmsg' style='color:green'>"
								+ ParsedJSON.success + "</p>");
				$('#success').fadeOut(5000);
			}
		});
	}
	function cancelApp() {
		var data = {
			TCNo : TCNo
		};
		var TCNo = $('#tcNo').val();
		var remark = $('#remark').val();
		console.log(remark);
		$.ajax({
			type : 'post',
			url : 'cancelApp.do',
			data : {
				TCNo : TCNo,
				remark : remark
			},
			success : function(data) {
				var ParsedJSON = JSON.parse(data);
				if (ParsedJSON.success != "success") {
					$('#error2').html(
							"<p class='successmsg' style='color:red'>"
									+ ParsedJSON.error2 + "</p>");
					$('#error2').fadeOut(3000);
				} else {
					$('#success2').html(
							"<p class='successmsg' style='color:green'>"
									+ ParsedJSON.success + "</p>");
					$('#success2').fadeOut(3000);
					$('#modal').modal('hide');
				}
			}
		});
	}
	function updateAppStatus() {
		var a = appNo;
		//alert("getstd");
		$.ajax({
			type : 'get',
			data : {
				applicationNo : appNo,
			},
			url : 'updateAppStatus.do',
			success : function(msg) {
				console.log(msg);
				alert(msg);
			}
		});
	}
	function viewMore(TCNo) {
		$.ajax({
			type : 'get',
			data : {
				TCNo : TCNo,
			},
			url : 'viewMore.do',
			success : function(msg) {
				var parsedJson = JSON.parse(msg);
				var datalist = parsedJson.listTC[0];
				console.log(msg);
				//alert(datalist.amount);
				$('#amount').html(datalist.amount);
				$('#period').html(datalist.period);
				$('#rate').html(datalist.rate);
				$('#installment').html(datalist.installment);
			}
		});
	}
</script>
</head>
<body>
	<div id="success"></div>
	<div id="error3"></div>
	<h2 style="text-align: left">Approval</h2>
	<input id="applicationNo" type="hidden">
	<input id="clientCode" type="hidden">
	<input id="loanStatus" type="hidden">
	<input id="TCNo" type="hidden">
	<div id="stypetbl"></div>
	<table id="apslTbl" class="table">
		<tr>
		<thead>
			<th width="80">App.No</th>
			<th width="80">TCNo</th>
			<th width="120">NIC</th>
			<th width="120">First Name</th>
			<th width="120">createdBy</th>
			<th width="200">createdDate</th>
			<th>Action</th>
		</thead>
		</tr>
		<c:forEach items="${listApprsl}" var="appsl">
			<tbody>
				<tr id="appsl.applicationNo">
					<td>${appsl.applicationNo}</td>
					<td id="a">${appsl.TCNo}</td>
					<td>${appsl.client.NIC}</td>
					<td>${appsl.client.firstName}</td>
					<td>${appsl.createdBy}</td>
					<td>${appsl.createdDate}</td>
					<td><button type="button" class="btn btn-primary btn-sm"
							data-toggle="modal" data-target="#myModal"
							onclick="viewMore('${appsl.TCNo}');">More</button>
						<button type="button" id="apbtn" class="btn btn-primary btn-sm"
							onclick="initiateApp('${appsl.applicationNo}','${appsl.client.clientCode}','${appsl.TCNo}');">Initiate</button>
						<button type="button" class="btn btn-primary btn-sm" id="cnl"
							onclick="modelShow('${appsl.TCNo}');" data-toggle="modal"
							data-target="#cancelModel">Cancel</button></td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
	<!-- The Modal -->
	<div class="modal" id="myModal">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">TC Details</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<!-- Modal body -->
				<div class="modal-body">
					<!-- <input id="amount" type="text"> -->
					<table>
						<tr>
							<td><label>Amount:</label>
							<p id="amount"></p></td>
						</tr>
						<tr>
							<td><label>Period:</label>
							<p id="period"></p></td>
						</tr>
						<tr>
							<td><label>Rate:</label>
							<p id="rate"></p></td>
						</tr>
						<tr>
							<td><label>Installment:</label>
							<p id="installment"></p></td>
						</tr>
					</table>
				</div>
				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
				</div>

			</div>
		</div>
	</div>

	<div class="modal" id="cancelModel">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Cancel Application</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<!-- Modal body -->
				<div class="modal-body">
					<div id="success2"></div>
					<div id="error2"></div>
					<input id="tcNo" type="hidden">
					<div>
						<label>Remark:</label><input type="text" id="remark">
					</div>
				</div>
				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary btn-sm"
						onclick="cancelApp();">Submit</button>
					<button type="button" class="btn btn-danger btn-sm"
						data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>