package com.capgemini.ngo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.ngo.entity.Donation;

import java.util.List;

@Repository
public interface DonationDao extends JpaRepository<Donation, Integer>{

    List<Donation> findByDonorId(int donorId);
	
}
