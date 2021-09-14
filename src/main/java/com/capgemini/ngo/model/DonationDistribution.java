package com.capgemini.ngo.model;

import java.util.Date;

import com.capgemini.ngo.constants.DonationDistributionStatus;


public class DonationDistribution {

	private int distributionId;
	
	private Double amountDistributed;
	
	private Date dateOfDistribution;
	
	private Date approvalOrRejectedDate;
	
	private DonationDistributionStatus status;

	public DonationDistribution() {
	}

	public DonationDistribution(int distributionId, Double amountDistributed, Date dateOfDistribution,
			Date approvalOrRejectedDate, DonationDistributionStatus status) {
		this.distributionId = distributionId;
		this.amountDistributed = amountDistributed;
		this.dateOfDistribution = dateOfDistribution;
		this.approvalOrRejectedDate = approvalOrRejectedDate;
		this.status = status;
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

	@Override
	public String toString() {
		return "DonationDistribution [distributionId=" + distributionId + ", amountDistributed=" + amountDistributed
				+ ", dateOfDistribution=" + dateOfDistribution + ", approvalOrRejectedDate=" + approvalOrRejectedDate
				+ ", status=" + status + "]";
	}
	
	
	
}
