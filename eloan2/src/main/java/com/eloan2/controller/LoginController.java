package com.eloan2.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.eloan2.domain.Users;
import com.eloan2.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	public LoginService loginService;

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	// View Dashboard jsp
	@RequestMapping(value = "/dashboard.do", method = RequestMethod.GET)
	public String viewDashboard(HttpSession session) {
		if (session.getAttribute("username") == null) {
			// response.sendRedirect("../index.jsp");
			return "index";
		} else {
			return "dashboard";
		}
	}

//	Logout Process
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String Logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "index";
	}

	// Login Process
	@RequestMapping(value = "/loginProcess.do", method = RequestMethod.POST)
	public String processForm(HttpServletRequest request, @RequestParam String username, @RequestParam String password,
			HttpServletResponse response, Model model, HttpSession session, Locale locale) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		try {
			// Check User availability
			boolean userExists = loginService.checkLogin(username, password);
			
			  Users userRole = loginService.getGroupCodeByUser(username);
			  System.out.println(userRole.getGcode().getGroupCode());
			  
			  
			if (userExists) {
				session.setAttribute("username", username);
				session.setAttribute("formattedDate", date);
				session.setAttribute("grpCode", userRole.getGcode().getGroupCode());
				// session.setAttribute("groupcode",usr.getGcode());
				model.addAttribute("username", username);
				model.addAttribute("success", "Login Success !");
				return "navigation";
			} else {
				model.addAttribute("error", "Username/Password Incorrect");
				return "index";
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return ex.getMessage();
		}

	}
}
