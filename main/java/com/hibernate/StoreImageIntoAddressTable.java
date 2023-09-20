package com.hibernate;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StoreImageIntoAddressTable {
	public static void main(String[] args) throws IOException {
		System.out.println("Program started");
		Configuration cfg=new Configuration();
		cfg.configure();
		
		Address address=new Address();
		address.setPincode(587301);
		address.setAddress("Jamakhandi");
		address.setStreet("Linganur");
		address.setNotAcolumn(123);
		address.setDate(new Date());
		
		//Setting image
		FileInputStream image=new FileInputStream("src/main/java/Linganur.png");
		byte[] imageByte=new byte[image.available()];
		image.read(imageByte);
		address.setImage(imageByte);
		
		
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		session.save(address);
		session.getTransaction().commit();
		System.out.println("Address data stored successfully.!");
		session.close();
		
	}
}
