package com.craterzone.demo.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.craterzone.demo.model.User;
import com.craterzone.demo.dao.UserDao;
import com.craterzone.demo.mapper.UserMapper;
import com.craterzone.demo.model.Address;
import com.craterzone.demo.repository.*;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	
	public Optional<User> saveUser(User user)
	{
		Optional<User> userDb=repo.findByEmail(user.getEmail());
		if(userDb.isPresent())
		{
			return null;
		}
		UserDao userDao = UserMapper.UserToUserDao(user);
		repo.save(userDao);
		
		
		return Optional.of(user);
		
	}
	
	

	
}
