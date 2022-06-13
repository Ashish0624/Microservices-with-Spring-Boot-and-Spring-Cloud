package com.ashish.rest.webservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	
	@GetMapping("/hello")
	public String helloWorld() {
		return "HelloWorld!";
	}
	
	@GetMapping("/hello/bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World!");
	}
}
