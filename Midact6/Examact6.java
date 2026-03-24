package Midact6;






import java.util.Scanner;


public class Examact6  {


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
            System.out.println("4. View Exam by Index"); 
            choice = InputInteger("Enter choice: ");


            switch (choice) {


                case 1:
                    if (count < size) {


                        System.out.println("\nWhere do you want to insert?");
                        System.out.println("1. At End");
                        System.out.println("2. At Beginning");
                        System.out.println("3. At Specific Position");
                        int insertChoice = InputInteger("Enter choice: ");


                        int position = count;


                        if (insertChoice == 2) {
                            position = 0;
                        } else if (insertChoice == 3) {
                            position = InputInteger("Enter position (1 to " + (count + 1) + "): ") - 1;


                            if (position < 0 || position > count) {
                                System.out.println("Invalid position.");
                                break;
                            }
                        }


                        for (int i = count; i > position; i--) {
                            examID[i] = examID[i - 1];
                            subject[i] = subject[i - 1];
                            date[i] = date[i - 1];
                            duration[i] = duration[i - 1];
                            room[i] = room[i - 1];
                        }


                        System.out.println("\nEnter Exam Details");


                        examID[position] = InputInteger("Enter Exam ID: ");
                        subject[position] = InputString("Enter Subject: ");
                        date[position] = InputString("Enter Date (YYYY-MM-DD): ");
                        duration[position] = InputDouble("Enter Duration (in minutes): ");
                        room[position] = InputString("Enter Room: ");


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
                        System.out.println("\n===== LIST OF EXAMS =====");


                        System.out.printf("%-5s %-10s %-15s %-12s %-10s %-10s\n",
                                "No.", "ID", "Subject", "Date", "Duration", "Room");


                        for (int i = 0; i < count; i++) {
                            System.out.printf("%-5d %-10d %-15s %-12s %-10.2f %-10s\n",
                                    (i + 1),
                                    examID[i],
                                    subject[i],
                                    date[i],
                                    duration[i],
                                    room[i]);
                        }
                    }
                    break;


                case 3:
                    System.out.println("Exiting program...");
                    break;


               
                case 4:
                    if (count == 0) {
                        System.out.println("No exams recorded.");
                    } else {
                        int index = InputInteger("Enter exam number (1 to " + count + "): ") - 1;


                        if (index < 0 || index >= count) {
                            System.out.println("Invalid index.");
                        } else {
                            print(
                                    examID[index],
                                    subject[index],
                                    date[index],
                                    duration[index],
                                    room[index]
                            );
                        }
                    }
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
