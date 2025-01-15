package com.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Books {
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String book_author;
	private String book_name;
@ManyToMany(mappedBy = "book")
private List<Library>library;


public Books() {
	
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public String getBook_author() {
	return book_author;
}


public void setBook_author(String book_author) {
	this.book_author = book_author;
}


public String getBook_name() {
	return book_name;
}


public void setBook_name(String book_name) {
	this.book_name = book_name;
}


public List<Library> getLibrary() {
	return library;
}


public void setLibrary(List<Library> library) {
	this.library = library;
}


public Books(int id, String book_author, String book_name, List<Library> library) {
	super();
	this.id = id;
	this.book_author = book_author;
	this.book_name = book_name;
	this.library = library;
}


@Override
public String toString() {
	return "Books [id=" + id + ", book_author=" + book_author + ", book_name=" + book_name + ", library=" + library
			+ "]";
}


}
