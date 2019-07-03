package Lesson_8;

public class DoubleHashTableImpl extends HashTableImpl {

    public static final int DOUBLE_HASH_CONST = 5;

    public DoubleHashTableImpl(int maxSize) {
        super(maxSize);
    }

    @Override
    protected int getStep(Item item) {
        return hashDoubleFunc(item);
    }

    private int hashDoubleFunc(Item item) {
        return DOUBLE_HASH_CONST - (item.hashCode() % 5);
    }

}
