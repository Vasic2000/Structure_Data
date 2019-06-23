package Lesson_5;

public class Countdown {
    public static void main(String[] args) {
        countDownLoop(5);
        countDownRecursion(4);
    }

    private static void countDownLoop(int n) {
        while (n > 0) {
            System.out.println(n);
            n--;
        }
    }

    private static void countDownRecursion(int n) {
        if(n < 1) return;
        System.out.println(n);
        countDownRecursion(--n);
    }
}


