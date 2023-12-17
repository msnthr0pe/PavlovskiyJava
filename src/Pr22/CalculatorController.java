package Pr22;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class CalculatorController implements ActionListener {
    private CalculatorModel model;
    private CalculatorView view;

    private Stack<Double> stack;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
        stack = new Stack<>();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (isNumber(command)) {
            double number = Double.parseDouble(command);
            stack.push(number);
            view.updateDisplay(Double.toString(number));
        } else if (command.equals("C")) {
            stack.clear();
            view.updateDisplay("");
        } else if (isOperator(command)) {
            if (stack.size() < 2) {
                view.updateDisplay("Error");
                return;
            }

            double operand2 = stack.pop();
            double operand1 = stack.pop();
            double result = performOperation(operand1, operand2, command);
            stack.push(result);
            view.updateDisplay(Double.toString(result));
        }
    }

    private boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private double performOperation(double operand1, double operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    view.updateDisplay("Error");
                    return Double.NaN; // Обработка деления на ноль
                }
                return operand1 / operand2;
            default:
                view.updateDisplay("Error");
                return 0;
        }
    }
}
