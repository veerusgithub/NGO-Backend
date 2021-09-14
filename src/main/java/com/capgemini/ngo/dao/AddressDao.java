package com.capgemini.ngo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.ngo.entity.Address;

public interface AddressDao extends JpaRepository<Address, Integer>{

}
