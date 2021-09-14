package com.capgemini.ngo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.ngo.entity.Donation;
import com.capgemini.ngo.entity.Donor;

@Repository
public interface DonorDao extends JpaRepository<Donor, Integer> {

	public Donor findByDonorEmail(String email);

	public Donor findByDonorId(int donorId);

	 Donor findByDonorUsernameAndDonorPassword(String username, String password);

	 Donor findByDonorUsername(String username);
}
