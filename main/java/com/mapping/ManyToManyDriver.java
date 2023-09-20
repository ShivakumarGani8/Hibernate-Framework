package com.mapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToManyDriver {
	public static void main(String[] args) {
		Configuration config= new Configuration();
		config.configure();
		SessionFactory factory=config.buildSessionFactory();
		Session session=factory.openSession();
		
//		List<Projects> projects1=new ArrayList<Projects>();
//		List<Employee> employees1=new ArrayList<Employee>();
//		Employee e1=new Employee(101,"Employee1");
//		Projects p1=new Projects(1409,"Project1");
//		projects1.add(p1);
//		employees1.add(e1);
//		e1.setProjects(projects1);
//		p1.setEmployees(employees1);
		
		
		List<Projects> projects2=new ArrayList<Projects>();
		List<Employee> employees2=new ArrayList<Employee>();
		Employee e1=new Employee(101,"Employee1");
		employees2.add(e1);
		Employee e2=new Employee(102,"Employee2");
		employees2.add(e2);
		Projects p2=new Projects(1410,"Project2");
		projects2.add(p2);
		Projects p3=new Projects(1411,"Project3");
		projects2.add(p3);
		e2.setProjects(projects2);
		p2.setEmployees(employees2);
		
//
//		List<Projects> projects3=new ArrayList<Projects>();
//		List<Employee> employees3=new ArrayList<Employee>();
//		Employee e3=new Employee(103,"Employee3");
//		Employee e4=new Employee(104,"Employee3");
//		Projects p4=new Projects(1412,"Project4");
//		projects3.add(p4);
//		employees3.add(e3);
//		employees3.add(e4);
//		e3.setProjects(projects3);
//		p3.setEmployees(employees3);
//		
		
		Transaction tx=session.beginTransaction();
		session.save(e1);
//		session.save(p1);
		session.save(e2);
		session.save(p2);
		session.save(p3);
//		session.save(e3);
//		session.save(e4);
//		session.save(p4);
		tx.commit();
		
		session.close();
		factory.close();
	}
}
