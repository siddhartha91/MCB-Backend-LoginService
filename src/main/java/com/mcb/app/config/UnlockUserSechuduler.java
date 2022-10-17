package com.mcb.app.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.mcb.app.entities.User;
import com.mcb.app.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
public class UnlockUserSechuduler {

	@Autowired
	private UserRepository userRepository;
	
	@Scheduled(fixedRate = 60000  )
	public void unLockingUserAccount() {
		
		try {
			log.info("calling Schedule ::");
			List<User> userList = userRepository.getAllLockedAccounts();
			log.info("Locked Accouncts size is ::"+userList.size());

			if (userList.isEmpty()) {
				log.info("NO Locked Account Found ");
			} else {
				for (User user : userList) {
					Long lockedTime = user.getLockTime().getTime() + 60000;
					Long currentTime = System.currentTimeMillis();
					if (lockedTime < currentTime) {
						user.setAccountNonLocked(false);
						user.setLockTime(null);
						user.setFailedAttempt(0);
						userRepository.save(user);
						log.info("Reset to Default and saving In DB");

					}
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			log.error("Exception Occured while in schedulling:"+e.getCause());
		}

	

	}

}
