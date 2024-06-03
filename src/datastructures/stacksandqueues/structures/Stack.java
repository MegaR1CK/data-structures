package datastructures.stacksandqueues.structures;

public class Stack {

    private final int[] array;
    private int topIndex;

    public Stack(int size) {
        array = new int[size];
        topIndex = -1;
    }

    public void push(int value) {
        array[++topIndex] = value;
    }

    public void push(char value) {
        array[++topIndex] = value;
    }

    public int pop() {
        return array[topIndex--];
    }

    public char popChar() {
        return (char) array[topIndex--];
    }

    public int peek() {
        return array[topIndex];
    }

    public boolean isEmpty() {
        return topIndex == -1;
    }
}
