package com.eloan2.controller;

import java.sql.Date;
import java.sql.Timestamp;
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
import org.springframework.web.bind.annotation.SessionAttribute;

import com.eloan2.domain.Due;
import com.eloan2.domain.OverPay;
import com.eloan2.domain.Receipt;
import com.eloan2.domain.SecurityTypes;
import com.eloan2.service.ReceiptService;

@Controller
public class ReceiptController {
	@Autowired
	private ReceiptService rcptService;

	public ReceiptService getRcptService() {
		return rcptService;
	}

	public void setRcptService(ReceiptService rcptService) {
		this.rcptService = rcptService;
	}
	
	@RequestMapping(path = "/receipt.do", method = RequestMethod.GET) 
	public String receipt(Model model,HttpSession session) { 
		if(session.getAttribute("username") == null) {
			//response.sendRedirect("../index.jsp");
			return "index";
		}else {
			return "receipt"; 
		}	
	}
	
	@RequestMapping(path = "/receiptDue.do", method = RequestMethod.GET)
	@ResponseBody
	public String viewDues(@RequestParam int fno,Model model) {
		JSONObject jo = new JSONObject();
//		Due du = getRcptService().getDuesById(fno);
		  List<Due> dueList = getRcptService().getDuesById(fno); 
		  JSONArray main = new JSONArray(); 
		  for(Due due: dueList){ 
			  JSONArray sub = new JSONArray();
			  sub.put(due.getId());
			  sub.put(due.getPaymentType());
			  sub.put(due.getDue()); 
			  sub.put(due.getPayment());
			  sub.put(due.getDue() - due.getPayment());

			  main.put(sub); 
		  }
		  jo.put("dueList", main);
		return jo.toString();
	}
	
//	Payment Updating 
	@RequestMapping(path = "/updatePayment.do", method = RequestMethod.GET)
	@ResponseBody
	public String updatePayment(HttpServletRequest req,
			@RequestParam int id, 
			@RequestParam int fno, 
			@RequestParam double payment,@RequestParam String paymentmode,
			HttpServletResponse res, Model model,HttpSession session) {
		System.out.println("sd");
		JSONObject stdo = new JSONObject();
		Due du = getRcptService().getDuesId(id);
		Receipt rcpt = new Receipt();

		double arrears = du.getDue() - du.getPayment();
		rcpt.setDueId(du.getId());
		rcpt.setPaymentmode(paymentmode);
		rcpt.setFno(fno);
		if(arrears >= payment) {
			rcpt.setAmt(payment);
			
			getRcptService().createReceipt(rcpt);
			du.setPayment(du.getPayment()+payment);
			getRcptService().updatePayment(du);
			
			stdo.put("success", "Payment successfull completed");
		}else {
			rcpt.setAmt(payment);
			double overpay = (double) (payment-arrears);
			getRcptService().createReceipt(rcpt);
			
			du.setPayment(du.getPayment()+arrears);
			getRcptService().updatePayment(du);
			
			OverPay op = new OverPay();
			op.setAmt(overpay);
			op.setFno(fno);
			op.setRcptNo(rcpt.getRcptNo());
			getRcptService().overPay(op);
			
			stdo.put("success", "Overpayment Updated successfull");
		}
		return stdo.toString();
	}
	
//	Print Receipt
	@RequestMapping(path = "/receiptPrint.do", method = RequestMethod.GET)
	@ResponseBody
	public String receiptPrint(@RequestParam int fno,Model model) {
		 String res = getRcptService().getAllById(fno);
		return res;
	}
}
