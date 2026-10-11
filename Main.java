
import java.util.*;

class Student {
    int rollNo;
    String name;
    double marks;

    Student(int rollNo, String name, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    String getGrade() {
        if (marks >= 90) {
            return "A+";
        } else if (marks >= 80) {
            return "A";
        } else if (marks >= 70) {
            return "B";
        } else if (marks >= 60) {
            return "C";
        } else if (marks >= 40) {
            return "D";
        } else {
            return "F";
        }
    }

    void display() {
        System.out.println("Roll No: " + rollNo
                + " | Name: " + name
                + " | Marks: " + marks
                + " | Grade: " + getGrade());
    }
}

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n=== Student Record Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student Marks");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    updateMarks();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 6:
                    System.out.println("Thank you for using the system!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 6);
    }

    static Student findStudent(int rollNo) {
        for (Student s : students) {
            if (s.rollNo == rollNo) {
                return s;
            }
        }
        return null;
    }

    static void addStudent() {
        System.out.print("Enter roll number: ");
        int rollNo = sc.nextInt();
        sc.nextLine();

        if (findStudent(rollNo) != null) {
            System.out.println("Roll number already exists!");
            return;
        }

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter marks (0-100): ");
        double marks = sc.nextDouble();
        sc.nextLine();

        if (marks < 0 || marks > 100) {
            System.out.println("Invalid marks!");
            return;
        }

        students.add(new Student(rollNo, name, marks));
        System.out.println("Student added successfully!");
    }

    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        for (Student s : students) {
            s.display();
        }
    }

    static void searchStudent() {
        System.out.print("Enter roll number to search: ");
        int rollNo = sc.nextInt();
        sc.nextLine();

        Student s = findStudent(rollNo);

        if (s != null) {
            s.display();
        } else {
            System.out.println("Student not found.");
        }
    }

    static void updateMarks() {
        System.out.print("Enter roll number: ");
        int rollNo = sc.nextInt();
        sc.nextLine();

        Student s = findStudent(rollNo);

        if (s == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter new marks (0-100): ");
        double marks = sc.nextDouble();
        sc.nextLine();

        if (marks < 0 || marks > 100) {
            System.out.println("Invalid marks!");
            return;
        }

        s.marks = marks;
        System.out.println("Marks updated successfully!");
    }

    static void deleteStudent() {
        System.out.print("Enter roll number to delete: ");
        int rollNo = sc.nextInt();
        sc.nextLine();

        Student s = findStudent(rollNo);

        if (s != null) {
            students.remove(s);
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }
}
