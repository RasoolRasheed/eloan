package com.eloan2.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "overpay")
public class OverPay {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="rcptNo")
	private int rcptNo;
	
	@Column(name="fno")
	private int fno;
	
	@Column(name="amt")
	private double amt;
	/*
	 * @Column(name="due") private double due;
	 */
	
	@Column(name="stlmnt")
	private double stlmnt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	/*
	 * public double getDue() { return due; }
	 * 
	 * public void setDue(double due) { this.due = due; }
	 */

	public double getStlmnt() {
		return stlmnt;
	}

	public void setStlmnt(double stlmnt) {
		this.stlmnt = stlmnt;
	}
	
	
	
}
