package datastructures.stacksandqueues.tests;

import datastructures.stacksandqueues.structures.PriorityQueueAlt;
import datastructures.stacksandqueues.exceptions.EmptyQueueException;
import datastructures.stacksandqueues.exceptions.FullQueueException;
import org.junit.Test;
import java.lang.reflect.Field;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class PriorityQueueAltTest {

    @Test
    public void insert() throws NoSuchFieldException, IllegalAccessException, FullQueueException {
        PriorityQueueAlt queue = new PriorityQueueAlt(5);
        queue.insert(3);
        queue.insert(2);
        queue.insert(5);
        queue.insert(4);
        assertArrayEquals(getArray(queue), new int[] { 3, 2, 5, 4, 0 });
    }

    @Test
    public void get() throws EmptyQueueException, FullQueueException {
        PriorityQueueAlt queue = new PriorityQueueAlt(5);
        queue.insert(3);
        queue.insert(2);
        queue.insert(5);
        queue.insert(4);
        assertEquals(2, queue.get());
        assertEquals(3, queue.get());
        assertEquals(4, queue.get());
        assertEquals(5, queue.get());
    }

    @Test
    public void getQueue() throws FullQueueException {
        PriorityQueueAlt queue = new PriorityQueueAlt(5);
        queue.insert(3);
        queue.insert(2);
        queue.insert(5);
        queue.insert(4);
        assertEquals("2 3 4 5", queue.display());
    }

    private int[] getArray(PriorityQueueAlt deque) throws NoSuchFieldException, IllegalAccessException {
        Field field = PriorityQueueAlt.class.getDeclaredField("array");
        field.setAccessible(true);
        return (int[]) field.get(deque);
    }
}
