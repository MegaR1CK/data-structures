package datastructures.stacksandqueues.structures;

import datastructures.stacksandqueues.exceptions.EmptyQueueException;
import datastructures.stacksandqueues.exceptions.FullQueueException;

public class Deque {

    private final int[] array;
    private final int maxSize;
    private int left = 0;
    private int right = -1;
    private int elementsCount = 0;

    public Deque(int maxSize) {
        array = new int[maxSize];
        this.maxSize = maxSize;
    }

    public void insertRight(int value) throws FullQueueException {
        if (elementsCount == maxSize) throw new FullQueueException();
        if (right == maxSize - 1) right = -1;
        array[++right] = value;
        elementsCount++;
    }

    public void insertLeft(int value) throws FullQueueException {
        if (elementsCount == maxSize) throw new FullQueueException();
        if (left == 0) left = maxSize;
        array[--left] = value;
        elementsCount++;
    }

    public int getRight() throws EmptyQueueException {
        if (elementsCount == 0) throw new EmptyQueueException();
        if (right == -1) right = maxSize - 1;
        elementsCount--;
        return array[right--];
    }

    public int getLeft() throws EmptyQueueException {
        if (elementsCount == 0) throw new EmptyQueueException();
        if (left == maxSize) left = 0;
        elementsCount--;
        return array[left++];
    }

    public boolean isEmpty() {
        return elementsCount == 0;
    }

    public boolean isFull() {
        return elementsCount == maxSize;
    }
}
