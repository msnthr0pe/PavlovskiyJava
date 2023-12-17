package Pr23_1;

public class Main {
    public static void main(String[] args) {
        // Тест класса ArrayQueueModule

        ArrayQueueModule.enqueue("1");
        ArrayQueueModule.enqueue("2");
        System.out.println(ArrayQueueModule.dequeue());
        System.out.println(ArrayQueueModule.element());
        System.out.println(ArrayQueueModule.size());
        ArrayQueueModule.clear();
        System.out.println(ArrayQueueModule.isEmpty());

        // Тест класса ArrayQueue
        ArrayQueue queue = new ArrayQueue();
        queue.enqueue("3");
        queue.enqueue("4");
        System.out.println(queue.dequeue());
        System.out.println(queue.element());
        System.out.println(queue.size());
        queue.clear();
        System.out.println(queue.isEmpty());

        // Тест класса LinkedQueue
        LinkedQueue q = new LinkedQueue();
        q.enqueue("5");
        q.enqueue("6");
        System.out.println(q.dequeue());
        System.out.println(q.element());
        System.out.println(q.size());
        q.clear();
        System.out.println(q.isEmpty());
    }
}