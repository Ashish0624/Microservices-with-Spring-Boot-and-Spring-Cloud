package com.ashish.rest.webservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	
	private static int userCount = 4;
	
	static {
		users.add(new User(1, "Adam", new Date()));
		users.add(new User(2, "Eve", new Date()));
		users.add(new User(3, "Andy", new Date()));
		users.add(new User(4, "Max", new Date()));
	}
	
	public List<User> findall(){
		return users;
	}
	
	public User save(User user) {
		
		if(user.getId() == null) {
			user.setId(++userCount); 
		}
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		for(User user : users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}
}
