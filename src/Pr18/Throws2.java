package Pr18;

import java.util.Scanner;

public class Throws2 {
    public void getKey() {
        Scanner myScanner = new Scanner( System.in );
        String key = myScanner.next();
        try {
            printDetails( key );
        } catch (Exception e) {
            System.out.println(e.getMessage());
            getKey();
        }

    }
    public void printDetails(String key) throws Exception {
        try {
            String message = getDetails(key);
            System.out.println( message );
        }catch ( Exception e){
            throw e;
        }
    }
    private String getDetails(String key) throws Exception {
        if(key.equals("empty")) {
            throw new Exception("Key set to empty string");
        }
        return "data for " + key;
    }

    public static void main(String[] args) {
        Throws2 demo1 = new Throws2();
        demo1.getKey();
    }
}