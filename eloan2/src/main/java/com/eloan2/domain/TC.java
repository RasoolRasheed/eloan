package com.eloan2.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trialcalculation")
public class TC {
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="TCNo")
		private int TCNo;
		
		@Column(name="applicationNo")
		private int applicationNo;
		
		@Column(name="clientCode")
		private int clientCode;
		
		@Column(name="LoanTypeCode")
		private String LoanTypeCode;

		@Column(name="loanSchemeCode")
		private String loanSchemeCode;

		@Column(name="Amount")
		private Double Amount;
		
		@Column(name="Period")
		private int Period;
		
		@Column(name="Rate")
		private Double Rate;
		
		@Column(name="Installment")
		private Double Installment;

		@Column(name="createdBy")
		private String createdBy;

		@Column(name="createdDate")
		private Timestamp createdDate;

		public Double getAmount() {
			return Amount;
		}

		public void setAmount(Double amount) {
			Amount = amount;
		}

		public int getPeriod() {
			return Period;
		}

		public void setPeriod(int period) {
			Period = period;
		}

		public Double getRate() {
			return Rate;
		}

		public void setRate(Double rate) {
			Rate = rate;
		}

		public Double getInstallment() {
			return Installment;
		}

		public void setInstallment(Double installment) {
			Installment = installment;
		}

		public int getTCNo() {
			return TCNo;
		}

		public void setTCNo(int tCNo) {
			TCNo = tCNo;
		}

		public int getApplicationNo() {
			return applicationNo;
		}

		public void setApplicationNo(int applicationNo) {
			this.applicationNo = applicationNo;
		}

		public int getClientCode() {
			return clientCode;
		}

		public void setClientCode(int clientCode) {
			this.clientCode = clientCode;
		}

		public String getLoanTypeCode() {
			return LoanTypeCode;
		}

		public void setLoanTypeCode(String loanTypeCode) {
			LoanTypeCode = loanTypeCode;
		}

		public String getLoanSchemeCode() {
			return loanSchemeCode;
		}

		public void setLoanSchemeCode(String loanSchemeCode) {
			this.loanSchemeCode = loanSchemeCode;
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
