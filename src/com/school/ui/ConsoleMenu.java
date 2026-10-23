package com.school.ui;

import java.util.Scanner;
import com.school.service.Managementservice;
import com.school.model.Student;

public class ConsoleMenu {
    public static void startMenu(Managementservice engine) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to the school management system console");

        while (running) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Enroll a New Student");
            System.out.println("2. Display All Registered Students");
            System.out.println("3. Save Data and Exit Application");
            System.out.print("Select an option (1-3): ");

            int choice = sc.nextInt();
            sc.nextLine(); // Clear the buffer line

            switch(choice) {
                case 1:
                    System.out.println("\n--- Add New Student ---");
                    System.out.print("Enter ID number: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Full Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email Address: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Student GPA: ");
                    double gpa = sc.nextDouble();
                    sc.nextLine();

                    Student newStudent = new Student(id, name, email, gpa);
                    engine.addStudent(newStudent);
                    break;

                case 2:
                    engine.displayStudents();
                    break; // Fixed fall-through bug

                case 3:
                    System.out.println("Backing up data fields to memory disk...");
                    engine.saveAllData();
                    System.out.println("Shutdown complete. Thank you!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice! Please select a choice between 1 and 3.");
            }
        }
        sc.close();
    }
}
