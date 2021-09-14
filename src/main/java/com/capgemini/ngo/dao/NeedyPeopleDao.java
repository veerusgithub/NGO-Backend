package com.capgemini.ngo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.ngo.entity.NeedyPeople;

@Repository
public interface NeedyPeopleDao extends JpaRepository<NeedyPeople, Integer>{

	public List<NeedyPeople> findByNeedyPersonName(String name);

	public  NeedyPeople findByUsername(String username);

	public  NeedyPeople findByUsernameAndPassword(String username,String password);
}
