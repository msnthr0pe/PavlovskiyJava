package Pr7;

public class Magazine implements Printable {

    private String name;
    private int number;

    public Magazine(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public void print() {
        System.out.println("The \"" + this.name + "\" magazine number " + this.number);
    }


}
