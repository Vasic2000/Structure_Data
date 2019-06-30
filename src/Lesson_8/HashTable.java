package Lesson_8;

public interface HashTable {

    public boolean put(Item item, Integer cost);

    Integer get(Item item);

    boolean delete(Item item);

    int size();

    boolean isEmpty();

    void display();

}
