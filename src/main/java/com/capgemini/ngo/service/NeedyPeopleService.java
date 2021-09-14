package com.capgemini.ngo.service;

import java.util.List;

import com.capgemini.ngo.entity.Donor;
import com.capgemini.ngo.entity.NeedyPeople;
import com.capgemini.ngo.model.NeedyPeopleDto;
import com.capgemini.ngo.util.RecordNotFoundException;

public interface NeedyPeopleService {

	public boolean registerNeedyPerson(NeedyPeopleDto needyPerson);
	
	public boolean login(NeedyPeopleDto needyPeople);
	
	public boolean requestForHelp(NeedyPeopleDto needyPeople);
	
	public boolean removeNeedyPersonById(int id);
	
	public NeedyPeople readNeedyPeopleById(int id) throws RecordNotFoundException;
	
	public List<NeedyPeople> readNeedyPeopleByName(String name);
	
	List<NeedyPeople> readAllNeedyPeople();

	NeedyPeople findByUsernameAndPassword(String username, String password);

    boolean modifyNeedyPeople(NeedyPeopleDto needyPeopleDto);
}
