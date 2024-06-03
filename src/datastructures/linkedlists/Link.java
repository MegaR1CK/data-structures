package datastructures.linkedlists;

public class Link {
    public int data;
    public Link next;

    public Link(int data) {
        this.data = data;
        next = null;
    }

    public void displayLink() {
        System.out.print(data);
    }
}
