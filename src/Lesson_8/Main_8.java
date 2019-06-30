package Lesson_8;

public class Main_8 {
    public static void main(String[] args) {
        // HashTable hashTable = new HashTableImpl(5);
        HashTable hashTable = new DoubleHashTableImpl(5);



        hashTable.put(new Item(1, "Orange"), 150);
        hashTable.put(new Item(77, "Banana"), 100);
        hashTable.put(new Item(77, "Banana"), 125);
        hashTable.put(new Item(60, "Lemon"), 250);
        hashTable.put(new Item(21, "Potato"), 67);
        hashTable.put(new Item(52, "Milk"), 120);

        System.out.println("Размер = " + hashTable.size());
        hashTable.display();

//        System.out.println(new Item(77, "Banana").getId());
        System.out.println("Potato cost is " + hashTable.get(new Item(21, "Potato")));
        System.out.println("Banana cost is " + hashTable.get(new Item(77, "Banana")));

        hashTable.delete(new Item(21, "Potato"));
        hashTable.delete(new Item(77, "Banana"));

        System.out.println("Banana cost is " + hashTable.get(new Item(77, "Banana")));
        hashTable.display();

    }
}
