
package com.calc.tests;

import com.calc.steps.CalculatorSteps;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Owner;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Allure;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

@Epic("Калькулятор")
@Feature("Арифметические операции")
public class ArithmeticTest {

    private final CalculatorSteps steps = new CalculatorSteps();

    @Test
    @Story("Сложение")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Даша")
    @Description("Проверяем сложение двух положительных чисел")
    @Link(name = "Требования", url = "https://example.com/calculator")
    public void testAddPositiveNumbers() {

        Allure.parameter("Первое число", 2);
        Allure.parameter("Второе число", 3);

        Allure.step("Выполняем сложение двух чисел", () -> {
            double result = steps.add(2, 3);
            Assertions.assertEquals(5, result, 0.000001);
        });
    }

    @Test
    @Story("Сложение")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Даша")
    @Description("Проверяем сложение отрицательного и положительного числа")
    public void testAddNegativeNumber() {

        double result = steps.add(-5, 3);

        Assertions.assertEquals(-2, result, 0.000001);
    }

    @Test
    @Story("Вычитание")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверяем вычитание двух положительных чисел")
    public void testSubtract() {

        double result = steps.subtract(10, 4);

        Assertions.assertEquals(6, result, 0.000001);
    }

    @Test
    @Story("Умножение")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверяем умножение двух положительных чисел")
    public void testMultiply() {

        double result = steps.multiply(7, 8);

        Assertions.assertEquals(56, result, 0.000001);
    }

    @Test
    @Story("Деление")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверяем деление двух положительных чисел")
    public void testDivide() {

        double result = steps.divide(15, 3);

        Assertions.assertEquals(5, result, 0.000001);
    }

    @Test
    @Story("Деление на ноль")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверяем, что при делении на ноль возникает ArithmeticException")
    public void testDivideByZero() {

        ArithmeticException exception = Assertions.assertThrows(
                ArithmeticException.class,
                () -> steps.divide(10, 0)
        );

        Assertions.assertEquals("Деление на ноль", exception.getMessage());
    }
}
