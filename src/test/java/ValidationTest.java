import com.deepak.training.ncr.CalculatorImpl;
import com.deepak.training.ncr.ICalculator;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

public class ValidationTest {

    private ICalculator calc = null;

    @Test(expected = NoSuchElementException.class)
    public void testNoSuchElementException1() {
        new CalculatorImpl().computeSequence("nine over1 eight plus four times two divided-by three ".toUpperCase());
    }

    @Test(expected = NoSuchElementException.class)
    public void testNoSuchElementException2() {
        new CalculatorImpl().computeSequence("nine nine".toUpperCase());
    }

    @Test(expected = NoSuchElementException.class)
    public void testNoSuchElementException3() {
        new CalculatorImpl().computeSequence("nine over1 over1 plus four times two divided-by three ".toUpperCase());
    }

    @Test(expected = NoSuchElementException.class)
    public void testNoSuchElementException4() {
        new CalculatorImpl().computeSequence("nine over1 eight plus four times two divided-by three three".toUpperCase());
    }

    @Test(expected = java.lang.IllegalArgumentException.class)
    public void testNoSuchElementException5() {
        new CalculatorImpl().computeSequence("plus four times".toUpperCase());
    }
}
