package com.vijay.springbootconfig.profiles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("test")
public class LocalSourceBean {
	
	
	@Bean
	public SomeService getService() {
		SomeService ss = new SomeService();
		ss.setDbConnection("local connection");
		ss.setHost("local host");
		ss.setPort(1234);
		return ss;
	}
}
