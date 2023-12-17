package Pr23_1;

import java.util.Arrays;

class ArrayQueue implements Queue {
    private Object[] elements = new Object[10];
    private int size = 0;
    private int head = 0;
    private int tail = 0;

    // Предусловие: элемент не является null
    // Постусловие: элемент добавлен в конец очереди
    public void enqueue(Object element) {
        assert element != null : "Null elements are not allowed";
        ensureCapacity(size + 1);
        elements[tail] = element;
        tail = (tail + 1) % elements.length;
        size++;
    }

    // Предусловие: очередь не пуста
    // Постусловие: первый элемент удален и возвращен
    public Object dequeue() {
        assert size > 0 : "Queue is empty";
        Object removed = elements[head];
        elements[head] = null;
        head = (head + 1) % elements.length;
        size--;
        return removed;
    }

    // Предусловие: очередь не пуста
    // Постусловие: первый элемент возвращен
    public Object element() {
        assert size > 0 : "Queue is empty";
        return elements[head];
    }

    // Постусловие: размер очереди возвращен
    public int size() {
        return size;
    }

    // Постусловие: вернуто true, если очередь пуста, иначе false
    public boolean isEmpty() {
        return size == 0;
    }

    // Постусловие: очередь очищена
    public void clear() {
        Arrays.fill(elements, null);
        size = 0;
        head = 0;
        tail = 0;
    }

    private void ensureCapacity(int capacity) {
        if (capacity > elements.length) {
            int newCapacity = Math.max(2 * elements.length, capacity);
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }
}