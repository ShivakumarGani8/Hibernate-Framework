package com.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.Student;
import com.mapping.BankAccount;
import com.mapping.Person;

public class HibernetQueryLanguage {
	public static void main(String[] args) {
		Configuration configure = new Configuration();
		configure.configure();
		SessionFactory factory = configure.buildSessionFactory();
		Session session = factory.openSession();

		// Fetching all data from DB using HQL
//		Query query=session.createQuery("from Student");
//		List<Student> students=query.list();
//		for(Student student: students ) {
//			System.out.println("ID: "+student.getId()+", Name: "+student.getName());
//		}

//		System.out.println("_______________________________________________________");
		// Fetching specific data from DB using HQL
//		Query  query2= session.createQuery("from Student where name='Shivakumar Gani'");
//		List<Student> students2= query2.list();
//		for(Student student: students2)
//			System.out.println("Name: "+student.getName()+", Address: "+student.getAddress());

//		System.out.println("_______________________________________________________");
		// Updating data of table using HQL
//		Query query3= session.createQuery("update Student set id=1242 where id=:id");
		Transaction transaction = session.beginTransaction();
//		query3.setParameter("id",1234);
//		int updates=query3.executeUpdate();
//		System.out.println("Total updates done: "+updates);

//		System.out.println("_______________________________________________________");
		// Deleting specific data from table
//		Query query4= session.createQuery("delete from Student where id=1234");
//		int deleted= query4.executeUpdate();
//		System.out.println("Total data deleted: "+deleted);

//		transaction.commit();
		System.out.println("_______________________________________________________");
		// Joining two tables using HQL
		Query query5 = session
				.createQuery("Select p.id ,p.name, a.accountNo "
						+ "from Person as p INNER JOIN p.accounts as a");
		List<Object[]> persons = query5.list();

		for (Object[] person : persons) {
			System.out.println(Arrays.toString(person));
		}

		session.close();
		factory.close();

	}
}
