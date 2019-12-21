package com.eloan2.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eloan2.domain.SecurityTypes;
import com.eloan2.service.SecurityTypesService;

@Controller
public class SecurityTypeController {
	@Autowired
	private SecurityTypesService stService;

	public SecurityTypesService getStService() {
		return stService;
	}

	public void setStService(SecurityTypesService stService) {
		this.stService = stService;
	}

	// View security type JSP
	@RequestMapping(path = "/viewStype.do", method = RequestMethod.GET)
	public String viewSType(Model model, HttpSession session) {
		if (session.getAttribute("username") == null) {
			return "index";
		} else {
			model.addAttribute("stype", new SecurityTypes());
			model.addAttribute("viewSecurityType", this.stService.listSecurityTypes());
			return "securitytype";
		}
	}

	// View Security Type table
	@RequestMapping(path = "/viewStypeTable.do", method = RequestMethod.GET)
	@ResponseBody
	public String viewSecurityType(SecurityTypes stypes, Model model) {
		JSONObject jo = new JSONObject();
		jo.put("stypes", new SecurityTypes());

		List<SecurityTypes> styp = this.stService.listSecurityTypes();
		JSONArray main = new JSONArray();
		for (SecurityTypes stype : styp) {
			JSONArray sub = new JSONArray();
			sub.put(stype.getId());
			sub.put(stype.getStc());
			sub.put(stype.getDescription());
			main.put(sub);
		}
		jo.put("stype", new SecurityTypes());
		jo.put("listSecurityTypes", main);
		return jo.toString();
	}

	// Create new Security Type
	@RequestMapping(value = "/createSecurityTypes.do", method = RequestMethod.POST)
	@ResponseBody
	public String createSecurityTypes(HttpServletRequest req, @RequestParam String stc,
			@RequestParam String description, HttpServletResponse res) {
		JSONObject jo = new JSONObject();
		SecurityTypes st = new SecurityTypes();
		st.setStc(stc);
		st.setDescription(description);

		if (stc.trim().equals("") || stc.equals(null)) {
			jo.put("error1", "* Please fill in the required fields");
			jo.put("error2", "* Please fill in the required fields");
			return jo.toString();

		} else if (description.trim().equals("") || description.equals(null)) {
			jo.put("error1", "");
			jo.put("error2", "Please fill in the required fields");
			return jo.toString();

		} else {
			getStService().createSecurityTypes(st);
			jo.put("success", "User created Successfull");
			return jo.toString();
		}
	}

	@RequestMapping(path = "/updateSecurityTypes.do", method = RequestMethod.GET)
	@ResponseBody
	public String updateUser(HttpServletRequest req, @RequestParam int id, @RequestParam String stc,
			@RequestParam String description, HttpServletResponse res, Model model) {
		JSONObject stdo = new JSONObject();
		SecurityTypes st = getStService().getSecurityTypesId(id);
		st.setStc(stc);
		st.setDescription(description);
		getStService().updateSecurityTypes(st);
		stdo.put("success", "Updated successfull");
//		stdo.put("viewUser", this.userService.listUsers());
		return stdo.toString();
	}

	// Remove Security Type
	@RequestMapping(value = "/removeStype/{id}.do", method = RequestMethod.GET)
	public String removeSecurityType(HttpServletRequest req, @PathVariable("id") int id, HttpServletResponse res) {
		SecurityTypes st = getStService().getSecurityTypesId(id);
		JSONObject stdo = new JSONObject();
		System.out.println(st.getId());
		stService.removeSecurityTypes(id);
		stdo.put("success", "Deleted successfull");
		return "redirect:/viewStype.do";

	}
	
	//@GetMapping("/stype")
	@RequestMapping(value = "/stype.do", method = RequestMethod.GET)
	public ResponseEntity<String> securityType(String data){
		List<SecurityTypes> st = getStService().listSecurityTypes();
		JSONObject jo = new JSONObject();
		jo.put("s", st);
		return new ResponseEntity<>(jo.toString(),HttpStatus.OK);
	}
}
