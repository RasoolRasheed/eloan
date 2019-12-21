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


<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>

<title>Insert title here</title>
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

	$(document).ready(function() { 
		Highcharts.chart('container', {
			  chart: {
			    plotBackgroundColor: null,
			    plotBorderWidth: null,
			    plotShadow: false,
			    type: 'pie'
			  },
			  title: {
			    text: 'Loan Pipeline Information, 2019'
			  },
			  tooltip: {
			    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
			  },
			  plotOptions: {
			    pie: {
			      allowPointSelect: true,
			      cursor: 'pointer',
			      dataLabels: {
			        enabled: true,
			        format: '<b>{point.name}</b>: {point.percentage:.1f} %',
			        style: {
			          color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
			        }
			      }
			    }
			  },
			  series: [{
			    name: 'Brands',
			    colorByPoint: true,
			    data: [{
			      name: 'Approved',
			      y: 61.41,
			      sliced: true,
			      selected: true
			    }, {
			      name: 'Activated',
			      y: 11.84
			    }, {
			      name: 'Feasilitated',
			      y: 10.85
			    }, {
			      name: 'Just Created',
			      y: 4.67
			    }, {
			      name: 'Submitted',
			      y: 4.18
			    }, {
			      name: 'Appraisaled',
			      y: 1.64
			    }, {
			      name: 'Rejected',
			      y: 1.6
			    }, {
			      name: 'Cancelled',
			      y: 1.2
			    }, {
			      name: 'Closed',
			      y: 2.61
			    }]
			  }]
			});
		
	   
	});

	

</script>
</head>
<body>

<div id="container" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div>

</body>
</html>