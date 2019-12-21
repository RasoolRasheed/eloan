//
//package com.eloan2.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.eloan2.serviceimpl.FacilityServiceImpl;
//
//@Controller
//public class FacilityController {
//
//	@Autowired
//	private FacilityServiceImpl fcltyService;
//
//	public FacilityServiceImpl getFcltyService() {
//		return fcltyService;
//	}
//
//	public void setFcltyService(FacilityServiceImpl fcltyService) {
//		this.fcltyService = fcltyService;
//	}
//
//	@RequestMapping(path = "/receipt.do", method = RequestMethod.GET) 
//	public String receipt(Model model) { 
//		// model.addAttribute("appsl", new LAppraisal()); 
//		// model.addAttribute("listApprsl", this.lappslsvce.listAppraisals()); 
//		return "receipt"; 
//	}
//	
//}
