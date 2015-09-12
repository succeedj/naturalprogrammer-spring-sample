package com.naturalprogrammer.spring.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication is the same as @Configuration, @EnableAutoConfiguration, @ComponentScan
// @Configuration - class is source of bean definitions for the application context
// @EnableAutoConfiguration - instructs Spring to start adding beans based on the classpath settings
// @ComponentScan - tells Spring to look for other components, configurations, and services in the 
// com.naturalprogrammer.spring.sample package
// You would need to add @EnableWebMVC for a Spring MVC app, but Spring Boot adds it automatically when..
// it sees spring-webmvc on the classpath. This identifies the application as a web application and...
// automatically activates behaviors such as setting up a DispatcherServlet
@SpringBootApplication
public class NaturalprogrammerSpringSampleApplication {

	// The main method uses Spring Boot's SpringApplication.run() method to launch the application
	// No need for any xml files, including web.xml, its all Java
	// The run() method returns an ApplicationContext
    public static void main(String[] args) {
        SpringApplication.run(NaturalprogrammerSpringSampleApplication.class, args);
    }
}
