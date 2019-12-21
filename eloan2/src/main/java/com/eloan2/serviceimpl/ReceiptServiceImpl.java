package com.eloan2.serviceimpl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eloan2.dao.ReceiptDAO;
import com.eloan2.domain.Due;
import com.eloan2.domain.OverPay;
import com.eloan2.domain.Receipt;
import com.eloan2.service.ReceiptService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@Service
@Transactional
public class ReceiptServiceImpl implements ReceiptService {
	@Autowired
	private ReceiptDAO receiptDAO;
	

	public ReceiptDAO getReceiptDAO() {
		return receiptDAO;
	}

	public void setReceiptDAO(ReceiptDAO receiptDAO) {
		this.receiptDAO = receiptDAO;
	}
//
//	@Override
//	public Due listDues(int fno) {
//		return getReceiptDAO().listDues(fno);
//	}
//	
	public void createReceipt(Receipt rcpt) {
		getReceiptDAO().createReceipt(rcpt);
	}
	public List<Due> getDuesById(int fno){
		return getReceiptDAO().getDuesById(fno);
	}
	
	public void updatePayment(Due due) {
		getReceiptDAO().updatePayment(due);
	}
	
	public Due getDuesId(int id) {
		return getReceiptDAO().getDuesId(id);
	}
	
	public void overPay(OverPay op) {
		getReceiptDAO().overPay(op);
	}
	
	public Receipt getReceiptId(int fno) {
		return getReceiptDAO().getReceiptId(fno);
	}
	
	public String getAllById(int fno) {
		
		 Receipt dueList= getReceiptDAO().getAllById(fno);
		 String dest="E:/"+dueList.getFno()+".pdf"; 
		  Document document=new Document(); 
		  try {
			  PdfWriter writer;
				writer = PdfWriter.getInstance(document, new FileOutputStream(dest));
		  		document.open(); 
		  		document.add(new Paragraph("Receipt",FontFactory.getFont(FontFactory.COURIER,18,Font.BOLD )));
		  		document.add(new Paragraph(new Date().toString(),FontFactory.getFont(FontFactory.HELVETICA,12,Font.BOLD)));
		  		document.add(new Paragraph("____________________________________________________________________________"));
		  		document.add(new Paragraph("Customer Details",FontFactory.getFont(FontFactory.HELVETICA,13,Font.BOLD)));
		  		document.add(new Paragraph("RcptNo: \t"+dueList.getRcptNo(),FontFactory.getFont(FontFactory.HELVETICA,11))); 
		  		document.add(new Paragraph("Fno: \t"+dueList.getFno(),FontFactory.getFont(FontFactory.HELVETICA,11,Font.NORMAL)));
		  		document.add(new Paragraph("Paid Amount: \t"+dueList.getAmt(),FontFactory.getFont(FontFactory.HELVETICA,11,Font.NORMAL)));
		  		document.add(new Paragraph("By: \t"+dueList.getCreatedBy(),FontFactory.getFont(FontFactory.HELVETICA,11,Font.NORMAL)));
		  		document.add(new Paragraph("_____________________________________________________________________________"));
		  		document.add(new Paragraph("Date "+dueList.getCreatedDate(),FontFactory.getFont(FontFactory.HELVETICA,12,Font.BOLD)));
		  		document.close(); 
		  		writer.close();
		  		return "Done";
		  }
		  			
		catch (FileNotFoundException e) {
			e.printStackTrace();
			return "Failed";
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Failed";
		}
	}
	public Due getPaymentBYId(int id) {
		return getReceiptDAO().getPaymentBYId(id);
	}
}
