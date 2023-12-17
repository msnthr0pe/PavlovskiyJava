package Pr13;

public class String {
    public static void strOperations(java.lang.String str){
        System.out.println("The last character is  " + str.charAt(str.length()-1));
        if (str.endsWith("The string ends with '!!!'")){
            System.out.println(" '!!!'");
        } else {
            System.out.println("The string does not end with '!!!'");
        }

        if (str.startsWith("I like")){
            System.out.println("The string starts with 'I like'");
        } else {
            System.out.println("The string does not start with 'I like'");
        }

        if (str.contains("Java")){
            System.out.println("The string contains 'Java'");
        } else {
            System.out.println("The string does not contain 'Java'");
        }

        System.out.println("Position of the string 'Java' " + str.indexOf("Java"));

        System.out.println(str.replaceAll("a", "e"));
        System.out.println(str.toUpperCase());
        System.out.println(str.toLowerCase());
        System.out.println(str.substring(0, str.indexOf("Java")));
    }

    public static void main(java.lang.String[] args) {
        strOperations("I like Java!!!");
    }
}