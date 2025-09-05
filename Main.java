


 import java.util.Scanner;

// ======================
// Task 1: Student Class
// ======================
class Student {
    String rollNo;
    String name;
    String course;
    double marks;
    String grade;

    Scanner sc = new Scanner(System.in);

    // Method to input student details
    public void inputStudent() {
        System.out.print("Enter Roll Number: ");
        rollNo = sc.nextLine();

        System.out.print("Enter Name: ");
        name = sc.nextLine();

        System.out.print("Enter Course: ");
        course = sc.nextLine();

        System.out.print("Enter Marks: ");
        marks = sc.nextDouble();
        sc.nextLine(); 

        // After entering marks, calculate grade
        calculateGrade();
    }

    // Method to calculate grade based on marks
    public void calculateGrade() {
        if (marks >= 90) 
            grade = "A+";
        else if (marks >= 80) 
            grade = "A";
        else if (marks >= 70) 
            grade = "B";
        else if (marks >= 60) 
            grade = "C";
        else if (marks >= 50) 
            grade = "D";
        else 
            grade = "F"; // Fail
    }

    // Method to display student details
    public void displayStudent() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);
        System.out.println("-----------------------------------");
    }
}

// ========================================
// Task 2: Student Management System Class
// ========================================
class StudentManagementSystem {
    Student[] students; // Array to store students
    int studentCount;   // Keep track of number of students
    Scanner sc = new Scanner(System.in);

    // Initialize the system with given array size
    public void initializeSystem(int size) {
        students = new Student[size]; // create array of students
        studentCount = 0; // initially, no students added
    }

    // Method to add new student
    public void addStudent() {
        if (studentCount >= students.length) {
            System.out.println("Cannot add more students. Array is full!");
            return;
        }
        // Create a new student and input details
        Student s = new Student();
        s.inputStudent();

        // Store in array and increase count
        students[studentCount] = s;
        studentCount++;

        System.out.println("Student added successfully!\n");
    }

    // Method to display all student records
    public void displayAllStudents() {
        if (studentCount == 0) {
            System.out.println("No student records available!\n");
            return;
        }

        System.out.println("======= Student Records =======");
        for (int i = 0; i < studentCount; i++) {
            students[i].displayStudent(); // call display method of Student class
        }
    }
}

// ==========================
// Task 3: Main Driver Class
// ==========================
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();

        // Initialize system with user-defined array size
        System.out.print("Enter the maximum number of students: ");
        int size = sc.nextInt();
        sc.nextLine(); 
        sms.initializeSystem(size);

        int choice;
        // Menu-driven program
        do {
            System.out.println("\n===== Student Record Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    sms.addStudent();
                    break;
                case 2:
                    sms.displayAllStudents();
                    break;
                case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 3); // keep running until user exits
        sc.close();
    }
}
