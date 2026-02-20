package com.anupd.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId",length = 11,nullable = false,unique = true)
	private int id;
	
	@Column(name = "username",length = 100)
	private String name;
	
	@Column(name = "email",length =100,nullable = true,unique = true)
	private String email;
	
	@Column(name = "role",length = 100)
	private String role;
	
	@Column(name = "userpass",length = 100)
	private String password;
	
	

}
