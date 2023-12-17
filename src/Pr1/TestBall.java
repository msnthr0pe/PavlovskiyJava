package Pr1;

public class TestBall {
    public static void main(String[] args) {
        Ball b1 = new Ball ("Yellow", 12);
        Ball b2 = new Ball ("Red", 17);
        Ball b3 = new Ball ("Black"); b3.setRadius(9);
        System.out.println(b1);
        b1.print();
        b2.print();
        b3.print();
    }
}