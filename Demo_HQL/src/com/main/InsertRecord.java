package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import com.entities.Employee;

public class InsertRecord {
	public static void main(String[] args) {
		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Employee.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss= sf.openSession();
		Transaction tr=ss.beginTransaction();
		
		String hqlQuery="insert into employee (salary,emp_name,Domain)values(:salary,:emp_name,:domain)";
		MutationQuery query=ss.createNativeQuery(hqlQuery);
	    query.setParameter("emp_name", "abhi");
	    query.setParameter("salary", 70000);
	    query.setParameter("domain", "prompt engineer");
	    query.executeUpdate();
	    System.out.println("data is inserted sucessfully");
	    tr.commit();
	    ss.close();

	}
	

}
