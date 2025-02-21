package org.prabhav;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ScientificCalculator calculator = new ScientificCalculator();

        System.out.println("Choose an operation:");
        System.out.println("1. Square Root");
        System.out.println("2. Factorial");
        System.out.println("3. Natural Log");
        System.out.println("4. Power");
        System.out.print("Enter your choice (1-4): ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter a number: ");
                double num1 = scanner.nextDouble();
                System.out.println("Square root of " + num1 + " is: " + calculator.squareRoot(num1));
                break;

            case 2:
                System.out.print("Enter a number: ");
                int num2 = scanner.nextInt();
                System.out.println("Factorial of " + num2 + " is: " + calculator.factorial(num2));
                break;

            case 3:
                System.out.print("Enter a number: ");
                double num3 = scanner.nextDouble();
                System.out.println("Natural Log of " + num3 + " is: " + calculator.naturalLog(num3));
                break;

            case 4:
                System.out.print("Enter base: ");
                double base = scanner.nextDouble();
                System.out.print("Enter exponent: ");
                double exponent = scanner.nextDouble();
                System.out.println(base + " raised to " + exponent + " is: " + calculator.power(base, exponent));
                break;

            default:
                System.out.println("Invalid choice!");
        }

        scanner.close();
    }
}
