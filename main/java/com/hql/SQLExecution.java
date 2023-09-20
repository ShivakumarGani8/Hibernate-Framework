package com.hql;

import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SQLExecution {
	public static void main(String[] args) {
		Configuration configure= new Configuration();
		configure.configure();
		SessionFactory factory=configure.buildSessionFactory();
		Session session=factory.openSession();
		
		String qy="Select e.name,p.project_name,p.project_id from "
				+ "((employee e inner join projects_employee pe on e.emp_id=pe.employees_emp_id) "
				+ "inner join projects p on pe.projects_project_id=p.project_id)";
		Query query=session.createSQLQuery(qy);
		List<Object[]> list=query.getResultList();

		for(Object[] object: list) {
			System.out.println(Arrays.toString(object));
		}
		
		session.close();
		factory.close();
	}
}
