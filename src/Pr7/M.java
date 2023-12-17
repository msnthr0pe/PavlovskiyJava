package Pr7;
interface MathCalculable {
    double calculatePower(double base, double exponent);
    double calculateComplexModulus(double realPart, double imaginaryPart);
    double PI = 3.14159265359;

    default String Name() {return "Имя";}
}

class MathFunc implements MathCalculable {
    @Override
    public double calculatePower(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    @Override
    public double calculateComplexModulus(double realPart, double imaginaryPart) {
        return Math.sqrt(realPart * realPart + imaginaryPart * imaginaryPart);
    }

    public double calculateCircleLength(double radius) {
        return 2 * PI * radius;
    }
}

public class M {
    public static void main(String[] args) {
        MathFunc mathFunc = new MathFunc();

        double resultPower = mathFunc.calculatePower(2, 3);
        System.out.println("2^3 = " + resultPower);

        double resultModulus = mathFunc.calculateComplexModulus(3, 4);
        System.out.println("|3 + 4i| = " + resultModulus);

        double circleLength = mathFunc.calculateCircleLength(5);
        System.out.println("Длина окружности с радиусом 5: " + circleLength);
    }
}
