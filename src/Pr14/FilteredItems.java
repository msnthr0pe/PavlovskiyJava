package Pr14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface Filter<T> {
    boolean apply(T item);
}
public class FilteredItems {
    public static void main(String[] args) {
        Double[] numbers = {1.2, 2.0, 3.1, 4., 5.9, 6., 7., 8.2, 9., 10.};

        Filter<Double> evenFilter = number -> number % 2 == 0;

        Double[] filteredNumbers = filter(numbers, evenFilter);

        System.out.println("Initial array: " + Arrays.toString(numbers));
        System.out.println("Filtered array: " + Arrays.toString(filteredNumbers));
    }

    public static <T> T[] filter(T[] array, Filter<T> filter) {
        List<T> filteredList = new ArrayList<>();

        for (T item : array) {
            if (filter.apply(item)) {
                filteredList.add(item);
            }
        }

        // Преобразование списка в массив
        T[] filteredArray = Arrays.copyOf(array, filteredList.size());
        return filteredList.toArray(filteredArray);
    }
}