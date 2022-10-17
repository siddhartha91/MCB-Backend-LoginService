package com.mcb.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.mcb.app.repository.TransactionsRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
@EnableScheduling
public class McbBackendServiceApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(McbBackendServiceApplication.class, args);
		log.info("app running fine...");
	}

	@Autowired
	private TransactionsRepository transactionsRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		//transactionsRepository.save(new Transactions(101L, "Deposit", 30000D, "Siddhartha Sharma", LocalDate.now(), true));
		//transactionsRepository.save(new Transactions(102L, "Fund Transfer", 40000D, "Aman", LocalDate.now(), false));
	}

}
