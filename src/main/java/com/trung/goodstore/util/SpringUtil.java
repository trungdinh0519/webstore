package com.trung.goodstore.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtil {
	private static ApplicationContext context = new ClassPathXmlApplicationContext(
			"applicationContext*.xml");

	public static Object getBean(String beanName) {
		Object bean = context.getBean(beanName);
		return bean;
		
	}
	public void mm(){
	//	m.getMimeMessage().getFolder().
	}
	org.springframework.mail.javamail.MimeMailMessage m;

	public void setM(org.springframework.mail.javamail.MimeMailMessage m) {
		this.m = m;
	}
	
}
