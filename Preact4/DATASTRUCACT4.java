package Preact4;
import java.util.Scanner;

public class DATASTRUCACT4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String emfirstname, emmidname, emlastname;
        double emhourrate, emhoursworked, overtime, emtotaldeductions, overtimepay;

        emfirstname = InputString("Firstname: ");
        emmidname = InputString("Midname: ");
        emlastname = InputString("Lastname: ");
        emhoursworked = InputDouble("HoursWorked: ");
        emhourrate = InputDouble("HourRate: ");
        overtime = InputDouble("Overtime: ");
        emtotaldeductions = InputDouble("Total Deductions: ");
        overtimepay = ComputeSalary(emhourrate, emhoursworked, overtime) - emtotaldeductions;

    }

    public static String InputString(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        return sc.nextLine();
    }

    public static int InputInt(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        return sc.nextInt();
    }

    public static double InputDouble(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        return sc.nextDouble();
    }

    public static double ComputeSalary(double rate, double hours, double overtime, double deductions) {
        return (rate * hours) + overtime;
    }
    public static void Displayinfo(String name,  double salary) {
        System.out.println(name);
        System.out.printf("NET PAY %.2f\n", salary);
    }




}