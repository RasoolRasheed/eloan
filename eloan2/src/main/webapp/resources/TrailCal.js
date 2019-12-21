var facAmou, interest, repayPeriod, rentalVal, errPrint, facAmou_val, interest_val, repayPeriod_val,
rentalVal_val;

$(document).ready(function() { 
	var repaymentSch;
	//repaymentSchedule();
});
function calculate(){
	
	 facAmou = document.getElementById('loanAmount');
	 interest = document.getElementById('interestRate');
	 repayPeriod = document.getElementById('loanTerm');
	 rentalVal = document.getElementById('installment');
	 errPrint = document.getElementById('print');
	 
	 facAmou_val = parseFloat(facAmou.value);
	 interest_val = parseFloat(interest.value);
	 repayPeriod_val = parseFloat(repayPeriod.value);
	 rentalVal_val = parseFloat(rentalVal.value);
	 
	 if (facAmou_val && interest_val && repayPeriod_val && rentalVal_val) {
			errPrint.innerHTML = "One field must be empty!!!";
			rentalVal.value = "";
		} else if (facAmou_val && interest_val && repayPeriod_val) {
			errPrint.innerHTML = "";
			rentalVal.value = calRV(facAmou_val, interest_val, repayPeriod_val).toFixed(2);
			rentalVal_val= calRV(facAmou_val, interest_val, repayPeriod_val);
			
			
		} else if (rentalVal_val && interest_val && repayPeriod_val) {
			errPrint.innerHTML = "";
			facAmou_val = calFA(interest_val, repayPeriod_val, rentalVal_val);
			facAmou.value = calFA(interest_val, repayPeriod_val, rentalVal_val).toFixed(2);
			
		} else if (rentalVal_val && interest_val && facAmou_val) {
			errPrint.innerHTML = "";
			repayPeriod_val = calRP(facAmou_val, interest_val, rentalVal_val);
			repayPeriod.value = calRP(facAmou_val, interest_val, rentalVal_val).toFixed(0);
			
		} else if (facAmou_val && repayPeriod_val && rentalVal_val) {
			errPrint.innerHTML = "";
			interest_val = calIR(facAmou_val, repayPeriod_val, rentalVal_val);
			interest.value = calIR(facAmou_val, repayPeriod_val, rentalVal_val).toFixed(2);
		}
}

function calRV(facAmou, interest, repayPeriod) {
    return ((facAmou * (interest / 100) * 1 / 12) / (1 - (1 / Math.pow(1 + (interest / 100) * 1 / 12, repayPeriod))));
    //I = (F * i * 1 / 12) / (1 - (1 / POWER(1 + i * 1 / 12, n)))
}

function calFA(interest, repayPeriod, rentalVal) {
    //return (rentalVal * (1 - (1 / Math.pow(1 + (interest / 100) * 1 / 12, repayPeriod))) * ((interest / 100) * 1 / 12));
    return ((rentalVal * (1 - (1 / Math.pow((1 + ((interest / 100) / 12)), repayPeriod)))) / ((interest / 100) / 12));
    //F=I*(1-(1/POWER(1+i*1/12,n)))/(i*1/12)					
}

function calRP(facAmou, interest, rentalVal) {
    return Math.round(Math.log10(rentalVal / (rentalVal - (facAmou * (interest / 100) * 1 / 12))) / Math.log10(1 + (interest / 100) * 1 / 12));
    //n=LOG10(I/(I-(F*i*1/12)))/LOG10(1+i*1/12)					
}
function calIR(facAmou, repayPeriod, rentalVal) {
    return ((12 * ((rentalVal * repayPeriod) - facAmou) * ((95 * repayPeriod) + 9)) / (12 * repayPeriod * (repayPeriod + 1) * (4 * facAmou + ((rentalVal * repayPeriod) - facAmou))) * 100);
}

function calShedule() {
	if (!facAmou_val || !interest_val || !repayPeriod_val || !rentalVal_val) {
		errPrint = document.getElementById('print');
		errPrint.innerHTML = "Calculate First!!!";
	}
	else
	shedule(facAmou_val, interest_val, repayPeriod_val, rentalVal_val);
}

var repaymentSch = [];

function shedule(facAmou, interest, repayPeriod, rentalVal) {
    //var capitalBal=facAmou;
    var table = document.getElementById("tblShedule");
    table.innerHTML = "<tr><th>Inst.No</th ><th>Installment Value</th><th>Interest Amount</th><th>Capital Amount</th><th>Capital Balance</th></tr>";
    var investAmou = facAmou * (interest / 100) * 1 / 12;
    var capitalAmou = rentalVal - investAmou;
    var capitalBal = facAmou - capitalAmou;

    var totalRentalVal = 0.0;
    var totalInvestAmou = investAmou;
    var totalCapitalAmou = 0.0;
    totalCapitalAmou -= investAmou;

    for (let x = 1; x <= repayPeriod; x++) {
    	
        var newRow = document.all("tblShedule").insertRow();
        var oCell = newRow.insertCell();
        oCell.innerHTML = x;

        oCell = newRow.insertCell();
        oCell.innerHTML = rentalVal.toFixed(2).replace(/\d(?=(\d{3})+\.)/g, '$&,');

        oCell = newRow.insertCell();
        oCell.innerHTML = investAmou.toFixed(2).replace(/\d(?=(\d{3})+\.)/g, '$&,');

        oCell = newRow.insertCell();
        oCell.innerHTML = capitalAmou.toFixed(2).replace(/\d(?=(\d{3})+\.)/g, '$&,');

        oCell = newRow.insertCell();
        oCell.innerHTML = capitalBal.toFixed(2).replace(/\d(?=(\d{3})+\.)/g, '$&,');
        
        var data={month:x,rentalVal:rentalVal.toFixed(2),investAmou:investAmou.toFixed(2),capitalAmou:capitalAmou.toFixed(2),capitalBal:capitalBal.toFixed(2)};
        repaymentSch.push(data);

        investAmou = capitalBal * (interest / 100) * 1 / 12;
        capitalAmou = rentalVal - investAmou;
        capitalBal = capitalBal - capitalAmou;

        /*repaymentSch.investAmou = investAmou;
        repaymentSch.capitalAmou = capitalAmou;
        repaymentSch.capitalBal = capitalBal;*/
        //repaymentSch.payment = payment;
        
        
        totalRentalVal += parseFloat(rentalVal);
        totalInvestAmou += parseFloat(investAmou);
        totalCapitalAmou += parseFloat(capitalAmou);

    }
    var newRow = document.getElementById("tblShedule").insertRow();
    var oCell = newRow.insertCell();
    oCell.innerHTML = "<b>TOTAL</b>";

    oCell = newRow.insertCell();
    oCell.innerHTML = "<b id=\"totRental\">" + totalRentalVal.toFixed(2).replace(/\d(?=(\d{3})+\.)/g, '$&,') + "</b>";
    oCell = newRow.insertCell();
    oCell.innerHTML = "<b id=\"totInvest\">" + totalInvestAmou.toFixed(2).replace(/\d(?=(\d{3})+\.)/g, '$&,') + "</b>";
    oCell = newRow.insertCell();
    oCell.innerHTML = "<b id=\"defVal\">" + totalCapitalAmou.toFixed(2).replace(/\d(?=(\d{3})+\.)/g, '$&,') + "</b>";

    var totRental = document.getElementById("totRental");
    totRental.innerHTML = totalRentalVal.toFixed(2).replace(/\d(?=(\d{3})+\.)/g, '$&,');
    var totInvest = document.getElementById("totInvest");
    totInvest.innerHTML = totalInvestAmou.toFixed(2).replace(/\d(?=(\d{3})+\.)/g, '$&,');
    var totInvest = document.getElementById("defVal");
    totInvest.innerHTML = (totalRentalVal - totalInvestAmou).toFixed(2).replace(/\d(?=(\d{3})+\.)/g, '$&,');

}

function unformatNo(val){
	if(val.match(/[^\,\.0-9]+/g)){
		return "NaN";
	}else{	
		return parseFloat(parseFloat(val.replace(/,/g ,'')).toFixed(2));
	}
}

function repaymentSchedule(){
    //var action = "Save_repaymentSch";
    // var jsonString = JSON.stringify(repaymentSchs);
    //console.log('repaymentSch',repaymentSchs);
}