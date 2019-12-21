package com.eloan2.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "loanapplication")
public class LAppraisal {
	private int applicationNo;
	private int TCNo;
	private String currentStatus;
	private String createdBy;
	private String followupOfficer;
	private String marketingOfficer;
	private String recovreyOfficer;
	private String createdDate;
	private String firstName;
	private Client client;
	private String remark;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "applicationNo")
	public int getApplicationNo() {
		return applicationNo;
	}

	public void setApplicationNo(int applicationNo) {
		this.applicationNo = applicationNo;
	}

	@Column(name = "TCNo", unique = true)
	public int getTCNo() {
		return TCNo;
	}

	public void setTCNo(int tCNo) {
		TCNo = tCNo;
	}

	@Column(name = "currentStatus")
	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	@Column(name = "createdBy")
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "followupOfficer")
	public String getFollowupOfficer() {
		return followupOfficer;
	}

	public void setFollowupOfficer(String followupOfficer) {
		this.followupOfficer = followupOfficer;
	}

	@Column(name = "marketingOfficer")
	public String getMarketingOfficer() {
		return marketingOfficer;
	}

	public void setMarketingOfficer(String marketingOfficer) {
		this.marketingOfficer = marketingOfficer;
	}

	@Column(name = "recovreyOfficer")
	public String getRecovreyOfficer() {
		return recovreyOfficer;
	}

	public void setRecovreyOfficer(String recovreyOfficer) {
		this.recovreyOfficer = recovreyOfficer;
	}

	@Column(name = "createdDate")
	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "firstName")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@ManyToOne
	@JoinColumn(name = "clientCode")
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Column(name = "remark")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
