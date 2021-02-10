package com.craterzone.demo.repository;



import com.craterzone.demo.model.ContactNo;
import com.craterzone.demo.model.User;
import com.craterzone.demo.model.Address;
import com.craterzone.demo.dao.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface UserRepository extends JpaRepository<UserDao,Integer>{
	
	Optional<User> findByEmail(String email);

	

	
	
}
