package Lesson_3.Deck;

public class DeckImpl<E> implements Deck<E> {
    private int left;
    private int right;
    private int maxSize;

    private static final int DEFAULT_RIGHT = -1;
    private static final int DEFAULT_LEFT = 0;

    protected E[] data;

    protected int size;

    @SuppressWarnings("unchecked")
    public DeckImpl(int maxSize) {
        this.data = (E[]) new Object[maxSize];
        this.left = DEFAULT_LEFT;
        this.right = DEFAULT_RIGHT;
        this.maxSize = maxSize;
    }


    @Override
    public boolean insertLeft(E value) {
        if (!isFull()) {
            if (left == 0) {
                left = DEFAULT_LEFT + maxSize;
            }
            data[--left] = value;
            size++;
            return true;
        }
        return false;
    }

    @Override
    public boolean insertRight(E value) {
        if (!isFull()) {
            if (right == data.length) {
                right = DEFAULT_RIGHT;
            }
            data[++right] = value;
            size++;
            return true;
        }
        return false;
    }

    @Override
    public E removeLeft() {
        if (!isEmpty()) {
            if (left == data.length) {
                left = DEFAULT_LEFT;
            }
            size--;
            E returnV = data[left];
            data[left++] = null; // Для дебагера
            return returnV;
        }
        return null;
    }

    @Override
    public E removeRight() {
        if (!isEmpty()) {
            if (right == DEFAULT_RIGHT) {
                right = DEFAULT_RIGHT + maxSize;
            }
            size--;
            E returnV = data[right];
            data[right--] = null;  // Для дебагера
            return returnV;
        }
        return null;
    }

    @Override
    public E peekLeft() {
        if (left == data.length) {
            left = DEFAULT_LEFT;
        }
        return data[left];
    }

    @Override
    public E peekRight() {
        if (right == DEFAULT_RIGHT) {
            right = DEFAULT_RIGHT + maxSize;
        }
        return data[right];
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
