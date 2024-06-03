package datastructures.stacksandqueues.tests;

import datastructures.stacksandqueues.structures.Deque;
import datastructures.stacksandqueues.exceptions.EmptyQueueException;
import datastructures.stacksandqueues.exceptions.FullQueueException;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class DequeTest {

    @Test
    public void insertRight() throws FullQueueException, NoSuchFieldException, IllegalAccessException {
        Deque deque = new Deque(5);
        deque.insertRight(1);
        deque.insertRight(2);
        deque.insertRight(3);
        deque.insertRight(4);
        assertArrayEquals(getArray(deque), new int[] { 1, 2, 3, 4, 0 } );
    }

    @Test
    public void insertLeft() throws FullQueueException, NoSuchFieldException, IllegalAccessException {
        Deque deque = new Deque(5);
        deque.insertLeft(1);
        deque.insertLeft(2);
        deque.insertLeft(3);
        deque.insertLeft(4);
        assertArrayEquals(getArray(deque), new int[] { 0, 4, 3, 2, 1 } );
    }

    @Test
    public void getRight() throws FullQueueException, EmptyQueueException {
        Deque deque = new Deque(5);
        deque.insertRight(1);
        deque.insertRight(2);
        deque.insertLeft(3);
        deque.insertLeft(4);
        Assert.assertEquals(2, deque.getRight());
        Assert.assertEquals(1, deque.getRight());
        Assert.assertEquals(3, deque.getRight());
        Assert.assertEquals(4, deque.getRight());
    }

    @Test
    public void getLeft() throws FullQueueException, EmptyQueueException {
        Deque deque = new Deque(5);
        deque.insertLeft(1);
        deque.insertLeft(2);
        deque.insertRight(3);
        deque.insertRight(4);
        Assert.assertEquals(2, deque.getLeft());
        Assert.assertEquals(1, deque.getLeft());
        Assert.assertEquals(3, deque.getLeft());
        Assert.assertEquals(4, deque.getLeft());
    }

    @Test
    public void isEmpty() throws FullQueueException {
        Deque deque = new Deque(5);
        assertTrue(deque.isEmpty());
        deque.insertRight(1);
        assertFalse(deque.isEmpty());
    }

    @Test
    public void isFull() throws FullQueueException {
        Deque deque = new Deque(2);
        assertFalse(deque.isFull());
        deque.insertRight(1);
        deque.insertRight(2);
        assertTrue(deque.isFull());
    }

    @Test(expected = FullQueueException.class)
    public void overfill() throws FullQueueException {
        Deque deque = new Deque(2);
        deque.insertRight(1);
        deque.insertRight(2);
        deque.insertRight(3);
    }

    @Test(expected = EmptyQueueException.class)
    public void emptyDeque() throws EmptyQueueException {
        Deque deque = new Deque(2);
        deque.getLeft();
    }

    private int[] getArray(Deque deque) throws NoSuchFieldException, IllegalAccessException {
        Field field = Deque.class.getDeclaredField("array");
        field.setAccessible(true);
        return (int[]) field.get(deque);
    }
}
