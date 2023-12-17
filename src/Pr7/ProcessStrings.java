package Pr7;

interface StringManipulator {
    int countCharacters(String s);
    String oddPositionChars(String s);
    String reverseString(String s);
}

class StringProcessor implements StringManipulator {
    @Override
    public int countCharacters(String s) {
        return s.length();
    }

    @Override
    public String oddPositionChars(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }

    @Override
    public String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}

public class ProcessStrings {
    public static void main(String[] args) {
        StringProcessor stringProcessor = new StringProcessor();

        String inputString = "Hello, World!";

        int charCount = stringProcessor.countCharacters(inputString);
        System.out.println("Количество символов: " + charCount);

        String oddChars = stringProcessor.oddPositionChars(inputString);
        System.out.println("Символы на нечетных позициях: " + oddChars);

        String reversedString = stringProcessor.reverseString(inputString);
        System.out.println("Инвертированная строка: " + reversedString);
    }
}
