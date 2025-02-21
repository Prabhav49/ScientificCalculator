package org.prabhav;

public class Main {
    public static void main(String[] args) {
        ScientificCalculator calculator = new ScientificCalculator();
        double sq = calculator.squareRoot(25);
        System.out.println("Square root of 25 is: " + sq);

        long fac = calculator.factorial(25);
        System.out.println("Factorial of 25 is: " + fac);

        double nl = calculator.naturalLog(5);
        System.out.println("Natural Log of 5 is: " + nl);

        double pow = calculator.power(4, 2);
        System.out.println("Power of 4 ^ 2: " + pow);
    }
}
