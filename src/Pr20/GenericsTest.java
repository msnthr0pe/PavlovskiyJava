package Pr20;

public class GenericsTest {
    public static void main(String[] args) {
        Integer num = 0;
        String str = "word";
        Float flt = 1.1F;
        Generics gnre = new Generics(num, str, flt);
        gnre.printClassNames();
    }
}
