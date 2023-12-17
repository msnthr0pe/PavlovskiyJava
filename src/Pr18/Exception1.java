package Pr18;

public class Exception1 {
    public static void exceptionDemo() {
        try{
            System.out.println( 1/0 );
        } catch ( ArithmeticException e ) {
            System.out.println("Attempted division by zero");
        }
    }

    public static void main(String[] args) {
        Exception1.exceptionDemo();
    }
}