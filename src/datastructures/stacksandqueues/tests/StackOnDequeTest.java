package datastructures.stacksandqueues.tests;

import datastructures.stacksandqueues.structures.Deque;
import datastructures.stacksandqueues.structures.StackOnDeque;
import datastructures.stacksandqueues.exceptions.EmptyQueueException;
import datastructures.stacksandqueues.exceptions.FullQueueException;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class StackOnDequeTest {

    @Test
    public void push() throws FullQueueException, NoSuchFieldException, IllegalAccessException {
        StackOnDeque stack = new StackOnDeque(5);
        stack.push(3);
        stack.push(2);
        assertArrayEquals(getArray(stack), new int[] { 3, 2, 0, 0, 0 });
    }

    @Test
    public void pop() throws EmptyQueueException, FullQueueException {
        StackOnDeque stack = new StackOnDeque(5);
        stack.push(3);
        stack.push(2);
        assertEquals(2, stack.pop());
        assertEquals(3, stack.pop());
    }

    @Test
    public void peek() throws NoSuchFieldException, IllegalAccessException, EmptyQueueException, FullQueueException {
        StackOnDeque stack = new StackOnDeque(5);
        stack.push(3);
        stack.push(2);
        assertEquals(2, stack.peek());
        assertArrayEquals(getArray(stack), new int[] { 3, 2, 0, 0, 0 });
    }

    @Test
    public void isEmpty() throws FullQueueException {
        StackOnDeque stack = new StackOnDeque(5);
        assertTrue(stack.isEmpty());
        stack.push(3);
        assertFalse(stack.isEmpty());
    }

    private int[] getArray(StackOnDeque stack) throws NoSuchFieldException, IllegalAccessException {
        Field dequeField = StackOnDeque.class.getDeclaredField("deque");
        dequeField.setAccessible(true);
        Field arrayField = Deque.class.getDeclaredField("array");
        arrayField.setAccessible(true);
        return (int[]) arrayField.get(dequeField.get(stack));
    }
}
