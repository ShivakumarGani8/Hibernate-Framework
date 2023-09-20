package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentTable 
{
    public static void main( String[] args )
    {
        System.out.println( "Start of program" );
        Configuration cfg= new Configuration();
        cfg.configure();
        SessionFactory factory=cfg.buildSessionFactory();
        Student student=new Student(3, "Temp user", "Temp Address");
        Session session=  factory.openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        System.out.println("---Data updated into DB---");
        
    }
}
