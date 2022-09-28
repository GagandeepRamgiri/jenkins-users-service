package com.sony.model;

import java.util.UUID;

import lombok.Data;

@Data
public class User {
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String city;
	
	public User() {
		this.setId(UUID.randomUUID().toString());
	}
	
	public User(String firstName, String lastName, String email, String city) {
		this();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.city = city;
	}
	
	
}
