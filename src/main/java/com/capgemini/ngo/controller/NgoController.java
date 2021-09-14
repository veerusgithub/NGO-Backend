package com.capgemini.ngo.controller;

import java.util.List;

import com.capgemini.ngo.entity.*;
import com.capgemini.ngo.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.capgemini.ngo.service.AdminService;
import com.capgemini.ngo.service.DonationBoxService;
import com.capgemini.ngo.service.DonorService;
import com.capgemini.ngo.service.NeedyPeopleService;
import com.capgemini.ngo.util.RecordNotFoundException;

@RestController
@RequestMapping("/ngo/")
public class NgoController {

	Logger logger = LoggerFactory.getLogger(NgoController.class);

	@Autowired
	DonorService donorService;

	@Autowired
	NeedyPeopleService needyPeopleService;

	@Autowired
	AdminService adminService;
	
	@Autowired
	DonationBoxService donationBoxService;
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> exception(Exception e) {

		return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(value = "createdonor", method = RequestMethod.POST)
	public ResponseEntity<Boolean> createDonor(@RequestBody DonorDto donor) {

		logger.info("Started creating the Donor");
		boolean value= donorService.registerDonor(donor);
		logger.info("Donor creation is done");
		if(value){
			return new ResponseEntity<Boolean>(Boolean.valueOf(false), HttpStatus.CREATED);
		}
		return new ResponseEntity<Boolean>(Boolean.valueOf(true), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "savedonationbox", method = RequestMethod.POST)
	public ResponseEntity<Boolean> saveDonationBox(@RequestBody DonationBoxDto donationBoxDto) {

		logger.info("Started saving the DonationBox");
		donationBoxService.saveDonationBox(donationBoxDto);
		logger.info("DonationBox saved!!");
		return new ResponseEntity<Boolean>(Boolean.valueOf(true), HttpStatus.CREATED);
	}

	@RequestMapping(value = "saveDonation", method = RequestMethod.POST)
	public ResponseEntity<Donation> donateToNGO(@RequestBody DonationDto donationDto) {

		return new ResponseEntity<Donation>(donorService.donateToNGO(donationDto), HttpStatus.CREATED);
	}

	@RequestMapping(value = "createneedyperson", method = RequestMethod.POST)
	public ResponseEntity<Boolean> createNeedyPerson(@RequestBody NeedyPeopleDto needyPeopleDto) {

		boolean value =needyPeopleService.registerNeedyPerson(needyPeopleDto);
		if(value){
			return new ResponseEntity<Boolean>(Boolean.valueOf(false), HttpStatus.CREATED);
		}

		return new ResponseEntity<Boolean>(Boolean.valueOf(true), HttpStatus.CREATED);
	}

	@RequestMapping(value = "createemployee", method = RequestMethod.POST)
	public ResponseEntity<Boolean> createEmployee(@RequestBody EmployeeDto employeeDto) {

		boolean value= adminService.addEmployee(employeeDto);
		if(value){
			return new ResponseEntity<Boolean>(Boolean.valueOf(false), HttpStatus.CREATED);
		}

		return new ResponseEntity<Boolean>(Boolean.valueOf(true), HttpStatus.CREATED);
	}

	@RequestMapping(value = "modifyemployee", method = RequestMethod.PUT)
	public ResponseEntity<Boolean> modifyEmployee(@RequestBody EmployeeDto employeeDto) {

		boolean value = adminService.modifyEmployee(employeeDto);
		if(value){
			return new ResponseEntity<Boolean>(Boolean.valueOf(false), HttpStatus.CREATED);
		}

		return new ResponseEntity<Boolean>(Boolean.valueOf(true), HttpStatus.CREATED);
	}

	@RequestMapping(value = "modifyNeedyPeople", method = RequestMethod.PUT)
	public ResponseEntity<Boolean> modifyNeedyPeople(@RequestBody NeedyPeopleDto needyPeopleDto) {

		boolean value = needyPeopleService.modifyNeedyPeople(needyPeopleDto);
		if(!value){
			return new ResponseEntity<Boolean>(Boolean.valueOf(false), HttpStatus.CREATED);
		}

		return new ResponseEntity<Boolean>(Boolean.valueOf(true), HttpStatus.CREATED);
	}

	@RequestMapping(value = "modifyDonor", method = RequestMethod.PUT)
	public ResponseEntity<Boolean> modifyDonor(@RequestBody DonorDto DonorDto) {

		boolean value = donorService.modeifyDonor(DonorDto);
		if(!value){
			return new ResponseEntity<Boolean>(Boolean.valueOf(false), HttpStatus.CREATED);
		}

		return new ResponseEntity<Boolean>(Boolean.valueOf(true), HttpStatus.CREATED);
	}

	@RequestMapping(value = "removeemployee/{empId}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> removeEmployee(@PathVariable int empId) {

		adminService.removeEmployee(empId);

		return new ResponseEntity<Boolean>(Boolean.valueOf(true), HttpStatus.ACCEPTED);
	}



	@RequestMapping(value = "removeDonor/{donorId}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> removeDonor(@PathVariable int donorId) {

		donorService.removeDonor(donorId);

		return new ResponseEntity<Boolean>(Boolean.valueOf(true), HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "findby/employeeid/{empId}", method = RequestMethod.GET)
	public ResponseEntity<Employee> findEmployeeById(@PathVariable int empId) {

		return new ResponseEntity<Employee>(adminService.findEmployeeById(empId), HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "findby/donorId/{donorId}", method = RequestMethod.GET)
	public ResponseEntity<Donor> findDonorById(@PathVariable int donorId) {

		return new ResponseEntity<Donor>(donorService.findByDonorId(donorId), HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "findby/employeename/{empname}", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> findEmployeeByName(@PathVariable String empname) {

		return new ResponseEntity<List<Employee>>(adminService.findEmployeeByName(empname), HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "findby/employeeall", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> findAllEmployee() {

		return new ResponseEntity<List<Employee>>(adminService.findAllEmployee(), HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "findby/donorall", method = RequestMethod.GET)
	public ResponseEntity<List<Donor>> findAllDonors() {

		return new ResponseEntity<List<Donor>>(donorService.findAllDonors(), HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "removeneedyperson/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> removeNeedyPersonById(@PathVariable int id) {

		needyPeopleService.removeNeedyPersonById(id);

		return new ResponseEntity<Boolean>(Boolean.valueOf(true), HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "findby/needyperson/{id}", method = RequestMethod.GET)
	public ResponseEntity<NeedyPeople> readNeedyPeopleById(@PathVariable int id) {
		try {
			return new ResponseEntity<NeedyPeople>(needyPeopleService.readNeedyPeopleById(id), HttpStatus.ACCEPTED);
		} catch (RecordNotFoundException e) {
			logger.error("record is not available in Database");
			return new ResponseEntity<NeedyPeople>(new NeedyPeople(), HttpStatus.ACCEPTED);
		}
	}

	@RequestMapping(value = "findby/needypersonName/{name}", method = RequestMethod.GET)
	public ResponseEntity<List<NeedyPeople>> readNeedyPeopleByName(@PathVariable String name) {

		return new ResponseEntity<List<NeedyPeople>>(needyPeopleService.readNeedyPeopleByName(name),
				HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "findall/needyperson", method = RequestMethod.GET)
	public ResponseEntity<List<NeedyPeople>> readAllNeedyPeople() {

		return new ResponseEntity<List<NeedyPeople>>(needyPeopleService.readAllNeedyPeople(), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value = "findall/donationboxes", method = RequestMethod.GET)
	public ResponseEntity<List<DonationBox>> readAllDonationBoxes() {

		return new ResponseEntity<List<DonationBox>>(donationBoxService.getAllDonationBoxes(), HttpStatus.ACCEPTED);
	}

	@GetMapping("login/admin/{username}/{password}")
	public ResponseEntity<UserDTO> loginAdmin(@PathVariable String username, @PathVariable String password){

		if("Admin".equalsIgnoreCase(username)){
			return new ResponseEntity<UserDTO>(new UserDTO(0,"Admin","Admin"), HttpStatus.ACCEPTED);

		}
		return new ResponseEntity<UserDTO>(new UserDTO(), HttpStatus.NOT_FOUND);
	}

	@GetMapping("login/employee/{username}/{password}")
	public ResponseEntity<UserDTO> loginEmployee(@PathVariable String username, @PathVariable String password){

		Employee employee =adminService.findByUsernameAndPassword(username,password);
		if(employee!=null){
			return new ResponseEntity<UserDTO>(new UserDTO(employee.getEmployeeId(),employee.getUsername(),"Employee"), HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<UserDTO>(new UserDTO(), HttpStatus.NOT_FOUND);
	}
	@GetMapping("login/donor/{username}/{password}")
	public ResponseEntity<UserDTO> loginDonor(@PathVariable String username, @PathVariable String password){

		Donor donor =  donorService.findByUsernameAndPassword(username,password);
		if(donor!=null){
			return new ResponseEntity<UserDTO>(new UserDTO(donor.getDonorId(),donor.getDonorUsername(),"Donor"), HttpStatus.ACCEPTED);

		}
		return new ResponseEntity<UserDTO>(new UserDTO(), HttpStatus.NOT_FOUND);
	}

	@GetMapping("login/needy/{username}/{password}")
	public ResponseEntity<UserDTO> loginNeedy(@PathVariable String username, @PathVariable String password){
			NeedyPeople needyPeople = needyPeopleService.findByUsernameAndPassword(username, password);

		if(needyPeople!=null){

			return new ResponseEntity<UserDTO>(new UserDTO(needyPeople.getNeedyPersonId(),needyPeople.getUsername(), "Needy"), HttpStatus.ACCEPTED);

		}
		return new ResponseEntity<UserDTO>(new UserDTO(), HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "findDonation/donorId/{donorId}", method = RequestMethod.GET)
	public ResponseEntity<List<Donation>> findDonationsBYDonor(@PathVariable int donorId) {

		return new ResponseEntity<List<Donation>>(donorService.findALlDonationsByDonor(donorId), HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "allDonations", method = RequestMethod.GET)
	public ResponseEntity<List<Donation>> findAllDonations() {

		return new ResponseEntity<List<Donation>>(donorService.findAllDonations(), HttpStatus.ACCEPTED);
	}

}
