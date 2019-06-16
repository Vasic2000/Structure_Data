package Lesson_3.stack;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StackImplTest {
    protected StackImpl stackImpl;

    @Before
    public void setUp() {
        System.out.println("Start");
        stackImpl = new StackImpl(5);
    }

    @Test
    public void push() {
        Assert.assertEquals(true, stackImpl.push(1));
        Assert.assertEquals(true, stackImpl.push(10));
        Assert.assertEquals(true, stackImpl.push(-1));
        Assert.assertEquals(true, stackImpl.push(-7));
        Assert.assertEquals(true, stackImpl.push(11));
        Assert.assertEquals(false, stackImpl.push(100));
    }

    @Test
    public void peek() {
        Assert.assertNull(stackImpl.peek());
        stackImpl.push(1);
        Assert.assertEquals(1, stackImpl.peek());
        stackImpl.push(-15);
        stackImpl.push(0);
        Assert.assertEquals(0, stackImpl.peek());
    }

    @Test
    public void poop() {
        stackImpl.push(1);
        stackImpl.push(2);
        stackImpl.push(3);
        stackImpl.push(4);
        stackImpl.push(5);

        Assert.assertEquals(5, stackImpl.pop());
        Assert.assertEquals(4, stackImpl.pop());
        Assert.assertEquals(3, stackImpl.pop());
        Assert.assertEquals(2, stackImpl.pop());
        Assert.assertEquals(1, stackImpl.pop());
        Assert.assertNull( stackImpl.pop());
    }

    @Test
    public void isEmpty() {
        Assert.assertTrue(stackImpl.isEmpty());
        stackImpl.push(1);
        stackImpl.push(2);
        stackImpl.push(3);
        Assert.assertFalse(stackImpl.isEmpty());
    }

    @Test
    public void isFull() {
        Assert.assertFalse(stackImpl.isFull());
        stackImpl.push(1);
        stackImpl.push(2);
        stackImpl.push(3);
        stackImpl.push(4);
        stackImpl.push(5);
        Assert.assertTrue(stackImpl.isFull());
    }

    @Test
    public void size() {
        Assert.assertEquals(0, stackImpl.size());
        stackImpl.push(1);
        stackImpl.push(2);
        stackImpl.push(3);
        Assert.assertEquals(3, stackImpl.size());
        stackImpl.pop();
        Assert.assertEquals(2, stackImpl.size());
        stackImpl.pop();
        Assert.assertEquals(1, stackImpl.size());
        stackImpl.pop();
        Assert.assertEquals(0, stackImpl.size());
        stackImpl.pop();
        Assert.assertEquals(0, stackImpl.size());
    }


        @After
    public void tearDown() throws Exception {
        System.out.println("End");
    }
}