package Midact8;


import java.util.Scanner;
import java.io.*;

public class Examact8 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int size = InputInteger("How many exams can be stored? ");

        int[] examID = new int[size];
        String[] subject = new String[size];
        String[] date = new String[size];
        double[] duration = new double[size];
        String[] room = new String[size];

        int count = loadFromFile(examID, subject, date, duration, room);

        int choice;

        do {
            System.out.println("\n===== EXAM MENU =====");
            System.out.println("1. Add Exam");
            System.out.println("2. View All Exams");
            System.out.println("3. Exit");
            System.out.println("4. View/Edit Exam by Index");
            System.out.println("5. Search/Delete Exam"); // NEW
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

                        saveToFile(count, examID, subject, date, duration, room);

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

                            String updateChoice = InputString("\nDo you want to update this exam? (yes/no): ");

                            if (updateChoice.equalsIgnoreCase("yes")) {
                                System.out.println("\nEnter New Exam Details");

                                examID[index] = InputInteger("Enter Exam ID: ");
                                subject[index] = InputString("Enter Subject: ");
                                date[index] = InputString("Enter Date (YYYY-MM-DD): ");
                                duration[index] = InputDouble("Enter Duration (in minutes): ");
                                room[index] = InputString("Enter Room: ");

                                System.out.println("Exam updated successfully!");

                                saveToFile(count, examID, subject, date, duration, room);
                            } else {
                                System.out.println("No changes made.");
                            }
                        }
                    }
                    break;

                case 5: 
                    if (count == 0) {
                        System.out.println("No exams recorded.");
                    } else {
                        int searchID = InputInteger("Enter Exam ID to search: ");
                        boolean found = false;

                        for (int i = 0; i < count; i++) {
                            if (examID[i] == searchID) {

                                print(
                                        examID[i],
                                        subject[i],
                                        date[i],
                                        duration[i],
                                        room[i]
                                );

                                found = true;

                                String deleteChoice = InputString("\nDo you want to delete this exam? (yes/no): ");

                                if (deleteChoice.equalsIgnoreCase("yes")) {

                                    for (int j = i; j < count - 1; j++) {
                                        examID[j] = examID[j + 1];
                                        subject[j] = subject[j + 1];
                                        date[j] = date[j + 1];
                                        duration[j] = duration[j + 1];
                                        room[j] = room[j + 1];
                                    }

                                    count--;

                                    System.out.println("Exam deleted successfully!");

                                    saveToFile(count, examID, subject, date, duration, room);
                                } else {
                                    System.out.println("No changes made.");
                                }

                                break;
                            }
                        }

                        if (!found) {
                            System.out.println("Exam not found.");
                        }
                    }
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 3);
    }

    public static void saveToFile(int count, int[] examID, String[] subject,
                                 String[] date, double[] duration, String[] room) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("exams.txt"));

            for (int i = 0; i < count; i++) {
                writer.println(examID[i] + "," +
                        subject[i] + "," +
                        date[i] + "," +
                        duration[i] + "," +
                        room[i]);
            }

            writer.close();
            System.out.println("Data saved to exams.txt!");

        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }

    public static int loadFromFile(int[] examID, String[] subject,
                                  String[] date, double[] duration, String[] room) {
        int count = 0;

        try {
            File file = new File("exams.txt");
            if (!file.exists()) return 0;

            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] data = line.split(",");

                examID[count] = Integer.parseInt(data[0]);
                subject[count] = data[1];
                date[count] = data[2];
                duration[count] = Double.parseDouble(data[3]);
                room[count] = data[4];

                count++;
            }

            fileScanner.close();

        } catch (Exception e) {
            System.out.println("Error loading file.");
        }

        return count;
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
