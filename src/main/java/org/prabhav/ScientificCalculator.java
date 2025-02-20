package org.prabhav;

public class ScientificCalculator {
    public double squareRoot(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("Square root of a negative number is not defined for real numbers.");
        }
        return Math.sqrt(x);
    }
    public long factorial(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("Factorial of a negative number is not defined.");
        }
        long fact = 1;
        for (int i = 1; i <= x; i++) {
            fact *= i;
        }
        return fact;
    }
}
