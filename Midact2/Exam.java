package Midact2;

import java.util.Scanner;

public class Exam {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int size = InputInteger("How many exams? ");

        int[] examID = new int[size];
        String[] subject = new String[size];
        String[] date = new String[size];
        double[] duration = new double[size];
        String[] room = new String[size];

        for (int i = 0; i < size; i++) {
            System.out.println("\nEnter details for Exam " + (i + 1));

            examID[i] = InputInteger("Enter Exam ID: ");
            subject[i] = InputString("Enter Subject: ");
            date[i] = InputString("Enter Date (YYYY-MM-DD): ");
            duration[i] = InputDouble("Enter Duration (in minutes): ");
            room[i] = InputString("Enter Room: ");
        }

       
        for (int i = 0; i < size; i++) {
            print(examID[i], subject[i], date[i], duration[i], room[i]);
        }
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