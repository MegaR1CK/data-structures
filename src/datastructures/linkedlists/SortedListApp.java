package datastructures.linkedlists;

import static datastructures.Utils.println;

public class SortedListApp {

    public static void main(String[] args) {

        int size = 10;
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 99);
        }


        println("Unsorted array:");
        for (int i : arr) System.out.print(i + " ");
        println();

        SortedList sortedList = new SortedList(arr);

        for (int i = 0; i < size; i++) {
            arr[i] = sortedList.removeFirst();
        }

        println("Sorted array:");
        for (int i : arr) System.out.print(i + " ");
        println();
    }
}
