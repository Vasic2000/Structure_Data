package Lesson_3;

import Lesson_3.Deck.Deck;
import Lesson_3.Deck.DeckImpl;

public class Main {
    public static void main(String[] args) {
        System.out.println(reVerse("Мама мыла раму"));
    }

    public static String reVerse(String str) {
        char [] sstr = str.toCharArray();
        char [] ret = new char [str.length()];

        Deck stroka = new DeckImpl<String>(str.length());

        for(int i =0; i < sstr.length; i++)
            stroka.insertRight(sstr[i]);

        for(int i =0; i < sstr.length; i++)
            ret[i] = (char) stroka.removeRight();

        return String.valueOf(ret);
    }
}
