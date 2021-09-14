package com.capgemini.ngo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.ngo.entity.DonationItem;

public interface DonationItemDao extends JpaRepository<DonationItem, Integer>{

}
