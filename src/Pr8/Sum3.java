package Pr8;

public class Sum3 {

    public static int sum(int num) {
        if (num/10 == 0) {
            return num;
        }
        return (sum(num/10) + num%10);
    }

    public static void main(String[] args) {
        int num = 12345;
        System.out.println(sum(num));
    }
}
