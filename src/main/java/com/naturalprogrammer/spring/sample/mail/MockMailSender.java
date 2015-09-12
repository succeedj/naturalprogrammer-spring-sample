package com.naturalprogrammer.spring.sample.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

// @Component instructs Spring to create an instance of MockMailSender
// Object is placed onto the Spring application context
//@Component 
public class MockMailSender implements MailSender {

	private static final Log log = LogFactory.getLog(MockMailSender.class);

	/*private DemoObject demoObject;
	
	public void setDemoObject(DemoObject demoObject) {
		this.demoObject = demoObject;
	}*/
	
	private JavaMailSender javaMailSender;
	
	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	/* (non-Javadoc)
	 * @see com.naturalprogrammer.spring.sample.mail.MailSender#send(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void send(String to, String subject, String body) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper;
		
		helper = new MimeMessageHelper(message, true); // true indicates multipart message
		
		helper.setSubject(subject);
		helper.setTo(to);
		helper.setText(body, true); // true indicates html
		
		javaMailSender.send(message);
	}
	
}
