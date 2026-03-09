package Midact3;


import java.util.Scanner;

public class Exam {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int size = InputInteger("How many exams can be stored? ");

        int[] examID = new int[size];
        String[] subject = new String[size];
        String[] date = new String[size];
        double[] duration = new double[size];
        String[] room = new String[size];

        int count = 0;
        int choice;

        do {
            System.out.println("\n===== EXAM MENU =====");
            System.out.println("1. Add Exam");
            System.out.println("2. View All Exams");
            System.out.println("3. Exit");
            choice = InputInteger("Enter choice: ");

            switch (choice) {

                case 1:
                    if (count < size) {
                        System.out.println("\nEnter Exam Details");

                        examID[count] = InputInteger("Enter Exam ID: ");
                        subject[count] = InputString("Enter Subject: ");
                        date[count] = InputString("Enter Date (YYYY-MM-DD): ");
                        duration[count] = InputDouble("Enter Duration (in minutes): ");
                        room[count] = InputString("Enter Room: ");

                        count++;
                        System.out.println("Exam added successfully!");
                    } else {
                        System.out.println("Storage is full.");
                    }
                    break;

                case 2:
                    if (count == 0) {
                        System.out.println("No exams recorded.");
                    } else {
                        for (int i = 0; i < count; i++) {
                            print(examID[i], subject[i], date[i], duration[i], room[i]);
                        }
                    }
                    break;

                case 3:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 3);
    }

    public static int InputInteger(String message) {
        while (true) {
            System.out.print(message);
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            } else {
                System.out.println("Invalid input. Enter a number.");
                scanner.next();
            }
        }
    }

    public static String InputString(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    public static double InputDouble(String message) {
        while (true) {
            System.out.print(message);
            if (scanner.hasNextDouble()) {
                double value = scanner.nextDouble();
                scanner.nextLine();
                return value;
            } else {
                System.out.println("Invalid input. Enter a decimal number.");
                scanner.next();
            }
        }
    }

    public static void print(int examID, String subject, String date, double duration, String room) {
        System.out.println("\n-------------- Exam Details --------------");
        System.out.println("Exam ID: " + examID);
        System.out.println("Subject: " + subject);
        System.out.println("Date: " + date);
        System.out.println("Duration: " + duration + " minutes");
        System.out.println("Room: " + room);
    }
}