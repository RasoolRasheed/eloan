<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<link rel="icon" type="image/png" href="resources/openarc.jpg">
<title>Loan Hub</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- CSS -->
<link type="text/css" rel="stylesheet" href="resources/nav.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

 <!-- jQuery CDN - Slim version (=without AJAX) -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<!-- Popper.JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
	integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
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

<!-- Font Awesome JS -->
<script defer
	src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js"
	integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ"
	crossorigin="anonymous"></script>
<script defer
	src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js"
	integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY"
	crossorigin="anonymous">
</script>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<%-- <c:otherwise> --%>
 
<!--     //menu for all othe users all other users -->
 
<%-- </c:otherwise> --%>
</head>
<body>
<input type="hidden" name="username" id="username" value="${username}"/>
<input type="hidden" name="userRole" id="userRole" value="${grpCode}"/>

	<div class="wrapper">
		<!-- Sidebar  -->
		<nav id="sidebar">
			<button type="button" id="sidebarCollapse" class="btn btn-info" id="navBtn">
				<i class="fas fa-align-left"></i> <span></span>
			</button>
			<div class="sidebar-header">
<!--  			<img alt="loanhubLogo"  width="auto" height="50px" src="resources/loanhub.png"> -->
				<!--  <h3>E-loan System</h3>-->
				<strong>LH</strong>
			</div>

			<ul class="list-unstyled components">
				<li class="active"><a href="#homeSubmenu"
					data-toggle="collapse" aria-expanded="false"
					class="dropdown-toggle" > <i class="fas fa-home"></i> Reference
				</a>
					<ul class="collapse list-unstyled" id="homeSubmenu">
						<li><a href="http://localhost/eloan/LoanTypes.php" target="frame1"><span class="glyphicon glyphicon-file"></span> Loan Types</a></li>
						<li><a href="http://localhost/eloan/LoanSchemes.php" target="frame1"><span class="glyphicon glyphicon-file"></span> Loan Schemes</a></li>
						<li><a href="http://localhost/eloan/adminDivision.php" target="frame1"><span class="glyphicon glyphicon-file"></span> Administrative Division</a></li>
						<li><a href="http://localhost/eloan/userGroup.php" target="frame1"><span class="glyphicon glyphicon-file"></span> User Groups</a></li>
						<li><a href="viewStype.do" target="frame1"><span class="glyphicon glyphicon-file"></span> Security Types</a></li>	
						<li><a href="viewLStatus.do" target="frame1"><span class="glyphicon glyphicon-file"></span>Loan status</a></li>
					</ul></li>
					
				<li><a href="#pageSubmenu1" data-toggle="collapse"
					aria-expanded="false" class="dropdown-toggle" id="front"> <i
						class="fas fa-briefcase"></i> Front Office
				</a>
					<ul class="collapse list-unstyled" id="pageSubmenu1">
						 <li>
<!-- 							<a href="http://localhost/eloan/clientRegistration.php"target="frame1"><span class="glyphicon glyphicon-file"></span>Client Registration</a> -->
								<a href="client.do"target="frame1"><span class="glyphicon glyphicon-file"></span>Client Registration</a>
						</li> 
						<li>
							<a href="http://localhost/eloan/trialCal.php"target="frame1"><span class="glyphicon glyphicon-file"></span> Trial Calculation</a>
						</li>
						<li>
						<li><a href="viewTC.do"
							target="frame1"><span class="glyphicon glyphicon-file"></span> Trial Calculation - Goal Seek</a>
						</li>
						<li>
							<a href="http://localhost/eloan/applicationEntry.php" target="frame1"><span class="glyphicon glyphicon-file"></span> Application Entry</a>
						</li>
						<li>
							<a href="receipt.do"
								target="frame1"><span class="glyphicon glyphicon-file"></span> Receipt</a>
						</li>
						<li>
							<a href="payment.do"
							target="frame1"><span class="glyphicon glyphicon-file"></span> Payment</a>
						</li>
						
					</ul></li>
				<li><a href="#pageSubmenu2" data-toggle="collapse"
					aria-expanded="false" class="dropdown-toggle" id="busFlow"> <i
						class="fas fa-copy"></i> 4. Business Flow
				</a>
					<ul class="collapse list-unstyled" id="pageSubmenu2">
						<li><a href="http://localhost/eloan/submitForAproval.php" target="frame1"><span class="glyphicon glyphicon-file"></span> Loan Appraisal</a></li>
						<li><a href="http://localhost/eloan/loanApprovals.php" target="frame1"><span class="glyphicon glyphicon-file"></span> Approval</a></li>
						<li><a href="appraisal.do" target="frame1"><span class="glyphicon glyphicon-file"></span> Approvals with Dual
								control </a></li>
						<li><a href="viewActivation.do" target="frame1"><span class="glyphicon glyphicon-file"></span>Loan Activation</a></li>
						<li><a href="payment.do" target="frame1"><span class="glyphicon glyphicon-file"></span> Loan Disbursements</a></li>
						<li><a href="viewCollection.do" target="frame1"><span class="glyphicon glyphicon-file"></span> Loan Collections</a></li>
					</ul></li>
				<li><a href="#pageSubmenu3" data-toggle="collapse"
					aria-expanded="false" class="dropdown-toggle" id="facMaintain"> <i
						class="fas fa-copy"></i> 5. Facility Maintenance
				</a>
					<ul class="collapse list-unstyled" id="pageSubmenu3">
						<li><a href="viewCollection.do" target="frame1"><span class="glyphicon glyphicon-file"></span> Day End process</a></li>
						<li><a href="viewCollection.do" target="frame1"><span class="glyphicon glyphicon-file"></span> Loan
								Re-schedulements</a></li>
						<li><a href="viewCollection.do" target="frame1"><span class="glyphicon glyphicon-file"></span> Loan Closures</a></li>
					</ul></li>
				<li><a href="#pageSubmenu4" data-toggle="collapse"
					aria-expanded="false" class="dropdown-toggle" id="rcvy"> <i
						class="fas fa-copy"></i> 6. Recoveries
				</a>
					<ul class="collapse list-unstyled" id="pageSubmenu4">
						<li><a href="viewCollection.do" target="frame1"><span class="glyphicon glyphicon-file"></span> Reminders</a></li>
						<li><a href="viewCollection.do" target="frame1"><span class="glyphicon glyphicon-file"></span> Terminations</a></li>
					</ul></li>
				<li><a href="#pageSubmenu5" data-toggle="collapse"
					aria-expanded="false" class="dropdown-toggle" id="infCenter"> <i
						class="fas fa-copy"></i> 7. Information Center
				</a>
					<ul class="collapse list-unstyled" id="pageSubmenu5">
						<li><a href="dashboard.do" target="frame1"><span class="glyphicon glyphicon-file"></span> Loan Pipeline
								Information </a></li>
						<li><a href="viewCollection.do" target="frame1"><span class="glyphicon glyphicon-file"></span> Loan Account
								Statements</a></li>
						<li><a href="viewCollection.do" target="frame1"><span class="glyphicon glyphicon-file"></span> Managers Screen</a></li>
					</ul></li>
				<li><a href="#pageSubmenu6" data-toggle="collapse"
					aria-expanded="false" class="dropdown-toggle" id="report"> <i
						class="fas fa-copy"></i> 8. Report Center
				</a>
					<ul class="collapse list-unstyled" id="pageSubmenu6">
						<li><a href="viewCollection.do" target="frame1"><span class="glyphicon glyphicon-file"></span> Loan Approvals &
								Disbursement Report</a></li>
						<li><a href="viewCollection.do" target="frame1"><span class="glyphicon glyphicon-file"></span> Loan Portfolio
								Status Report </a></li>
						<li><a href="viewCollection.do" target="frame1"><span class="glyphicon glyphicon-file"></span> Collections Report </a>
						</li>
						<li><a href="viewCollection.do" target="frame1"><span class="glyphicon glyphicon-file"></span> Interest Income
								Report </a></li>
						<li><a href="viewCollection.do" target="frame1"><span class="glyphicon glyphicon-file"></span> Age Analysis </a></li>
					</ul></li>
			</ul>
		</nav>
		<!-- Page Content  -->
		<div id="content">

			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<div class="navhub">
				
					<p>hi &nbsp <span class="glyphicon glyphicon-user"></span>${username}  &nbsp<span class="glyphicon glyphicon-bell"></span> ${serverTime}</p>
					
				</div>
				<a class="button" href="logout.do">Logout</a>
			</nav>
			<div id="iframe" >
				<iframe name="frame1" width="100%" frameBorder="0" height="475px" src="dashboard.do"></iframe>
				<p style="color:blcak" class="navbar navbar-expand-lg navbar-light bg-light">Openarc Systems & Management Pvt(Ltd). Developed By Rasool
					Rasheed &c 2019</p>
				
			</div>
		</div>
	</div>
	<script type="text/javascript">
        $(document).ready(function () {
        	 
        	var username=$('#username').val();
        	var userRole=$('#userRole').val();
       		alert(userRole);
       		
        	if(userRole == "ADM"){
        		$('#front').prop("disabled", false);
               } else{
               	//$('#front').toggleClass('disabled');
            	   $('#front').prop("disabled", true);
            	   $('#busFlow').prop("disabled", true);
            	   $('#facMaintain').prop("disabled", true);
            	   $('#infCenter').prop("disabled", true);
            	   $('#report').prop("disabled", true);
               }
            $('#sidebarCollapse').on('click', function () {
            	$('#sidebar').toggleClass('active');
            });
            
        });
    </script>
 <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-sm">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Modal Header</h4>
        </div>
        <div class="modal-body">
          <p>This is a small modal.</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>