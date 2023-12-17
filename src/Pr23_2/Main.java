package Pr23_2;

// Создание интерфейса для всех классов выражений
interface Expression {
    int evaluate(int x);
}

// Создание класса Const, представляющего константу
class Const implements Expression {
    private final int value;

    public Const(int value) {
        this.value = value;
    }

    public int evaluate(int x) {
        return value;
    }
}

// Создание класса Variable, представляющего переменную
class Variable implements Expression {
    private final String name;

    public Variable(String name) {
        this.name = name;
    }

    public int evaluate(int x) {
        return x;
    }
}

// Создание абстрактного класса для бинарных операций
abstract class BinaryOperation implements Expression {
    protected final Expression left, right;

    public BinaryOperation(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
}

// Создание классов для арифметических операций
class Add extends BinaryOperation {
    public Add(Expression left, Expression right) {
        super(left, right);
    }

    public int evaluate(int x) {
        return left.evaluate(x) + right.evaluate(x);
    }
}

class Subtract extends BinaryOperation {
    public Subtract(Expression left, Expression right) {
        super(left, right);
    }

    public int evaluate(int x) {
        return left.evaluate(x) - right.evaluate(x);
    }
}

class Multiply extends BinaryOperation {
    public Multiply(Expression left, Expression right) {
        super(left, right);
    }

    public int evaluate(int x) {
        return left.evaluate(x) * right.evaluate(x);
    }
}

class Divide extends BinaryOperation {
    public Divide(Expression left, Expression right) {
        super(left, right);
    }

    public int evaluate(int x) {
        return left.evaluate(x) / right.evaluate(x);
    }
}

// Класс для тестирования программы
public class Main {
    public static void main(String[] args) {
        // Создание выражения x^2−2x+1
        Expression expression = new Add(
                new Subtract(
                        new Multiply(new Variable("x"), new Variable("x")),
                        new Multiply(new Const(2), new Variable("x"))
                ),
                new Const(1)
        );

        int x = 3;
        int result = expression.evaluate(x);
        System.out.println("Получилось: " + result);
    }
}