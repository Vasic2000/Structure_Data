package lesson_2;

public class Main {
    public static void main(String[] args) {
//        testJdkArray();
        Array<Integer> array = new ArrayImpl<>(5);
//        Array<Integer> array = new SortedArrayImpl<>(5);
        array.add(1);
        array.add(5);
        array.add(3);
        array.add(2);
        array.add(4);
        array.add(6);

//        array.sortBubble();
//        array.sortSelect();
        array.sortInsert();
        array.display();

        System.out.println("Size is " + array.size());
        System.out.println("Find 1: " + array.contains(1));
        System.out.println("Find 6: " + array.contains(6));
        System.out.println("Find 666: " + array.contains(666));
        System.out.println("Find index for 3: " + array.indexOf(3));

        array.remove(3);
        System.out.println("Find index for 3: " + array.indexOf(3));

        array.display();

    }

    private static void testJdkArray() {
        //        int[] array = new int[6];
//        int[] array = new int[] {1, 2, 3};
        int[] array = {1, 2, 3};
        array[2] = 5;

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}

