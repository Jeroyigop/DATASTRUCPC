package activity6;
import java.util.*;
import java.io.*;

public class DATASTRUCACT6 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        File oF = new File("output.txt");
        FileWriter FW = new FileWriter(oF);

        int rent = 0, sales = 0;
        int horror = 0, scifi = 0, drama = 0, comedy = 0, cartoons = 0;
        int dvdtotal = 0, vcdtotal = 0, tapetotal = 0;

        String answer;

        do {
            System.out.println("\nREGISTRATION");
            FW.write("\nREGISTRATION\n");

            System.out.println("1. DVD");
            FW.write("1. DVD\n");
            System.out.println("2. VCD");
            FW.write("2. VCD\n");
            System.out.println("3. Tape");
            FW.write("3. Tape\n");

            System.out.print("Enter media code: ");
            FW.write("Enter media code: ");
            int code = sc.nextInt();
            FW.write(code + "\n");

            if (code == 1) {
                System.out.println("Type: DVD");
                FW.write("Type: DVD\n");
                dvdtotal++;
            } else if (code == 2) {
                System.out.println("Type: VCD");
                FW.write("Type: VCD\n");
                vcdtotal++;
            } else if (code == 3) {
                System.out.println("Type: Tape");
                FW.write("Type: Tape\n");
                tapetotal++;
            }

            sc.nextLine();
            System.out.print("Enter title: ");
            FW.write("Enter title: ");
            String title = sc.nextLine();
            FW.write(title + "\n");

            System.out.println("1. Horror");
            FW.write("1. Horror\n");
            System.out.println("2. Scifi");
            FW.write("2. Scifi\n");
            System.out.println("3. Drama");
            FW.write("3. Drama\n");
            System.out.println("4. Comedy");
            FW.write("4. Comedy\n");
            System.out.println("5. Cartoons");
            FW.write("5. Cartoons\n");

            System.out.print("Enter category: ");
            FW.write("Enter category: ");
            int category = sc.nextInt();
            FW.write(category + "\n");

            if (category == 1) horror++;
            else if (category == 2) scifi++;
            else if (category == 3) drama++;
            else if (category == 4) comedy++;
            else if (category == 5) cartoons++;

            System.out.print("Enter minutes: ");
            FW.write("Enter minutes: ");
            int minutes = sc.nextInt();
            FW.write(minutes + "\n");

            System.out.println("1. Rental");
            FW.write("1. Rental\n");
            System.out.println("2. Sales");
            FW.write("2. Sales\n");

            System.out.print("Enter transaction type: ");
            FW.write("Enter transaction type: ");
            int transactionType = sc.nextInt();
            FW.write(transactionType + "\n");

            if (transactionType == 1) rent++;
            else if (transactionType == 2) sales++;

            System.out.print("Enter price: ");
            FW.write("Enter price: ");
            double price = sc.nextDouble();
            FW.write(price + "\n");

            System.out.print("Register another? (yes/no): ");
            FW.write("Register another? (yes/no): ");
            sc.nextLine();
            answer = sc.nextLine();
            FW.write(answer + "\n");

        } while (answer.equalsIgnoreCase("yes"));

        System.out.println("\nREPORTS");
        FW.write("\nREPORTS\n");

        System.out.println("For Rent: " + rent);
        FW.write("For Rent: " + rent + "\n");
        System.out.println("For Sale: " + sales);
        FW.write("For Sale: " + sales + "\n");
        System.out.println("VCD Total: " + vcdtotal);
        FW.write("VCD Total: " + vcdtotal + "\n");
        System.out.println("DVD Total: " + dvdtotal);
        FW.write("DVD Total: " + dvdtotal + "\n");
        System.out.println("Tape Total: " + tapetotal);
        FW.write("Tape Total: " + tapetotal + "\n");
        System.out.println("Horror Movies: " + horror);
        FW.write("Horror Movies: " + horror + "\n");
        System.out.println("Scifi Movies: " + scifi);
        FW.write("Scifi Movies: " + scifi + "\n");
        System.out.println("Drama Movies: " + drama);
        FW.write("Drama Movies: " + drama + "\n");
        System.out.println("Comedy Movies: " + comedy);
        FW.write("Comedy Movies: " + comedy + "\n");
        System.out.println("Cartoons: " + cartoons);
        FW.write("Cartoons: " + cartoons + "\n");

        FW.close();
        sc.close();
    }
}
