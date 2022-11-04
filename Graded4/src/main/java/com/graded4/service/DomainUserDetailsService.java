package com.graded4.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.graded4.entity.DomainUserDetails;
import com.graded4.entity.User;
import com.graded4.repository.UserRepository;

@Service
public class DomainUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> optionaluser=this.userRepository.findByUsername(username);
		
		if (optionaluser.isPresent()) {
			User user =optionaluser.get();
			System.out.println(optionaluser.get());
			return new DomainUserDetails(user);
		}
		throw new UsernameNotFoundException("Bad Credentials");
	}

}
