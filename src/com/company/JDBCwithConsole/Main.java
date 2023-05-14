package com.company.JDBCwithConsole;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        StudentManagement studentManagement = new StudentManagement();
        while (true) {
            System.out.println("Please choose an option:");
            System.out.println("1. Add a new student");
            System.out.println("2. Update a student");
            System.out.println("3. Delete a student");
            System.out.println("4. View all students");
            System.out.println("5. Quit");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    studentManagement.addStudent();
                    break;
                case 2:
                    studentManagement.updateStudent();
                    break;
                case 3:
                    studentManagement.deleteStudent();
                    break;
                case 4:
                    studentManagement.viewAllStudents();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}

