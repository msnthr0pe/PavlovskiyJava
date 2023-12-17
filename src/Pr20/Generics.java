package Pr20;

import java.io.Serializable;

public class Generics<T extends Comparable<T>, V extends Serializable, K> {
    private T item1;
    private V item2;
    private K item3;

    public Generics(T item1, V item2, K item3) {
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
    }

    public T getItem1() {
        return item1;
    }

    public void setItem1(T item1) {
        this.item1 = item1;
    }

    public V getItem2() {
        return item2;
    }

    public void setItem2(V item2) {
        this.item2 = item2;
    }

    public K getItem3() {
        return item3;
    }

    public void setItem3(K item3) {
        this.item3 = item3;
    }

    public void printClassNames() {
        System.out.println("Type of item1: " + item1.getClass().getSimpleName());
        System.out.println("Type of item2: " + item2.getClass().getSimpleName());
        System.out.println("Type of item3: " + item3.getClass().getSimpleName());
    }
}