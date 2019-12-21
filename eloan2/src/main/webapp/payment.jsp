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

<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>

<title>Payment</title>
<style>
table#styType tbody  tr {
    cursor : pointer;
}
 #barChart{
  background-color: grey;
  border-radius: 6px;
}

</style>
<script>

var pickedup;

	$(document).ready(function() { 
		
		/* 
		stypetbl = $('#stypetbl').DataTable( {
	   		data: [],
	   		"paging": false,
	       columns: [
	           { title: "Student Id" },
	           { title: "Security Code" },     
	           { title: "Description"}
	       ],
	       "scrollY":        "400px",
           
	       columnDefs: [ {"targets": [0], "searchable": false, "visible": false}] 
	   }); */
		   
		$( "#styType tbody tr" ).on( "click", function( event ) {
			 
	        // get back to where it was before if it was selected :
			$("#id").val($(this).find("td").eq(0).html());
	        $("#stc").val($(this).find("td").eq(1).html());
	        $("#description").val($(this).find("td").eq(2).html());
	        var btn = document.getElementById("addbtn")
        	btn.disabled = true;
	  });
	   
	});

	/* function drawTable(id,data){
		console.log(data);
		$('#'+id).dataTable().fnClearTable();
		if(data != null && data.length>0){	
			$('#'+id).dataTable().fnAddData(data);
		}
	} */
	function createStype() {
		var data = {
				stc : $('#stc').val(),
				description : $('#description').val()
		};
	
		$.ajax({
			type :'post',
			url :'createSecurityTypes.do',
			data : data,
			success : function(data) {
				//alert(data);
	
				var ParsedJSON = JSON.parse(data);
				//alert(ParsedJSON.error1);
				//alert(ParsedJSON.success);
	
				if (ParsedJSON.error1 || ParsedJSON.error2) {
					$('#error1').html(
							"<p class='successmsg' style='color:red'>"
									+ ParsedJSON.error1 + "</p>");
					$('#error2').html(
							"<p class='successmsg' style='color:red'>"
									+ ParsedJSON.error2 + "</p>");
				} else {
					//alert(ParsedJSON.success);
					$('#success').html("<p class='successmsg' style='color:green'>" + ParsedJSON.success + "</p>");
					$('#success').fadeOut(5000);
					//location.reload();
					
				}
	
			}
	
		});
	
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
	        var datalist = a.dueList[0];loantype
	        $('#clientNam').html(datalist[1]+" "+datalist[2]);
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
	function dataTable(){
		 $('#styType').DataTable({
             "dom":'<"toolbar">frtip',
             "scrollY":        "400px",
             "scrollCollapse": true,
             "paging": false,
             "columnDefs": [
                 
                 { "width": "300px", "targets": 2},{ "width": "80px", "targets": 0},{ "width": "200px", "targets": 1} 
		 ],
		 "autoWidth": true
         });
		}
	function  getStyType(){
		  //alert("getstd");
	      $.ajax({
	        type:'get',
	        url: 'viewStype.do',
	        success:function(msg){ 
		      console.log(msg);	      
			      
		      	//msg = JSON.parse(msg);
		      	//alert(msg);
	      	 // drawTable("stypetbl",msg['listSecurityTypes']);
	      	  
	         }
	      
	      });
	  }
	  
	function updateRecord(){
    	var stc = $('#stc').val();
        var description = $('#description').val();
        var id1 = $('#id').val();
 			// alert(id1);
    $.ajax({
          type:'get',
          url: 'updateSecurityTypes.do',
          data:{
	    		id:id1,
	    		stc :stc,
	    		description :description
	          },
          success:function(msg){
	          alert(msg);
	          location.reload();
          }
	          });
    }
    
	function deleteRecord(){
        var id3 = $('#id').val();
        console.log($('#id').val());
      $.ajax({
            type:'get',
            url:'removeStype.do',
            data :id3,                
            success:function(msg){
                alert("delete");
                var ParsedJSON = JSON.parse(msg);

            }
        }); 

          
		}
	

</script>
</head>
<body>
<%-- <canvas id="barChart"></canvas>
 --%>


<div id="success"></div>
<div id="error3"></div>
<table id="stypetbl"></table>
<form action="" method="post">

		<table id="regTable">
			<h4 style="text-align: left">Payment</h4>
			</br>
			<tr>
				<td>NIC No:</td>
				<td><input type="text" name="NIC" id="NIC" class="input"></td>
				<td><button type="button" class="btn btn-info btn-sm" onclick="viewDue();">view</button></td>
				<td><input type="hidden" path="id" id="id" name="id"></td>
				<td><div><h6 id="clientNam"></h6></div></td>
				<td><div><h6 id="loantype"></h6></div></td>
			</tr>
			
			<tr>
				<td><div id="error1"></div></td>
			</tr>
			
		</table>
	</form>
	<div id="stypetbl"></div>
	<table id="styType" class="table">
		<thead>
			<tr>
				<th>Facility No</th>
				<th>Desc</th>
			
				<th>Payment</th>
				
				
			</tr>
			</thead>
		<c:forEach items="${viewSecurityType}" var="stype">
			<tbody>
				<tr>
					<td>${stype.id}</td>
					<td>${stype.stc}</td>
					<td>${stype.description}</td>
					<td><input type="text" name="stc" id="stc" class="input" placeholder="payment"></td>
					<td><a  class="btn btn-info btn-sm" onclick="return confirm('Are you sure you want to delete this item?');" href="<c:url value='/removeStype/${stype.id}.do' />" >Delete</a></td>
	<%--  				<td><a  href="<c:url value='/remove/${user.id}.do' />" >Delete</a></td> --%>
	<!-- 				<td><button id="{user.id}" type="button" onclick="deleteRecord()">del</button></td> -->
				</tr>
			</tbody>
		</c:forEach>
	</table>
	<div>
		CHQ No:
		<input type="text" name="stc" id="stc" class="input">
	</div>
	
	<button class="btn btn-success btn-sm">SAVE</button>
	
	<button class="btn btn-default btn-sm">Print</button>
</body>
</html>