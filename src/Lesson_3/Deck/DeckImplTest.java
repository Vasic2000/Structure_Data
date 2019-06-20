package Lesson_3.Deck;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DeckImplTest {
    protected DeckImpl deckImpl;

    @Before
    public void setUp() {
        System.out.println("Start");
        deckImpl = new DeckImpl<>(7);
    }

    @Test
    public void test1() {
        Assert.assertTrue(deckImpl.isEmpty());
        Assert.assertFalse(deckImpl.isFull());
        for(int i = 0; i < 7; i++)
            deckImpl.insertLeft(i);

        Assert.assertEquals(0, deckImpl.peekRight());
        Assert.assertEquals(0, deckImpl.removeRight());
        Assert.assertEquals(6, deckImpl.removeLeft());
        Assert.assertEquals(5, deckImpl.size());
        Assert.assertEquals(5, deckImpl.peekLeft());

        for(int i = 0; i < 5; i++)
            deckImpl.removeLeft();
        Assert.assertNull(deckImpl.removeLeft());
        Assert.assertTrue(deckImpl.isEmpty());
    }

    @Test
    public void test2() {
        for(int i = 0; i < 7; i++)
            deckImpl.insertLeft(i + 5);
        Assert.assertTrue(deckImpl.isFull());
        Assert.assertEquals(5, deckImpl.peekRight());
        Assert.assertEquals(11, deckImpl.removeLeft());
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("End");
    }
}