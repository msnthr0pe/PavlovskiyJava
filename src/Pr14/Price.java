package Pr14;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Price {
    public static void main(String[] args) {
        String text = "Text with the list of prices: 25.98 USD, 100 RUB, 5.99 EU, 44 ERR";
        String regex = "\\b(\\d+(?:\\.\\d{1,2})?)\\s+(USD|RUB|EU)\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            double price = Double.parseDouble(matcher.group(1));
            String currency = matcher.group(2);

            System.out.println("Price: " + price + " " + currency);
        }
    }
}
