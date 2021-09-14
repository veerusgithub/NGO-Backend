package com.capgemini.ngo.model;

public class DonorDto {

	private int donorId;
	
	private String donorName;
	
	private String donorEmail;
	
	private String donorPhone;
	
	private String donorUsername;
	
	private String donorPassword;
	
	private AddressDto address;
	
	public DonorDto() {
	}

	public DonorDto(int donorId, String donorName, String donorEmail, String donorPhone, String donorUsername,
			String donorPassword, AddressDto address) {
		this.donorId = donorId;
		this.donorName = donorName;
		this.donorEmail = donorEmail;
		this.donorPhone = donorPhone;
		this.donorUsername = donorUsername;
		this.donorPassword = donorPassword;
		this.address = address;
	}

	public int getDonorId() {
		return donorId;
	}

	public void setDonorId(int donorId) {
		this.donorId = donorId;
	}

	public String getDonorName() {
		return donorName;
	}

	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}

	public String getDonorEmail() {
		return donorEmail;
	}

	public void setDonorEmail(String donorEmail) {
		this.donorEmail = donorEmail;
	}

	public String getDonorPhone() {
		return donorPhone;
	}

	public void setDonorPhone(String donorPhone) {
		this.donorPhone = donorPhone;
	}

	public String getDonorUsername() {
		return donorUsername;
	}

	public void setDonorUsername(String donorUsername) {
		this.donorUsername = donorUsername;
	}

	public String getDonorPassword() {
		return donorPassword;
	}

	public void setDonorPassword(String donorPassword) {
		this.donorPassword = donorPassword;
	}
	

	public AddressDto getAddress() {
		return address;
	}

	public void setAddress(AddressDto address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "DonorDto [donorId=" + donorId + ", donorName=" + donorName + ", donorEmail=" + donorEmail
				+ ", donorPhone=" + donorPhone + ", donorUsername=" + donorUsername + ", donorPassword=" + donorPassword
				+ ", address=" + address + "]";
	}

}
