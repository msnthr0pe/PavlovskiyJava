package Pr23_1;

class LinkedQueue extends AbstractQueue implements Queue {
    private Node head;
    private Node tail;

    public LinkedQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    // Предусловие: элемент не является null
    // Постусловие: элемент добавлен в конец очереди
    public void enqueue(Object element) {
        assert element != null : "Null elements are not allowed";
        Node newNode = new Node(element);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Предусловие: очередь не пуста
    // Постусловие: первый элемент удален и возвращен
    public Object dequeue() {
        assert !isEmpty() : "Queue is empty";
        Object removed = head.value;
        head = head.next;
        size--;
        if (isEmpty()) {
            tail = null;
        }
        return removed;
    }

    // Предусловие: очередь не пуста
    // Постусловие: первый элемент возвращен
    public Object element() {
        assert !isEmpty() : "Queue is empty";
        return head.value;
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
        head = null;
        tail = null;
        size = 0;
    }

    // Внутренний класс для представления узла в связанном списке
    private class Node {
        Object value;
        Node next;

        Node(Object value) {
            this.value = value;
            this.next = null;
        }
    }
}