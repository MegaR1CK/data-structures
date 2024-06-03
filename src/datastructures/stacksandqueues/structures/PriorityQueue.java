package datastructures.stacksandqueues.structures;

import datastructures.stacksandqueues.exceptions.EmptyQueueException;
import datastructures.stacksandqueues.exceptions.FullQueueException;

public class PriorityQueue {

    private final int[] array;
    private final int maxSize;
    private int elementsCount = 0;

    public PriorityQueue(int maxSize) {
        array = new int[maxSize];
        this.maxSize = maxSize;
    }

    public void insert(int value) throws FullQueueException {
        if (elementsCount == maxSize) throw new FullQueueException();
        if (elementsCount == 0) {
            array[elementsCount++] = value;
        } else {
            int i;
            for (i = elementsCount - 1; i >= 0; i--) {
                if (value > array[i]) {
                    array[i + 1] = array[i];
                } else {
                    break;
                }
            }
            array[i + 1] = value;
            elementsCount++;
        }
    }

    public int get() throws EmptyQueueException {
        if (elementsCount == 0) throw new EmptyQueueException();
        return array[--elementsCount];
    }
}
