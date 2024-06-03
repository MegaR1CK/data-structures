package datastructures.stacksandqueues.structures;

import datastructures.stacksandqueues.exceptions.EmptyQueueException;
import datastructures.stacksandqueues.exceptions.FullQueueException;

public class PriorityQueueAlt {

    private final int[] array;
    private final int maxSize;
    private int elementsCount = 0;

    public PriorityQueueAlt(int maxSize) {
        array = new int[maxSize];
        this.maxSize = maxSize;
    }

    public void insert(int value) throws FullQueueException {
        if (elementsCount == maxSize) throw new FullQueueException();
        array[elementsCount++] = value;
    }

    public int get() throws EmptyQueueException {
        if (elementsCount == 0) throw new EmptyQueueException();
        int minIndex = 0;
        for (int i = 1; i < elementsCount; i++) {
            if (array[i] < array[minIndex]) {
                minIndex = i;
            }
        }
        int value = array[minIndex];
        for (int i = minIndex; i < elementsCount - 1; i++) {
            array[i] = array[i + 1];
        }
        elementsCount--;
        return value;
    }

    public String display() {
        StringBuilder output = new StringBuilder();
        try {
            int[] savedValues = new int[elementsCount];
            int savedCount = elementsCount;
            for (int i = 0; i < savedCount; i++) {
                int value = get();
                output.append(value);
                if (i != savedCount - 1) output.append(" ");
                savedValues[i] = value;
            }
            for (int i = 0; i < savedCount; i++) {
                insert(savedValues[i]);
            }
            return output.toString();
        } catch (EmptyQueueException exception) {
            return "Очередь пустая!";
        } catch (FullQueueException exception) {
            return "Очередь заполнена!";
        }
    }
}
