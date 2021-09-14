package com.capgemini.ngo.service;

import java.util.List;

import com.capgemini.ngo.entity.DonationBox;
import com.capgemini.ngo.model.DonationBoxDto;

public interface DonationBoxService {

	public boolean saveDonationBox(DonationBoxDto donationBoxDto);
	
	public List<DonationBox> getAllDonationBoxes();
} 
