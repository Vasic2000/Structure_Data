package Lesson_3.queue;

public class QueueImpl<E> implements Queue<E> {

    private int head;
    private int tail;

    private static final int DEFAULT_TAIL = -1;
    private static final int DEFAULT_HEAD = 0;

    protected E[] data;

    protected int size;


    @SuppressWarnings("unchecked")
    public QueueImpl(int maxSize) {
        this.data = (E[]) new Object[maxSize];
        this.head = DEFAULT_HEAD;
        this.tail = DEFAULT_TAIL;
    }

    @Override
    public boolean insert(E value) {
        if (!isFull()) {
            if (tail ==  data.length - 1) {
                tail = DEFAULT_TAIL;
            }

            data[++tail] = value;
            size++;
            return true;
        }
        return false;
    }

    @Override
    public E remove() {
        if (!isEmpty()) {
            if (head == data.length) {
                head = DEFAULT_HEAD;
            }

            E removedValue = data[head++];
            size--;
            return removedValue;
        }
        return null;
    }

    @Override
    public E peek() {
        return data[head];
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
