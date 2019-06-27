package Lesson_6;

public class Main_6 {
    public static void main(String[] args) {
        Tree<Integer>[] tree = new TreeImpl[20];
        double sbal = 0;

//      Создал и показал 20 деревьев
        for(int i = 0; i < 20; i++) {
            tree[i] = new TreeImpl<>();
            for(int j = 0; j < 50; j++) {
                tree[i].add((int) (Math.random() * 40) - 20);
            }
            tree[i].display();

            if (tree[i].isBald()) {
                sbal++;
            }
        }

        System.out.println("Сбалансированных деревьев - " + (sbal / 20) * 100 + "%");

    }
}
