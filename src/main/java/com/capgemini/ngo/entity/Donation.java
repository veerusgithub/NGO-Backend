package com.capgemini.ngo.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "donation")
public class Donation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int donationId;
	
	private Double donationAmount;
	
	private Date donationDate;
	
	private int donorId;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "donationitem_id", referencedColumnName = "itemId")
	private DonationItem donationItem;
	
	public Donation() {
	}

	public Donation(int donationId, Double donationAmount, Date donationDate, int donorId, DonationItem donationItem) {
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

	
	public DonationItem getDonationItem() {
		return donationItem;
	}

	public void setDonationItem(DonationItem donationItem) {
		this.donationItem = donationItem;
	}

	@Override
	public String toString() {
		return "Donation [donationId=" + donationId + ", donationAmount=" + donationAmount + ", donationDate="
				+ donationDate + ", donorId=" + donorId + ", donationItem=" + donationItem + "]";
	}

}
