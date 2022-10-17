package com.mcb.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mcb.app.entities.Transactions;
import com.mcb.app.service.TransactionsServiceImpl;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin("http://localhost:4200")
@RestController
@Slf4j
@RequestMapping("mcb/api/transactions")
public class TransactionsController {

	@Autowired
	private TransactionsServiceImpl transactionsServiceImpl;

	@GetMapping("/view")
	public ResponseEntity<?> getTransactionsList() {
		log.info("Controller : getTransactionsList() executed!");
		List<Transactions> transactions = transactionsServiceImpl.getTransactionsList();
		if (transactions.isEmpty()) {
			return new ResponseEntity<>("No content", HttpStatus.OK);
		} else {
			return new ResponseEntity<>(transactionsServiceImpl.getTransactionsList(), HttpStatus.OK);
		}
	}

	@PostMapping("/create")
	public String createTransactions(@RequestBody Transactions transactions) {
		log.info("Controller : createTransactions() executed!");
		Transactions transaction = transactionsServiceImpl.createTransactions(transactions);
		if (transaction != null) {
			return "Hi " + transaction.getTransactionsBy() + "!, your tansactions processed successfully!";
		} else {
			return "Hi " + transaction.getTransactionsBy() + "!, your tansactions failed!";
		}
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateTransactions(@RequestBody Transactions transactions) {
		log.info("Controller : updateTransactions() executed!");
		Transactions transaction = transactionsServiceImpl.createTransactions(transactions);
		if (transaction != null) {
			return new ResponseEntity<>(transaction, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Unable to update this transaction", HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteTransactionsById(@PathVariable Long id) {
		log.info("Controller : deleteTransactionsById(" + id + ") executed!");
		if (transactionsServiceImpl.findOneTransactions(id) != null) {
			transactionsServiceImpl.deleteTransactionsById(id);
			return new ResponseEntity<>("deleted this transaction successfuly", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Unable to delete this transaction", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/view/{id}")
	public ResponseEntity<?> findOneTransactions(@PathVariable Long id) {
		log.info("Controller : deleteTransactionsById(" + id + ") executed!");
		Transactions transactions = transactionsServiceImpl.findOneTransactions(id);
		if (transactions != null) {
			return new ResponseEntity<>(transactions, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("transaction not found!", HttpStatus.NOT_FOUND);
		}
	}

}
