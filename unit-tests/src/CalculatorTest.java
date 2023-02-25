import seminars.first.model.Calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static seminars.first.model.Calculator.calculatingDiscount;

public class CalculatorTest {
    public static void main(String[] args) {
        positiveTests();

        // Негативные тесты.
        // Сумма покупки равна 0.
        assertThatThrownBy(() ->
                Calculator.calculatingDiscount(0, 1))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Order is empty.");
        // отрицательная сумма покупки.
        assertThatThrownBy(() ->
                Calculator.calculatingDiscount(-1, 1))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("The purchase amount cannot be negative.");
        // параметр "скидка" отрицательный.
        assertThatThrownBy(() ->
                Calculator.calculatingDiscount(100, -1))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("The discount amount cannot be a negative number.");
        // скидка больше 100%
        assertThatThrownBy(() ->
                Calculator.calculatingDiscount(100, -1))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("The discount amount cannot exceed purchase amount.");
    }

    public static void positiveTests() {
        assertThat(calculatingDiscount(100, 2)).isEqualTo(98);
        assertThat(calculatingDiscount(100, 100)).isEqualTo(0);
        assertThat(calculatingDiscount(100, 0)).isEqualTo(100);
    }
}