package com.capgemini.ngo.service;

import java.util.List;

import com.capgemini.ngo.entity.Employee;
import com.capgemini.ngo.model.DonationDistribution;
import com.capgemini.ngo.model.EmployeeDto;


public interface AdminService {

	public boolean addEmployee(EmployeeDto employee);
	
	public boolean modifyEmployee(EmployeeDto employee);
	
	public boolean removeEmployee(int empId);
	
	public Employee findEmployeeById(int empId);
	
	public List<Employee> findEmployeeByName(String name);
	
	public List<Employee> findAllEmployee();
	
	public boolean approveDonation(DonationDistribution donationDistribution);

	public Employee findByUsernameAndPassword(String username,String password);

	public Employee findByUsername(String username);
	
}
