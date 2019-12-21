package com.eloan2.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eloan2.domain.LStatus;

@Controller
public class PaymentController {
	
	@RequestMapping(path = "/payment.do", method = RequestMethod.GET)
	public String viewPayment(Model model,HttpSession session) {
		if(session.getAttribute("username")== null) {
			return "index"; // return jsp here
		}else {
			return "payment";
		}
		
	}
}
