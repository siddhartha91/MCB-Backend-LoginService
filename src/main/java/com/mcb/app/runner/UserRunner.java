package com.mcb.app.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.mcb.app.entities.User;
import com.mcb.app.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UserRunner implements ApplicationRunner {

	@Autowired
	UserRepository userRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// to test/execute any logic just on application ready
		
		log.info("JdbcAuth : creating users in db for User entity class.");
		User user1 = new User("mausoof", "m123", "USER");
		User user2 = new User("sid", "s123", "ADMIN");
		User user3 = new User("asif", "a123", "USER");
		User user4 = new User("aman", "a123", "MANAGER");
		User user5 = new User("vinod", "v123", "MANAGER");

//		userRepository.save(user1);
//		userRepository.save(user2);
//		userRepository.save(user3);
//		userRepository.save(user4);
//		userRepository.save(user5);

	}

}
