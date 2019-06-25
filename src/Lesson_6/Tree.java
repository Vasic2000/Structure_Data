package Lesson_6;

public interface Tree<E> {
    boolean isBald();

    enum TraverseMode {
        IN_ORDER,
        PRE_ORDER,
        POST_ORDER
    }

    boolean add(E value);

    boolean find(E value);

    boolean remove(E value);

    boolean isEmpty();

    int size();

    void traverse(TraverseMode mode);

    void display();
}
