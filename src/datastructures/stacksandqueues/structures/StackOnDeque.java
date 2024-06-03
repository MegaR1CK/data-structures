package datastructures.stacksandqueues.structures;

import datastructures.stacksandqueues.exceptions.EmptyQueueException;
import datastructures.stacksandqueues.exceptions.FullQueueException;

public class StackOnDeque {

    private final Deque deque;

    public StackOnDeque(int size) {
        deque = new Deque(size);
    }

    public void push(int value) throws FullQueueException {
        deque.insertRight(value);
    }

    public int pop() throws EmptyQueueException {
        return deque.getRight();
    }


    public int peek() throws FullQueueException, EmptyQueueException {
        int value = deque.getRight();
        deque.insertRight(value);
        return value;
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }
}
