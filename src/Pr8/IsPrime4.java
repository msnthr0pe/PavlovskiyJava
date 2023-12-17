package Pr8;

public class IsPrime4 {

    public static boolean primeCheck(int num, int denominator) {
        if (num == denominator) {
            return true;
        }
        if (num % denominator == 0 && denominator != 1) {
            return false;
        }
        return primeCheck(num, denominator + 1);
    }

    public static void main(String[] args) {
        int num = 1;
        for (int i=0; i<30; i++) {
            System.out.println(num + " " +primeCheck(num, 1));
            num++;
        }
    }
}