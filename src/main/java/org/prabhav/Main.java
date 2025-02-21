package org.prabhav;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Error: No input provided. Pass a number as an argument.");
            return;
        }

        int choice = Integer.parseInt(args[0]);
        ScientificCalculator calculator = new ScientificCalculator();

        switch (choice) {
            case 1:
                double sq = calculator.squareRoot(25);
                System.out.println("Square root of 25 is: " + sq);
                break;
            case 2:
                long fac = calculator.factorial(5);
                System.out.println("Factorial of 5 is: " + fac);
                break;
            case 3:
                double nl = calculator.naturalLog(5);
                System.out.println("Natural Log of 5 is: " + nl);
                break;
            case 4:
                double pow = calculator.power(4, 2);
                System.out.println("Power of 4 ^ 2: " + pow);
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
}
