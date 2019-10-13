import com.deepak.training.ncr.CalculatorImpl;
import com.deepak.training.ncr.ICalculator;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.NoSuchElementException;

public class CalculatorTest extends TestCase {

    private ICalculator calc = null;

    protected void setUp() {
        calc = new CalculatorImpl();
    }

    public void test1() {
        final String value = calc.computeSequence("nine over eight plus four times two divided-by three".toUpperCase());
        assertEquals("3.79", value);
    }

    public void test2() {
        final String value = calc.computeSequence("one plus six".toUpperCase());
        assertEquals("7", value);
    }

    public void test3() {
        final String value = calc.computeSequence("one plus two times three".toUpperCase());
        assertEquals("7", value);
    }

    public void test4() {
        final String value = calc.computeSequence("nine minus three times seven".toUpperCase());
        assertEquals("-12", value);
    }

    public void test5() {
        final String value = calc.computeSequence("four minus eight plus six times nine".toUpperCase());
        assertEquals("50", value);
    }

    public void test6() {
        final String value = calc.computeSequence("seven over nine plus two".toUpperCase());
        assertEquals("2.78", value);
    }

}
