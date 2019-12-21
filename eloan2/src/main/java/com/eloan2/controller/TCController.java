package com.eloan2.controller;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.eloan2.domain.LAppraisal;
import com.eloan2.domain.RentalSchedule;
import com.eloan2.domain.TC;
import com.eloan2.service.TCService;

@Controller
public class TCController {
	@Autowired
	private TCService tcService;

	public TCService getTcService() {
		return tcService;
	}

	public void setTcService(TCService tcService) {
		this.tcService = tcService;
	}

	@RequestMapping(path = "/viewTC.do", method = RequestMethod.GET)
	public String viewTC(HttpSession session) {
		if (session.getAttribute("username") == null) {
			return "index"; // return jsp here
		} else {
			return "tc";
		}
	}

	// Create Trial Calculation
	@RequestMapping(path = "/createTC.do", method = RequestMethod.POST)
	public String createTC(HttpServletRequest req, @RequestParam String Amount, @RequestParam String Period,
			@RequestParam String Rate, @RequestParam String Installment, @RequestParam int clientCode,
			HttpServletResponse res, HttpSession session) {

		TC tc = new TC();
		LAppraisal lapp = new LAppraisal();
		lapp.setCurrentStatus("JC");
		// lapp.setClient(req.getParameter(clientCode));
		if (Amount != null && Period != null && Rate != null && Installment != null) {
			tc.setAmount(Double.parseDouble(Amount));
			tc.setPeriod(Integer.parseInt(Period));
			tc.setRate(Double.parseDouble(Rate));
			tc.setInstallment(Double.parseDouble(Installment));
			tc.setClientCode(clientCode);
			tc.setCreatedBy(session.getAttribute("username").toString());
			// tc.setCreatedDate((Timestamp) session.getAttribute("formattedDate"));
		}
		JSONObject jo = new JSONObject();

		if (Amount == null || Amount.equals("") || clientCode == 0) {
			jo.put("error", "TC not saved");
		} else {
			getTcService().createTC(tc);
			jo.put("Success", "TC saved successful");
		}
		return jo.toString();
	}

	// Rental Shedule creation
	@RequestMapping(path = "/saveReshedule.do", method = RequestMethod.POST)
	public String saveReshedule(HttpServletRequest req, @RequestParam String a, @RequestParam int clientCode,
			HttpServletResponse res) throws ParseException {
		System.out.println(a);

		JSONObject jsnobject = new JSONObject(a);
		JSONArray jsonArray = jsnobject.getJSONArray("schedule");
		
		/*
		 * TC tc = getTcService().getTCNOByClientCode(clientCode);
		 * System.out.println(tc.getTCNo());
		 */
		 

		RentalSchedule rs = new RentalSchedule();
		Calendar c = new GregorianCalendar();
		// c.add(Calendar.DATE, 30);
		if (c.get(Calendar.DATE) > 28) {
			c.set(Calendar.DATE, 28);
		}
		c.add(Calendar.MONTH, 1);
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject explrObject = jsonArray.getJSONObject(i);
			System.out.println(explrObject.get("month"));
			System.out.println("");

			System.out.println(explrObject.get("rentalVal"));
			System.out.println("");

			System.out.println(explrObject.get("investAmou"));
			System.out.println("");

			System.out.println(explrObject.get("capitalAmou"));
			System.out.println("");

			System.out.println(explrObject.get("capitalBal"));

			// Object month = explrObject.get("month");
			int months = Integer.parseInt(explrObject.get("month").toString());
			Double installmentamount = Double.parseDouble(explrObject.get("rentalVal").toString());

			Double interest = Double.parseDouble(explrObject.get("investAmou").toString());
			Double capitalamount = Double.parseDouble(explrObject.get("capitalAmou").toString());
			Double capitalbalance = Double.parseDouble(explrObject.get("capitalBal").toString());
			Date d = c.getTime();

			// int maxDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
			System.out.println(d);

			rs.setRentalNo(months);
			rs.setInstallmentamount(installmentamount);
			rs.setInterest(interest);
			rs.setCapitalamount(capitalamount);
			rs.setCapitalbalance(capitalbalance);
			rs.setDueDate(d);
			// c.add(Calendar.DATE, 30);
			c.add(Calendar.MONTH, 1);
			getTcService().saveSchedule(rs);
			jsnobject.put("Success", "Rental shedule saved");
		}
		return jsnobject.toString();
	}

}
