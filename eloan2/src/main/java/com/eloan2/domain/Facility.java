package com.eloan2.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "facility")
public class Facility {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="fno")
	private int fno;
	
	@Column(name="applicationNo")
	private int applicationNo;
	
	@Column(name="TCNo")
	private int TCNo;
	
	@Column(name="loanStatus")
	private String loanStatus;
	
	@Column(name="createdBy")
	private String createdBy;
	
	@Column(name="createdDate")
	private Date createdDate;

	@Column(name="NIC")
	private String NIC;
	
	@Column(name="fname")
	private String fname;
	
	@ManyToOne
	@JoinColumn(name = "clientCode")
	private Client client;
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getNIC() {
		return NIC;
	}

	public void setNIC(String nIC) {
		this.NIC = nIC;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public int getFno() {
		return fno;
	}

	public void setFno(int fno) {
		this.fno = fno;
	}

	public int getApplicationNo() {
		return applicationNo;
	}

	public void setApplicationNo(int applicationNo) {
		this.applicationNo = applicationNo;
	}

	public int getTCNo() {
		return TCNo;
	}

	public void setTCNo(int tCNo) {
		this.TCNo = tCNo;
	}
	
	public String getLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	
	
}
