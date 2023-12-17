package Pr23_1;

import java.util.Arrays;

class ArrayQueueADT {
    private Object[] elements = new Object[10];
    private int size = 0;
    private int head = 0;
    private int tail = 0;

    // Предусловие: элемент не является null
    // Постусловие: элемент добавлен в конец очереди
    public static void enqueue(ArrayQueueADT queue, Object element) {
        assert element != null : "Null elements are not allowed";
        ensureCapacity(queue, queue.size + 1);
        queue.elements[queue.tail] = element;
        queue.tail = (queue.tail + 1) % queue.elements.length;
        queue.size++;
    }

    // Предусловие: очередь не пуста
    // Постусловие: первый элемент удален и возвращен
    public static Object dequeue(ArrayQueueADT queue) {
        assert queue.size > 0 : "Queue is empty";
        Object removed = queue.elements[queue.head];
        queue.elements[queue.head] = null;
        queue.head = (queue.head + 1) % queue.elements.length;
        queue.size--;
        return removed;
    }

    // Предусловие: очередь не пуста
    // Постусловие: первый элемент возвращен
    public static Object element(ArrayQueueADT queue) {
        assert queue.size > 0 : "Queue is empty";
        return queue.elements[queue.head];
    }

    // Постусловие: размер очереди возвращен
    public static int size(ArrayQueueADT queue) {
        return queue.size;
    }

    // Постусловие: вернуто true, если очередь пуста, иначе false
    public static boolean isEmpty(ArrayQueueADT queue) {
        return queue.size == 0;
    }

    // Постусловие: очередь очищена
    public static void clear(ArrayQueueADT queue) {
        Arrays.fill(queue.elements, null);
        queue.size = 0;
        queue.head = 0;
        queue.tail = 0;
    }

    private static void ensureCapacity(ArrayQueueADT queue, int capacity) {
        if (capacity > queue.elements.length) {
            int newCapacity = Math.max(2 * queue.elements.length, capacity);
            queue.elements = Arrays.copyOf(queue.elements, newCapacity);
        }
    }
}