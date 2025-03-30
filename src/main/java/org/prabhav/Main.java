package org.prabhav;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Scientific Calculator Started!");
        System.out.println("1: Square Root  |  2: Factorial  |  3: Natural Log  |  4: Power");

        ScientificCalculator calculator = new ScientificCalculator();

        while (true) {
            System.out.print("Enter choice (1-4) or 0 to exit: ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Exiting Calculator...");
                break;
            }

            System.out.print("Enter num1: ");
            double num1 = scanner.nextDouble();

            double num2 = 0;
            if (choice == 4) { 
                System.out.print("Enter num2: ");
                num2 = scanner.nextDouble();
            }

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
        scanner.close();
    }
}
