package Pr23_1;
interface Queue {
    // Предусловие: элемент не является null
    // Постусловие: элемент добавлен в конец очереди
    void enqueue(Object element);

    // Предусловие: очередь не пуста
    // Постусловие: первый элемент удален и возвращен
    Object dequeue();

    // Предусловие: очередь не пуста
    // Постусловие: первый элемент возвращен
    Object element();

    // Постусловие: размер очереди возвращен
    int size();

    // Постусловие: вернуто true, если очередь пуста, иначе false
    boolean isEmpty();

    // Постусловие: очередь очищена
    void clear();
}