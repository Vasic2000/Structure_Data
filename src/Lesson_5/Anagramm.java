package Lesson_5;

import java.util.HashSet;
import java.util.Set;

public class Anagramm {
    private char[] word;
    private Set<String> result = new HashSet<>();

    public Anagramm(String word) {
        this.word = word.toCharArray();
    }

    public void getAnagramm() {
        if (word.length == 1) {
            System.out.println(word[0]);
            return;
        }

        getAnagramm(word.length);

        for (String anagramm : result) {
            System.out.println(anagramm);
        }
    }

    private void getAnagramm(int length) {
        if (length == 1) {
            return;
        }

        for (int i = 0; i < length; i++) {
            getAnagramm(length - 1);
//            showResult();
            result.add(String.valueOf(word));
            rotate(length);
        }
    }
        private void showResult() {
            for (char c : word) {
                System.out.print(c);
            }
            System.out.println();
        }


        private void rotate(int length) {
            int pos = word.length - length;
            char temp = word[pos];
            for (int i = pos + 1; i < word.length; i++) {
                word[i - 1] = word[i];
            }

            word[word.length - 1] = temp;
        }

    public static void main(String[] args) {
        new Anagramm("клей").getAnagramm();
    }
}
