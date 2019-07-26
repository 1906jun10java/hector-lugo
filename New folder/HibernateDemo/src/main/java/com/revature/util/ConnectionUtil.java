package com.revature.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionUtil {
	
	private ConnectionUtil() {
		
	}
	
	private static SessionFactory sf;
	
	public static SessionFactory getSessionFactory() {
		if(sf==null) {
			Configuration c=new Configuration();
			c.configure();
			
			c.setProperty("hibernate.connection.username", System.getenv("DEMO_DB_USERNAME"));
			c.setProperty("hibernate.connection.password", System.getenv("DEMO_DB_PASSWORD"));
			c.setProperty("hibernate.connection.url", System.getenv("DEMO_DB_URL"));
			
			sf=c.buildSessionFactory();
		}
		
		return sf;
	}

}
