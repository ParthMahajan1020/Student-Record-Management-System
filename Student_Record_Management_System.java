// Importing necessary packages
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// Class representing a single student with encapsulation
class Student {
    private int ID;          // Student ID (unique)
    private String Name;     // Student Name
    private int Marks;       // Student Marks

    // Constructor to initialize student details
    public Student(int ID, String Name, int Marks) {
        this.ID = ID;
        this.Name = Name;
        this.Marks = Marks;
    }

    // Getters and Setters for encapsulated fields
    public int getID() { return ID; }
    public String getName() { return Name; }
    public int getMarks() { return Marks; }

    public void setName(String Name) { this.Name = Name; }
    public void setMarks(int Marks) { this.Marks = Marks; }

    // Display student details neatly
    public void displayInfo() {
        System.out.println("Student ID: " + ID);
        System.out.println("Student Name: " + Name);
        System.out.println("Student Marks: " + Marks);
    }
}

// Main class managing all CRUD operations
class StudentManagementSystem {
    private final ArrayList<Student> students = new ArrayList<>();  // Dynamic list for student data
    private final Scanner sc = new Scanner(System.in);

    // Method to safely take integer input
    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                sc.nextLine(); // clear invalid input
            }
        }
    }

    // Method to safely take string input
    private String readString(String prompt) {
        System.out.print(prompt);
        sc.nextLine(); // clear newline buffer before reading text
        String input = sc.nextLine().trim();
        while (input.isEmpty()) {
            System.out.print("Input cannot be empty. Try again: ");
            input = sc.nextLine().trim();
        }
        return input;
    }

    // Add new student after validation
    public void addStudent() {
        System.out.println("\n--- Add Student ---");

        int id = readInt("Enter Student ID: ");

        // Check for duplicate ID
        if (findStudentById(id) != null) {
            System.out.println("Student with this ID already exists.");
            return;
        }

        String name = readString("Enter Student Name: ");
        int marks;

        // Marks validation (0–100 range)
        while (true) {
            marks = readInt("Enter Student Marks (0–100): ");
            if (marks >= 0 && marks <= 100) break;
            System.out.println("Marks must be between 0 and 100. Try again.");
        }

        students.add(new Student(id, name, marks));
        System.out.println("✅ Student '" + name + "' added successfully!");
    }

    // View all students
    public void viewStudents() {
        System.out.println("\n--- View Students ---");

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student s : students) {
            System.out.println("-----------------------");
            s.displayInfo();
        }
        System.out.println("-----------------------");
        System.out.println("Total Students: " + students.size());
    }

    // Update existing student
    public void updateStudent() {
        System.out.println("\n--- Update Student ---");

        if (students.isEmpty()) {
            System.out.println("No students to update.");
            return;
        }

        int id = readInt("Enter Student ID: ");
        Student s = findStudentById(id);

        if (s == null) {
            System.out.println("No student found with this ID.");
            return;
        }

        String newName = readString("Enter new name: ");
        int newMarks;

        // Marks validation again
        while (true) {
            newMarks = readInt("Enter new marks (0–100): ");
            if (newMarks >= 0 && newMarks <= 100) break;
            System.out.println("Marks must be between 0 and 100.");
        }

        s.setName(newName);
        s.setMarks(newMarks);
        System.out.println("✅ Student record updated successfully.");
    }

    // Search for a student by ID
    public void searchStudent() {
        System.out.println("\n--- Search Student ---");

        if (students.isEmpty()) {
            System.out.println("No students to search.");
            return;
        }

        int id = readInt("Enter Student ID: ");
        Student s = findStudentById(id);

        if (s != null) {
            System.out.println("\nStudent Found:");
            s.displayInfo();
        } else {
            System.out.println("No student found with ID " + id + ".");
        }
    }

    // Delete student by ID
    public void deleteStudent() {
        System.out.println("\n--- Delete Student ---");

        if (students.isEmpty()) {
            System.out.println("No students to delete.");
            return;
        }

        int id = readInt("Enter Student ID: ");
        Student s = findStudentById(id);

        if (s != null) {
            students.remove(s);
            System.out.println("✅ Student '" + s.getName() + "' deleted successfully!");
            System.out.println("Remaining Students: " + students.size());
        } else {
            System.out.println("No student found with ID " + id + ".");
        }
    }

    // Helper function: find student by ID
    private Student findStudentById(int id) {
        for (Student s : students) {
            if (s.getID() == id) return s;
        }
        return null;
    }
}

// Entry point class
public class Student_Record_Management_System {
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner sc = new Scanner(System.in);

        while (true) {
            // Display menu
            System.out.println("\n===== STUDENT RECORD MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Search Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            // Validate menu input
            int choice;
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Enter a number between 1 and 6.");
                sc.nextLine(); // clear invalid input
                continue;
            }

            // Menu operations
            switch (choice) {
                case 1 -> sms.addStudent();
                case 2 -> sms.viewStudents();
                case 3 -> sms.updateStudent();
                case 4 -> sms.searchStudent();
                case 5 -> sms.deleteStudent();
                case 6 -> {
                    System.out.println("Exiting program... Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
