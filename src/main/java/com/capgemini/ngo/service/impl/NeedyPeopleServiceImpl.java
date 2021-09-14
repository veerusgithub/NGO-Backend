package com.capgemini.ngo.service.impl;

import java.util.List;
import java.util.Optional;

import com.capgemini.ngo.entity.Donor;
import com.capgemini.ngo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ngo.dao.AddressDao;
import com.capgemini.ngo.dao.NeedyPeopleDao;
import com.capgemini.ngo.entity.Address;
import com.capgemini.ngo.entity.NeedyPeople;
import com.capgemini.ngo.model.AddressDto;
import com.capgemini.ngo.model.NeedyPeopleDto;
import com.capgemini.ngo.service.NeedyPeopleService;
import com.capgemini.ngo.util.RecordNotFoundException;

@Service
public class NeedyPeopleServiceImpl implements NeedyPeopleService{

	@Autowired
	NeedyPeopleDao needyPeopleDao;
	
	@Autowired
	AddressDao addressDao;
	
	@Override
	public boolean registerNeedyPerson(NeedyPeopleDto needyPeopleDto) {
		Optional<NeedyPeople> optionalDonor = needyPeopleDao.findById(needyPeopleDto.getNeedyPersonId());
		if(optionalDonor.isPresent()){
			NeedyPeople needyPeople = optionalDonor.get();
			if(!needyPeople.getUsername().equalsIgnoreCase(needyPeopleDto.getUsername())){
				NeedyPeople existingNeedy = needyPeopleDao.findByUsername(needyPeopleDto.getUsername());
				if(existingNeedy!= null ){
					return  false;
				}
			}
		}

		AddressDto address = needyPeopleDto.getAddress();

		Address addEntity = new Address();
		addEntity.setAddressId(address.getAddressId());
		addEntity.setCity(address.getCity());
		addEntity.setState(address.getState());
		addEntity.setPin(address.getPin());
		addEntity.setLandmark(address.getLandmark());
		addressDao.save(addEntity);
		
		NeedyPeople entity = new NeedyPeople(needyPeopleDto.getNeedyPersonId(),
				needyPeopleDto.getNeedyPersonName(),needyPeopleDto.getPhone(),needyPeopleDto.getFamilyIncome(),needyPeopleDto.getUsername(),needyPeopleDto.getPassword(),addEntity);
		needyPeopleDao.save(entity);
		
		return true;
	}

	@Override
	public boolean login(NeedyPeopleDto needyPeople) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean requestForHelp(NeedyPeopleDto needyPeople) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeNeedyPersonById(int id) {

		needyPeopleDao.deleteById(id);
		return false;
	}

	@Override
	public NeedyPeople readNeedyPeopleById(int id) throws RecordNotFoundException {

		Optional<NeedyPeople> needyPeople = needyPeopleDao.findById(id);
		
		if(needyPeople.isPresent()) {
			return needyPeople.get();
		}else {
			throw new RecordNotFoundException("Record is not available in Database");
		}
	}

	@Override
	public List<NeedyPeople> readNeedyPeopleByName(String name) {
		
		List<NeedyPeople> list = needyPeopleDao.findByNeedyPersonName(name);
		
		return list;
	}

	@Override
	public List<NeedyPeople> readAllNeedyPeople() {

		List<NeedyPeople> list = needyPeopleDao.findAll();
		
		return list;
	}

	@Override
	public NeedyPeople findByUsernameAndPassword(String username, String password) {
		return needyPeopleDao.findByUsernameAndPassword(username, password);
	}

	@Override
	public boolean modifyNeedyPeople(NeedyPeopleDto needyPeopleDto) {
		Optional<NeedyPeople> optionalDonor = needyPeopleDao.findById(needyPeopleDto.getNeedyPersonId());
		if(optionalDonor.isPresent()){
			NeedyPeople needyPeople = optionalDonor.get();
			if(!needyPeople.getUsername().equalsIgnoreCase(needyPeopleDto.getUsername())){
				NeedyPeople existingNeedy = needyPeopleDao.findByUsername(needyPeopleDto.getUsername());
				if(existingNeedy!= null ){
					return  false;
				}
			}
		}
		AddressDto address = needyPeopleDto.getAddress();

		Address addEntity = new Address();
		addEntity.setAddressId(address.getAddressId());
		addEntity.setCity(address.getCity());
		addEntity.setState(address.getState());
		addEntity.setPin(address.getPin());
		addEntity.setLandmark(address.getLandmark());
		addressDao.save(addEntity);
		NeedyPeople entity = new NeedyPeople(needyPeopleDto.getNeedyPersonId(), needyPeopleDto.getNeedyPersonName(), needyPeopleDto.getPhone(),
				needyPeopleDto.getFamilyIncome(), needyPeopleDto.getUsername(), needyPeopleDto.getPassword(), addEntity);

		NeedyPeople result = needyPeopleDao.save(entity);

		return true;
	}

}
