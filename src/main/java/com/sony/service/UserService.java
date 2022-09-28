
package com.sony.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sony.model.User;

@Service
public class UserService {
	
	private Map<String,User> users;
	
	public UserService() {
		users = new HashMap<>();
		User user;
		
		user = new User("Gagandeep","Ramgiri","gagandeep@xmpl.com","Hubballi");
		users.put(user.getId(), user);
		
		user = new User("Adarsh","Shanbhag","adarsh@xmpl.com","Karwar");
		users.put(user.getId(), user);
		
		user = new User("Suraj","Meharwade","suraj@xmpl.com","Hubballi");
		users.put(user.getId(), user);
		
	}
	
	
	public Iterable<User> getAllUsers(){
		return this.users.values();
	}
	
	public User getUserById(String id) {
		return this.users.get(id);
	}
}
