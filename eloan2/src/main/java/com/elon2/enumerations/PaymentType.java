package com.elon2.enumerations;

public enum PaymentType {
	INS(1,"INS","Insurance Payment"),
	DOC(2,"DOC","Document Charges");
	
	private int id;
	private String code;
	private String description;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	private PaymentType(int id, String code, String description) {
		this.id = id;
		this.code = code;
		this.description = description;
	}
	
	public PaymentType getPaymentTypeByCode(String code) {
		PaymentType paymentType = PaymentType.DOC;
		return paymentType;
	}
	
}
