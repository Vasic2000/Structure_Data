package Lesson_3.queue;

public interface Queue<E> {

    boolean insert(E value);

    E remove();

    E peek();

    int size();

    boolean isEmpty();

    boolean isFull();

}
