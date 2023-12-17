package Pr14;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    public static void main(String[] args) {
        String password1 = "pASSword123";
        String password2 = "password";
        String password3 = "87654321";
        String password4 = "PASSWORD";

        boolean isValidPassword1 = isValidPassword(password1);
        boolean isValidPassword2 = isValidPassword(password2);
        boolean isValidPassword3 = isValidPassword(password3);
        boolean isValidPassword4 = isValidPassword(password4);

        System.out.println(password1 + " Is acceptable password? " + isValidPassword1);
        System.out.println(password2 + " Is acceptable password? " + isValidPassword2);
        System.out.println(password3 + " Is acceptable password? " + isValidPassword3);
        System.out.println(password4 + " Is acceptable password? " + isValidPassword4);
    }

    public static boolean isValidPassword(String password) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);

        return matcher.matches();
    }
}