import java.util.*;
import java.io.*;

public class EFM {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int choice;

        do {
            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. Grocery Billing");
            System.out.println("2. Exam Registration");
            System.out.println("3. Movie Registration");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = InputInteger("");

            switch (choice) {
                case 1:
                    groceryProgram();
                    break;
                case 2:
                    examProgram();
                    break;
                case 3:
                    movieProgram();
                    break;
                case 4:
                    System.out.println("Program terminated.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);

        sc.close();
    }



    public static int InputInteger(String msg) {
        while (true) {
            if (!msg.isEmpty()) System.out.print(msg);
            if (sc.hasNextInt()) {
                int val = sc.nextInt();
                sc.nextLine();
                return val;
            } else {
                System.out.println("Invalid input. Enter integer.");
                sc.next();
            }
        }
    }

    public static double InputDouble(String msg) {
        while (true) {
            if (!msg.isEmpty()) System.out.print(msg);
            if (sc.hasNextDouble()) {
                double val = sc.nextDouble();
                sc.nextLine();
                return val;
            } else {
                System.out.println("Invalid input. Enter decimal.");
                sc.next();
            }
        }
    }

    public static String InputString(String msg) {
        System.out.print(msg);
        return sc.nextLine();
    }



    public static void groceryProgram() {
        char anotherCustomer = 'Y';

        do {
            double bill = 0;
            char anotherProduct = 'Y';

            do {
                System.out.print("Product name: ");
                String product = sc.nextLine();

                System.out.print("Price: ");
                double price = InputDouble("");

                System.out.print("Quantity: ");
                double qty = InputDouble("");

                bill += price * qty;

                System.out.print("Another product (Y/N)? ");
                anotherProduct = sc.nextLine().charAt(0);

            } while (anotherProduct == 'Y' || anotherProduct == 'y');

            System.out.println("Total Bill: " + bill);

            System.out.print("Payment: ");
            double payment = InputDouble("");

            if (payment >= bill) {
                System.out.println("Change: " + (payment - bill));
            } else {
                System.out.println("Money not enough.");
            }

            System.out.print("Another customer (Y/N)? ");
            anotherCustomer = sc.nextLine().charAt(0);

        } while (anotherCustomer == 'Y' || anotherCustomer == 'y');
    }



    public static void examProgram() {
        int examID = InputInteger("Enter Exam ID: ");
        String subject = InputString("Enter Subject: ");
        String date = InputString("Enter Date (YYYY-MM-DD): ");
        double duration = InputDouble("Enter Duration (minutes): ");
        String room = InputString("Enter Room: ");

        System.out.println("\n----- Exam Details -----");
        System.out.println("Exam ID: " + examID);
        System.out.println("Subject: " + subject);
        System.out.println("Date: " + date);
        System.out.println("Duration: " + duration + " minutes");
        System.out.println("Room: " + room);
    }


    public static void movieProgram() throws Exception {
        FileWriter fw = new FileWriter("output.txt");

        int rent = 0, sales = 0;
        int horror = 0, scifi = 0, drama = 0, comedy = 0, cartoons = 0;
        int dvd = 0, vcd = 0, tape = 0;

        String answer;

        do {
            System.out.println("\nMOVIE REGISTRATION");

            System.out.println("1. DVD\n2. VCD\n3. Tape");
            System.out.print("Media code: ");
            int code = InputInteger("");

            if (code == 1) dvd++;
            else if (code == 2) vcd++;
            else if (code == 3) tape++;

            System.out.print("Title: ");
            String title = sc.nextLine();

            System.out.println("1.Horror 2.Scifi 3.Drama 4.Comedy 5.Cartoons");
            System.out.print("Category: ");
            int cat = InputInteger("");

            if (cat == 1) horror++;
            else if (cat == 2) scifi++;
            else if (cat == 3) drama++;
            else if (cat == 4) comedy++;
            else if (cat == 5) cartoons++;

            System.out.print("Minutes: ");
            InputInteger("");

            System.out.println("1.Rental 2.Sales");
            System.out.print("Transaction: ");
            int trans = InputInteger("");

            if (trans == 1) rent++;
            else if (trans == 2) sales++;

            System.out.print("Price: ");
            InputDouble("");

            System.out.print("Register another (yes/no)? ");
            answer = sc.nextLine();

        } while (answer.equalsIgnoreCase("yes"));

        System.out.println("\n--- Movie Report ---");
        System.out.println("Rent: " + rent);
        System.out.println("Sales: " + sales);
        System.out.println("DVD: " + dvd);
        System.out.println("VCD: " + vcd);
        System.out.println("Tape: " + tape);
        System.out.println("Horror: " + horror);
        System.out.println("Scifi: " + scifi);
        System.out.println("Drama: " + drama);
        System.out.println("Comedy: " + comedy);
        System.out.println("Cartoons: " + cartoons);

        fw.close();
    }
}
