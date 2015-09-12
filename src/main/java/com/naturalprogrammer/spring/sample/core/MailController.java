package com.naturalprogrammer.spring.sample.core;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naturalprogrammer.spring.sample.mail.MailSender;

// @RestController means its ready for use by Spring MVC to handle web requests
// @RestController convenience annotation that is annotated @Controller and @ResponseBody,
// a combination of @Controller and @ResponseBody results in web requests returning data instead of views
@RestController 
public class MailController {

	//private MailSender mailSender = new MockMailSender();
	
	// @Resource looks for a bean named mailSender, but in this case it wont find it..
	// it then proceeds to look for a bean of type MailSender, and in this case, 
	// it will find MockMailSender, which implements the MailSender interface
	// After finding it, @Resource will inject the bean into mailSender
	//@Resource
	private MailSender mailSender;
	
	// @Resource annotation can also be used on setter methods
	/*@Resource
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}*/
	
	// @Autowired is similar to @Resource, but it also works on constructors
	// Unlike @Resource, @Autowire does not take the name parameter, but it uses @Qualifier
	/*@Autowired
	public MailController(@Qualifier("smtp") MailSender mailSender) {
		this.mailSender = mailSender;
	}*/
	
	@Autowired
	public MailController(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	
	@RequestMapping("/mail")
	public String sendMail() throws MessagingException {
		mailSender.send("xxx", "working?", "working on friday?");
		return "Mail sent";
	}
	
}
