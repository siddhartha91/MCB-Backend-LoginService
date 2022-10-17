package com.mcb.app.service;

import java.sql.Timestamp;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcb.app.entities.LoginResponse;
import com.mcb.app.entities.User;
import com.mcb.app.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class UserLoginService {

	public static final int LOGIN_MAX_FAILED_ATTEMPTS = 2;
	private static final long ACCOUNT_LOCK_TIME_DURATION = 24 * 60 * 60 * 1000; // 24 hours
	private int count = 0;

	@Autowired
	private UserRepository userRepository;

	public LoginResponse userLogin(User user) {
		// fetch user from db & storing into dbUser
		User dbUser = userRepository.findByUsername(user.getUsername());
		LoginResponse loginResponse = new LoginResponse();
		try {

			if (dbUser != null) {

				if (dbUser.isAccountNonLocked()) {

					loginResponse.setMessage("Your account locked please try after 24 hours!");
					loginResponse.setStatus(403);

				} else {
					if (dbUser.getUsername().equalsIgnoreCase(user.getUsername())
							&& dbUser.getPassword().equalsIgnoreCase(user.getPassword())) {
						loginResponse.setStatus(200);
						loginResponse.setMessage("Login sucess");
						dbUser.setFailedAttempt(0);
						userRepository.save(dbUser);

					} else {

						loginResponse.setStatus(401);
						loginResponse.setMessage("Login failed attempt username or password inncorrect!");
						dbUser.setFailedAttempt(dbUser.getFailedAttempt() + 1);

						userRepository.save(dbUser);

						if (dbUser.getFailedAttempt() > LOGIN_MAX_FAILED_ATTEMPTS) {

							dbUser.setAccountNonLocked(true);
							dbUser.setLockTime(new Timestamp(System.currentTimeMillis()));
							userRepository.save(dbUser);

						}

					}

				}
			} else {
				loginResponse.setMessage("User Not Found! with " + user.getUsername());
				loginResponse.setStatus(404);

			}
			return loginResponse;
		} catch (Exception e) {
			e.printStackTrace();
			loginResponse.setMessage("Internal server Error!");
			loginResponse.setStatus(500);
			return loginResponse;
		}

	}

}
