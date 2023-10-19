package seminars.third.hw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MainHWTest {
    MainHW mainHW;
    @BeforeEach
    public void setUp() {
        this.mainHW = new MainHW();
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 4, 6, 8, 444})
    public void testEven(int num) {
        boolean even = mainHW.isEven(num);
        Assertions.assertTrue(even);
    }

    @ParameterizedTest
    @ValueSource(ints = {13, 1, 5, 7, 333})
    public void testOdd(int num) {
        boolean even = mainHW.isEven(num);
        Assertions.assertFalse(even);
    }

    @ParameterizedTest
    @ValueSource(ints = {26, 99, 50})
    public void testIntervalPositive(int num) {
        boolean inInterval = mainHW.isInInterval(num);
        Assertions.assertTrue(inInterval);
    }

    @ParameterizedTest
    @ValueSource(ints = {25, 100, 0, -10, 110})
    public void testIntervalNegative(int num) {
        boolean inInterval = mainHW.isInInterval(num);
        Assertions.assertFalse(inInterval);
    }
}
