package com.capgemini.ngo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.ngo.entity.DonationBox;

public interface DonationBoxDao extends JpaRepository<DonationBox, Integer>{

}
