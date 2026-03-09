package Preact2;
import java.util.Scanner;

public class DATASTRUCBILL {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String strProdName, strAnotherP, strCustomer;
        char cCustomer = 'Y', cAnotherP = 'Y';
        double dQty, dbill, dPrice;
        double dtotal, dpay, dchange = 0;

        do {
            dbill = 0;

            do {
                System.out.println("\nGROCERY PROGRAM");
                System.out.println("Input product name: ");
                strProdName = input.nextLine();

                System.out.println("Price: ");
                dPrice = input.nextDouble();

                System.out.println("Quantity: ");
                dQty = input.nextDouble();
                input.nextLine();

                dtotal = dQty * dPrice;
                dbill += dtotal;

                System.out.println("Another product Y/N?");
                strAnotherP = input.nextLine();
                cAnotherP = strAnotherP.charAt(0);

            } while ((cAnotherP == 'Y') || (cAnotherP == 'y'));

            System.out.println("Bill: " + dbill);
            System.out.println("Payment: ");
            dpay = input.nextDouble();
            input.nextLine();

            if (dpay >= dbill) {
                dchange = dpay - dbill;
                System.out.println("Change: " + dchange);
                System.out.println("Thank you for purchasing");
            } else {
                System.out.println("Money is not enough");
            }

            System.out.println("Another customer Y/N?");
            strCustomer = input.nextLine();
            cCustomer = strCustomer.charAt(0);

        } while ((cCustomer == 'Y') || (cCustomer == 'y'));

        System.out.println("Grocery program terminating....");
        input.close();
    }
}