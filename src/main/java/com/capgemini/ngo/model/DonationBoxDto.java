package com.capgemini.ngo.model;

public class DonationBoxDto {

	private int id;
	
	private String ngoName;
	
	private String registrationNumber;
	
	private String accountNumber;
	
	private Double totalCollection;
	
	

	public DonationBoxDto() {
	}

	public DonationBoxDto(int id, String ngoName, String registrationNumber, String accountNumber,
			Double totalCollection) {
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
		return "DonationBoxDto [id=" + id + ", ngoName=" + ngoName + ", registrationNumber=" + registrationNumber
				+ ", accountNumber=" + accountNumber + ", totalCollection=" + totalCollection + "]";
	}

	
}
