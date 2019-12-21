package com.eloan2.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eloan2.domain.Due;
import com.eloan2.domain.Facility;
import com.eloan2.domain.LAppraisal;
import com.eloan2.domain.TC;
import com.eloan2.service.LAppraisalService;

@Controller
public class AppraisalController {
	@Autowired
	private LAppraisalService lappslsvce;

	public LAppraisalService getLappslsvce() {
		return lappslsvce;
	}

	public void setLappslsvce(LAppraisalService lappslsvce) {
		this.lappslsvce = lappslsvce;
	}

	@RequestMapping(path = "/appraisal.do", method = RequestMethod.GET)
	public String viewAppraisal(Model model, HttpSession session) {
		if (session.getAttribute("username") == null) {
			return "index";
		} else {
			model.addAttribute("appsl", new LAppraisal());
			model.addAttribute("listApprsl", this.lappslsvce.listAppraisals());
			return "appraisal";
		}
	}

//	View TC Details
	@RequestMapping(path = "/viewMore.do", method = RequestMethod.GET)
	@ResponseBody
	public String viewMore(HttpServletRequest req, @RequestParam int TCNo, Model model, HttpServletResponse res) {
		JSONObject jo = new JSONObject();

		List<TC> tclist = this.lappslsvce.listTc(TCNo);
		JSONArray main = new JSONArray();
		for (TC tc : tclist) {
			JSONArray sub = new JSONArray();
			sub.put(tc.getLoanTypeCode());
			sub.put(tc.getAmount());
			sub.put(tc.getPeriod());
			sub.put(tc.getRate());
			sub.put(tc.getInstallment());
			main.put(sub);
		}
		jo.put("listTC", this.lappslsvce.listTc(TCNo));

		return jo.toString();
	}

//	Initiating Application
	@RequestMapping(path = "/initiateApp.do", method = RequestMethod.POST)
	@ResponseBody
	public String initiateApp(HttpServletRequest req, @RequestParam int applicationNo, @RequestParam int clientCode,
			@RequestParam int TCNo, HttpServletResponse res, Model model, HttpSession session) {
		JSONObject jo = new JSONObject();
		Facility fclty = new Facility();

		fclty.setApplicationNo(applicationNo);
//		fclty.setClient(client.clientCode);
		fclty.setLoanStatus("I");
		fclty.setTCNo(TCNo);
		getLappslsvce().initiateApp(fclty);

		LAppraisal lapsl = getLappslsvce().getAppStatusByTCNo(TCNo);
		lapsl.setCurrentStatus("F");
		getLappslsvce().updateSecurityTypes(lapsl);
		Due due = new Due();

		due.setFno(fclty.getFno());
		due.setPaymentType("Prepayments");
		due.setDue(2500);
		String username = session.getAttribute("username").toString();
		due.setCreatedBy(username);
		getLappslsvce().addPrepayments(due);
		System.out.println(fclty.getFno());

		jo.put("success", "Application intiated Successfull");
		jo.put("fno", "Facility No : " + fclty.getFno());
		return jo.toString();
	}

	/*
	 * @RequestMapping(path = "/prepaymentCharge.do", method = RequestMethod.POST)
	 * 
	 * @ResponseBody public String prepaymentCharge(HttpServletRequest req,
	 * 
	 * @RequestParam int applicationNo, HttpServletResponse res, Model model) {
	 * JSONObject jo = new JSONObject();
	 * 
	 * 
	 * jo.put("success", "Application intiated Successfull"); return jo.toString();
	 * }
	 */

//	Cancel Application
	@RequestMapping(path = "/cancelApp.do", method = RequestMethod.POST)
	@ResponseBody
	public String cancelApp(HttpServletRequest req, @RequestParam int TCNo, @RequestParam String remark,
			HttpServletResponse res, Model model) {
		JSONObject jo = new JSONObject();

		LAppraisal lapsl = getLappslsvce().getAppStatusByTCNo(TCNo);
		if (remark.equals(null) || remark.trim().equals("")) {
			jo.put("error2", "Application can't Cancel without remark");
			return jo.toString();
		} else {
			lapsl.setRemark(remark);
			lapsl.setCurrentStatus("C");
			getLappslsvce().updateSecurityTypes(lapsl);
			jo.put("success", "Application Cancelled Successfull");
			return jo.toString();
		}
	}

}
