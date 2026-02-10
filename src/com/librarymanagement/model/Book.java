package com.librarymanagement.model;

import java.io.Serializable;

public class Book implements Serializable{
	
	private int id;
	private String title;
	private String author;
	private boolean isIssued;
	
	private static final long serialVersionUID = 1L;
	
	public Book(int id, String title, String author, boolean isIssued) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.isIssued = isIssued;
	}
	
	public Book(int id, String title, String author) {
		this(id, title, author, false);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public boolean isIssued() {
		return isIssued;
	}
	public void setIssued(boolean isIssued) {
		this.isIssued = isIssued;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + 
				", title=" + title + 
				", author=" + author + 
				", isIssued=" + isIssued +"]";
	}
	


}
