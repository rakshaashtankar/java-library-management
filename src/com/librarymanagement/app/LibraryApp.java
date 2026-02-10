package com.librarymanagement.app;

import java.util.Scanner;

import com.librarymanagement.service.LibraryService;

public class LibraryApp {
	public static void main(String[] args) {
		System.out.println("Library Management System Started...");
		Scanner sc = new Scanner(System.in);
		LibraryService libraryService = new LibraryService();
		boolean exit = false;
		while(!exit) {
			System.out.println("=== Library Management System Menu ===");	
			System.out.println("1. Add Book");
			System.out.println("2. View Books");
			System.out.println("3. Search Book");
			System.out.println("4. Update Book");
			System.out.println("5. Issue Book");
			System.out.println("6. Return Book");
			System.out.println("7. Exit");
			
			System.out.println("Enter your choice: ");
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1:
				System.out.println("Enter the book title: ");
				String title = sc.nextLine();
				System.out.println("Enter the book author: ");
				String author = sc.nextLine();
				boolean isBookAdded = libraryService.addBook(title, author);
				if(isBookAdded) {
					System.out.println("Book added successfully.");
				} 
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			default:
				System.out.println("Invalid choice");
			}
		}
		sc.close();
	}

}
