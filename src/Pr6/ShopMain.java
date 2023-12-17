package Pr6;

import java.util.Scanner;

public class ShopMain {
    public static void main(String[] args) {
        Shop shop = new Shop();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Хотите ли вы добавить новый компьютер?");
        while(scanner.nextLine().equals("Да")) {
            shop.addComputer();
            System.out.println("Хотите ли вы добавить новый компьютер?");
        }
        shop.deleteComputer();
        shop.printAllComputer();
        shop.searchComputer();
    }
}
