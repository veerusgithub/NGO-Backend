package com.capgemini.ngo.service;

import com.capgemini.ngo.entity.Donation;
import com.capgemini.ngo.entity.Donor;
import com.capgemini.ngo.model.DonationDto;
import com.capgemini.ngo.model.DonorDto;

import java.util.List;

public interface DonorService {

	public boolean registerDonor(DonorDto donor);
	
	public boolean login(DonorDto donor);
	
	public Donation donateToNGO(DonationDto donation);
	
	public void sendThankyouMailToDonator(Donation donor);
	
	public String forgotPassword(String password);
	
	public String resetPassword(String password);
	
	public void emailPasswordToDonor(String password);

	public Donor findByUsernameAndPassword(String username,String password);

	List<Donor> findAllDonors();

	Donor findByDonorId(int donorId);

	void removeDonor(int donorId);

	boolean modeifyDonor(DonorDto donorDto);

	List<Donation> findAllDonations();

	List<Donation> findALlDonationsByDonor(int donorId);
}
