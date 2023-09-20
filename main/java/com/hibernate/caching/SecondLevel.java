package com.hibernate.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.Student;

public class SecondLevel {
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session1=factory.openSession();
		//Query will be written over DB for 1st call with session1
		Student student1= session1.get(Student.class, 1239);
		System.out.println(student1);
		session1.close();
		
		Session session2 = factory.openSession();
		//Query will not be written over DB for 2nd call even with session2
		Student student2= session2.get(Student.class, 1239);
		System.out.println(student2);
		session2.close();
		
	}
}
