package com.mcb.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mcb.app.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	
	User findByUsername(String username);
	
	@Query(value = "select * from Users where account_non_locked = 1",nativeQuery = true)
	public List<User> getAllLockedAccounts();


}
