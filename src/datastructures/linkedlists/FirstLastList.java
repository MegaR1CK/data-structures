package datastructures.linkedlists;

import static datastructures.Utils.println;

public class FirstLastList {

    public Link first;
    public Link last;

    public FirstLastList() {
        first = null;
        last = null;
    }

    public void insertFirst(int value) {
        Link newLink = new Link(value);
        if (isEmpty()) {
            last = newLink;
        } else {
            newLink.next = first;
        }
        first = newLink;
    }

    public void deleteFirst() {
        if (first.next == null) {
            last = null;
        }
        first = first.next;
    }

    public void insertLast(int value) {
        Link newLink = new Link(value);
        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
        }
        last = newLink;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void displayList() {
        Link current = first;
        while (current != null) {
            current.displayLink();
            System.out.print(" ");
            current = current.next;
        }
        println();
    }
}
