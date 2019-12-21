package com.eloan2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eloan2.domain.Due;
import com.eloan2.service.ActivationService;

@Controller
public class ActivationController {
	@Autowired
	private ActivationService activationService;
	
	public ActivationService getActivationService() {
		return activationService;
	}
	public void setActivationService(ActivationService activationService) {
		this.activationService = activationService;
	}

//	Get Activating View
	@RequestMapping(path = "/viewActivation.do", method = RequestMethod.GET)
	public String viewActivation(Model model,HttpSession session) {
		if(session.getAttribute("username") == null) {
			//response.sendRedirect("../index.jsp");
			return "index";
		}else {
			return "activation";
		}	
	}
	
//	Get Collection View
	@RequestMapping(path = "/viewCollection.do", method = RequestMethod.GET)
	public String viewCollection(Model model,HttpSession session) {
		if(session.getAttribute("username") == null) {
			//response.sendRedirect("../index.jsp");
			return "index";
		}else {
			return "collections";
		}	
	}
	
//	Activating Application
	@RequestMapping(path = "/activeLoan.do", method = RequestMethod.POST)
	@ResponseBody
	public String activeLoan(HttpServletRequest req,
			@RequestParam int fno,Model model,
			HttpServletResponse res) {
		Due due= new Due();
		boolean arriesBalanceZero=getActivationService().checkBalance(fno);
		//arriesBalanceZero = getActivationService().checkBalance(fno);
		System.out.println(arriesBalanceZero);
		if(arriesBalanceZero) {
			//System.out.println(arriesBalanceZero);
			model.addAttribute("success", "Loan Active Successful ");
			return "True";
		}
		return "faild";
	}
}
