package com.eloan2.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

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

import com.eloan2.domain.Users;
import com.eloan2.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	// view Signup jsp
	@RequestMapping(path = "/goToRegister.do", method = RequestMethod.GET)
	public String viewRegister(Model model) {
		System.out.println(System.getProperty("user.name"));
		model.addAttribute("user", new Users());
		model.addAttribute("viewUser", this.userService.listUsers());
		return "signup";
	}

	// Create User
	@RequestMapping(path = "/createUser.do", method = RequestMethod.POST)
	@ResponseBody
	public String createUser(HttpServletRequest req, @RequestParam String firstname, @RequestParam String lastname,
			@RequestParam String username, @RequestParam String gender, @RequestParam String contactno,
			@RequestParam String nic, @RequestParam String password, HttpServletResponse res, Model model) {
		JSONObject jo = new JSONObject();

		Users users = new Users();
		users.setUsername(username);
		users.setPassword(password);
		users.setFirstname(firstname);
		users.setLastname(lastname);
		users.setNic(nic);
		users.setGender(gender);

		if (contactno.equals("") || contactno.equals(null)) {
			jo.put("contactError", "Contact fill is required field");
		} else {
			int contactNo = Integer.parseInt(contactno);
			users.setContactno(contactNo);
		}
		if (username.trim().equals("") || username.equals(null) || password.trim().equals("") || password.equals(null)
				|| firstname.trim().equals("") || firstname.equals(null) || lastname.trim().equals("")
				|| lastname.equals(null) || nic.trim().equals("") || nic.equals(null) || contactno.equals("")
				|| contactno.equals(null)) {
			jo.put("error2", "Please fill in the required fields");
			return jo.toString();
		} else if (password.trim().equals("") || password.equals(null)) {
			jo.put("error1", "");
			jo.put("error2", "Please fill in the required fields");
			return jo.toString();
		} else {
			getUserService().createUser(users);
			jo.put("success", "User created Successfull");
			return jo.toString();
		}
	}

	// View users list
	@RequestMapping(value = "/viewUser.do", method = RequestMethod.GET)
	public String viewUser(Model model) {
		model.addAttribute("user", new Users());
		model.addAttribute("viewUser", this.userService.listUsers());
		return "user";
	}

	// Edit users
	@RequestMapping(value = "/edit/{id}.do", method = RequestMethod.GET)
	public String editUser(@PathVariable("id") int id, Model model) {
		model.addAttribute("user", this.userService.getStudentById(id));
		model.addAttribute("viewUser", this.userService.listUsers());
		return "user";
	}

	// Update User
	@RequestMapping(path = "/updateUser.do", method = RequestMethod.GET)
	@ResponseBody
	public String updateUser(HttpServletRequest req, @RequestParam int id, @RequestParam String username,
			@RequestParam String password, HttpServletResponse res, Model model) {
		JSONObject stdo = new JSONObject();
		Users st = getUserService().getStudentById(id);
		System.out.println(st.getId());
		st.setUsername(username);
		st.setPassword(password);
		getUserService().updateUsers(st);
		stdo.put("success", "Updated successfull");

		return stdo.toString();
	}

	// Delete User
	@RequestMapping(value = "/remove/{id}.do", method = RequestMethod.GET)
//		@ResponseBody
	public String removeUser(@PathVariable("id") int id) {
		Users st = getUserService().getStudentById(id);
		System.out.println(st.getId());
		userService.removeStudent(id);
//			return "redirect:/persons.ru";
		return "redirect:/goToRegister.do";
	}

}
