package com.sony.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sony.model.User;
import com.sony.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService mgr;
	
	
	@GetMapping(produces = "application/json")
	public Iterable<User> handleGet(){
		return mgr.getAllUsers();
	}
	
	@GetMapping(path = "/{id}" , produces = "application/json")
	public ResponseEntity<Object> handleGetUserById(@PathVariable String id) {
		User obj = mgr.getUserById(id);
		if(obj == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(obj);
	}
	
}
