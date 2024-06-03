package datastructures.linkedlists;


import static datastructures.Utils.println;

public class DoubleLinkedList {

    DoubleLink first;
    DoubleLink last;

    public DoubleLinkedList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(int value) {
        DoubleLink newLink = new DoubleLink(value);
        if (isEmpty())
            last = newLink;
        else
            first.previous = newLink;
        newLink.next = first;
        first = newLink;
    }

    public void insertLast(int value) {
        DoubleLink newLink = new DoubleLink(value);
        if (isEmpty())
            first = newLink;
        else {
            last.next = newLink;
            newLink.previous = last;
        }
        last = newLink;
    }

    public void deleteFirst() {
        if (first.next == null)
            last = null;
        else
            first.next.previous = null;
        first = first.next;
    }

    public void deleteLast() {
        if (first.next == null)
            first = null;
        else
            last.previous.next = null;
        last = last.previous;
    }

    public void insertAfter(int key, int value) {
        DoubleLink current = first;
        while (current.data != key) {
            current = current.next;
            if (current == null)
                return;
        }

        DoubleLink newLink = new DoubleLink(value);
        if (current == last) {
            last = newLink;
        } else {
            newLink.next = current.next;
            current.next.previous = newLink;
        }
        newLink.previous = current;
        current.next = newLink;
    }

    public void deleteKey(int key) {
        DoubleLink current = first;
        while (current.data != key) {
            current = current.next;
            if (current == null)
                return;
        }
        if (current == first)
            first = current.next;
        else
            current.previous.next = current.next;

        if (current == last)
            last = current.previous;
        else
            current.next.previous = current.previous;
    }

    public void displayForward() {
        DoubleLink current = first;
        while (current != null) {
            current.displayLink();
            System.out.print(" ");
            current = current.next;
        }
        println();
    }

    public void displayBackward() {
        DoubleLink current = last;
        while (current != null) {
            current.displayLink();
            System.out.print(" ");
            current = current.previous;
        }
        println();
    }
}
