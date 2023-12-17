package Pr22;

public class CalculatorModel {
    private double result;

    public double getResult() {
        return result;
    }

    public void performOperation(double operand1, double operand2, String operator) {
        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                if (operand2 == 0) {
                    result = Double.NaN; // Обработка деления на ноль
                } else {
                    result = operand1 / operand2;
                }
                break;
        }
    }
}