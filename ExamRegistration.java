package ProjectsFile;

import java.io.*;
import java.util.*;

public class ExamRegistration {
    private static final String FILE_NAME = "exam_registration.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1. Register for the exam");
            System.out.println("2. Display registered students");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    registerStudent(scanner);
                    break;
                case 2:
                    displayRegisteredStudents();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }

    private static void registerStudent(Scanner scanner) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true));

            System.out.print("Enter student name: ");
            String name = scanner.nextLine();

            System.out.print("Enter student ID: ");
            String id = scanner.nextLine();

            System.out.print("Enter student email: ");
            String email = scanner.nextLine();

            writer.write(name + "," + id + "," + email);
            writer.newLine();
            writer.close();

            System.out.println("Registration successful!");
        } catch (IOException e) {
            System.out.println("An error occurred while registering the student.");
            e.printStackTrace();
        }
    }

    private static void displayRegisteredStudents() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            String line;

            System.out.println("Registered students:");

            while ((line = reader.readLine()) != null) {
                String[] studentData = line.split(",");
                System.out.println("Name: " + studentData[0]);
                System.out.println("ID: " + studentData[1]);
                System.out.println("Email: " + studentData[2]);
                System.out.println();
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the registered students.");
            e.printStackTrace();
        }
    }
}
