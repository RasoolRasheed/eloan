function allowOnlyNumber(evt) {
				var charCode = (evt.which) ? evt.which : event.keyCode
				if (charCode > 31 && (charCode < 48 || charCode > 57))
					return false;
				return true;
			}
function onlyFloat(evt) {
			var regexp = /^\d+(\.\d{1,2})?$/;
			return regexp.test(evt);
		}
function allowOnlyFloat(evt) {
			var charCode = (evt.which) ? evt.which : evt.keyCode;
			if (charCode != 46 && charCode > 31 && (charCode < 48 || charCode > 57))
				return false;
		}
function validIR(val) {
	if (val<0 || val>100) {
		window.alert(" Error: calculation is not accure!\n Wrong Investment Rate"+val.toFixed(2)+"% : Not in Range!");
		return false;
	}
	return true;
}

function validRP(val) {
	if (val<1 || val>240 || val=="" || !val) {
		window.alert(" Error: calculation is not accure!\n"+val+" months :Repayment Period not in range!\n");
		return false;
	}
	return true;
}

function validFA(val) {
	if (val<0 || val>100000000 || val=="" || !val) {
		window.alert(" Error: calculation is not accure!\n"+val.toFixed(2)+"  :Loan Amount not in range!\n");
		return false;
	}
	return true;
}

function validRV(val) {
	if (val<0 || val>10000000 || val=="" || !val) {
		window.alert(" Error: calculation is not accure!\n"+val.toFixed(2)+"  :Rental Value not in range!\n");
		return false;
	}
	return true;
}

function currencyPattern() {
	var temp=document.getElementById('factoringAmountTemp').value;
	document.getElementById('factoringAmountTemp').value=temp.replace(/\d(?=(\d{3})+\.)/g, '$&,');
}

function validateForm() {
	 var error = 0;
	    var fa = document.getElementById("loanAmount").value;
	    document.getElementById('fa_error').innerHTML = '';
	    if (fa == null || fa == "") {
	        error++;
	        document.getElementById('fa_error').innerHTML = 'Facility Amount must be filled out';
	    }
	    
	    var ir = document.forms["schedule"]["interestRate"].value;
	    document.getElementById('ir_error').innerHTML = '';
	    if (ir == null || ir == "") {
	        error++;
	        document.getElementById('ir_error').innerHTML = 'Rate must be filled out';
	    }
	    
	    var rp = document.forms["schedule"]["loanTerm"].value;
	    document.getElementById('rp_error').innerHTML = '';
	    if (rp == null || rp == "") {
	        error++;
	        document.getElementById('rp_error').innerHTML = 'Period must be filled out';
	    }
	    
	    var rv = document.forms["schedule"]["installment"].value;
	    document.getElementById('rv_error').innerHTML = '';
	    if (rv == null || rv == "") {
	        error++;
	        document.getElementById('rv_error').innerHTML = 'Rental be filled out';
	    }
	    
	   /* var cid = document.forms["schedule"]["client"].value;
	    document.getElementById('cid_error').innerHTML = '';
	    if (cid == null || cid == "") {
	        error++;
	        document.getElementById('cid_error').innerHTML = 'Customer ID be filled out';
	    }*/

	    if(error>0) {
	        return false;
	    }
	    return true;
	
}