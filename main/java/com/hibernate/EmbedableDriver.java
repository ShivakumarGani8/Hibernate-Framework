package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbedableDriver {
	public static void main(String[] args) {
		System.out.println("+++++++++++Start+++++++++");
		Configuration configuration=new Configuration();
		configuration.configure();
		SessionFactory factory= configuration.buildSessionFactory();
		Student student1=new Student(1238,"Shivakumar Gani","Bagalkote");
		StudentCertificate stdcert1=new StudentCertificate("ABC1234", "Java Core");
		student1.setCertificate(stdcert1);
		Student student2=new Student(1239,"Sudeep Gani","Jamakhandi");		
		StudentCertificate stdcert2=new StudentCertificate("ABC1235", "Java Advance");
		student2.setCertificate(stdcert2);
		
		Session session= factory.openSession();
		Transaction transaction=session.beginTransaction();
		session.save(student1);
		session.save(student2);
		session.getTransaction().commit();
		
		factory.close();
		System.out.println("++++++++++++++Data updated++++++++++++");
	}
}
