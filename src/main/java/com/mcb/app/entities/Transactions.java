package com.mcb.app.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Transactions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transId;
	private String transactions;
	private Double amount;
	private String transactionsBy;
	private LocalDate transDate;
	private boolean status; 
}
