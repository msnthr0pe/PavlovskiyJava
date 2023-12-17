package Pr20;

public class MinMaxTest {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3};
        MinMax<Integer> num = new MinMax<>(arr);
        System.out.println("The lowest number in the array is " + num.findMin());
        System.out.println("The highest number in the array is " + num.findMax());
    }
}
