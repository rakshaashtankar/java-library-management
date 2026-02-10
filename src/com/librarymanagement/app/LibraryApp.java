package com.librarymanagement.app;

import java.util.List;
import java.util.Scanner;

import com.librarymanagement.model.Book;
import com.librarymanagement.service.LibraryService;

public class LibraryApp {
	
	public static void printBooks(List<Book> books) {
		if(!books.isEmpty()) {
			System.out.println("\nID | Title | Author | Isissued");
			for(Book b: books) {
				System.out.println(b.getId() + " | " + b.getTitle()  + " | " + b.getAuthor()  + " | " + b.isIssued());
			}
		} else {
			System.out.println("\nNo record found.");
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Library Management System Started...");
		Scanner sc = new Scanner(System.in);
		LibraryService libraryService = new LibraryService();
		boolean exit = false;
		while(!exit) {
			System.out.println("\n=== Library Management System Menu ===");	
			System.out.println("1. Add Book");
			System.out.println("2. View Books");
			System.out.println("3. Search Book");
			System.out.println("4. Update Book");
			System.out.println("5. Issue Book");
			System.out.println("6. Return Book");
			System.out.println("7. Exit");
			
			System.out.println("\nEnter your choice: ");
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1:
				System.out.println("\nEnter the book title: ");
				String title = sc.nextLine();
				System.out.println("\nEnter the book author: ");
				String author = sc.nextLine();
				boolean isBookAdded = libraryService.addBook(title, author);
				if(isBookAdded) {
					System.out.println("\nBook added successfully.");
				} else {
					System.out.println("\nFailed to add the book.");
				}
				break;
			case 2:
				List<Book> books = libraryService.viewAllBooks();
				printBooks(books);
				break;
			case 3:
				System.out.println("\nSearch By \n1. Title \n2. Author\n");
				int searchChoice = sc.nextInt();
				sc.nextLine();
				if(searchChoice == 1) {
					System.out.println("Enter the book title: ");
					String searchTitle = sc.nextLine();
					List<Book> searchTitleBooks = libraryService.searchBookByTitle(searchTitle);
					printBooks(searchTitleBooks);
				} else if(searchChoice == 2) {
					System.out.println("Enter the book author: ");
					String searchAuthor = sc.nextLine();
					List<Book> searchAuthorBooks = libraryService.searchBookByAuthor(searchAuthor);
					printBooks(searchAuthorBooks);
				} else {
					System.out.println("\nInvalid choice");
				}
				break;
			case 4:
				System.out.println("\nEnter the ID to update book details: ");
				int updateId = sc.nextInt();
				sc.nextLine();
				System.out.println("\nEnter the book title: ");
				String updatedTitle = sc.nextLine();
				System.out.println("\nEnter the book author: ");
				String updatedAuthor = sc.nextLine();
				boolean isUpdated = libraryService.updateBook(updateId, updatedTitle, updatedAuthor);
				if(isUpdated ) {
					System.out.println("\nBook details updated successfully.");
				} else {
					System.out.println("\nFailed to update the book details.");
				}
				break;
			case 5:
				System.out.println("\nEnter the ID of the book to be issued: ");
				int issueId = sc.nextInt();
				sc.nextLine();
				boolean issuedBook = libraryService.issueBook(issueId);
				if(issuedBook) {
					System.out.println("Book issue successful.");
				} else {
					System.out.println("Failed to issue book.");
				}
				break;
			case 6:
				System.out.println("\nEnter the ID of the book to be issued: ");
				int returnId = sc.nextInt();
				sc.nextLine();
				boolean returnBook = libraryService.returnBook(returnId);
				if(returnBook) {
					System.out.println("Book return successful.");
				} else {
					System.out.println("Failed to return book.");
				}
				break;
			case 7:
				System.out.println("Exiting...");
				exit = true;
				break;
			default:
				System.out.println("Invalid choice");
			}
		}
		sc.close();
	}

}
