package com.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entities.Books;
import com.entities.Library;

public class MainClass {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Books.class);
		cfg.addAnnotatedClass(Library.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		Books b = new Books();
		b.setBook_author("Akshat Gupta");
		b.setBook_name("Naga Warriers");

		Books b1 = new Books();
		b1.setBook_author("Kusumagraj");
		b1.setBook_name("Natasamrat");

		Books b2 = new Books();
		b2.setBook_author("Stan Lee");
		b2.setBook_name("Avengers");

		Library l = new Library();
	
		l.setDept_id(101);
		l.setDept_name("History");

		Library l1 = new Library();
		
		l1.setDept_id(202);
		l1.setDept_name("Drama");

		Library l2 = new Library();
		
		l2.setDept_id(303);
		l2.setDept_name("Science Friction");

		List<Books> bookslist = new ArrayList<>();
		bookslist.add(b);
		l.setBook(bookslist);
		l1.setBook(bookslist);
		l2.setBook(bookslist);

		List<Library> librarylist = new ArrayList<>();
		librarylist.add(l);
		b.setLibrary(librarylist);
		b1.setLibrary(librarylist);
		b2.setLibrary(librarylist);

		ss.persist(l);
		ss.persist(l1);
		ss.persist(l2);
		
		ss.persist(b);
		ss.persist(b1);
		ss.persist(b2);
		

		tr.commit();
		ss.close();
		sf.close();
		System.out.println("data featch sucessfully");
	}

}
