package Pr21;

import java.util.Arrays;

public class TypedArray<T> {
    private T[] array;

    public TypedArray(T[] array) {
        this.array = array;
    }

    public T[] getArray() {
        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        TypedArray<Integer> typedIntArray = new TypedArray<>(intArray);
        Integer[] retrievedIntArray = typedIntArray.getArray();
        System.out.println(Arrays.toString(retrievedIntArray));

        String[] stringArray = {"Hello", "World"};
        TypedArray<String> typedStringArray = new TypedArray<>(stringArray);
        String[] retrievedStringArray = typedStringArray.getArray();
        System.out.println(Arrays.toString(retrievedStringArray));
    }

    public T getByIndex(int index){
        return array[index];
    }
}