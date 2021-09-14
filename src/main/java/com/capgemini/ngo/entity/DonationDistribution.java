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

import com.capgemini.ngo.constants.DonationDistributionStatus;


@Entity
@Table(name = "donationDistribution")
public class DonationDistribution {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int distributionId;
	
	private Double amountDistributed;
	
	private Date dateOfDistribution;
	
	private Date approvalOrRejectedDate;
	
	private DonationDistributionStatus status;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "donationitem_id", referencedColumnName = "itemId")
	private DonationItem donationItem;

	public DonationDistribution() {
	}

	public DonationDistribution(int distributionId, Double amountDistributed, Date dateOfDistribution,
			Date approvalOrRejectedDate, DonationDistributionStatus status, DonationItem donationItem) {
		this.distributionId = distributionId;
		this.amountDistributed = amountDistributed;
		this.dateOfDistribution = dateOfDistribution;
		this.approvalOrRejectedDate = approvalOrRejectedDate;
		this.status = status;
		this.donationItem = donationItem;
	}

	public int getDistributionId() {
		return distributionId;
	}

	public void setDistributionId(int distributionId) {
		this.distributionId = distributionId;
	}

	public Double getAmountDistributed() {
		return amountDistributed;
	}

	public void setAmountDistributed(Double amountDistributed) {
		this.amountDistributed = amountDistributed;
	}

	public Date getDateOfDistribution() {
		return dateOfDistribution;
	}

	public void setDateOfDistribution(Date dateOfDistribution) {
		this.dateOfDistribution = dateOfDistribution;
	}

	public Date getApprovalOrRejectedDate() {
		return approvalOrRejectedDate;
	}

	public void setApprovalOrRejectedDate(Date approvalOrRejectedDate) {
		this.approvalOrRejectedDate = approvalOrRejectedDate;
	}

	public DonationDistributionStatus getStatus() {
		return status;
	}

	public void setStatus(DonationDistributionStatus status) {
		this.status = status;
	}

	public DonationItem getDonationItem() {
		return donationItem;
	}

	public void setDonationItem(DonationItem donationItem) {
		this.donationItem = donationItem;
	}

	@Override
	public String toString() {
		return "DonationDistribution [distributionId=" + distributionId + ", amountDistributed=" + amountDistributed
				+ ", dateOfDistribution=" + dateOfDistribution + ", approvalOrRejectedDate=" + approvalOrRejectedDate
				+ ", status=" + status + ", donationItem=" + donationItem + "]";
	}

	
}
