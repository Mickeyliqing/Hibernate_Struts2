package com.hibernate.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	private static SessionFactory factory;
	static {
		factory = new Configuration().configure().buildSessionFactory();
	}
	
	public static Session HibernateConfigSession(){
		return factory.openSession();
	}
}
