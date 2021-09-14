package com.capgemini.ngo.service;

import java.util.List;

import com.capgemini.ngo.model.DonationDistribution;
import com.capgemini.ngo.model.EmployeeDto;
import com.capgemini.ngo.model.NeedyPeopleDto;


public interface EmployeeService {

	public boolean login(EmployeeDto employee);
	
	public boolean addNeedyPerson(NeedyPeopleDto needyPeople);
	
	public boolean removeNeedyPerson(NeedyPeopleDto needyPeople);
	
	public NeedyPeopleDto findNeedyPeopleById(int id);
	
	public List<NeedyPeopleDto> findNeedyPeopleByName(String name);
	
	public List<NeedyPeopleDto> findAllNeedyPeople();
	
	public String helpNeedyPerson(DonationDistribution donationDistribution);
}
