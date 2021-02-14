package com.craterzone.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.craterzone.demo.repository.UserRepository;

@Service
public class MyUserDetailService implements UserDetailsService{
	
	@Autowired
	private UserRepository repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		if(username.equals(repo.findByUsername(username).get().getUsername()))
			
            return new User(repo.findByUsername(username).get().getUsername(),repo.findByUsername(username).get().getPassword(),new ArrayList<>()); 
		else
			throw new UsernameNotFoundException("User Not Found!");
			
		
		
	}

}
