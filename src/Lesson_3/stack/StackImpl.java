package Lesson_3.stack;

public class StackImpl<E> implements Stack<E> {
    private int size;
    private E[] data;

    @SuppressWarnings("unchecked")
    public StackImpl(int maxSize) {
        this.data = (E[]) new Object[maxSize];
    }


    @Override
    public boolean push(E value) {
        if(!isFull()) {
            data[size++] = value;
            return true;
        }
        return false;
    }

    @Override
    public E pop() {
        if(!isEmpty())
            return data[--size];
        return null;
    }

    @Override
    public E peek() {
        if(!isEmpty())
            return data[size - 1];
        return null;
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
