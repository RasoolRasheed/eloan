package com.eloan2.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loanstatus")
public class LStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sno")
	private int sno;
	
	@Column(name="lsc")
	private String lsc;

	@Column(name="des")
	private String des;
	
	
	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getLsc() {
		return lsc;
	}

	public void setLsc(String lsc) {
		this.lsc = lsc;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	
	
}
