package com.capgemini.ngo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.capgemini.ngo.constants.DonationType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "donationItem")
public class DonationItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int itemId;
	
	private String itemDescription;
	
	@OneToOne(mappedBy="donationItem")
	@JsonIgnoreProperties("donationItem")
	private Donation donation;
	
	@OneToOne(mappedBy="donationItem")
	@JsonIgnoreProperties("donationItem")
	private DonationDistribution donationDistribution;
	
	private DonationType donationType;

	public DonationItem() {
	}

	public DonationItem(int itemId, String itemDescription, Donation donation,
			DonationDistribution donationDistribution, DonationType donationType) {
		this.itemId = itemId;
		this.itemDescription = itemDescription;
		this.donation = donation;
		this.donationDistribution = donationDistribution;
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
	

	public Donation getDonation() {
		return donation;
	}

	public void setDonation(Donation donation) {
		this.donation = donation;
	}

	public DonationDistribution getDonationDistribution() {
		return donationDistribution;
	}

	public void setDonationDistribution(DonationDistribution donationDistribution) {
		this.donationDistribution = donationDistribution;
	}
	
	public DonationType getDonationType() {
		return donationType;
	}

	public void setDonationType(DonationType donationType) {
		this.donationType = donationType;
	}

	@Override
	public String toString() {
		return "DonationItem [itemId=" + itemId + ", itemDescription=" + itemDescription + ", donation=" + donation
				+ ", donationDistribution=" + donationDistribution + ", donationType=" + donationType + "]";
	}

}
