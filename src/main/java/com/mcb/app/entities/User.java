package com.mcb.app.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Users")
@Data
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String username;
	private String password;
	private String role;
	private boolean enabled;

	//check attempt
	private boolean accountNonLocked;

	private int failedAttempt;

	private Date lockTime;

	// insert into users values(101, 'mausoof','m123','USER');

	public User(String username, String password, String role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}
}
