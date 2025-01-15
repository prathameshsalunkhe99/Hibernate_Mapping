package com.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Library {
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int dept_id;
	private String dept_name;
	
	@ManyToMany
	@JoinTable(
			name="library_books",
			joinColumns =@JoinColumn(name="library_id"),
			inverseJoinColumns = @JoinColumn(name ="books_id")
			)
	private List<Books>book;

	public Library() {
		
	}

	public Library(int id, int dept_id, String dept_name, List<Books> book) {
		super();
		this.id = id;
		this.dept_id = dept_id;
		this.dept_name = dept_name;
		this.book = book;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDept_id() {
		return dept_id;
	}

	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public List<Books> getBook() {
		return book;
	}

	public void setBook(List<Books> book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Library [id=" + id + ", dept_id=" + dept_id + ", dept_name=" + dept_name + ", book=" + book + "]";
	}

	
}
