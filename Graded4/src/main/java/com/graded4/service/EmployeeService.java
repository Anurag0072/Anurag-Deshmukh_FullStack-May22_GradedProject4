package com.graded4.service;

import java.util.List;

import com.graded4.entity.Employee;


public interface EmployeeService {


	public Employee save(Employee employee);
	
	public  List<Employee> findAll();
	
	public Employee findById(int id);
	
	public Employee updateEmployee(int id, Employee updatedEmployee);
	
	public void deleteEmployeeById(int id);
	
	public List<Employee> findByFirstNameOrderByLastNameAsc(String firstName);
	
	public List<Employee> findByFirstNameOrderByLastNameDesc(String firstName);
}

