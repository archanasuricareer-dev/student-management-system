import java.util.ArrayList;
import java.util.Scanner;

// Student Management System
// Features: Add, Display, Delete, Search, Update
// Developed by Archana

// Student class
class Student {
    int id;
    String name;
    int age;

    Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    void display() {
        System.out.println("---------------------------");
        System.out.println("ID   : " + id);
        System.out.println("Name : " + name);
        System.out.println("Age  : " + age);
    }
}

public class StudentManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList<>();

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student");
            System.out.println("5. Update Student");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            // Input validation for choice
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Enter a number.");
                sc.next();
                continue;
            }

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid ID!");
                        sc.next();
                        break;
                    }
                    int id = sc.nextInt();

                    // Check duplicate ID
                    boolean exists = false;
                    for (Student s : list) {
                        if (s.id == id) {
                            exists = true;
                            break;
                        }
                    }

                    if (exists) {
                        System.out.println("Student with this ID already exists!");
                        break;
                    }

                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid Age!");
                        sc.next();
                        break;
                    }
                    int age = sc.nextInt();

                    list.add(new Student(id, name, age));
                    System.out.println("Student Added!");
                    break;

                case 2:
                    if (list.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        for (Student s : list) {
                            s.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter ID to delete: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid ID!");
                        sc.next();
                        break;
                    }
                    int deleteId = sc.nextInt();
                    boolean foundDelete = false;

                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).id == deleteId) {
                            list.remove(i);
                            foundDelete = true;
                            System.out.println("Student Deleted!");
                            break;
                        }
                    }

                    if (!foundDelete) {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter ID to search: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid ID!");
                        sc.next();
                        break;
                    }
                    int searchId = sc.nextInt();
                    boolean foundSearch = false;

                    for (Student s : list) {
                        if (s.id == searchId) {
                            s.display();
                            foundSearch = true;
                            break;
                        }
                    }

                    if (!foundSearch) {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter ID to update: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid ID!");
                        sc.next();
                        break;
                    }
                    int updateId = sc.nextInt();
                    boolean foundUpdate = false;

                    for (Student s : list) {
                        if (s.id == updateId) {
                            sc.nextLine();
                            System.out.print("Enter new name: ");
                            s.name = sc.nextLine();

                            System.out.print("Enter new age: ");
                            if (!sc.hasNextInt()) {
                                System.out.println("Invalid Age!");
                                sc.next();
                                break;
                            }
                            s.age = sc.nextInt();

                            System.out.println("Student Updated!");
                            foundUpdate = true;
                            break;
                        }
                    }

                    if (!foundUpdate) {
                        System.out.println("Student not found.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}