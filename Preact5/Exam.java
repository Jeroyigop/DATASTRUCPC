package Preact5;

import java.util.Scanner;


public class Exam {


    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {


        int examID = InputInteger("Enter Exam ID: ");
        String subject = InputString("Enter Subject: ");
        String date = InputString("Enter Date (YYYY-MM-DD): ");
        double duration = InputDouble("Enter Duration (in minutes): ");
        String room = InputString("Enter Room: ");


        print(examID, subject, date, duration, room);
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
