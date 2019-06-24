package Lesson_5.HomeTask;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BackPack {
    final static int backPackVolume = 5;
    private Item[] items;
    private static Set<Item[]> result = new HashSet<>();

    public static Item[] makeItems() {
        Item[] items = new Item[5];
        items[0] = new Item("Книга", 1, 600);
        items[1] = new Item("Бинокль", 2, 5000);
        items[2] = new Item("Аптечка", 4, 1500);
        items[3] = new Item("Ноутбук", 2, 40000);
        items[4] = new Item("Котелок", 1, 500);
        return items;
    }

    public BackPack(Item[] items) {
        this.items = items;
    }


    public void getRandomItems() {
        Item[] kup = copyOf(items);
        if (items.length == 1)
            result.add(kup);
        else
            getRandomItems(items.length);

//        for(Item[] it : result) {
//            for(int i = 0; i < it.length; i++) {
//                System.out.print(it[i].getName() + " ");
//            }
//            System.out.println();
//        }
    }

    private Item[] copyOf(Item[] items) {
        Item[] result = new Item[items.length];
        for(int i = 0; i < items.length; i++)
            result[i] = items[i];
        return result;
    }

    private void getRandomItems(int length) {
        if (length == 1) {
            Item[] kup = copyOf(items);
            result.add(kup);
        }
        for (int i = 0; i < length; i++) {
            getRandomItems(length - 1);
            rotate(length);
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


    public static void findExpensive() {
        int maxPrice = 0;
        List<Item> maxPriceList = new ArrayList<>();

        int price;
        int weight;
        List<Item> priceList = new ArrayList<>();

        for(Item[] it : result) {
            weight = 0;
            price = 0;
            priceList.clear();

            for(int i = 0; i < it.length; i++) {
                weight += it[i].getWeight();
                if(weight <= backPackVolume) {
                    price += it[i].getPrice();
                    priceList.add(it[i]);
                }
            }

            if(price > maxPrice) {
                maxPrice = price;
                maxPriceList = copyOf2(priceList);
            }
        }

        System.out.println("Максимальная стоимость рюкзака: " + maxPrice);
        for(Item ii : maxPriceList)
            System.out.println(ii.getName() + " : " + ii.getPrice() + " : " + ii.getWeight() + " кг");
    }

    private static List<Item> copyOf2(List<Item> priceList) {
        List<Item> result = new ArrayList<>();
        for(int i = 0; i < priceList.size(); i ++)
            result.add(priceList.get(i));
        return result;
    }

    public static void main(String[] args) {
        new BackPack(makeItems()).getRandomItems();
        findExpensive();
    }
}
