package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;

import com.entities.Employee;

public class UpdateRecord {
	public static void main(String[] args) {
		
		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Employee.class);
		
		SessionFactory sf= cfg.buildSessionFactory();
		Session ss=sf.openSession();
		Transaction tr=ss.beginTransaction();
		String hqlQuery="update Employee set emp_name=:name,salary=:salary where emp_id=:emp_id";
	MutationQuery query=ss.createMutationQuery(hqlQuery);
	query.setParameter("name","sanket");
	query.setParameter("salary", 60000);
	query.setParameter("emp_id", 1);
	query.executeUpdate();
	System.out.println("data is updated sucessfully");
	tr.commit();
	ss.close();
	}

	
}
