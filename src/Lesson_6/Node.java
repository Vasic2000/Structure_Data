package Lesson_6;

public class Node<T extends Comparable<? super T>> {
    private final T value;

    protected Node<T> leftChild;
    protected Node<T> rightChild;

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }


    public boolean isLeaf() {
        return getLeftChild() == null && getRightChild() == null;
    }

    public boolean shouldBeLeft(T value) {
        return value.compareTo(getValue()) < 0;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
