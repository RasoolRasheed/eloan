package com.eloan2.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "duefrmclnt")
public class Due {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="fno")
	private int fno;
	
	@Column(name="paymenttype")
	private String paymenttype;
	
	@Column(name="due")
	private double due;

	@Column(name="payment")
	private double payment;

	@Column(name="createdBy")
	private String createdBy;

	@Column(name="createdDate")
	private Timestamp createdDate;

	/*
	 * @Column(name="balance") private double balance;
	 * 
	 * public double getBalance() { return balance; }
	 * 
	 * public void setBalance(double balance) { this.balance = balance; }
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFno() {
		return fno;
	}

	public void setFno(int fno) {
		this.fno = fno;
	}

	public String getPaymentType() {
		return paymenttype;
	}

	public void setPaymentType(String paymenttype) {
		this.paymenttype = paymenttype;
	}

	public double getDue() {
		return due;
	}

	public void setDue(double due) {
		this.due = due;
	}

	public double getPayment() {
		return payment;
	}

	public void setPayment(double payment) {
		this.payment = payment;
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

	
	
}
