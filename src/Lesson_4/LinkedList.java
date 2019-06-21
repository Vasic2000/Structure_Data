package Lesson_4;

import java.util.Iterator;

public interface LinkedList<E> extends Iterator<E>, Iterable {

    void insertFirst(E value);

    E removeFirst();

    boolean remove(E value);

    boolean contains(E value);

    boolean isEmpty();

    int size();

    void display();

    E getFirstElement();

    Entry getFirst();

    //-------------
    @Override
    default Iterator<E> iterator() {
        return this;
    };

    @Override
    default boolean hasNext() {
        return false;
    }

    @Override
    default E next() {
        return null;
    }
    //-------------

    class Entry<E> {
        public final E value;
        public Entry<E> next;

        public Entry(E value) {
            this.value = value;
        }
    }
}
