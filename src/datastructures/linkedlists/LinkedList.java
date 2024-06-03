package datastructures.linkedlists;

import static datastructures.Utils.println;

public class LinkedList {
    public Link first;

    LinkedList() {
        first = null;
    }

    public void insertFirst(int data) {
        Link newLink = new Link(data);
        newLink.next = first;
        first = newLink;
    }

    public int deleteFirst() {
        int temp = first.data;
        first = first.next;
        return temp;
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

    public Link find(int value) {
        Link current = first;
        while (current.data != value) {
            if (current.next == null) {
                return null;
            } else {
                current = current.next;
            }
        }
        return current;
    }

    public Link delete(int value) {
        Link current = first;
        Link previous = first;
        while (current.data != value) {
            if (current.next == null) {
                return null;
            } else {
                previous = current;
                current = current.next;
            }
        }
        if (current == first) {
            first = first.next;
        } else {
            previous.next = current.next;
        }
        return current;
    }
}
