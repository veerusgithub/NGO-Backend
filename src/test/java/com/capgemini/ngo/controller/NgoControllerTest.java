package com.capgemini.ngo.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.capgemini.ngo.entity.Employee;
import com.capgemini.ngo.model.DonationDto;
import com.capgemini.ngo.model.DonorDto;
import com.capgemini.ngo.model.EmployeeDto;
import com.capgemini.ngo.model.NeedyPeopleDto;
import com.capgemini.ngo.service.AdminService;
import com.capgemini.ngo.service.DonorService;
import com.capgemini.ngo.service.NeedyPeopleService;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class NgoControllerTest {

	@InjectMocks
	private NgoController ngoController;

	@Mock
	DonorService donorService;

	@Mock
	NeedyPeopleService needyPeopleService;

	@Mock
	AdminService adminService;

	@Test
	void addNewDonor() {
		Mockito.when(donorService.registerDonor(Mockito.any())).thenReturn(true);
		ngoController.createDonor(new DonorDto());
		Mockito.verify(donorService, Mockito.times(1)).registerDonor(Mockito.any());
	}

	@Test
	void saveDonation() {
		Mockito.when(donorService.donateToNGO(Mockito.any())).thenReturn(Mockito.any());
		ngoController.donateToNGO(new DonationDto());
		Mockito.verify(donorService, Mockito.times(1)).donateToNGO(Mockito.any());
	}

	@Test
	void createNeedyPerson() {
		Mockito.when(needyPeopleService.registerNeedyPerson(Mockito.any())).thenReturn(true);
		ngoController.createNeedyPerson(new NeedyPeopleDto());
		Mockito.verify(needyPeopleService, Mockito.times(1)).registerNeedyPerson(Mockito.any());
	}

	@Test
	void createEmployee() {
		Mockito.when(adminService.addEmployee(Mockito.any())).thenReturn(true);
		ngoController.createEmployee(new EmployeeDto());
		Mockito.verify(adminService, Mockito.times(1)).addEmployee(Mockito.any());
	}

	/*@Test
	void modifyEmployee() {
		Mockito.when(adminService.modifyEmployee(Mockito.any())).thenReturn(Mockito.any());
		ngoController.modifyEmployee(new EmployeeDto());
		Mockito.verify(adminService, Mockito.times(1)).modifyEmployee(Mockito.any());
	}*/

	@Test
	void findEmployeeById() {
		Mockito.when(adminService.findEmployeeById(121)).thenReturn(Mockito.any());
		assertNotNull(ngoController.findEmployeeById(121));
	}

	@Test
	void findAllEmployee() {

		Mockito.when(adminService.findAllEmployee()).thenReturn(Stream.of(new Employee()).collect(Collectors.toList()));
		assertNotNull(ngoController.findAllEmployee());
	}

}