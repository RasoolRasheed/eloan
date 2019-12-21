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
<title>Activation</title>
<style>
table#table1 tbody  tr {
    cursor : pointer;
}
</style>
<script>
	$(document).ready(function() {
		   
	
	});

	function drawTable(id,data){
		//alert(data);
		console.log(data);
		$('#'+id).dataTable().fnClearTable();
		if(data != null && data.length>0){	
			$('#'+id).dataTable().fnAddData(data);
		}
	}
	function viewDue(){
		var NIC = $('#NIC').val();
		//alert(fno);
	      $.ajax({
	        type:'get',
	        url: 'checkClient.do',
	        data:{
	        	NIC:NIC
		        },
	        success:function(msg){ 
	        var a = JSON.parse(msg);
	        var datalist = a.dueList[0];
	        $('#clientNam').html(datalist[1]+" "+datalist[2]);
	       
	        /* var datalist = a.dueList[0];
	        for(int x=0;x<=datalist.length;x++){
	        	datalist += datalist[x];
					alert(datalist);
		        }
	        var datalist2 = a.dueList[1];
	        	alert(datalist[4] +datalist[4] ); */
	        
	         }
	      });
	  }
	  
	function activeAcc(){
        var fno = $('#fno').val();
 		alert(fno);
	    $.ajax({
	          type:'get',
	          url: 'receiptDue.do',
	          data:{	       
	        	  fno :fno
		          },
	          success:function(msg){
		          var parsedJson = JSON.parse(msg);
		          var datalist = parsedJson.dueList[0];
		          //alert(datalist[2]);
		         // alert(datalist[4]);
		          if(datalist[2] == datalist[3] || datalist[4]== 0){
							alert("Application Active Successful");
			          }else{
			        	  alert("Can't Active account , You have Arrears Amount");
				          }
		          
	          }
          });
    }
</script>
</head>
<body>
<div id="success"></div>
${success}
<div id="error3"></div>
<table id="stypetbl"></table>
<input type="hidden" id="blce" >
		<table id="regTable">
			<h4 style="text-align: left">Activation</h4>
			</br>
			<tr>
				<td>NIC No:</td>
				<td><input type="text" name="NIC" id="NIC" class="input"></td>
				<td><button type="button" class="btn btn-info btn-sm" onclick="viewDue();">view</button></td>
				<td> </td>
				<td> </td>
				<td><div><h6 id="clientNam"></h6></div></td>
			</tr>
			<tr>
				<td>Facility No:</td> 
				<td><input type="text" name="fno" id="fno" class="input"></td>
				<td><div id="error1"></div></td>
			</tr>
			
		</table>
	<div id="footer">
		<button type="button" class="btn btn-success btn-sm" id="paybtn" onclick="activeAcc();">Activate</button>
		<button type="button" class="btn btn-default btn-sm">Cancel</button>
	</div>
	
</body>
</html>