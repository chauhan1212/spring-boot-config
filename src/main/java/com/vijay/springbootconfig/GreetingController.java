package com.vijay.springbootconfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vijay.springbootconfig.profiles.SomeService;

@RestController
@RefreshScope
public class GreetingController {

	@Value("${my.greeting}")
	private String greetingMessage;

	@Value("${app.description}")
	private String description;

	@GetMapping("/greeting")
	public String greeting() {
		return greetingMessage;
	}

	@Value("${java.home}")
	private String javaHome;

	@GetMapping("/desc")
	public String desc() {
		return description;
	}

	@GetMapping("/home")
	public String home() {
		return javaHome;
	}

	@Value("some static message")
	private String staticMessage;

	@GetMapping("/staticmessage")
	public String staticMessage() {
		return staticMessage;
	}

	@Value("${my.defaultvalue: default value}")
	private String defaultValue;

	@GetMapping("/defaultvalue")
	public String defaultValue() {
		return defaultValue;
	}
	
	@Value("${my.list.values}")
	private List<String> listValues;
	
	@GetMapping("/listvalues")
	public List<String> listvalue() {
		return listValues;
	}
	
	@Value("${my.set.values}")
	private Set<String> setValues;
	
	@GetMapping("/setvalues")
	public Set<String> setvalue() {
		return setValues;
	}
	
	@Value("#{${dbvalues}}")
	private Map<String,String> mapValues;
	
	@GetMapping("mapvalues")
	public Map<String,String> mapValues() {
		return mapValues;
	}
	
	// 06 Configuration Properties
	@Autowired
	private DbSettings dbSettings;
	
	@GetMapping("/dbsettings")
	public String getDbSettings() {
		return dbSettings.getConnection()+ dbSettings.getHost()+" "+dbSettings.getPort();
	}
	
	@Autowired
	SomeService ss;
	
	@GetMapping("/profileinfo")
	public String getProfileInfo() {
		return ss.toString();
	}
	
	@Autowired
	Environment env;
	
	@GetMapping("/envdetails")
	public String getEnvDetails() {
		return env.toString();
	}
}
