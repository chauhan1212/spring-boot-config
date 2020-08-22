package com.vijay.springbootconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	
	@Value("${my.greeting}")
	private String greetingMessage;
	
	@Value("${app.description}")
	private String description;
	
	@GetMapping("/greeting")
	public String greeting() {	
		return greetingMessage;
	}
	
	
	@RequestMapping(method = {RequestMethod.GET}, path = "desc")
	public String desc() {
		return description;
	}
}
