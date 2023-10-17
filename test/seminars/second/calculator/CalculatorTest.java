package seminars.second.calculator;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @Test
    public void testSum() {
        if (8 != Calculator.calculation(2, 6, '+')) {
            throw new AssertionError("Ошибка в методе");
        }
    }

    @Test
    public void testMinus() {
        if (0 != Calculator.calculation(2, 2, '-')) {
            throw new AssertionError("Ошибка в методе");
        }
    }

    @Test
    public void testMulti() {
        if (14 != Calculator.calculation(2, 7, '*')) {
            throw new AssertionError("Ошибка в методе");
        }
    }

    @Test
    public void testDevide() {
        if (2 != Calculator.calculation(100, 50, '/')) {
            throw new AssertionError("Ошибка в методе");
        }
    }

    @Test
    public void testSum2() {
        assert 8 == Calculator.calculation(2, 6, '+');
    }

    @Test
    public void testMinus2() {
        assert 0 == Calculator.calculation(2, 2, '-');
    }

    @Test
    public void testMulti2() {
        assert 14 == Calculator.calculation(2, 7, '*');
    }

    @Test
    public void testDevide2() {
        assert 2 == Calculator.calculation(100, 50, '/');
    }

    @Test
    public void testDistinctCorrect() {
        assertThat(Calculator.calculatingDiscount(120D, 20)).isEqualTo(100D);
    }

    @Test
    public void testDistinctNegative() {
        assertThatThrownBy(() -> Calculator.calculatingDiscount(100D, -10))
                .isInstanceOf(ArithmeticException.class);
    }

    @Test
    public void testDistinctResultNegative() {
        assertThatThrownBy(() -> Calculator.calculatingDiscount(100D, 120))
                .isInstanceOf(ArithmeticException.class);
    }

    @Test
    public void testPowPositive() {
        assertThat(Calculator.pow(2,2)).isEqualTo(4);
    }

    @Test
    public void testPowZeroBase() {
        assertThat(Calculator.pow(0, 2)).isEqualTo(0);
    }

    @Test
    public void testPowZeroExponent() {
        assertThat(Calculator.pow(2, 0)).isEqualTo(1);
    }

    @Test
    public void testPowOneExponent() {
        assertThat(Calculator.pow(5, 1)).isEqualTo(5);
    }

    @Test
    public void testPowNegativeBase() {
        assertThat(Calculator.pow(-2, 2)).isEqualTo(4);
    }

    @Test
    public void testPowOddExponent() {
        assertThat(Calculator.pow(-2, 3)).isEqualTo(-8);
    }
}