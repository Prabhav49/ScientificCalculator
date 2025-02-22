package org.prabhav;

public class Main {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java org.prabhav.Main <choice> <num1> <num2>");
            System.out.println("1: Square Root  |  2: Factorial  |  3: Natural Log  |  4: Power");
            return;
        }

        int choice = Integer.parseInt(args[0]);
        double num1 = Double.parseDouble(args[1]);
        double num2 = Double.parseDouble(args[2]);

        ScientificCalculator calculator = new ScientificCalculator();
        double result = 0;

        switch (choice) {
            case 1:
                result = calculator.squareRoot(num1);
                System.out.println("Square root of " + num1 + " is: " + result);
                break;

            case 2:
                long fact = calculator.factorial((int) num1);
                System.out.println("Factorial of " + (int) num1 + " is: " + fact);
                break;

            case 3:
                result = calculator.naturalLog(num1);
                System.out.println("Natural log of " + num1 + " is: " + result);
                break;

            case 4:
                result = calculator.power(num1, num2);
                System.out.println(num1 + " raised to the power of " + num2 + " is: " + result);
                break;

            default:
                System.out.println("Invalid choice!");
        }
    }
}
