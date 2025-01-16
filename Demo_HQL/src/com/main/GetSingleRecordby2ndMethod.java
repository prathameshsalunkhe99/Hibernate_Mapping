package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.entities.Employee;

public class GetSingleRecordby2ndMethod {
	public class GetSingleRecordby1stMethod {
		public static void main(String[] args) {

			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			cfg.addAnnotatedClass(Employee.class);

			SessionFactory sf = cfg.buildSessionFactory();
			Session ss = sf.openSession();
			Transaction tr = ss.beginTransaction();

			String hqlQuery = " from Employee where emp_id=:emp_id";
			Query<Employee> query = ss.createQuery(hqlQuery, Employee.class);
			query.setParameter("emp_id", 3);
			Employee e = query.uniqueResult();
			System.out.println(e);
		}

	}


}
