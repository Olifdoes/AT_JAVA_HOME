
package com.calc.tests;

import com.calc.steps.CalculatorSteps;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Owner;
import io.qameta.allure.Description;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

@Epic("Калькулятор")
@Feature("Математические функции")
public class MathFunctionsTest {

    private final CalculatorSteps steps = new CalculatorSteps();

    @Test
    @Story("Возведение в степень")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Ваше имя")
    @Description("Проверяем возведение числа 2 в десятую степень")
    public void testPower() {

        double result = steps.power(2, 10);

        Assertions.assertEquals(1024, result, 0.000001);
    }

    @Test
    @Story("Квадратный корень из отрицательного числа")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Даша")
    @Description("Проверяем, что при вычислении квадратного корня из отрицательного числа возникает ArithmeticException")
    public void testSqrtNegativeNumber() {

        ArithmeticException exception = Assertions.assertThrows(
                ArithmeticException.class,
                () -> steps.sqrt(-25)
        );

        Assertions.assertEquals(
                "Корень из отрицательного числа",
                exception.getMessage()
        );
    }
}
