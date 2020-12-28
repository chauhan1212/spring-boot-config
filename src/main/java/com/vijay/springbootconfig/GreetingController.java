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
// 13 Dynamic config with spring Boot
// To change dynamic properties from git  
@RefreshScope
public class GreetingController {

	/*
	 * 03 Using property file config with Spring Boot
	 * 04 Using external property sources with Spring Boot
	 * 
	 * Method1:
	 * create application.properties in same dir where jar exist. ( it will override properties insider properties)
	 * java -jar .\spring-cloud-config-0.0.1-SNAPSHOT.jar
	 * 
	 * Method2:
	 * java -jar .\spring-cloud-config-0.0.1-SNAPSHOT.jar --server.port=8081 --my.greeting="Hello from command line args"
	 * 
	 * 
	 * http://localhost:8080/greeting
	 * http://localhost:8080/desc
	 */
	
	@Value("${my.greeting}")
	private String greetingMessage;
	
	@GetMapping("/greeting")
	public String greeting() {
		return greetingMessage;
	}

	@Value("${app.description}")
	private String description;
	
	@GetMapping("/desc")
	public String desc() {
		return description;
	}

	/* Method 3:
	 * Taking value from system properties
	 * 
	 * http://localhost:8080/home
	 */
	@Value("${java.home}")
	private String javaHome;

	@GetMapping("/home")
	public String home() {
		return javaHome;
	}

	/*
	 * 05 Three Value annotation tricks you should know
	 *  http://localhost:8080/staticmessage
	 *  http://localhost:8080/defaultvalue
	 *  
	 */
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
	
	/*
	 * Fetching List, Set and Map using @Value annotation
	 * http://localhost:8080/listvalues
	 * http://localhost:8080/setvalues
	 * http://localhost:8080/mapvalues
	 */
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
	
	
	/*
	 * 06 Configuration Properties
	 * http://localhost:8080/actuator/configprops
	 * http://localhost:8080/dbsettings
	 * 
	 * 07 is about yml file structure
	 */
	@Autowired
	private DbSettings dbSettings;
	
	/*
	 * This we will use in 11, 12 Video for spring cloud config
	 */
	@GetMapping("/dbsettings")
	public String getDbSettings() {
		return dbSettings.toString();
	}
	
	/*
	 * 08 Spring profiles explained
	 * http://localhost:8080/profileinfo
	 * 
	 */
	@Autowired
	SomeService ss;
	
	@GetMapping("/profileinfo")
	public String getProfileInfo() {
		return ss.toString();
	}
	
	/*
	 * 09 Using Environment object
	 * http://localhost:8080/envdetails
	 * 
	 * From Video 10 we are using different project called spring-cloud-config-server
	 */
	@Autowired
	Environment env;
	
	@GetMapping("/envdetails")
	public String getEnvDetails() {
		return env.toString();
	}
	
	
	
}
