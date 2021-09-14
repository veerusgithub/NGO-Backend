package com.capgemini.ngo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "donation")
public class DonationBox {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String ngoName;
	
	private String registrationNumber;
	
	private String accountNumber;
	
	private Double totalCollection;
	
	

	public DonationBox() {
	}

	public DonationBox(int id, String ngoName, String registrationNumber, String accountNumber,
			Double totalCollection) {
		super();
		this.id = id;
		this.ngoName = ngoName;
		this.registrationNumber = registrationNumber;
		this.accountNumber = accountNumber;
		this.totalCollection = totalCollection;
	}


	public String getNgoName() {
		return ngoName;
	}



	public void setNgoName(String ngoName) {
		this.ngoName = ngoName;
	}



	public String getRegistrationNumber() {
		return registrationNumber;
	}



	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}



	public String getAccountNumber() {
		return accountNumber;
	}



	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}



	public Double getTotalCollection() {
		return totalCollection;
	}



	public void setTotalCollection(Double totalCollection) {
		this.totalCollection = totalCollection;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "DonationBox [id=" + id + ", ngoName=" + ngoName + ", registrationNumber=" + registrationNumber
				+ ", accountNumber=" + accountNumber + ", totalCollection=" + totalCollection + "]";
	}

}
