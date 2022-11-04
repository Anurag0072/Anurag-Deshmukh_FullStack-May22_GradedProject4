package com.graded4.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.graded4.entity.Employee;

@Repository
public interface employeeRepository extends JpaRepository<Employee, Integer> {
	
	
	//public List<Employee> findByfirstNameStartingWith(String firstName);
	List<Employee> findByFirstNameOrderByLastNameAsc(String firstName);
	List<Employee> findByFirstNameOrderByLastNameDesc(String firstName);

}
