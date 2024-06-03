package datastructures.linkedlists;

import static datastructures.Utils.println;

public class SortedList {
    public Link first;

    SortedList() {
        first = null;
    }

    SortedList(int[] arr) {
        first = null;
        for (int j : arr) insert(j);
    }

    public void insert(int value) {
        Link newLink = new Link(value);
        Link current = first;
        Link previous = null;
        while (current != null && value > current.data) {
            previous = current;
            current = current.next;
        }
        if (previous == null)
            first = newLink;
        else
            previous.next = newLink;
        newLink.next = current;
    }

    public int removeFirst() {
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
}
