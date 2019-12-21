<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
	<!-- DATA TABLES -->
	<script type="text/javascript" src = "https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
<title>Insert title here</title>
<style>
table#lsts tbody  tr {
    cursor : pointer;
}
</style>
<script>
var pickedup;
	$(document).ready(function() { 
		$( "#lsts tbody tr" ).on( "click", function( event ) {
			 
	        // get back to where it was before if it was selected :
	        $("#sno").val($(this).find("td").eq(0).html());
	        $("#lsc").val($(this).find("td").eq(1).html());
	        $("#des").val($(this).find("td").eq(2).html());
	        var btn = document.getElementById("LStsbtn");
        	btn.disabled = true;
	  });
	  getLSts();
	});

	/* function drawTable(id,data){
		console.log(data);
		$('#'+id).dataTable().fnClearTable();
		if(data != null && data.length>0){	
			$('#'+id).dataTable().fnAddData(data);
		}
	} */
	function createStatus() {
		var data = {
			lsc : $('#lsc').val(),
			desc : $('#des').val()
		};
		var lsc = $('#lsc').val();
		var desc = $('#des').val();
		$.ajax({
			type :'post',
			url :'createLStatus.do',
			data : {
				lsc : lsc,
				des : desc
				},
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
					location.reload();
					//$('#success').html("<p class='successmsg' style='color:red'>" + ParsedJSON.success + "</p>");
				}
		}
		});
	}
	
	function  getLSts(){
	      $.ajax({
	        type:'get',
	        url: 'viewLStatus.do',
	        success:function(msg){ 
		      //console.log(msg);
		      	//msg = JSON.parse(msg);
		      	//alert(msg);
	      	 // drawTable("stypetbl",msg['listSecurityTypes']);
	         }
	      
	      });
	  }
	  
	function updateRecord(){
    	var lsc = $('#lsc').val();
        var des = $('#des').val();
        var sno = $('#sno').val();
 	alert(sno);
    $.ajax({
          type:'get',
          url: 'updateLoanStatus.do',
          data:{ 
        	  sno:sno,
        	  lsc :lsc,
	    		des :des
	          },
          success:function(msg){
	          alert(msg);
	          location.reload();
          	}
          });
    }
    
	function deleteRecord(){
		 var sno = $('#sno').val();
        console.log($('#sno').val());
      $.ajax({
            type:'get',
            url:'removeLStatus.do',
            data :
                {sno:sno},                
            success:function(msg){
                alert("delete");
                location.reload();            }
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
			<h4 style="text-align: left">Loan Status</h4>
			</br>
			<tr>
				<td><input type="hidden" path="sno" id="sno" name="sno"></td>
			</tr>
			
			<tr>
				<td>Loan Status Code:</td>
				<td><input type="text" name="lsc" id="lsc"
					class="input"></td>
				<td><div id="error1"></div></td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><input type="text" name="des" id="des"
					class="input"></td>
				<td><div id="error2"></div></td>
			</tr>
			<tr>
				<td></td>
				<td><button type="button"  class="btn btn-success btn-sm" onclick="createStatus()" id="LStsbtn" >Save</button>
<!-- 				<td><button type="button" class="btn btn-primary" onclick="createUser()">Create</button></td> -->
				<button type="button" class="btn btn-primary btn-sm" onclick="updateRecord()">Update</button>
				<button type="button" class="btn btn-primary btn-sm" onclick="deleteRecord()">Delete</button></td>
				
			</tr>
		</table>
	</form>
	
	<div id="stypetbl"></div>
	<table id="lsts" class="table table-hover">
		<tr>
			<th width="80">S.No</th>
			<th width="80">Code</th>
			<th width="120">Description</th>
		</tr>
		<c:forEach items="${viewLSts}" var="lsts">
			<tbody>
				<tr>
					<td>${lsts.sno}</td>
					<td>${lsts.lsc}</td>
					<td>${lsts.des}</td>				
				</tr>
			</tbody>
		</c:forEach>
	</table>
	
</body>
</html>