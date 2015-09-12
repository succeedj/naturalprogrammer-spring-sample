package com.naturalprogrammer.spring.sample.mail;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class MailConfig {
	
	// If we wanted to use a third party library, for which we do not have source code, and
	// cannot create annotations for, we can use the @Bean annotation on a method
	// In this case, the returned value should be going to the application context as a bean...
	// with the name mailSenderThirdParty. The result is the same as identifying the MailSenderThirdParty...
	// class as @Component, thereby indirectly creating an instance of the MailSenderThirdParty class
	// Spring Profiles provide a way to segregrate parts of your application configuration and make it
	// only available in certain environments, eg development, testing, or production
	// @Profile tells Spring to only create the bean when the profile is dev
	@Bean
	//@Profile("dev")
	public MailSender mailSenderThirdParty() {
		// return new MailSenderThirdParty();
		// DemoObject demobj = new DemoObject();
		MailSenderThirdParty mailSender = new MailSenderThirdParty();
		mailSender.setDemoObject(demoObject()); // demoobject will be created only once in the application context
		return mailSender;
	}
	
	@Bean
	@Primary
	public MockMailSender mockMailSender(JavaMailSender javaMailSender) {
		// return new MockMailSender();
		// DemoObject demoobj = new DemoObject();
		MockMailSender mailSender = new MockMailSender();
		mailSender.setJavaMailSender(javaMailSender);
		return mailSender;
	}
	
	@Bean // demoobject will be created only once in the application context, because this is a @Configuration class
	public DemoObject demoObject() {
		return new DemoObject();
	}
}
