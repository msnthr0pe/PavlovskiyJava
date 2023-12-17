package Pr8;


public class CountSums2 {

    public static void recursion(double num, double k, int s, int count) {
        double saved = num;
        if (num < Math.pow(10, k)) {
            int sum = 0;
            for (int i=0; i<k; i++) {
                sum += num%10;
                num/=10;
            }
            if (sum == s) {
                count++;
            }
            recursion(saved+1, k, s, count);
        }
        else {
            System.out.println(count);
        }
    }

    public static void main(String[] args) {
        double k = 2;
        int s = 18;

        double num = Math.pow(10, k-1);
        recursion(num, k, s , 0);
    }
}
