package com.librarymanagement.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
	
	public boolean updateBook(int id, String title, String author) {
		for(Book b : books) {
			if(b.getId() == id) {
				b.setTitle(title);
				b.setAuthor(author);
				return true;
			}
		}
		return false;
	}
	
	public boolean issueBook(int id) {
		for(Book b : books) {
			if(b.getId() == id) {
				if(!b.isIssued()) {
					b.setIssued(true);
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}
	
	public boolean returnBook(int id) {
		for(Book b : books) {
			if(b.getId() == id) {
				if(b.isIssued()) {
					b.setIssued(false);
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	public boolean saveToFile() {
		try(FileOutputStream fos = new FileOutputStream("data/books.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(books);
			return true;
		} catch(IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	public boolean loadFromFile() {
		File file = new File("data/books.dat");
		if(!file.exists()) {
			books = new ArrayList<>();
			return false;
		}
		try(FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis)) {
			books = (List<Book>) ois.readObject();
			return true;
		} catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
			books = new ArrayList<>();
			return false;
		}
	}
}
