# Student Record Management System (Java Console Application)

## Overview
The **Student Record Management System (SRMS)** is a Java console-based application designed to perform CRUD operations (Create, Read, Update, Delete) on student records. It allows users to manage a dynamic list of students with unique IDs, names, and marks.  

This project demonstrates basic Java programming skills, object-oriented programming (OOP) concepts like encapsulation, and exception handling.

---

## Features
- **Add Student**: Add a new student with a unique ID, name, and marks (0–100).  
- **View Students**: Display all student records neatly.  
- **Update Student**: Update the name and marks of an existing student using their ID.  
- **Search Student**: Search for a student by their ID.  
- **Delete Student**: Remove a student record by ID.  
- **Input Validation**: Handles invalid inputs (numbers, strings, marks range).  

---

## Technologies Used
- **Programming Language**: Java  
- **IDE/Compiler**: Any Java IDE or command-line `javac` compiler  
- **Data Structure**: `ArrayList` for dynamic storage  
- **OOP Concepts**: Encapsulation, Classes, Objects, Methods  
- **Exception Handling**: `try-catch` for input validation  

---

## How to Run
1. **Clone the repository**:  
   ```bash
   git clone https://github.com/ParthMahajan1020/Student-Record-Management-System.git
   ```
2. **Compile the Java files**:
   ```
   javac Student_Record_Management_System.java
   ```
3. **Run the program**:
   ```
   java Student_Record_Management_System
   ```
4. Follow the menu:
   The console will display options to add, view, update, search, or delete students.


## Code Structure
   ```
   Student.java                    // Defines Student class with encapsulated fields and methods
   StudentManagementSystem.java    // Manages CRUD operations, input validation, and data storage
   Student_Record_Management_System.java  // Main entry point with interactive menu
   ```

## Key Highlights
- Encapsulation: Student fields are private and accessed via getters and setters.

- Dynamic List: ArrayList stores student records allowing flexible addition and deletion.

- Input Validation: Ensures IDs are unique, marks are in 0–100, and text inputs are not empty.

- Error Handling: Handles invalid input using InputMismatchException.

## Sample Output
```
===== STUDENT RECORD MANAGEMENT SYSTEM =====
1. Add Student
2. View Students
3. Update Student
4. Search Student
5. Delete Student
6. Exit
Enter your choice: 1

--- Add Student ---
Enter Student ID: 101
Enter Student Name: Alice
Enter Student Marks (0–100): 95
✅ Student 'Alice' added successfully!
```

  ## Author

*Parth Mahajan*  
- BTech Student | Java & Software Development Enthusiast  
- GitHub: https://github.com/ParthMahajan1020  
- Email: parth.mahajan1020@example.com  
- Passionate about building console applications, learning new programming languages, and exploring software projects.
