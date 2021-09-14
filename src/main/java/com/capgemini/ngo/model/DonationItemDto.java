package com.capgemini.ngo.model;

import com.capgemini.ngo.constants.DonationType;

public class DonationItemDto {

	private int itemId;
	
	private String itemDescription;
	
	private DonationType donationType;

	public DonationItemDto() {
	}


	public DonationItemDto(int itemId, String itemDescription, DonationType donationType) {
		this.itemId = itemId;
		this.itemDescription = itemDescription;
		this.donationType = donationType;
	}


	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}


	public DonationType getDonationType() {
		return donationType;
	}


	public void setDonationType(DonationType donationType) {
		this.donationType = donationType;
	}


	@Override
	public String toString() {
		return "DonationItemDto [itemId=" + itemId + ", itemDescription=" + itemDescription + ", donationType="
				+ donationType + "]";
	}

}
