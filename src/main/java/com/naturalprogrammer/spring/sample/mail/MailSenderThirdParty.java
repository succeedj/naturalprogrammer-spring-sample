package com.naturalprogrammer.spring.sample.mail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;


public class MailSenderThirdParty implements MailSender {

	private static final Log log = LogFactory.getLog(MailSenderThirdParty.class);
	
	private DemoObject demoObject;
	
	public void setDemoObject(DemoObject demoObject) {
		this.demoObject = demoObject;
	}
	
	/* (non-Javadoc)
	 * @see com.naturalprogrammer.spring.sample.mail.MailSender#send(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void send(String to, String subject, String body) {
		log.info("Sending third party mail to " + to);
		log.info("Subject: " + subject);
		log.info("Body: " + body);
	}
	
}
