package com.capgemini.ngo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ngo.dao.DonationBoxDao;
import com.capgemini.ngo.entity.DonationBox;
import com.capgemini.ngo.model.DonationBoxDto;
import com.capgemini.ngo.service.DonationBoxService;

@Service
public class DonationBoxServiceImpl implements DonationBoxService {

	@Autowired
	DonationBoxDao donationBoxDao;
	
	@Override
	public boolean saveDonationBox(DonationBoxDto donationBoxDto) {
		
		DonationBox entity = new DonationBox(donationBoxDto.getId(),donationBoxDto.getNgoName(),donationBoxDto.getRegistrationNumber(),donationBoxDto.getAccountNumber(),donationBoxDto.getTotalCollection());
		
		donationBoxDao.save(entity);
		
		return true;
	}

	@Override
	public List<DonationBox> getAllDonationBoxes() {
		return donationBoxDao.findAll();
	}

}
