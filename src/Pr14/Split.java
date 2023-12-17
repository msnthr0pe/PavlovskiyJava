package Pr14;

import java.util.Arrays;

public class Split {
    public static void main(String[] args) {
        String input = "Hello, World! How are you today?";

        // Разбиение строки по пробелам
        String[] words = input.split("\\s+");
        System.out.println("Words: " + Arrays.toString(words));

        // Разбиение строки по запятой и восклицательному знаку
        String[] tokens = input.split("[,!]");
        System.out.println("Tokens: " + Arrays.toString(tokens));

        // Разбиение строки на отдельные символы
        String[] characters = input.split("");
        System.out.println("Characters: " + Arrays.toString(characters));
    }
}