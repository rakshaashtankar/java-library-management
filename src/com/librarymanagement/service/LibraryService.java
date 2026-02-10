package com.librarymanagement.service;

import java.util.ArrayList;
import java.util.List;

import com.librarymanagement.model.Book;

public class LibraryService {
	
	private List<Book> books = new ArrayList<>();
	private int counter = 1;
	
	public boolean addBook(String title, String author) {
		Book newBook = new Book(counter++, title, author);
		books.add(newBook);
		return true;
	}
	
	public List<Book> viewAllBooks() {
		return new ArrayList<>(books);
	}
	
	public List<Book> searchBookByTitle(String title) {
		List<Book> result = new ArrayList<>();
		for(Book b : books) {
			if(b.getTitle().toLowerCase().contains(title.toLowerCase())) {
				result.add(b);
			}
		}
		return result;
	}
	
	public List<Book> searchBookByAuthor(String author) {
		List<Book> result = new ArrayList<>();
		for(Book b : books) {
			if(b.getAuthor().toLowerCase().contains(author.toLowerCase())) {
				result.add(b);
			}
		}
		return result;
	}
	
	public boolean updateBook(String title, String author) {
		return false;
	}
	
	public boolean issueBook(int id) {
		return false;
	}
	
	public boolean returnBook(int id) {
		return false;
	}

	public boolean saveToFile() {
		// use `this.books` internally
		return false;
	}
	
	public boolean loadFromFile() {
		return false;
	}

	
	

}
