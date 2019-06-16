package Lesson_3.stack;

public interface Stack<E> {

    boolean push(E value);

    E pop();

    E peel();

    int size();

    boolean isEmpty();

    boolean isFull();

}
