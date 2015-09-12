package com.naturalprogrammer.spring.sample.mail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// @Component instructs Spring to create an instance of MockMailSender
// Object is placed onto the Spring application context
// @Primary instructs Spring to use this bean if there are multiple beans that are.. 
// eligible to be injected
// @Qualifier is used to identify bean when using @Autowired annotation
@Component 
//@Primary
@Qualifier("smtp")
public class SmtpMailSender implements MailSender {

	private static final Log log = LogFactory.getLog(SmtpMailSender.class);
	
	/* (non-Javadoc)
	 * @see com.naturalprogrammer.spring.sample.mail.MailSender#send(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void send(String to, String subject, String body) {
		log.info("Sending SMPT mail to " + to);
		log.info("Subject: " + subject);
		log.info("Body: " + body);
	}
	
}
