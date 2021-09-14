package com.capgemini.ngo.model;

import java.util.Date;

public class DonationDto {

    private int donationId;
	
	private Double donationAmount;
	
	private Date donationDate;
	
	private int donorId;
	
	private DonationItemDto donationItem;
	
	public DonationDto() {
	}

	public DonationDto(int donationId, Double donationAmount, Date donationDate, int donorId,
			DonationItemDto donationItem) {
		this.donationId = donationId;
		this.donationAmount = donationAmount;
		this.donationDate = donationDate;
		this.donorId = donorId;
		this.donationItem = donationItem;
	}


	public int getDonationId() {
		return donationId;
	}

	public void setDonationId(int donationId) {
		this.donationId = donationId;
	}

	public Double getDonationAmount() {
		return donationAmount;
	}

	public void setDonationAmount(Double donationAmount) {
		this.donationAmount = donationAmount;
	}

	public Date getDonationDate() {
		return donationDate;
	}

	public void setDonationDate(Date donationDate) {
		this.donationDate = donationDate;
	}

	
	public int getDonorId() {
		return donorId;
	}

	public void setDonorId(int donorId) {
		this.donorId = donorId;
	}

	
	public DonationItemDto getDonationItem() {
		return donationItem;
	}

	public void setDonationItem(DonationItemDto donationItem) {
		this.donationItem = donationItem;
	}

	@Override
	public String toString() {
		return "DonationDto [donationId=" + donationId + ", donationAmount=" + donationAmount + ", donationDate="
				+ donationDate + ", donorId=" + donorId + ", donationItem=" + donationItem + "]";
	}

}
