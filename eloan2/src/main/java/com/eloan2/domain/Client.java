package com.eloan2.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "clientCode")
	private int clientCode;

	@Column(name = "NIC")
	private String NIC;

	public String getNIC() {
		return NIC;
	}

	public void setNIC(String nIC) {
		NIC = nIC;
	}

	@Column(name = "Salutation")
	private String Salutation;

	public String getSalutation() {
		return Salutation;
	}

	public void setSalutation(String salutation) {
		Salutation = salutation;
	}

	@Column(name = "Initials")
	private String Initials;

	public String getInitials() {
		return Initials;
	}

	public void setInitials(String initials) {
		Initials = initials;
	}

	@Column(name = "initialsinFull")
	private String initialsinFull;

	public String getInitialsinFull() {
		return initialsinFull;
	}

	public void setInitialsinFull(String initialsinFull) {
		this.initialsinFull = initialsinFull;
	}

	@Column(name = "firstName")
	private String firstName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "lastName")
	private String lastName;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "contactNo")
	private int contactNo;

	public int getContactNo() {
		return contactNo;
	}

	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}

	@Column(name = "addressLine01")
	private String addressLine01;

	public String getAddressLine01() {
		return addressLine01;
	}

	public void setAddressLine01(String addressLine01) {
		this.addressLine01 = addressLine01;
	}

	@Column(name = "addressLine02")
	private String addressLine02;

	public String getAddressLine02() {
		return addressLine02;
	}

	public void setAddressLine02(String addressLine02) {
		this.addressLine02 = addressLine02;
	}

	@Column(name = "addressLine03")
	private String addressLine03;

	public String getAddressLine03() {
		return addressLine03;
	}

	public void setAddressLine03(String addressLine03) {
		this.addressLine03 = addressLine03;
	}

	@Column(name = "addressLine04")
	private String addressLine04;

	public void setAddressLine04(String addressLine04) {
		this.addressLine04 = addressLine04;
	}

	public String getAddressLine04() {
		return addressLine04;
	}

	@Column(name = "postalCode")
	private String postalCode;

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@Column(name = "Gender")
	private String Gender;

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	/*
	 * @ManyToMany(mappedBy="client") private Set<DueToClient> duetoclient;
	 * 
	 * public Set<DueToClient> getDuetoclient() { return duetoclient; }
	 * 
	 * public void setDuetoclient(Set<DueToClient> duetoclient) { this.duetoclient =
	 * duetoclient; }
	 */
	@OneToMany(mappedBy = "client")
	private Set<LAppraisal> Appraisal;

	public Set<LAppraisal> getAppraisal() {
		return Appraisal;
	}

	public void setAppraisal(Set<LAppraisal> appraisal) {
		Appraisal = appraisal;
	}

	@OneToMany(mappedBy = "client")
	private Set<Facility> Facility;

	public Set<Facility> getFacility() {
		return Facility;
	}

	public void setFacility(Set<Facility> facility) {
		Facility = facility;
	}

	public int getClientCode() {
		return clientCode;
	}

	public void setClientCode(int clientCode) {
		this.clientCode = clientCode;
	}

}
