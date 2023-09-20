package com.pagination;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.Student;


public class Pagination {
	public static void main(String[] args) {
		Configuration configure=new Configuration();
		configure.configure();
		SessionFactory factory=configure.buildSessionFactory();
		Session session=factory.openSession();
		
		System.out.println("_________________________________________________");
		Query query=session.createQuery("from Student");
		List<Student> list=query.list();
		for(Student student :list)
			System.out.println(student);
		
		System.out.println("==============Pagination With Start And Max===================");
		query.setFirstResult(3);
		query.setMaxResults(4);
		List<Student> list2=query.list();
		for(Student student :list2)
			System.out.println(student);
		
		
//		System.out.println("==============Pagination Without Maximum===================");
//		query.setFirstResult(2);
//		List<Student> list4=query.list();
//		for(Student student :list4)
//			System.out.println(student);
//		
//		System.out.println("==============Pagination Without Start===================");
//		query.setMaxResults(5);
//		List<Student> list3=query.list();
//		for(Student student :list3)
//			System.out.println(student);
		
		
	}
}
