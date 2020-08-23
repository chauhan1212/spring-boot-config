package com.vijay.springbootconfig.profiles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("production")
public class ProdSourceBean {
	
	@Bean
	public SomeService getService() {
		SomeService ss = new SomeService();
		ss.setDbConnection("production connection");
		ss.setHost("prod host");
		ss.setPort(1234);
		return ss;
	}

}
