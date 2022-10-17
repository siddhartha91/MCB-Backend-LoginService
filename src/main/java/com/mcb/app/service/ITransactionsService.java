package com.mcb.app.service;

import java.util.List;

import com.mcb.app.entities.Transactions;

public interface ITransactionsService {
	List<Transactions> getTransactionsList();
	Transactions createTransactions(Transactions transactions);
	Transactions updateTransactions(Transactions transactions);
	String deleteTransactionsById(Long id);
	Transactions findOneTransactions(Long id);
}
