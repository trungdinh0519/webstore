package com.trung.goodstore.service.util;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.ui.velocity.VelocityEngineUtils;


/**
 * Class for sending e-mail messages standalone or based on Velocity templates
 * or with attachments.
 * 
 * @author Trung Dinh
 */
public class MailEngine implements Serializable{
public static final long serialVersionUID=121231231231256676L;
	protected Log log = LogFactory.getLog(getClass());

	private MailSender mailSender;

	private VelocityEngine velocityEngine;

	public MailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}

	public VelocityEngine getVelocityEngine() {
		return velocityEngine;
	}

	/**
	 * send a simple message with fields values
	 * 
	 * @param msg
	 */
	public void send(SimpleMailMessage msg) {
		try {
			mailSender.send(msg);
			log.debug("sended a message");
		} catch (MailException e) {
			log.error(e);
		}

	}

	/**
	 * send multi simple message with fields values
	 * 
	 * @param msg
	 */
	public void send(SimpleMailMessage[] msg) {
		for (int i = 0; i < msg.length; i++)
			this.send(msg[i]);
	}

	/**
	 * Convenience method for sending messages with attachments.
	 * 
	 * @param resource
	 * @param msg
	 * @param attachmentName
	 * @throws MessagingException
	 * @author Trung Dinh
	 */
	public void sendWithAttach(SimpleMailMessage msg, File resource,
			String attachmentName) throws MessagingException {
		MimeMessage message = ((JavaMailSenderImpl) mailSender)
				.createMimeMessage();
		MailHelper helper = new MailHelper(message, true);
		helper.copyTo(msg);
		helper.addAttachment(attachmentName, resource);
		((JavaMailSenderImpl) mailSender).send(message);
	}

	public void sendWithAttach(SimpleMailMessage msg,
			ClassPathResource resource, String attachmentName) {
		try {
			this.sendWithAttach(msg, resource.getFile(), attachmentName);
		} catch (MessagingException me) {
			log.error(me);
		} catch (IOException ie) {
			log.error(ie);
		} catch (Exception e) {
			log.error(e);
		}
	}

	public void sendWithInline(SimpleMailMessage msg,
			ClassPathResource resource, String inlineName)
			throws MessagingException {
		MimeMessage message = ((JavaMailSenderImpl) mailSender)
				.createMimeMessage();
		MailHelper helper = new MailHelper(message, true);
		helper.copyTo(msg);
		helper.addInline(inlineName, resource);
		((JavaMailSenderImpl) mailSender).send(message);

	}

	/**
	 * Send a simple mail message based on a Velocity template.
	 * 
	 * @param msg
	 * @paramtemplateName
	 * @param model
	 * @author Trung Dinh
	 */
	public void send(SimpleMailMessage msg, String templateName, Map model) {
		try {

			String result = VelocityEngineUtils.mergeTemplateIntoString(
					this.velocityEngine, templateName, model);
			msg.setText(result);
			System.out.println(result);
			mailSender.send(msg);
		} catch (VelocityException ve) {
			log.error(ve);
			ve.printStackTrace();
		} catch (MailException me) {
			me.printStackTrace();
			log.error(me);
		}

	}

	/**
	 * Send a range simple mail message based on a Velocity template.
	 * 
	 * @param msg
	 * @paramtemplateName
	 * @param model
	 * @author Trung Dinh
	 */
	public void send(SimpleMailMessage[] msgs, String templateName, Map model) {
		for (int i = 0; i < msgs.length; i++)
			this.send(msgs[i], templateName, model);

	}

	public void sendWithInline(SimpleMailMessage msg, String templateName,
			Map model, File file, String inlineName) {
		try {

			String result = VelocityEngineUtils.mergeTemplateIntoString(
					this.velocityEngine, templateName, model);
			msg.setText(result);
			MimeMessage message = ((JavaMailSenderImpl) mailSender)
					.createMimeMessage();
			MailHelper helper = new MailHelper(message, true);
			helper.copyTo(msg);
			helper.addInline(inlineName, file);
			((JavaMailSenderImpl) mailSender).send(message);

		} catch (MessagingException msse) {
			log.error(msse);
			msse.printStackTrace();
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
		}
	}

	public void sendWithInline(SimpleMailMessage msg, String templateName,
			Map model, ClassPathResource resource, String inlineName) {
		try {
			this.sendWithInline(msg, templateName, model, resource.getFile(),
					inlineName);
		} catch (IOException ie) {
			log.error(ie);
		}
	}

	public void sendWithAttach(SimpleMailMessage msg, String templateName,
			Map model, File file, String attachmentName) {
		try {

			String result = VelocityEngineUtils.mergeTemplateIntoString(
					this.velocityEngine, templateName, model);
			msg.setText(result);
			MimeMessage message = ((JavaMailSenderImpl) mailSender)
					.createMimeMessage();
			MailHelper helper = new MailHelper(message, true);
			helper.copyTo(msg);
			helper.addAttachment(attachmentName, file);
			((JavaMailSenderImpl) mailSender).send(message);

		} catch (MessagingException msse) {
			log.error(msse);
			msse.printStackTrace();
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
		}
	}

	public void sendWithAttach(SimpleMailMessage msg, String templateName,
			Map model, ClassPathResource resource, String attachmentName) {
		try {

			this.sendWithAttach(msg, templateName, model, resource.getFile(),
					attachmentName);
		} catch (IOException ie) {
			log.error(ie);
		}
	}

}
