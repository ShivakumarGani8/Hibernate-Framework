package com.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneDriver {
	
	public static void main(String[] args) {
		System.out.println("++++++++++Start++++++++++++++");
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory factory=cfg.buildSessionFactory();
		
		Session session=factory.openSession();
		
		Answer answer1=new Answer();
		answer1.setAnswerId(101);
		answer1.setAnswer("Collection is API for Objects collection");
		Question question1=new Question();
		question1.setQuestionId(10001);
		question1.setQuestion("What is Collection?");
		question1.setAnswer(answer1);
		answer1.setQuestion(question1);
		
		Answer answer2=new Answer();
		answer2.setAnswerId(102);
		answer2.setAnswer("Eclipse is an IDE for Java");
		Question question2=new Question();
		question2.setQuestionId(10003);
		question2.setQuestion("What is Eclipse?");
		question2.setAnswer(answer2);
		answer2.setQuestion(question2);
		
		Transaction transaction= session.getTransaction();
		session.beginTransaction();
		
		session.save(question1);
		session.save(answer1);
		
		session.save(answer2);
		session.save(question2);
		
		transaction.commit();
		
//		Question question=(Question)session.get(Question.class, 10001);
//		System.out.println(question.getQuestion());
		session.close();
		factory.close();
		System.out.println("++++++++++END++++++++++++++");
	}
}
