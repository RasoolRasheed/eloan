<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%-- <%=session.getAttribute("username")%> --%>
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
<title>Receipt</title>
<style>
table#table1 tbody  tr {
	cursor: pointer;
}
</style>
<script>
	$(document).ready(function() {
		
	
	var	table1 = $('#table1').DataTable({
	   		data: [],
	   		"paging": false,
	       columns: [
	    	   { title: "ID" },
	           { title: "Description" },     
	           { title: "Due"},
	           { title: "Payment"},
	           { title: "Balance"}
	       ],
	       "scrollY":        "200px"
	   });
	   
		$( "#table1 tbody" ).on( "click",'tr', function( event ) {
			 var data = table1.row( this ).data();
			 var sum = (data[2]+data[3]);
			 //alert( 'You clicked on '+data[0]+'\'s row' );
			 
	       // get back to where it was before if it was selected :
			$("#id").val($(this).find("td").eq(0).html());
	      	$("#due").val($(this).find("td").eq(2).html());
	       var btn = document.getElementById("paybtn");
	   		btn.disabled = false; 
	 	});
		var btn = document.getElementById("paybtn");
    	btn.disabled = true; 

    	$(function(){ 
    		var sum = 0;
    		   $('#due').each(function(x,y){
    		       sum += parseInt($(this).text());                                   
    		   })           
    		   $('#due').text(sum);   
    	});
	});
	
	function drawTable(id,data){
		console.log(data);
		$('#'+id).dataTable().fnClearTable();
		if(data != null && data.length>0){	
			$('#'+id).dataTable().fnAddData(data);
		}
	}
	
	function viewDue(){
		var fno = $('#fno').val();
	      $.ajax({
	        type:'get',
	        datatype:'JSON',
	        url: 'receiptDue.do',
	        data:{
				fno:fno
		        },
	        success:function(msg){ 
	        var a = JSON.parse(msg);
	        	var datalist = a.dueList[0];
		      	var sumDue=0.0;
		      	var sumPaid=0.0;
		      	var sumBalance=0.0;
				for(var x=0;x<a.dueList.length;x++){
					sumDue+=parseInt(a.dueList[x][2]);
					sumPaid+=parseInt(a.dueList[x][3]);
					sumBalance+=parseInt(a.dueList[x][4]);
					}
		      	$('#sumDue').html(sumDue);
		      	$('#sumPaid').html(sumPaid);
		      	$('#sumBalance').html(sumBalance);
		      console.log(msg);
	    		drawTable("table1",a.dueList);
	         }
	      });
	  }
	  
	function updatePayment(){
    	var payment = $('#pmt').val();
        var fno = $('#fno').val();
        var id = $('#id').val();
        var paymentMode = $('#inputGroupSelect01').val();
        var username = $('#username').val();
        var createdDate = $('#date').val();;
	    $.ajax({
	          type:'get',
	          url: 'updatePayment.do',
	          data:{
		          id:id,
		    	  payment:payment,
	        	  paymentmode:paymentMode,
	        	  fno :fno,
		          },
	          success:function(msg){
	        	  var ParsedJSON = JSON.parse(msg);
	        	  $('#success').html("<p class='successmsg' style='color:green'>" + ParsedJSON.success + "</p>");
					$('#success').fadeOut(5000);
					viewDue();
					alert("Payment Successfully Rs "+payment +" paid");
		          location.reload();
	          }
          });
    }
    
	function receiptPrint(){
        var fno = $('#fno').val();
	    $.ajax({
	          type:'get',
	          url: 'receiptPrint.do',
	          data:{
	        	  fno :fno
		          },
	          success:function(msg){
		          alert(msg);
		          location.reload();
	          }
          });
    }
	function exportTableToExcel(tableID, filename = ''){
	    var downloadLink;
	    var dataType = 'application/vnd.ms-excel';
	    var tableSelect = document.getElementById(tableID);
	    var tableHTML = tableSelect.outerHTML.replace(/ /g, '%20');
	    
	    // Specify file name
	    filename = filename?filename+'.xls':'excel_data.xls';
	    
	    // Create download link element
	    downloadLink = document.createElement("a");
	    
	    document.body.appendChild(downloadLink);
	    
	    if(navigator.msSaveOrOpenBlob){
	        var blob = new Blob(['\ufeff', tableHTML], {
	            type: dataType
	        });
	        navigator.msSaveOrOpenBlob( blob, filename);
	    }else{
	        // Create a link to the file
	        downloadLink.href = 'data:' + dataType + ', ' + tableHTML;
	    
	        // Setting the file name
	        downloadLink.download = filename;
	        
	        //triggering the function
	        downloadLink.click();
	    }
	}
</script>
</head>
<body>
	<div id="success">${success}</div>
	<div id="error3"></div>
	<table id="stypetbl"></table>
	<form action="" method="post">
		<table id="regTable">
			<h2 style="text-align: left">Receipt</h2>
			</br>
			<tr>
				<td>Payment Mode:</td>
				<td><select class="custom-select" id="inputGroupSelect01">
						<option selected>Choose...</option>
						<option value="cash">Cash</option>
						<option value="card">Credit Card</option>
						<option value="deposit">Direct Deposit</option>
				</select></td>
				<td></td>
			</tr>
			<tr>
				<input type="hidden" id="username" value="${username }"
					class="input">
				<input type="hidden" id="date" value="${formattedDate}"
					class="input">
				<td>Facility No:</td>
				<td><input type="text" name="fno" id="fno" class="input"></td>
				<td><button type="button" class="btn btn-info btn-sm"
						onclick="viewDue()">view</button>
				<td><div id="error1"></div></td>
			</tr>
		</table>
	</form>
	<div id="footer">
		<table id="table1">
		</table>
		<table>
			<tfoot>
				<tr>
					<td></td>
					<td></td>
					<td><label>Total Due:</label>
						<p id="sumDue"></p></td>
					<td><label>Total Paid:</label>
						<p id="sumPaid"></p></td>
					<td><label>Total Balance:</label>
						<p id="sumBalance"></p></td>
				</tr>

			</tfoot>
		</table>
		<input type="hidden" id="id" name="id"> <label>Due:</label><input
			id="due" name="due" type="text" class="input" readonly> <label>Payment:</label><input
			id="pmt" name="pmt" type="text" class="input"></br>
		<button class="btn btn-success btn-sm" id="paybtn"
			onclick="updatePayment()">Pay</button>
		<button class="btn btn-default btn-sm" id="btnPrint" onclick="receiptPrint()">print</button>
		<button class="btn btn-primary btn-sm"
			onclick="exportTableToExcel('table1', 'members-data');">Export
			Excel File</button>
	</div>

</body>
</html>