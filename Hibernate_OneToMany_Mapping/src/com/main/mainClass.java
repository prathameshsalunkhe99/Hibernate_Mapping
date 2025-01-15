package com.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entities.Department;
import com.entities.Employee;

public class mainClass {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Employee.class);
		cfg.addAnnotatedClass(Department.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		System.out.println("Entities maps sucessfully");

		Employee e1 = new Employee();
		e1.setEmp_id(77788);
		e1.setEmp_name("Ram");
		ss.persist(e1);

		Employee e2 = new Employee();
		e2.setEmp_id(55446);
		e2.setEmp_name("Sham");
		ss.persist(e2);

//		Employee e3 = new Employee();
//		e3.setEmp_id(101112);
//		e3.setEmp_name("Anurag");
//		e3.setDept(d);
//		ss.persist(e3);

		List<Employee> list = new ArrayList<Employee>();
		list.add(e1);
		list.add(e2);
//		list.add(e3);

		Department d = new Department();
		d.setD_id(801);
		d.setD_name("python developer");

		e1.setDept(d);
		e2.setDept(d);

		d.setEmp(list);
		ss.persist(d);

		tr.commit();
		ss.close();

	}

}
