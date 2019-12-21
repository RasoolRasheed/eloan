package com.eloan2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eloan2.domain.LStatus;
import com.eloan2.domain.SecurityTypes;
import com.eloan2.service.LStatusService;

@Controller
public class LStatusController {
	@Autowired
	private LStatusService lsService;

	public LStatusService getLsService() {
		return lsService;
	}

	public void setLsService(LStatusService lsService) {
		this.lsService = lsService;
	}

	// View client jsp
	@RequestMapping(path = "/viewLStatus.do", method = RequestMethod.GET)
	public String viewSType(Model model, HttpSession session) {
		if (session.getAttribute("username") == null) {
			return "index"; // return jsp here
		} else {
			model.addAttribute("lsts", new LStatus());
			model.addAttribute("viewLSts", this.lsService.listLStatus());
			return "loanstatus";
		}
	}

	// Create new loan status
	@RequestMapping(value = "/createLStatus.do", method = RequestMethod.POST)
	@ResponseBody
	public String createLStatus(HttpServletRequest req, @RequestParam String lsc, @RequestParam String des,
			HttpServletResponse res) {

		JSONObject jo = new JSONObject();
		LStatus lsts = new LStatus();
		lsts.setLsc(lsc);
		lsts.setDes(des);

		if (lsc.trim().equals("") || lsc.equals(null)) {
			jo.put("error1", "Please fill in the required fields");
			jo.put("error2", "Please fill in the required fields");
			return jo.toString();

		} else if (des.trim().equals("") || des.equals(null)) {
			jo.put("error1", "");
			jo.put("error2", "Please fill in the required fields");
			return jo.toString();

		} else {
			getLsService().createLStatus(lsts);
			jo.put("success", "Loan Status created Successfull");
//			model.addAttribute("success", "User created Successfull");
			return jo.toString();
		}

	}

	// Update loan status
	@RequestMapping(path = "/updateLoanStatus.do", method = RequestMethod.GET)
	@ResponseBody
	public String updateLoanStatus(HttpServletRequest req, @RequestParam int sno, @RequestParam String lsc,
			@RequestParam String des, HttpServletResponse res, Model model) {
		JSONObject stdo = new JSONObject();
		LStatus st = getLsService().getLStatusId(sno);
		
		st.setDes(des);
		st.setLsc(lsc);
		getLsService().updateLStatus(st);
		stdo.put("success", "Updated successfull");
//		stdo.put("viewUser", this.userService.listUsers());
		
		return stdo.toString();
	}

	// Remove Loan status
	@RequestMapping(value = "/removeLStatus.do", method = RequestMethod.GET)
	@ResponseBody
	public String removeLStatus(HttpServletRequest req, @RequestParam int sno, HttpServletResponse res) {

		LStatus st = getLsService().getLStatusId(sno);
		JSONObject stdo = new JSONObject();
		getLsService().removeLStatus(sno);

		stdo.put("success", "Deleted successfull");
		return stdo.toString();
	}
}
