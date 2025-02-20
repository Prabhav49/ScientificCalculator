import org.prabhav.ScientificCalculator;
import org.junit.Test;
import static org.junit.Assert.*;

public class ScientificCalculatorTest {

    private final ScientificCalculator calculator = new ScientificCalculator();

    @Test
    public void testSquareRootPositiveNumber() {
        assertEquals(5.0, calculator.squareRoot(25), 0.0001);
    }

    @Test
    public void testSquareRootZero() {
        assertEquals(0.0, calculator.squareRoot(0), 0.0001);
    }

    @Test
    public void testSquareRootSmallNumber() {
        assertEquals(1.4142, calculator.squareRoot(2), 0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSquareRootNegativeNumber() {
        calculator.squareRoot(-4);
    }

    @Test
    public void testFactorial() {
        assertEquals(120, calculator.factorial(5));
        assertEquals(1, calculator.factorial(0));
        assertThrows(IllegalArgumentException.class, () -> calculator.factorial(-3));
    }

    @Test
    public void testNaturalLog() {
        assertEquals(1.0, calculator.naturalLog(Math.E), 0.0001);
        assertEquals(0.0, calculator.naturalLog(1), 0.0001);
        assertThrows(IllegalArgumentException.class, () -> calculator.naturalLog(-1));
        assertThrows(IllegalArgumentException.class, () -> calculator.naturalLog(0));
    }
}
