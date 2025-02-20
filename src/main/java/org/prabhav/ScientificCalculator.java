package org.prabhav;

public class ScientificCalculator {
    public double squareRoot(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("Square root of a negative number is not defined for real numbers.");
        }
        return Math.sqrt(x);
    }
}
