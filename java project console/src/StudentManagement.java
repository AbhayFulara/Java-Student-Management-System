import model.User;
import service.UserService;
import storage.UserStorage;

import java.util.Scanner;

public class StudentManagement {
    private static final Scanner sc = new Scanner(System.in);
    private static final UserService service = new UserService(new UserStorage());

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Add Marks to Student");
            System.out.println("4. Search Student by ID");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Select option: ");

            String input = sc.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> service.displayAll();
                case 3 -> addMarks();
                case 4 -> searchStudent();
                case 5 -> deleteStudent();
                case 6 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Class: ");
        String studentClass = sc.nextLine();
        System.out.print("Enter Student ID: ");
        String studentId = sc.nextLine();
        System.out.print("Enter Gender: ");
        String gender = sc.nextLine();

        double totalFee = readDouble("Enter Total Fee: ");
        double amountPaid = readDouble("Enter Amount Paid: ");

        User user = new User(name, studentClass, studentId, gender, totalFee, amountPaid);
        service.addUser(user);
        System.out.println("✅ Student added successfully.");
    }

    private static void addMarks() {
    System.out.print("Enter Student ID: ");
    String id = sc.nextLine();

    int subjectCount = readInt("Enter number of subjects: ");

    for (int i = 0; i < subjectCount; i++) {
        System.out.print("Enter Subject " + (i + 1) + " Name: ");
        String subject = sc.nextLine();
        int marks = readInt("Enter Marks for " + subject + ": ");
        service.addMarks(id, subject, marks);
    }
}


    private static void searchStudent() {
        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();
        service.searchById(id);
    }

    private static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        String id = sc.nextLine();
        service.deleteUser(id);
    }

    private static double readDouble(String message) {
        while (true) {
            System.out.print(message);
            try {
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private static int readInt(String message) {
        while (true) {
            System.out.print(message);
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }
}


