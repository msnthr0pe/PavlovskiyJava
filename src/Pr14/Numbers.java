package Pr14;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the text:");
        String text = scanner.nextLine();

        boolean containsDigitsWithoutPlus = checkDigitsWithoutPlus(text);
        if (containsDigitsWithoutPlus) {
            System.out.println("The text contains numbers without '+' sign");
        } else {
            System.out.println("The text does not contain contain numbers without '+' sign");
        }
    }

    private static boolean checkDigitsWithoutPlus(String text) {
        Pattern pattern = Pattern.compile("\\d(?![\\s*+])");
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }
}