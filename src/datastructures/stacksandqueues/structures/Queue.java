package datastructures.stacksandqueues.structures;

import datastructures.stacksandqueues.exceptions.EmptyQueueException;
import datastructures.stacksandqueues.exceptions.FullQueueException;

public class Queue {

    private final int[] array;
    private final int maxSize;
    private int front = 0;
    private int rear = -1;
    private int elementsCount = 0;


    public Queue(int maxSize) {
        array = new int[maxSize];
        this.maxSize = maxSize;
    }

    public void insert(int value) throws FullQueueException {
        if (elementsCount == maxSize) throw new FullQueueException();
        if (rear == maxSize - 1) rear = -1;
        array[++rear] = value;
        elementsCount++;
    }

    public int get() throws EmptyQueueException {
        if (elementsCount == 0) throw new EmptyQueueException();
        if (front == maxSize) front = 0;
        elementsCount--;
        return array[front++];
    }

    public int getSize() {
        return elementsCount;
    }

    public String display() {
        StringBuilder output = new StringBuilder();
        try {
            for (int i = 0; i < elementsCount; i++) {
                int value = get();
                output.append(value);
                if (i != elementsCount - 1) output.append(" ");
                insert(value);
            }
            return output.toString();
        } catch (EmptyQueueException exception) {
            return "Очередь пустая!";
        } catch (FullQueueException exception) {
            return "Очередь заполнена!";
        }
    }
}
