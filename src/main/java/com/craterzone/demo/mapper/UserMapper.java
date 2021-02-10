package com.craterzone.demo.mapper;

import com.craterzone.demo.dao.UserDao;
import com.craterzone.demo.model.User;

public class UserMapper {

	
	public static User UserDaoToUser(UserDao userDao)
	{
		//return new User(userDao.getName(),userDao.getUserName(),userDao.getAddress(),userDao.getContact(),userDao.getEmail(),userDao.getPassword());
		return new User();
	}
     	
	public static UserDao UserToUserDao(User user)
	{
		return new UserDao();
	
	}
}
