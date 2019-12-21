package com.eloan2.service;

import java.util.List;

import com.eloan2.domain.Due;
import com.eloan2.domain.OverPay;
import com.eloan2.domain.Receipt;

public interface ReceiptService {
//	public Due listDues(int fno);
	public void createReceipt(Receipt rcpt);
	public List<Due> getDuesById(int fno);
	public void updatePayment(Due due);
	public Due getDuesId(int id);
	public void overPay(OverPay op);
	public Receipt getReceiptId(int fno);
	public String getAllById(int fno);
	public Due getPaymentBYId(int id);
}
