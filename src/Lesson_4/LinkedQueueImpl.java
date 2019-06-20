package Lesson_4;

import Lesson_3.queue.Queue;

public class LinkedQueueImpl<E> implements Queue<E> {
    private TwoSideLinkedList<E> data = new TwoSideLinkedListImpl<>();

    @Override
    public boolean insert(E value) {
        data.insertLast(value);
        return true;
    }

    @Override
    public E remove() {
        return data.removeFirst();
    }

    @Override
    public E peek() {
        return data.getFirstElement();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.size() == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
