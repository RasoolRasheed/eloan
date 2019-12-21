package com.eloan2.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "receipt")
public class Receipt {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="rcptNo")
	private int rcptNo;
	
	@Column(name="fno")
	private int fno;
	
	@Column(name="amt")
	private double amt;
	
	@Column(name="createdBy")
	private String createdBy;
	
	@Column(name="createdDate")
	private Timestamp createdDate;
	
	@Column(name="paymentmode")
	private String paymentmode;
	
	@Column(name="dueId")
	private int dueId;

	public int getDueId() {
		return dueId;
	}

	public void setDueId(int dueId) {
		this.dueId = dueId;
	}

	public int getRcptNo() {
		return rcptNo;
	}

	public void setRcptNo(int rcptNo) {
		this.rcptNo = rcptNo;
	}

	public int getFno() {
		return fno;
	}

	public void setFno(int fno) {
		this.fno = fno;
	}

	public double getAmt() {
		return amt;
	}

	public void setAmt(double amt) {
		this.amt = amt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getPaymentmode() {
		return paymentmode;
	}

	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}
	
	
}
