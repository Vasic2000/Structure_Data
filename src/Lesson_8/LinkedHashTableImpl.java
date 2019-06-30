package Lesson_8;


import java.util.ArrayList;

public class LinkedHashTableImpl implements HashTable {

    private ArrayList<Entry>[] data;

    private int size;
    private int maxSize;

    public LinkedHashTableImpl(int maxSize) {
        this.maxSize = maxSize;
        this.data = new ArrayList [maxSize * 2];

        for (int i = 0; i < data.length; i++) {
            data[i] = new ArrayList<>();
        }
    }

//  =============================

    private int hashFunc(Item key) {
        return key.hashCode() % data.length;
    }


    @Override
    public boolean put(Item item, Integer cost) {
        int index = hashFunc(item);
        Entry en = new Entry(item, cost);

        if(data[index].isEmpty()) {
            data[index].add(en);
            size++;
            return true;
        }

        for(int i = 0; i < data[index].size(); i++)
            if(data[index].get(i).key.equals(item)) {
                data[index].set(i, en);
                size++;
                return true;
            }

        data[index].add(en);
        size++;
        return true;
    }

    @Override
    public Integer get(Item item) {
        int index = hashFunc(item);

        if(data[index].isEmpty())
            return -1;
        else {
            for(int i = 0; i < data[index].size(); i++)
                if(data[index].get(i).key.equals(item)) {
                    return data[index].get(i).value;
                }
        }
        return -1;
    }

    @Override
    public boolean delete(Item item) {
        int index = hashFunc(item);

        if(data[index].isEmpty())
            return false;
        else {
            for(int i = 0; i < data[index].size(); i++)
                if(data[index].get(i).key.equals(item)) {
                    data[index].remove(i);
                    return true;
                }
        }
        return false;
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
    public void display() {
        System.out.println("------------------------");
        for (int i = 0; i < data.length; i++) {
            for(Entry en : data[i])
                System.out.printf("%d : %d = [%s]\n", i, en.value, en.key.getTitle());
        }
        System.out.println("------------------------");
    }


//  =============================

    private static class Entry {
        private Item key;
        private int value;

        public Entry(Item key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
