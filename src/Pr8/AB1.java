package Pr8;


import java.util.Scanner;

public class AB1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();

        if (A <= B) {
            printAscending(A, B);
        } else {
            printDescending(A, B);
        }
    }

    static void printAscending(int A, int B) {
        if (A <= B) {
            System.out.print(A + " ");
            printAscending(A + 1, B);
        }
    }

    static void printDescending(int A, int B) {
        if (A >= B) {
            System.out.print(A + " ");
            printDescending(A - 1, B);
        }
    }
}