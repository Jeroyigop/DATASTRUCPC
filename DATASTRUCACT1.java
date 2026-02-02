import java.util.Scanner;

public class DATASTRUCACT1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        
        int rent = 0, sales = 0;
        int horror = 0, scifi = 0, drama = 0, comedy = 0, cartoons = 0;
        int dvdtotal = 0, vcdtotal = 0, tapetotal = 0;

        String answer;

        do {
            
            System.out.println("\nREGISTRATION");
            System.out.println("1. DVD");
            System.out.println("2. VCD");
            System.out.println("3. Tape");

            
            System.out.print("Enter media code: ");
            int code = sc.nextInt();

            
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

            
            sc.nextLine(); 
            System.out.print("Enter title: ");
            String title = sc.nextLine();

            
            System.out.println("1. Horror");
            System.out.println("2. Scifi");
            System.out.println("3. Drama");
            System.out.println("4. Comedy");
            System.out.println("5. Cartoons");

            
            System.out.print("Enter category: ");
            int category = sc.nextInt();

            
            if (category == 1) horror++;
            else if (category == 2) scifi++;
            else if (category == 3) drama++;
            else if (category == 4) comedy++;
            else if (category == 5) cartoons++;

            
            System.out.print("Enter minutes: ");
            int minutes = sc.nextInt();

            
            System.out.println("1. Rental");
            System.out.println("2. Sales");
            System.out.print("Enter transaction type: ");
            int transactionType = sc.nextInt();

            
            if (transactionType == 1) rent++;
            else if (transactionType == 2) sales++;

            
            System.out.print("Enter price: ");
            double price = sc.nextDouble();

            
            System.out.print("Register another? (yes/no): ");
            sc.nextLine(); 
            answer = sc.nextLine();

        } while (answer.equalsIgnoreCase("yes"));

        
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