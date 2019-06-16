package Lesson_3.queue;

import java.util.Objects;

public class QeueImpl<E> implements Queue<E> {

    private static final int DEFAULT_TAIL = -1;
    private static final int DEFAULT_HEAD = 0;

    protected E[] data;
    protected int size;

    private int head;
    private int tail;

    public QeueImpl(int maxSize) {
        this.data = (E[]) new Objects[maxSize];
        this.head = DEFAULT_HEAD;
        this.tail = DEFAULT_TAIL;
    }

    @Override
    public boolean insert(E value) {
        if(!isFull()) {
            if(tail == data.length - 1)
                tail = DEFAULT_TAIL;
            data[++tail] = value;
            size++;
        }
        return false;
    }

    @Override
    public E remove() {
        if(!isEmpty()) {
            if(head == data.length - 1)
                head = DEFAULT_HEAD;
            size--;
            return data[head++];
        }
        return null;
    }

    @Override
    public E peek() {
        return data[head++];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }
}
