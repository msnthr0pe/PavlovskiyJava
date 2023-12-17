package Pr7;

public class PrintMagazine {
    public static void main(String[] args) {
        Printable[] pieces = {new Magazine("Vogue", 3), new Magazine("Fashion Week", 84),
                new Magazine("7 days", 36)};
        for (Printable piece : pieces) {
            piece.print();
        }
    }
}
