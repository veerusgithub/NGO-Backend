package com.capgemini.ngo.service.impl;

import com.capgemini.ngo.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ngo.controller.NgoController;
import com.capgemini.ngo.dao.AddressDao;
import com.capgemini.ngo.dao.DonationDao;
import com.capgemini.ngo.dao.DonationItemDao;
import com.capgemini.ngo.dao.DonorDao;
import com.capgemini.ngo.model.AddressDto;
import com.capgemini.ngo.model.DonationDto;
import com.capgemini.ngo.model.DonationItemDto;
import com.capgemini.ngo.model.DonorDto;
import com.capgemini.ngo.service.DonorService;

import java.util.List;
import java.util.Optional;

@Service
public class DonorServiceImpl implements DonorService{

	Logger logger = LoggerFactory.getLogger(NgoController.class);
	
	@Autowired
	DonorDao donorDao;
	
	@Autowired
	DonationDao donationDao;
	
	@Autowired
	AddressDao addressDao;
	
	@Autowired
	DonationItemDao donationItemDao;
	
	@Override
	public boolean registerDonor(DonorDto donorDto) {

		Optional<Donor> optionalDonor = donorDao.findById(donorDto.getDonorId());
		if(optionalDonor.isPresent()){
			Donor donor = optionalDonor.get();
			if(!donor.getDonorUsername().equalsIgnoreCase(donorDto.getDonorUsername())){
				Donor existingDonor = donorDao.findByDonorUsername(donorDto.getDonorUsername());
				if(existingDonor!= null ){
					return  false;
				}
			}
		}
		
		AddressDto address = donorDto.getAddress();

		Address addEntity = new Address();
		addEntity.setAddressId(address.getAddressId());
		addEntity.setCity(address.getCity());
		addEntity.setState(address.getState());
		addEntity.setPin(address.getPin());
		addEntity.setLandmark(address.getLandmark());
		addressDao.save(addEntity);

		
		Donor entity = new Donor(donorDto.getDonorId(),donorDto.getDonorName(),
				donorDto.getDonorEmail(),donorDto.getDonorPhone(),donorDto.getDonorUsername(),donorDto.getDonorPassword(),addEntity);
		donorDao.save(entity);
		
		return true;
	}

	@Override
	public boolean login(DonorDto donor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Donation donateToNGO(DonationDto donation) {
		
		DonationItemDto donationItemDto = donation.getDonationItem();
		
		DonationItem donationItem = new DonationItem();
		donationItem.setItemDescription(donationItemDto.getItemDescription());
		donationItem.setDonationType(donationItemDto.getDonationType());
		donationItemDao.save(donationItem);
		

		Donation entity= new Donation(donation.getDonationId(),donation.getDonationAmount(),
				donation.getDonationDate(),donation.getDonorId(),donationItem);
		
		Donation result= donationDao.save(entity);
		
		sendThankyouMailToDonator(result);
		
		return result;
	}

	@Override
	public void sendThankyouMailToDonator(Donation donation) {
		logger.debug("Thank you for your kind donation !!:"+donation.getDonorId());
	}

	@Override
	public String forgotPassword(String email) {
		
		Donor entity = donorDao.findByDonorEmail(email);
		
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public String resetPassword(String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void emailPasswordToDonor(String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Donor findByUsernameAndPassword(String username, String password) {
		return donorDao.findByDonorUsernameAndDonorPassword(username,password);
	}

	@Override
	public List<Donor> findAllDonors() {
		return donorDao.findAll();
	}

	@Override
	public Donor findByDonorId(int donorId) {
		return donorDao.findByDonorId(donorId);
	}

	@Override
	public void removeDonor(int donorId) {
		donorDao.deleteById(donorId);
	}

	@Override
	public boolean modeifyDonor(DonorDto donorDto) {
		Optional<Donor> optionalDonor = donorDao.findById(donorDto.getDonorId());
		if(optionalDonor.isPresent()){
			Donor donor = optionalDonor.get();
			if(!donor.getDonorUsername().equalsIgnoreCase(donorDto.getDonorUsername())){
				Donor existingDonor = donorDao.findByDonorUsername(donorDto.getDonorUsername());
				if(existingDonor!= null ){
					return  false;
				}
			}
		}
		AddressDto address = donorDto.getAddress();

		Address addEntity = new Address();
		addEntity.setAddressId(address.getAddressId());
		addEntity.setCity(address.getCity());
		addEntity.setState(address.getState());
		addEntity.setPin(address.getPin());
		addEntity.setLandmark(address.getLandmark());
		addressDao.save(addEntity);

		Donor entity = new Donor(donorDto.getDonorId(), donorDto.getDonorName(), donorDto.getDonorEmail(),
				donorDto.getDonorPhone(), donorDto.getDonorUsername(), donorDto.getDonorPassword(), addEntity);

		Donor result = donorDao.save(entity);

		return true;
	}

	@Override
	public List<Donation> findAllDonations() {
		return donationDao.findAll();
	}

	@Override
	public List<Donation> findALlDonationsByDonor(int donorId) {
		return donationDao.findByDonorId(donorId);
	}

}
