package com.trung.goodstore.service.util;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
/**
 * 
 * @author Trung Dinh
 *
 */
public class MailHelper extends MimeMessageHelper {
/**
 * 
 * @param arg0
 * @param arg1
 * @param arg2
 * @throws MessagingException
 */
	public MailHelper(MimeMessage arg0, boolean arg1, String arg2) throws MessagingException {
		super(arg0, arg1, arg2);
		// TODO Auto-generated constructor stub
	}
/**
 * 
 * @param arg0
 * @param arg1
 * @throws MessagingException
 */
	public MailHelper(MimeMessage arg0, boolean arg1) throws MessagingException {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}
/**
 * 
 * @param arg0
 * @param arg1
 * @param arg2
 * @throws MessagingException
 */
	public MailHelper(MimeMessage arg0, int arg1, String arg2) throws MessagingException {
		super(arg0, arg1, arg2);
		// TODO Auto-generated constructor stub
	}
/**
 * 
 * @param arg0
 * @param arg1
 * @throws MessagingException
 */
	public MailHelper(MimeMessage arg0, int arg1) throws MessagingException {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}
/**
 * 
 * @param arg0
 * @param arg1
 */
	public MailHelper(MimeMessage arg0, String arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}
/**
 * 
 * @param arg0
 */
	public MailHelper(MimeMessage arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @param msg
	 * @throws MessagingException
	 */
	public void copyTo(SimpleMailMessage msg)throws MessagingException{
		this.setBcc(msg.getBcc());
		this.setCc(msg.getCc());
		this.setFrom(msg.getFrom());
		this.setTo(msg.getTo());
		this.setText(msg.getText());
		this.setReplyTo(msg.getReplyTo());
		this.setSubject(msg.getSubject());
		this.setSentDate(msg.getSentDate());
		
	}
}
