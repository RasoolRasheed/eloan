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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eloan2.dao.ClientDAO;
import com.eloan2.domain.Client;
import com.eloan2.domain.LStatus;
import com.eloan2.domain.SecurityTypes;
import com.eloan2.service.ClientService;
import com.eloan2.service.LStatusService;

@Controller
public class ClientController {
	@Autowired
	private ClientService clnService;

	public ClientService getClnService() {
		return clnService;
	}

	public void setLsService(ClientService clnService) {
		this.clnService = clnService;
	}

	// View client JSP
	@RequestMapping(path = "/client.do", method = RequestMethod.GET)
	public String viewClient(Model model, HttpSession session) {
		if (session.getAttribute("username") == null) {
			// response.sendRedirect("../index.jsp");
			return "index";
		} else {
			model.addAttribute("cln", new Client());
			model.addAttribute("viewClns", this.clnService.listClient());
			return "client";
		}
	}

	// Get client details table
	@RequestMapping(path = "/getClient.do", method = RequestMethod.GET)
	public String getClient() {
		JSONObject jo = new JSONObject();
		List<Client> cln = this.clnService.listClient();
		JSONArray main = new JSONArray();

		for (Client c : cln) {
			JSONArray sub = new JSONArray();
			sub.put(c.getFirstName());
			sub.put(c.getNIC());
			sub.put(c.getClientCode());
			sub.put(c.getContactNo());
			sub.put(c.getAddressLine01());
			sub.put(c.getAddressLine02());
			sub.put(c.getAddressLine03());
			sub.put(c.getAddressLine04());
			sub.put(c.getGender());
			sub.put(c.getSalutation());
			sub.put(c.getInitials());
			sub.put(c.getInitialsinFull());

			main.put(sub);
		}
		jo.put("clnlist", this.clnService.listClient());
		return jo.toString();
	}

	// Create new client
	@RequestMapping(value = "/createClient.do", method = RequestMethod.POST)
	@ResponseBody
	public String createClient(HttpServletRequest req, @RequestParam String NIC, @RequestParam String salutation,
			@RequestParam String initials, @RequestParam String initialsinFull, @RequestParam String firstName,
			@RequestParam String lastName, @RequestParam int contactNo, @RequestParam String addressLine01,
			@RequestParam String addressLine02, @RequestParam String addressLine03, @RequestParam String addressLine04,
			@RequestParam String postalCode, @RequestParam String gender, HttpServletResponse res) {

		JSONObject jo = new JSONObject();
		Client cln = new Client();

		cln.setNIC(NIC);
		cln.setSalutation(salutation);
		cln.setInitials(initials);
		cln.setInitialsinFull(initialsinFull);
		cln.setFirstName(firstName);
		cln.setLastName(lastName);
		cln.setContactNo(contactNo);
		cln.setAddressLine01(addressLine01);
		cln.setAddressLine02(addressLine02);
		cln.setAddressLine03(addressLine03);
		cln.setAddressLine04(addressLine04);
		cln.setPostalCode(postalCode);
		cln.setGender(gender);

		if (NIC.trim().equals("") || NIC.equals(null)) {
			jo.put("error1", "Please fill in the required fields");
			jo.put("error2", "Please fill in the required fields");
			return jo.toString();

		} else if (firstName.trim().equals("") || firstName.equals(null)) {
			jo.put("error1", "");
			jo.put("error2", "Please fill in the required fields");
			return jo.toString();

		} else if (addressLine01.trim().equals("") || addressLine01.equals(null)) {
			jo.put("error1", "");
			jo.put("error2", "Please fill in the required fields");
			return jo.toString();

		} else if (lastName.trim().equals("") || lastName.equals(null)) {
			jo.put("error1", "");
			jo.put("error2", "Please fill in the required fields");
			return jo.toString();

		} else {
			// ClientDAO clnt = (ClientDAO) getClnService().getClientByNIC(NIC);
			// if (clnt.getClntByNIC(NIC) != NIC) {
			getClnService().createClient(cln);
			jo.put("success", "Loan Status created Successfull");
			return jo.toString();
			/*
			 * //} else { //jo.put("error", "Client already exsit"); //return jo.toString();
			 * //}
			 */
		}
	}

//	Check client with NIC
	@RequestMapping(path = "/checkClient.do", method = RequestMethod.GET)
	@ResponseBody
	public String checkClient(@RequestParam String NIC, Model model) {
		JSONObject jo = new JSONObject();

		if (NIC.trim().equals("") || NIC.equals(null)) {
			jo.put("error", "NIC can't be null");
		} else {
			List<Client> clnList = getClnService().getClientByNIC(NIC);
			JSONArray main = new JSONArray();
			for (Client client : clnList) {
				JSONArray sub = new JSONArray();
				sub.put(client.getClientCode());
				sub.put(client.getFirstName());
				sub.put(client.getLastName());
				main.put(sub);
			}
			jo.put("dueList", main);
		}
		return jo.toString();
	}

//	Update Client 
	@RequestMapping(value = "/updateClient.do", method = RequestMethod.GET)
	@ResponseBody
	public String updateClient(HttpServletRequest req, @RequestParam int clientCode, @RequestParam String NIC,
			@RequestParam String salutation, @RequestParam String initials, @RequestParam String initialsinFull,
			@RequestParam String firstName, @RequestParam String lastName, @RequestParam int contactNo,
			@RequestParam String addressLine01, @RequestParam String addressLine02, @RequestParam String addressLine03,
			@RequestParam String addressLine04, @RequestParam String postalCode, @RequestParam String gender,
			HttpServletResponse res) {

		JSONObject jo = new JSONObject();
		Client cln = getClnService().getClientByClientCode(clientCode);

		cln.setNIC(NIC);
		cln.setSalutation(salutation);
		cln.setInitials(initials);
		cln.setInitialsinFull(initialsinFull);
		cln.setFirstName(firstName);
		cln.setLastName(lastName);
		cln.setContactNo(contactNo);
		cln.setAddressLine01(addressLine01);
		cln.setAddressLine02(addressLine02);
		cln.setAddressLine03(addressLine03);
		cln.setAddressLine04(addressLine04);
		cln.setPostalCode(postalCode);
		cln.setGender(gender);

		// ClientDAO clnt = (ClientDAO) getClnService().getClientByNIC(NIC);
		// System.out.println(clnt.getClntByNIC(NIC));
		// if (clnt.getClntByNIC(NIC) != NIC) {
		getClnService().updateClient(cln);
		jo.put("success", "Client updated Successfull");
		return jo.toString();

	}
}
