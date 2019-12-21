<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel='stylesheet'
	href='https://use.fontawesome.com/releases/v5.7.0/css/all.css'
	integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ'
	crossorigin='anonymous'>
<title>Trial Calculation</title>

<!-- jQuery CDN - Slim version (=without AJAX) -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<!-- Popper.JS -->
<script
	src="https://cdnj	s.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
	integrity="sha384-cs	/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
	crossorigin="anonymous"></script>
<!-- Bootstrap JS -->
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"
	integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm"
	crossorigin="anonymous"></script>

<!-- Bootstrap CSS CDN -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
	integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"
	crossorigin="anonymous">



<script src="resources/TrailCal.js" type="text/javascript"></script>
<script src="resources/validation.js" type="text/javascript"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<style>
</style>
<script>
	$(document).ready(function() { 
		$('#loanTerm').prop("disabled", true);
		$('#loanAmount').prop("disabled", true);
		$('#interestRate').prop("disabled", true);
		$('#installment').prop("disabled", true);
		$("#drop").change(function () {
			var la = $('#drop').val();
			if(la =="Amount"){
				$('#loanAmount').prop("disabled", true);
				$('#loanTerm').prop("disabled", false);
				$('#interestRate').prop("disabled", false);
				$('#installment').prop("disabled", false);
			}else if(la == "Term"){
				$('#loanTerm').prop("disabled", true);
				$('#loanAmount').prop("disabled", false);
				$('#interestRate').prop("disabled", false);
				$('#installment').prop("disabled", false);
			}else if(la=="Rate"){
				$('#interestRate').prop("disabled", true);
				$('#loanAmount').prop("disabled", false);
				$('#loanTerm').prop("disabled", false);
				$('#installment').prop("disabled", false);
			}else if(la=="Installment"){
				$('#installment').prop("disabled", true);
				$('#loanAmount').prop("disabled", false);
				$('#loanTerm').prop("disabled", false);
				$('#interestRate').prop("disabled", false);
			}else{
				$('#loanAmount').prop("disabled", true);
				$('#loanTerm').prop("disabled", true);
				$('#interestRate').prop("disabled", true);
				$('#installment').prop("disabled", true);
				}
			
	    });	    
		$("#viewbtn").on("click", function( event ) {
			 var btn1 = document.getElementById("save");
			 var clnName = $('#clientNam').val();
			if(clnName!= ""){
				btn1.disabled = false;
			}else{
				btn1.disabled = true;
			}	
		});
		$( "#viewShedulebtn" ).on( "click", function( event ) {	
			    var btn = document.getElementById("excelbtn")
				btn.disabled = false;
		});
		var btn2 = document.getElementById("save")
			btn2.disabled = true;
		var xclbtn = document.getElementById("excelbtn")
			xclbtn.disabled = true;
	});
	
	function createTC(){
		var clientCode = $('#clientCode').val();
		var Amount = $('#loanAmount').val();
		var Period = $('#loanTerm').val();
		var Rate = $('#interestRate').val();
		var Installment = $('#installment').val();
		$.ajax({
			type : 'POST',
			url : 'createTC.do',
			data : {
				clientCode:clientCode,
				Amount:Amount,
				Period:Period,
				Rate:Rate,
				Installment:Installment
				},
			success : function(data) {
				alert(data);
				location.reload();
			}
		});
	}
	function saveReshedule() {
		var a = JSON.stringify(repaymentSch);
		var clientCode = $('#clientCode').val();
		//alert(clientCode);
		a = "{\"schedule\":"+a+"}";
		alert(a);
		$.ajax({
			type : 'POST',
			url : 'saveReshedule.do',
			data : {a,clientCode:clientCode},
			success : function(data) {
				alert(data);
			}
		});
	}
	function checkClient(){
		var NIC = $('#nic').val();
	      $.ajax({
	        type:'get',
	        datatype:'JSON',
	        url: 'checkClient.do',
	        data:{
	        	NIC:NIC
		        },
	        success:function(msg){ 
	        var a = JSON.parse(msg);
	        var datalist = a.dueList[0];
		      	//alert(datalist);
		      	$('#clientNam').val(datalist[1]+" "+datalist[2]);
		    	$('#clientCode').val(datalist[0]);
		      	
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
	<div id="Success"></div>
	<div id="error"></div>
	<div ng-view="" class="ng-scope">
		<div class="calculator-container form_errors  ng-scope">
			<h4>Goal Seek</h4>

			<div class="form-group">
				<form name="Amortization" id="Amortization" required>
					<div class="form-group">
						<div class="form-group">
							<label for="nic">NIC No: </label> 
							<input type="text" name="nic"
								id="nic" class="input">
							<button type="button" class="btn btn-info btn-sm"
								id="viewbtn"onclick="checkClient();">view</button>
							<input type="text" class="form-group col-sm-3" id="clientNam"
								name="clientNam" readonly> 
							<input type="hidden"
								class="form-group col-sm-3" id="clientCode" name="clientCode"
								readonly> <select id="drop" class="form-group col-sm-3">
								<option>-----Select What You like to Calculate------</option>
								<option id="aa" value="Amount">Loan Amount</option>
								<option value="Term">Loan Term</option>
								<option value="Rate">Loan Rate</option>
								<option value="Installment">Loan Installment</option>
							</select>
							<div class="form-row">
								<label class="form-group col-sm-3" for="loan-Amount">Loan
									Amount</label> <input type="number" class='form-control-sm col-sm-4'
									id="loanAmount" name="loanAmount"
									pattern="^\$\d{1,3}(,\d{3})*(\.\d+)?$" value=""
									data-type="currency" placeholder="Rs. 1,000,000.00" required=""
									onkeypress="return allowOnlyNumber(event);">
							</div>
							<div class="form-row">
								<label class="form-group col-sm-3" for="loan-Term">Loan
									Term </label> <input type="number" class='form-control-sm col-sm-4'
									id="loanTerm" name="loanTerm" placeholder="Months" min="12"
									max="100" required=""
									onkeypress="return allowOnlyNumber(event);">
							</div>
							<div class="form-row">
								<label class="form-group col-sm-3" for="interest-Rate">Interest
									Rate %</label> <input type="number" class='form-control-sm col-sm-4'
									id="interestRate" placeholder="Rate" maxlength="5"
									name="interestRate" onkeypress="return allowOnlyFloat(event);"
									required="">&nbsp
							</div>
							<div class="form-row">
								<label class="form-group col-sm-3" for="loan-Amount">Installment</label>
								<input type="number" class='form-control-sm col-sm-4'
									id="installment" name="installment" value=""
									data-type="currency" placeholder="Rs.1,000,000.00" required=""
									onkeypress="return allowOnlyNumber(event);">
							</div>
						</div>
						<!-- <div id="payment"></div> -->
						<div class="form-group col-sm-8">
							<p style="color: red;" id="print"></p>
							<div class="form-group">
								<label class="form-group col-sm-5" for="loan-Amount"></label> 
								<input
									type="button" name="submit" class="btn btn-info btn-sm"
									id="calbtn" value="Calculate" onclick="calculate();"> 
								<input
									type="button" class="btn btn-success btn-sm"
									name="viewShedulebtn" id="viewShedulebtn" value="View Schedule"
									onclick="calShedule();"> 
								<input type="reset" id="reset"
									name="sub"
									class="submit-calculate button  btn-default btn-sm reset"
									value="Reset"> 
								<input type="button"
									class="btn btn-success btn-sm" name="saveTC" id="saveTC"
									value="save shedule" onclick="saveReshedule();">
								<input
									type="button" class="btn btn-success btn-sm" name="save"
									id="save" value="SaveTC" onclick="createTC();">
								<button class="btn btn-primary btn-sm" id="excelbtn"
									onclick="exportTableToExcel('tblShedule', 'Rentel Schedule');">
									<i class='fas fa-file-excel' style='font-size: 20px'>Excel</i>
								</button>
							</div>
						</div>
					</div>

				</form>
			</div>
			<div class="shedule">

				<table class="table" id="tblShedule" style="text-align: right;">
					<tr>
						<th>Inst.No</th>
						<th>Installment Value</th>
						<th>Interest Amount</th>
						<th>Capital Amount</th>
						<th>Capital Balance</th>
					</tr>
					<tfoot>
						<tr></tr>
					</tfoot>
				</table>
			</div>
		</div>

		<div id="Result"></div>
</body>
</html>