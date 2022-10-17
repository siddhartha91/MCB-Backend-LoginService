package com.mcb.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.mcb.app.entities.Transactions;

@Service
public interface TransactionsRepository extends JpaRepository<Transactions, Long>  {
}
