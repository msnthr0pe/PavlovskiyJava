package Pr24_2;

public class Main {
    public static void main(String[] args) {
        AbstractChairFactory factory = new ChairFactory();
        Client client = new Client();
        VictorianChair victorianChair = factory.createVictorianChair(100);
        MagicChair magicChair = factory.createMagicChair();
        FunctionalChair functionalChair = factory.createFunctionalChair();
        client.setChair(victorianChair);
        client.sit();
        client.setChair(magicChair);
        client.sit();
        magicChair.doMagic();
        client.setChair(functionalChair);
        client.sit();
    }
}