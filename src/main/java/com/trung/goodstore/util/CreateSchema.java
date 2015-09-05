package com.trung.goodstore.util;
import org.hibernate.Session;

public class CreateSchema {
	public static void main(String[] args) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.close();
	}

}
