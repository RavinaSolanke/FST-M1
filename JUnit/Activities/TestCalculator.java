import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


public class TestCalculator {
    private Calculator calculator;
    @BeforeEach
    public void setup(){
        calculator= new Calculator();
    }
    @Test
    @DisplayName("Simple multiplication should work")
    public void testMultiply(){
        assertEquals(20, calculator.multiple(4,5));

    }
}

