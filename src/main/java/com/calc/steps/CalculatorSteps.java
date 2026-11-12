
package com.calc.steps;

import com.calc.Calculator;
import io.qameta.allure.Step;
import io.qameta.allure.Allure;

public class CalculatorSteps {

    private final Calculator calculator = new Calculator();

    @Step("Сложить {a} + {b}")
    public double add(double a, double b) {
        double result = calculator.add(a, b);
        attachCalculation(a, "+", b, result);
        return result;
    }

    @Step("Вычесть {b} из {a}")
    public double subtract(double a, double b) {
        double result = calculator.subtract(a, b);
        attachCalculation(a, "-", b, result);
        return result;
    }

    @Step("Умножить {a} на {b}")
    public double multiply(double a, double b) {
        double result = calculator.multiply(a, b);
        attachCalculation(a, "*", b, result);
        return result;
    }

    @Step("Разделить {a} на {b}")
    public double divide(double a, double b) {
        double result = calculator.divide(a, b);
        attachCalculation(a, "/", b, result);
        return result;
    }

    @Step("Возвести {base} в степень {exponent}")
    public double power(double base, double exponent) {
        double result = calculator.power(base, exponent);
        attachCalculation(base, "^", exponent, result);
        return result;
    }

    @Step("Вычислить квадратный корень из {value}")
    public double sqrt(double value) {
        double result = calculator.sqrt(value);
        attachCalculation(value, "sqrt", 0, result);
        return result;
    }

    @Step("Прикрепить результат вычисления")
    public void attachCalculation(
            double a,
            String operation,
            double b,
            double result) {

        String attachment = a + " " + operation + " " + b
                + " = " + result;

        Allure.addAttachment(
                "Результат вычисления",
                "text/plain",
                attachment
        );
    }
}
