package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchData {
	public static void main(String[] args) {
		Configuration config=new Configuration();
		config.configure();
		SessionFactory factory=config.buildSessionFactory();
		Session session= factory.openSession();
		
// ++++++++++++++++++++Existing data++++++++++++++++++++++++++++++++++
//		Using get()
//		Student studentGet=(Student)session.get(Student.class, 3);
//		System.out.println(studentGet);
		
//		Using load()
		Student studentLoad=(Student)session.load(Student.class, 3);
		System.out.println(studentLoad);
		
//++++++++++++++++++++Non Existing data++++++++++++++++++++++++++++++++++
//		Using get()
//		Student studentGet2=(Student)session.get(Student.class, 6); //NullPointerException
//		System.out.println(studentGet2);
		
//		Using load()
		Student studentLoad2=(Student)session.load(Student.class, 6); //ObjectNotFoundException
		System.out.println(studentLoad2);
		
		factory.close();
	}
}
