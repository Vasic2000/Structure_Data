package Lesson_2;

public class Main {
    public static Array<Integer> array1 = new ArrayImpl<>();
    public static Array<Integer> array2 = new ArrayImpl<>();
    public static Array<Integer> array3 = new ArrayImpl<>();

    public static Array<Integer> array4 = new SortedArrayImpl<>();
    public static Array<Integer> array5 = new SortedArrayImpl<>();
    public static Array<Integer> array6 = new SortedArrayImpl<>();

    public static int Capasity = 50000;

    public static void main(String[] args) {
        long startTime;

        startTime = System.currentTimeMillis();
        makeArrays(Capasity);
        System.out.println(String.format("Время создания 3-х несортированных массивов %d, мСек",(System.currentTimeMillis() - startTime)));

        startTime = System.currentTimeMillis();
        makeSortArrays(Capasity);
        System.out.println(String.format("Время создания 3-х сортированных массивов %d, мСек",(System.currentTimeMillis() - startTime)));

        startTime = System.currentTimeMillis();
        array1.sortBubble();
        System.out.println(String.format("Сортировка пузырьком несортированного массива %d, мСек",(System.currentTimeMillis() - startTime)));

        startTime = System.currentTimeMillis();
        array2.sortSelect();
        System.out.println(String.format("Сортировка выбором несортированного массива %d, мСек",(System.currentTimeMillis() - startTime)));

        startTime = System.currentTimeMillis();
        array3.sortInsert();
        System.out.println(String.format("Сортировка вставкой несортированного массива %d, мСек",(System.currentTimeMillis() - startTime)));

        startTime = System.currentTimeMillis();
        array4.sortBubble();
        System.out.println(String.format("\"Сортировка\" пузырьком уже отсортированного массива %d, мСек",(System.currentTimeMillis() - startTime)));

        startTime = System.currentTimeMillis();
        array5.sortSelect();
        System.out.println(String.format("\"Сортировка\" выбором уже отсортированного массива %d, мСек",(System.currentTimeMillis() - startTime)));

        startTime = System.currentTimeMillis();
        array6.sortInsert();
        System.out.println(String.format("\"Сортировка\" вставкой уже отсортированного массива %d, мСек",(System.currentTimeMillis() - startTime)));
    }


    public static void makeArrays(int size) {
        int element;
        for(int i = 0; i < size; i++) {
            element = (int) (Math.random() * 100);
            array1.add(element);
            array2.add(element);
            array3.add(element);
        }
    }

    public static void makeSortArrays(int size) {
        int element;
        for(int i = 0; i < size; i++) {
            element = (int) (Math.random() * 100);
            array4.add(element);
            array5.add(element);
            array6.add(element);
        }
    }
}


