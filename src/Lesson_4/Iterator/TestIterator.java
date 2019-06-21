package Lesson_4.Iterator;
import Lesson_4.LinkedList;
import Lesson_4.SimpleLinkedListImpl;

import java.util.Iterator;

public class TestIterator {
    public static void main(String[] args) {

        int [] array = {1,2,3};
        System.out.println("---");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println("\n---");

        for (int i = 0; hasNext(array, i); i++) {
            int value = next(array, i);
            System.out.print(value + " ");
        }
        System.out.println();

        LinkedList linkedList = new SimpleLinkedListImpl();
        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);

        while (linkedList.hasNext())
            System.out.print(linkedList.next() + " ");
        System.out.println("\n---");

//        for (Integer value : linkedList)
//            System.out.println(value);

        LinkedList.Entry current = linkedList.getFirst();
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println("\n---");


        java.util.LinkedList<Integer> linkedList1JDK = new java.util.LinkedList<>();
        linkedList1JDK.add(1);
        linkedList1JDK.add(2);
        linkedList1JDK.add(3);
        for (Integer value : linkedList1JDK)
            System.out.print(value + " ");
        System.out.println("\n---");


        Iterator<Integer> iterator = linkedList1JDK.iterator();

        while (iterator.hasNext()) {
            Integer value = iterator.next();
            System.out.print(value + " ");
        }
        System.out.println("\n---");

    }

    private static int next(int[] array, int i) {
        return array[i];
    }

    private static boolean hasNext(int[] array, int i) {
        return i < array.length;
    }
}
