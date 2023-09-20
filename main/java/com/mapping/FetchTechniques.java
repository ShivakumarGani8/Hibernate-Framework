package com.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchTechniques {
	public static void main(String[] args) {
		System.out.println("++++++++++Start+++++++++++++");
		Configuration config=new Configuration();
		config.configure();
		SessionFactory factory=config.buildSessionFactory();
		Session session=factory.openSession();
		
		Person person= (Person) session.get(Person.class, 1001);
		System.out.println("Name: "+person.getName());
		System.out.println("Age: "+person.getAge());
	}
}
