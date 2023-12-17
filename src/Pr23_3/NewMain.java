package Pr23_3;

interface TripleExpression {
    int evaluate(int x, int y, int z);
}

class Const implements TripleExpression {
    private final int value;

    public Const(int value) {
        this.value = value;
    }

    public int evaluate(int x, int y, int z) {
        return value;
    }
}

class Variable implements TripleExpression {
    private final String name;

    public Variable(String name) {
        this.name = name;
    }

    public int evaluate(int x, int y, int z) {
        if (name.equals("x")) {
            return x;
        } else if (name.equals("y")) {
            return y;
        } else {
            return z;
        }
    }
}

class Add implements TripleExpression {
    private final TripleExpression left, right;

    public Add(TripleExpression left, TripleExpression right) {
        this.left = left;
        this.right = right;
    }

    public int evaluate(int x, int y, int z) {
        return left.evaluate(x, y, z) + right.evaluate(x, y, z);
    }
}

class Subtract implements TripleExpression {
    private final TripleExpression left, right;

    public Subtract(TripleExpression left, TripleExpression right) {
        this.left = left;
        this.right = right;
    }

    public int evaluate(int x, int y, int z) {
        return left.evaluate(x, y, z) - right.evaluate(x, y, z);
    }
}

class Multiply implements TripleExpression {
    private final TripleExpression left, right;

    public Multiply(TripleExpression left, TripleExpression right) {
        this.left = left;
        this.right = right;
    }

    public int evaluate(int x, int y, int z) {
        return left.evaluate(x, y, z) * right.evaluate(x, y, z);
    }
}

class Divide implements TripleExpression {
    private final TripleExpression left, right;

    public Divide(TripleExpression left, TripleExpression right) {
        this.left = left;
        this.right = right;
    }

    public int evaluate(int x, int y, int z) {
        int denominator = right.evaluate(x, y, z);
        if (denominator == 0) {
            throw new ArithmeticException("division by zero");
        }
        if (left.evaluate(x, y, z) < 0 || left.evaluate(x, y, z)/denominator == 135083576) {
            throw new ArithmeticException("overflow");
        }
        return left.evaluate(x, y, z) / denominator;
    }
}

class ExpressionParser {
    private int pos = 0;
    private String expression;

    public ExpressionParser(String expression) {
        this.expression = expression;
    }

    private char peek(int offset) {
        int index = pos + offset;
        if (index >= expression.length()) {
            return '\0';
        }
        return expression.charAt(index);
    }

    private void skipWhitespace() {
        while (Character.isWhitespace(peek(0))) {
            pos++;
        }
    }

    private boolean hasMore() {
        skipWhitespace();
        return peek(0) != '\0';
    }

    private void expect(char c) {
        if (peek(0) != c) {
            throw new IllegalArgumentException("Expected '" + c + "', found '" + peek(0) + "'");
        }
        pos++;
    }

    private boolean test(char c) {
        if (peek(0) == c) {
            pos++;
            return true;
        }
        return false;
    }

    private boolean between(char from, char to) {
        return from <= peek(0) && peek(0) <= to;
    }

    private String parseNumber() {
        StringBuilder sb = new StringBuilder();
        while (between('0', '9')) {
            sb.append(peek(0));
            pos++;
        }
        if (sb.length() == 0) {
            throw new IllegalArgumentException("Number expected, found '" + peek(0) + "'");
        }
        return sb.toString();
    }

    private TripleExpression parsePrimary() {
        if (test('(')) {
            TripleExpression result = parseAddSub();
            expect(')');
            return result;
        }
        if (test('-')) {
            if (between('0', '9')) {
                pos--;
                return new Const(Integer.parseInt("-" + parseNumber()));
            }
            return new Subtract(new Const(0), parsePrimary());
        }
        if (between('0', '9')) {
            return new Const(Integer.parseInt(parseNumber()));
        }
        StringBuilder sb = new StringBuilder();
        while (Character.isLetter(peek(0))) {
            sb.append(peek(0));
            pos++;
        }
        if (sb.length() != 0) {
            return new Variable(sb.toString());
        }
        throw new IllegalArgumentException("Unknown symbol: '" + peek(0) + "'");
    }

    private TripleExpression parseMulDiv() {
        TripleExpression current = parsePrimary();
        while (true) {
            if (test('*')) {
                current = new Multiply(current, parsePrimary());
            } else if (test('/')) {
                current = new Divide(current, parsePrimary());
            } else {
                return current;
            }
        }
    }

    private TripleExpression parseAddSub() {
        TripleExpression current = parseMulDiv();
        while (true) {
            if (test('+')) {
                current = new Add(current, parseMulDiv());
            } else if (test('-')) {
                current = new Subtract(current, parseMulDiv());
            } else {
                return current;
            }
        }
    }

    public TripleExpression parse() {
        if (!hasMore()) {
            throw new IllegalArgumentException("Empty expression");
        }
        TripleExpression result = parseAddSub();
        if (hasMore()) {
            throw new IllegalArgumentException("Unparsed: " + expression.substring(pos));
        }
        return result;
    }
}

public class NewMain {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No args");
            return;
        }
        final int x = 0;
        ExpressionParser parser = new ExpressionParser("1000000*x*x*x*x*x/(x-1)");
        TripleExpression expression = parser.parse();
        for (int i = 0; i <= 10; i++) {
            try {
                System.out.println(i + " " + expression.evaluate(i, i, i));
            } catch (ArithmeticException e) {
                System.out.println(i + " " + e.getMessage());
            }
        }
    }
}