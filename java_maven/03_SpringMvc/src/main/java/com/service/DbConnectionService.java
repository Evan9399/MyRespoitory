package com.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DbConnectionService {
	public Session getSession() {
		Configuration configuration = new Configuration().configure();
	    SessionFactory sessionFactory = configuration.buildSessionFactory();
	    Session session = sessionFactory.openSession();
	    return session;
	}
	
}
