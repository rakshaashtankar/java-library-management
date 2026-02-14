# 📚 Library Management System (Java CLI + File Storage)

## 🧩 Overview

This is a Java-based Command Line Interface (CLI) application that simulates a basic library management system.

The system allows users to manage books using a menu-driven interface while persisting data using Java Serialization.

This project demonstrates core backend development concepts including:

- Object-Oriented Programming (OOP)
- File Handling
- Data Persistence
- Clean Service Design
- Defensive Programming

---

## 🚀 Features

✔ Add new books  
✔ View all books  
✔ Search books by title  
✔ Search books by author  
✔ Update book details  
✔ Issue books  
✔ Return books  
✔ Delete books (only if not issued)  
✔ Persistent storage using file serialization  

---

## 🧠 Concepts Demonstrated

This project focuses on fundamental backend engineering skills:

- File Handling (`FileInputStream`, `FileOutputStream`)
- Java Serialization (`ObjectInputStream`, `ObjectOutputStream`)
- OOP Design (Model + Service + App layers)
- Iterator Usage (Safe collection modification)
- Input Validation & Defensive Programming
- Business Logic Enforcement

---

## 🛠️ Technologies Used

- Java (JDK 8+)
- Java Collections Framework
- Java IO (File Handling)
- Serialization API

No external libraries required.

---

## 📂 Project Structure

```
LibraryManagementSystem/
│
├── src/
│   ├── com.librarymanagement.model/
│   │      └── Book.java
│   │
│   ├── com.librarymanagement.service/
│   │      └── LibraryService.java
│   │
│   └── com.librarymanagement.app/
│          └── LibraryApp.java
│
└── data/
       └── books.dat   (auto-generated)
```

---

## ▶️ How to Compile & Run

### Compile

```bash
javac -d out src/com/librarymanagement/**/*.java
```

### Run

```bash
java -cp out com.librarymanagement.app.LibraryApp
```

---

## 💬 Application Flow

The system runs using a menu-driven interface:

```
1. Add Book
2. View Books
3. Search Book
4. Update Book
5. Issue Book
6. Return Book
7. Delete Book
8. Exit
```

Users interactively perform operations via console input.

---

## 💾 Persistence Mechanism

The system uses Java Serialization to persist book data.

Data stored in:

```
data/books.dat
```

Behavior:

✔ Data automatically loads on startup  
✔ Data saves on exit  
✔ Book ID counter restored dynamically  

This simulates real-world persistence logic without using a database.

---

## ✅ Business Rules Enforced

✔ Invalid input rejected  
✔ Cannot issue already issued book  
✔ Cannot return non-issued book  
✔ Cannot delete issued book  
✔ Input trimming & sanitization  

---

## ⭐ Design Highlights

✔ Clean separation of concerns:

- Model Layer → `Book`
- Service Layer → `LibraryService`
- Application Layer → `LibraryApp`

✔ Refactored logic using helper methods  
✔ Safe removal using Iterator  
✔ Defensive programming practices  

---

## 🧪 Future Improvements

Possible enterprise-level upgrades:

- JDBC / Database Integration
- DAO Layer Architecture
- REST API Version
- Spring Boot Migration
- Logging Framework
- Unit Testing (JUnit)

---

## 📌 Conclusion

This project provides a strong foundation in:

✔ Backend logic design  
✔ Persistence concepts  
✔ Clean Java service architecture  

It is designed primarily for learning core engineering principles and technical interview preparation.
