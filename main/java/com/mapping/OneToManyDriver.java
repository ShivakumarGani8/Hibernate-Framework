package com.mapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToManyDriver {
	public static void main(String[] args) {
		System.out.println("++++++++++Start+++++++++++++");
		Configuration config=new Configuration();
		config.configure();
		SessionFactory factory=config.buildSessionFactory();
		Session session=factory.openSession();
		
		List<BankAccount> bankAccounts=new ArrayList<BankAccount>();
		Person person1=new Person();
		person1.setId(1001);
		person1.setAge(25);
		person1.setName("Shivakumar Gani");
		
		BankAccount account1=new BankAccount();
		account1.setBankName("HDFC");;
		account1.setBalance(5000);
		account1.setPerson(person1);
		bankAccounts.add(account1);
		
		BankAccount account2=new BankAccount();
		account2.setBankName("Union Bank of India");;
		account2.setBalance(1000);
		account2.setPerson(person1);
		bankAccounts.add(account2);
		
		BankAccount account3=new BankAccount();
		account3.setBankName("HDFC");;
		account3.setBalance(5000);
		account3.setPerson(person1);
		bankAccounts.add(account3);
		
		person1.setAccounts(bankAccounts);
		Transaction transaction=session.beginTransaction();
		
		session.save(account1);
		session.save(account2);
		session.save(account3);
		session.save(person1);
		transaction.commit();
		
		session.close();
		factory.close();
		System.out.println("++++++++++END+++++++++++++");
		
		
	}
}
