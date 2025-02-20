package org.prabhav;

public class Main {
    public static void main(String[] args) {
        ScientificCalculator calculator = new ScientificCalculator();
        double sq = calculator.squareRoot(25); // Example input
        System.out.println("Square root of 25 is: " + sq);
        long fac = calculator.factorial(25);
        System.out.println("Factorial of 25 is: " + fac);
    }
}
