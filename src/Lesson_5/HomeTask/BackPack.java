package Lesson_5.HomeTask;

import java.util.HashSet;
import java.util.Set;

public class BackPack {
    final static int backPackVolume = 6;
    private Item[] items;
    private Set<Item[]> result = new HashSet<>();

    public BackPack(Item[] items) {
        this.items = items;
    }

    public static void main(String[] args) {
        new BackPack(makeItems()).getRandomItems();
    }





    public void getRandomItems() {
        if (items.length == 1)
            result.add(items);
        else
            getRandomItems(items.length);
    }

    private void getRandomItems(int length) {
        if (length == 1) {
            result.add(items);
        }

        for (int i = 0; i < length; i++) {
            getRandomItems(length - 1);
            result.add(items);
            rotate(length);
        }

        for(Item[] it : result) {
            for(int i = 0; i < it.length; i++) {
                System.out.print(it[i].getName() + " ");
            }
            System.out.println();
        }
    }

    private void rotate(int length) {
        int pos = items.length - length;
        Item temp = items[pos];
        for (int i = pos + 1; i < items.length; i++) {
            items[i - 1] = items[i];
        }
        items[items.length - 1] = temp;
    }

    public static Item[] makeItems() {
        Item[] items = new Item[5];
        items[0] = new Item("Книга", 1, 600);
        items[0] = new Item("Бинокль", 2, 5000);
        items[0] = new Item("Аптечка", 4, 1500);
        items[0] = new Item("Ноутбук", 2, 40000);
        items[0] = new Item("Котелок", 1, 500);
        return items;
    }
}
