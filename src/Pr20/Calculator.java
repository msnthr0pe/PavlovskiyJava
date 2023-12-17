package Pr20;

public class Calculator {
    public static <T extends Number> T sum(T num1, T num2) {
        if (num1 instanceof Integer && num2 instanceof Integer) {
            return (T) Integer.valueOf(num1.intValue() + num2.intValue());
        } else if (num1 instanceof Double && num2 instanceof Double) {
            return (T) Double.valueOf(num1.doubleValue() + num2.doubleValue());
        } else {
            throw new IllegalArgumentException("Unsupported number types. Only Integer and Double are supported.");
        }
    }

    public static <T extends Number> T multiply(T num1, T num2) {
        if (num1 instanceof Integer && num2 instanceof Integer) {
            return (T) Integer.valueOf(num1.intValue() * num2.intValue());
        } else if (num1 instanceof Double && num2 instanceof Double) {
            return (T) Double.valueOf(num1.doubleValue() * num2.doubleValue());
        } else {
            throw new IllegalArgumentException("Unsupported number types. Only Integer and Double are supported.");
        }
    }

    public static <T extends Number> T divide(T num1, T num2) {
        if (num1 instanceof Integer && num2 instanceof Integer) {
            return (T) Integer.valueOf(num1.intValue() / num2.intValue());
        } else if (num1 instanceof Double && num2 instanceof Double) {
            return (T) Double.valueOf(num1.doubleValue() / num2.doubleValue());
        } else {
            throw new IllegalArgumentException("Unsupported number types. Only Integer and Double are supported.");
        }
    }

    public static <T extends Number> T subtraction(T num1, T num2) {
        if (num1 instanceof Integer && num2 instanceof Integer) {
            return (T) Integer.valueOf(num1.intValue() - num2.intValue());
        } else if (num1 instanceof Double && num2 instanceof Double) {
            return (T) Double.valueOf(num1.doubleValue() - num2.doubleValue());
        } else {
            throw new IllegalArgumentException("Unsupported number types. Only Integer and Double are supported.");
        }
    }

    public static void main(String[] args) {
        double result = Calculator.sum(7.0, 7.1);
        System.out.println("Sum: " + result);

        result = Calculator.multiply(2.0, 1.5);
        System.out.println("Multiplication: " + result);

        result = Calculator.divide(6, 4);
        System.out.println("Division: " + result);

        result = Calculator.subtraction(8.5, 2.0);
        System.out.println("Subtraction: " + result);
    }
}
