package com.graded4.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.graded4.entity.Employee;
import com.graded4.entity.Role;
import com.graded4.entity.User;
import com.graded4.repository.UserRepository;
import com.graded4.repository.employeeRepository;

@Component
public class BootstrapAppData {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private employeeRepository empRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@EventListener(ApplicationReadyEvent.class)
	public void insertData(ApplicationReadyEvent event) {
		Employee employee = new Employee();
		employee.setFirstName("java-8");
		employee.setLastName("HearBert shild");
		employee.setEmail("programming");
		
		Employee employee2 = new Employee();
		employee2.setFirstName("Node js");
		employee2.setLastName("ppinto shild");
		employee2.setEmail("programming");
		
		Employee employee3 = new Employee();
		employee3.setFirstName("python");
		employee3.setLastName("vin shild");
		employee3.setEmail("programming");
		
		this.empRepository.save(employee);
		this.empRepository.save(employee2);
		this.empRepository.save(employee3);

	}
		
	@EventListener(ApplicationReadyEvent.class)
	public void insertUsers(ApplicationReadyEvent event) {
		
		User kiran = new User();
		kiran.setUsername("kiran");
		kiran.setPassword(this.passwordEncoder.encode("welcome"));
		
		User vinay = new User();
		vinay.setUsername("vinay");
		vinay.setPassword(this.passwordEncoder.encode("welcome"));
		
		Role userRole = new Role();
		userRole.setName("ROLE_USER");
		
		Role adminRole = new Role();
		adminRole.setName("ROLE_ADMIN");
		
		List<Role> roles = kiran.getRoles();
		roles.add(userRole);
		
		Role vinayuserRole = new Role();
		vinayuserRole.setName("ROLE_USER");
		
		List<Role> vinayRoles = vinay.getRoles();
		vinayRoles.add(adminRole);
		vinayRoles.add(vinayuserRole);
		
		this.userRepository.save(kiran);
		this.userRepository.save(vinay);

	}
		
	
}
