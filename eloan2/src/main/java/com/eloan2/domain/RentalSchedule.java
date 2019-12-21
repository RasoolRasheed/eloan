package com.eloan2.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rentalschedule")
public class RentalSchedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="TCNo")
	private int TCNo;
	
	@Column(name="rentalNo")
	private int rentalNo;
	
	@Column(name="installmentamount")
	private Double installmentamount;
	
	@Column(name="interest")
	private Double interest;
	
	@Column(name="capitalamount")
	private Double capitalamount;
	
	@Column(name="capitalbalance")
	private Double capitalbalance;
	
	@Column(name="dueDate")
	private Date dueDate;

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTCNo() {
		return TCNo;
	}

	public void setTCNo(int tCNo) {
		TCNo = tCNo;
	}

	public int getRentalNo() {
		return rentalNo;
	}

	public void setRentalNo(int rentalNo) {
		this.rentalNo = rentalNo;
	}

	public Double getInstallmentamount() {
		return installmentamount;
	}

	public void setInstallmentamount(Double installmentamount) {
		this.installmentamount = installmentamount;
	}

	public Double getInterest() {
		return interest;
	}

	public void setInterest(Double interest) {
		this.interest = interest;
	}

	public Double getCapitalamount() {
		return capitalamount;
	}

	public void setCapitalamount(Double capitalamount) {
		this.capitalamount = capitalamount;
	}

	public Double getCapitalbalance() {
		return capitalbalance;
	}

	public void setCapitalbalance(Double capitalbalance) {
		this.capitalbalance = capitalbalance;
	}

	
		
}
