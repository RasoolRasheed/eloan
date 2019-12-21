package com.eloan2.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
/*
@Entity
@Table(name = "duefrmclnt")
public class DueToClient {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="fno")
	private int fno;
	
	@ManyToMany
	@JoinColumn(name = "clientCode")
	private Client client;
	public Client getClient() {
		return client; 
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	@Column(name="payment")
	private double payment;

	@Column(name="createdBy")
	private String createdBy;

	@Column(name="createdDate")
	private Timestamp createdDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
*/