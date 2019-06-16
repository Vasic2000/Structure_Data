package Lesson_3.queue;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QueueImplTest {
    protected QueueImpl queueImpl;

    @Before
    public void setUp() {
        System.out.println("Start");
        queueImpl = new QueueImpl(5);
    }

    @Test
    public void test1() {
        Assert.assertNull(queueImpl.peek());
        Assert.assertNull(queueImpl.remove());
        Assert.assertTrue(queueImpl.isEmpty());
        Assert.assertTrue(queueImpl.insert(1));
        Assert.assertTrue(queueImpl.insert(10));
        Assert.assertEquals(2, queueImpl.size());
        Assert.assertEquals(1, (int) queueImpl.remove());
        Assert.assertFalse(queueImpl.isFull());
        Assert.assertFalse(queueImpl.isEmpty());
        Assert.assertTrue(queueImpl.insert(-1));
        Assert.assertTrue(queueImpl.insert(-7));
        Assert.assertTrue(queueImpl.insert(11));
        Assert.assertTrue(queueImpl.insert(100));
        Assert.assertEquals(10, (int) queueImpl.peek());
        Assert.assertFalse(queueImpl.insert(101));
    }

    @Test
    public void test2() {
        Assert.assertFalse(queueImpl.isFull());
        Assert.assertTrue(queueImpl.isEmpty());
        Assert.assertTrue(queueImpl.insert(2));
        Assert.assertTrue(queueImpl.insert(3));
        Assert.assertTrue(queueImpl.insert(4));
        Assert.assertTrue(queueImpl.insert(5));
        Assert.assertTrue(queueImpl.insert(6));
        Assert.assertFalse(queueImpl.insert(7));
        Assert.assertTrue(queueImpl.isFull());
        Assert.assertEquals(5, queueImpl.size());
        Assert.assertEquals(2, (int) queueImpl.remove());
        Assert.assertEquals(3, (int) queueImpl.remove());
        Assert.assertEquals(4, (int) queueImpl.remove());
        Assert.assertEquals(5, (int) queueImpl.remove());
        Assert.assertEquals(6, (int) queueImpl.remove());
        Assert.assertNull(queueImpl.remove());
        Assert.assertEquals(0, queueImpl.size());
        Assert.assertFalse(queueImpl.isFull());
        Assert.assertTrue(queueImpl.isEmpty());
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("End");
    }
}