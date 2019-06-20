package Lesson_4;

public interface LinkedList<E> {

    void insertFirst(E value);

    E removeFirst();

    boolean remove(E value);

    boolean contains(E value);

    boolean isEmpty();

    int size();

    void display();

    E getFirstElement();

    Entry getFirst();

    class Entry<E> {
        public final E value;
        public Entry<E> next;

        public Entry(E value) {
            this.value = value;
        }
    }
}
