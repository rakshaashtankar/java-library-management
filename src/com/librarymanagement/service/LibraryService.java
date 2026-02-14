package com.librarymanagement.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.librarymanagement.model.Book;

public class LibraryService {
	
	private List<Book> books = new ArrayList<>();
	private int counter;
	
	private boolean isInvalidString(String value) {
		return value == null || value.trim().isEmpty();
	}
	
	private boolean isInvalidId(int id) {
		return id<=0;
	}
	
	public boolean addBook(String title, String author) {
		if(isInvalidString(title) || isInvalidString(author)) return false;
		Book newBook = new Book(counter++, title, author);
		books.add(newBook);
		return true;
	}
	
	public List<Book> viewAllBooks() {
		return new ArrayList<>(books);
	}
	
	public List<Book> searchBookByTitle(String title) {
		List<Book> result = new ArrayList<>();
		if(isInvalidString(title)) return result;
		for(Book b : books) {
			if(b.getTitle().toLowerCase().contains(title.toLowerCase())) {
				result.add(b);
			}
		}
		return result;
	}
	
	public List<Book> searchBookByAuthor(String author) {
		List<Book> result = new ArrayList<>();
		if(isInvalidString(author)) return result;
		for(Book b : books) {
			if(b.getAuthor().toLowerCase().contains(author.toLowerCase())) {
				result.add(b);
			}
		}
		return result;
	}
	
	public boolean updateBook(int id, String title, String author) {
		if(isInvalidString(title) || isInvalidString(author)) return false;
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
		if(isInvalidId(id)) return false;
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
		if(isInvalidId(id)) return false;
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
	
	public boolean deleteBook(int id) {
		if(isInvalidId(id)) return false;
		Iterator<Book> iterator = books.iterator();
		while(iterator.hasNext()) {
			Book b = iterator.next();
			if(b.getId() == id && !b.isIssued()) {
				iterator.remove();
				return true;
			}
		}
		return false;
		
	}

	public boolean saveToFile() {
		File dir = new File("data");
		if(!dir.exists()) {
			dir.mkdirs();
		}
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
			counter = books.stream()
					.mapToInt(Book::getId)
					.max()
					.orElse(0)+1;
			return true;
		} catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
			books = new ArrayList<>();
			counter = 1;
			return false;
		}
	}
}
