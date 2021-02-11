package com.craterzone.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.craterzone.demo.service.*;
import com.craterzone.demo.model.User;
import com.craterzone.demo.mapper.UserMapper;
import com.craterzone.demo.model.Address;
import com.craterzone.demo.repository.*;
import java.util.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	@Autowired
	private UserService usersService;
	
	
	@PostMapping("/")
	public ResponseEntity<User> register(@Valid @RequestBody User user){
			 Optional<User> user1= usersService.saveUser(user);
			 //not null
			 if(!Objects.isNull(user1)) {
				 return ResponseEntity.status(HttpStatus.CREATED).body(user);
			 }	
		
		return ResponseEntity.badRequest().build();
	}
	
	@PostMapping("/login")
	public ResponseEntity<Optional<User>> login(@RequestBody User user){
		Optional<User> userDB = usersService.getUser(user);
		if(userDB!=null){
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(userDB);
		}
		
		return ResponseEntity.badRequest().build();
		
	}
	
	@GetMapping("/All")
	public ResponseEntity<Optional<List<User>>> getAll()
	{
		Optional<List<User>> list = usersService.getAll();
		if(list!=null)
		 return ResponseEntity.status(HttpStatus.OK).body(list);
		
		return ResponseEntity.noContent().build();
	}
	
	@PatchMapping("{id}/address")
	public ResponseEntity updateAddress(@PathVariable(name = "id") int id,@RequestBody Address address)
	{
		Optional<User> user = usersService.updateAddress(id, address);
		
		if(user.isPresent()){
			return ResponseEntity.status(HttpStatus.OK).body(user);
		}
		return ResponseEntity.badRequest().build();
		
	}
	
//	/*
//	 * @DeleteMapping("deleteuser") public void delete(int id) {
//	 * reqservice.delete(id); }
//	 */
	
//	@DeleteMapping("/delete/{id}")
//	public void delete(@PathVariable(name = "id") int id)
//	{
//		usersService.deleteUser(id);
//	}
	
}
