package com.hibernate.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.Student;

public class FirstLevel {
	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		//Objects will be cached until session is closed
		Session session1=factory.openSession();
		Student student1=session1.get(Student.class, 1235);
		System.out.println(student1);
		//Query will not be written to this get() calling because the object will be already cached in memory
		Student student2=session1.get(Student.class, 1235);
		System.out.println(student2);
		
		session1.close();
		
		Session session2=factory.openSession();
		//Query will be written again to DB to get data.
		Student student3=session2.get(Student.class, 1235);
		System.out.println(student3);
		session2.close();
	}
}
