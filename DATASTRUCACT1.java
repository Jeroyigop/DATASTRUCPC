import java.util.Scanner;

public class DATASTRUCACT1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 1. Initialize variables
        int rent = 0, sales = 0;
        int horror = 0, scifi = 0, drama = 0, comedy = 0, cartoons = 0;
        int dvdtotal = 0, vcdtotal = 0, tapetotal = 0;

        String answer;

        do {
            // 2–5 Display Registration & Media Type
            System.out.println("\nREGISTRATION");
            System.out.println("1. DVD");
            System.out.println("2. VCD");
            System.out.println("3. Tape");

            // 6 Input code
            System.out.print("Enter media code: ");
            int code = sc.nextInt();

            // 7–9 Media type condition
            if (code == 1) {
                System.out.println("Type: DVD");
                dvdtotal++;
            } else if (code == 2) {
                System.out.println("Type: VCD");
                vcdtotal++;
            } else if (code == 3) {
                System.out.println("Type: Tape");
                tapetotal++;
            }

            // 10 Input title
            sc.nextLine(); // consume newline
            System.out.print("Enter title: ");
            String title = sc.nextLine();

            // 11–15 Display categories
            System.out.println("1. Horror");
            System.out.println("2. Scifi");
            System.out.println("3. Drama");
            System.out.println("4. Comedy");
            System.out.println("5. Cartoons");

            // 16 Input category
            System.out.print("Enter category: ");
            int category = sc.nextInt();

            // 17–21 Category counters
            if (category == 1) horror++;
            else if (category == 2) scifi++;
            else if (category == 3) drama++;
            else if (category == 4) comedy++;
            else if (category == 5) cartoons++;

            // 22 Input minutes
            System.out.print("Enter minutes: ");
            int minutes = sc.nextInt();

            // 24–25 Transaction type
            System.out.println("1. Rental");
            System.out.println("2. Sales");
            System.out.print("Enter transaction type: ");
            int transactionType = sc.nextInt();

            // 27–28 Transaction counter
            if (transactionType == 1) rent++;
            else if (transactionType == 2) sales++;

            // 29 Input price
            System.out.print("Enter price: ");
            double price = sc.nextDouble();

            // 30–32 Register another
            System.out.print("Register another? (yes/no): ");
            sc.nextLine(); // consume newline
            answer = sc.nextLine();

        } while (answer.equalsIgnoreCase("yes"));

        // 33–43 REPORTS
        System.out.println("\nREPORTS");
        System.out.println("For Rent: " + rent);
        System.out.println("For Sale: " + sales);
        System.out.println("VCD Total: " + vcdtotal);
        System.out.println("DVD Total: " + dvdtotal);
        System.out.println("Tape Total: " + tapetotal);
        System.out.println("Horror Movies: " + horror);
        System.out.println("Scifi Movies: " + scifi);
        System.out.println("Drama Movies: " + drama);
        System.out.println("Comedy Movies: " + comedy);
        System.out.println("Cartoons: " + cartoons);

        sc.close();
    }
}