package com.mcb.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.mcb.app.entities.Customers;

@Service
public interface CustomerRepository extends JpaRepository<Customers, Long>  {
}
