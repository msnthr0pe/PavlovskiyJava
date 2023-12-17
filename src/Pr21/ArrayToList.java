package Pr21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayToList {
    public static List<String> convertStringArrayToList(String[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }
    public static List<Integer> convertIntArrayToList(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int element : array) {
            list.add(element);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 3};
        String[] strs = {"word", "letters", "symbols"};
        ArrayList<Integer> ints2 = (ArrayList<Integer>) convertIntArrayToList(ints);
        ArrayList<String> strs2 = (ArrayList<String>) convertStringArrayToList(strs);
        System.out.println(ints2);
        System.out.println(strs2);
    }
}