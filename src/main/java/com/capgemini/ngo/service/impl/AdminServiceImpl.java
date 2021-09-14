package com.capgemini.ngo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ngo.dao.AddressDao;
import com.capgemini.ngo.dao.AdminDao;
import com.capgemini.ngo.entity.Address;
import com.capgemini.ngo.entity.Employee;
import com.capgemini.ngo.model.AddressDto;
import com.capgemini.ngo.model.DonationDistribution;
import com.capgemini.ngo.model.EmployeeDto;
import com.capgemini.ngo.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao adminDao;

	@Autowired
	AddressDao addressDao;

	@Override
	public boolean addEmployee(EmployeeDto employee) {
		Optional<Employee> optionalEmployee = adminDao.findById(employee.getEmployeeId());
		if(optionalEmployee.isPresent()){
			Employee emp = optionalEmployee.get();
			if(!emp.getUsername().equalsIgnoreCase(employee.getUsername())){
				Employee existingEmp = adminDao.findByUsername(employee.getUsername());
				if(existingEmp!= null ){
					return  false;
				}
			}
		}

		AddressDto address = employee.getAddress();

		Address addEntity = new Address();
		addEntity.setAddressId(address.getAddressId());
		addEntity.setCity(address.getCity());
		addEntity.setState(address.getState());
		addEntity.setPin(address.getPin());
		addEntity.setLandmark(address.getLandmark());
		addressDao.save(addEntity);
		Employee entity = new Employee(employee.getEmployeeId(), employee.getEmployeeName(), employee.getEmail(),
				employee.getPhone(), employee.getUsername(), employee.getPassword(), addEntity);

		Employee result = adminDao.save(entity);

		return true;
	}

	@Override
	public boolean modifyEmployee(EmployeeDto employee) {
		Optional<Employee> optionalEmployee = adminDao.findById(employee.getEmployeeId());
		if(optionalEmployee.isPresent()){
			Employee emp = optionalEmployee.get();
			if(!emp.getUsername().equalsIgnoreCase(employee.getUsername())){
				Employee existingEmp = adminDao.findByUsername(employee.getUsername());
				if(existingEmp!= null ){
					return  false;
				}
			}
		}

		AddressDto address = employee.getAddress();

		Address addEntity = new Address();
		addEntity.setAddressId(address.getAddressId());
		addEntity.setCity(address.getCity());
		addEntity.setState(address.getState());
		addEntity.setPin(address.getPin());
		addEntity.setLandmark(address.getLandmark());
		addressDao.save(addEntity);
		Employee entity = new Employee(employee.getEmployeeId(), employee.getEmployeeName(), employee.getEmail(),
				employee.getPhone(), employee.getUsername(), employee.getPassword(), addEntity);

		Employee result = adminDao.save(entity);

		return true;
	}

	@Override
	public boolean removeEmployee(int empId) {

		adminDao.deleteById(empId);
		return true;
	}

	@Override
	public Employee findEmployeeById(int empId) {

		Optional<Employee> emp = adminDao.findById(empId);

		if (emp.isPresent()) {
			return emp.get();
		} else {
			return null;
		}
	}

	@Override
	public List<Employee> findEmployeeByName(String name) {

		List<Employee> empList = adminDao.findByEmployeeName(name);

		return empList;
	}

	@Override
	public List<Employee> findAllEmployee() {

		List<Employee> empList = adminDao.findAll();
		return empList;
	}

	@Override
	public boolean approveDonation(DonationDistribution donationDistribution) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Employee findByUsernameAndPassword(String username,String password) {
		return adminDao.findByUsernameAndPassword(username,password);
	}

	@Override
	public Employee findByUsername(String username){
		return adminDao.findByUsername(username);
	}

}
