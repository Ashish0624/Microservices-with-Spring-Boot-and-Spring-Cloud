package com.ashish.rest.webservices.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService userDaoService;

	@GetMapping("/user")
	public List<User> findAll() {
		return userDaoService.findall();
	}

	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable int id) {
		User user = userDaoService.findOne(id);
		if(user == null){
			throw new UserNotFoundException("id - " + id);
		}
		
		return user;
	}

	@PostMapping("/user")
	public ResponseEntity<Object> saveUser(@RequestBody User user) {
		User savedUser = userDaoService.save(user);

		java.net.URI location = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
}
