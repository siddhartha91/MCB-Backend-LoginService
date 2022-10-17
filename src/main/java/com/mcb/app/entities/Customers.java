package com.mcb.app.entities;

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
public class Customers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cust_No;
	private String short_Name;
	private String is_Individual;
	private String nationality;
	private int nationality_Num;
	private String nationality_Desc;
	private String street_Addr;
	private String town_Country;
	private String country;
	private String country_Code;
	private int country_Code_Num;
	private String despatch_Code;
}
