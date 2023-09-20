package com.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mapping.BankAccount;
import com.mapping.Person;

public class CascadingExample {
	public static void main(String[] args) {
		Configuration configure =new Configuration();
		configure.configure();
		SessionFactory fact=configure.buildSessionFactory();
		Session session=fact.openSession();
		
		Person person=new Person();
		person.setId(1004);
		person.setAge(40);
		person.setName("SBG");
		
		BankAccount account1=new BankAccount(7,"KVGB",12398,person);
		BankAccount account2=new BankAccount(8,"Bank 1",1231,person);
		BankAccount account3=new BankAccount(9,"Test Bank",4343412,person);
		List<BankAccount> accounts=new ArrayList<BankAccount>();
		accounts.add(account1);
		accounts.add(account2);
		accounts.add(account3);
		person.setAccounts(accounts);
		
		Transaction tx=session.beginTransaction();
		session.save(person);
		tx.commit();
		session.close();
		fact.close();
		
	}
}
