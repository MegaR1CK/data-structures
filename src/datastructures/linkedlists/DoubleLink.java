package datastructures.linkedlists;

public class DoubleLink {
    int data;
    DoubleLink next;
    DoubleLink previous;

    public DoubleLink(int value) {
        data = value;
        next = null;
        previous = null;
    }

    public void displayLink() {
        System.out.print(data);
    }
}

