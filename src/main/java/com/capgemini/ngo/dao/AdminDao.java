package com.capgemini.ngo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.ngo.entity.Employee;

@Repository
public interface AdminDao extends JpaRepository<Employee, Integer>{

	public List<Employee> findByEmployeeName(String name);

	public Employee findByUsernameAndPassword(String username,String password);

	public Employee findByUsername(String username);


}
