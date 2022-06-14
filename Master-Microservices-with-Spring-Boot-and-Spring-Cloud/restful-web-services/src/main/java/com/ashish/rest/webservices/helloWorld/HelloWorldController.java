package com.ashish.rest.webservices.helloWorld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@Autowired
	private MessageSource messageSource;
	
	@GetMapping("/hello")
	public String helloWorld() {
		return "HelloWorld!";
	}
	
	@GetMapping("/hello/bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World!");
	}
	
	@GetMapping("/hello/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World!, %s ", name));
	}
	
	@GetMapping("/hello-internationalization")
	public String helloWorldiInt(@RequestHeader(name="Accept-Language", required = false)Locale locale) {
		return messageSource.getMessage("good.morning.message", null, locale);
	}
}
