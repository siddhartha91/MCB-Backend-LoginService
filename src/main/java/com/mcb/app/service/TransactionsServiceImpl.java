package com.mcb.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcb.app.entities.Transactions;
import com.mcb.app.repository.TransactionsRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TransactionsServiceImpl implements ITransactionsService {

	@Autowired
	private TransactionsRepository transactionsRepository;

	private List<Transactions> transactions = new ArrayList<>();

//	{
//		transactions.add(new Transactions(101L, "Deposit", 30000D, "Siddhartha Sharma", LocalDate.now()));
//		transactions.add(new Transactions(102L, "Fund Transfer", 40000D, "Aman", LocalDate.now()));
//	}
	@Override
	public List<Transactions> getTransactionsList() {
		log.info("Service : getTransactionsList() executed!");
		return transactionsRepository.findAll();
	}

	@Override
	public Transactions createTransactions(Transactions transactions) {
		return transactionsRepository.save(transactions);
	}

	@Override
	public Transactions updateTransactions(Transactions transactions) {
		return transactionsRepository.save(transactions);
	}

	@Override
	public String deleteTransactionsById(Long id) {
		try {
			transactionsRepository.deleteById(id);
			return "Transaction id[" + id + "] deleted successfully!";
		} catch (Exception e) {
			log.info("Error : {}", e);
			return "Transaction id[" + id + "] deletion failed!";
		}
	}

	@Override
	public Transactions findOneTransactions(Long id) {
		return transactionsRepository.findById(id).orElse(new Transactions());
	}

}
