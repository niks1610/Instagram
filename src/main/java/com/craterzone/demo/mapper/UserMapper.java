package com.craterzone.demo.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.craterzone.demo.dao.AddressDao;
import com.craterzone.demo.dao.ContactDao;
import com.craterzone.demo.dao.UserDao;
import com.craterzone.demo.model.Address;
import com.craterzone.demo.model.ContactNo;
import com.craterzone.demo.model.User;
 
public class UserMapper {

	
	public static User UserDaoToUser(UserDao userDao){
		User user = new User();
		BeanUtils.copyProperties(userDao, user);
		user.setAddress(UserMapper.addressDaoToAddress(userDao.getAddress()));
		user.setContact(UserMapper.contactDaoToContact(userDao.getContact()));
		return user;
	}
     	
	public static UserDao UserToUserDao(User user){
		UserDao userDao = new UserDao();
		BeanUtils.copyProperties(user, userDao);
		userDao.setAddress(UserMapper.addressToAddressDao(user.getAddress()));
		userDao.getAddress().setUser(userDao);
		userDao.setContact(UserMapper.contactToContactDao(user.getContact()));
		userDao.getContact().setUser(userDao);
		return userDao;
	}
	
	public static AddressDao addressToAddressDao(Address address){
		AddressDao addressDao = new AddressDao();
		BeanUtils.copyProperties(address, addressDao);
		return addressDao;
	}
	
	public static ContactDao contactToContactDao(ContactNo contact){
		ContactDao contactDao = new ContactDao();
		BeanUtils.copyProperties(contact, contactDao);
        return contactDao;
	}
	
	public static Address addressDaoToAddress(AddressDao addressDao){
		Address address = new Address();
		BeanUtils.copyProperties(addressDao, address);
		return address;
	}
	
	public static ContactNo contactDaoToContact(ContactDao contactDao){
		ContactNo contact = new ContactNo();
		BeanUtils.copyProperties(contactDao, contact);
        return contact;
	}
	
	public static List<User> UserDaoListToUserList(List<UserDao> list)
	{
		return list.stream().map(x -> UserDaoToUser(x)).collect(Collectors.toList());
	}
	 
}
