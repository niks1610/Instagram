package com.craterzone.demo.repository;



import com.craterzone.demo.dao.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

public interface UserRepository extends JpaRepository<UserDao,Integer>{
	
	Optional<UserDao> findByEmail(String email);
	Optional<UserDao> findByUsername(String username);
	
	@Modifying
	@Transactional
	@Query("update UserDao u set u.address = address where u.id = id")
	int updateAddress( @Param(value = "address") AddressDao address,@Param(value = "id") int id);
	
    
	

	
	
}
