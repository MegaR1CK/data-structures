package datastructures.arrays.simplearray;

public class SimpleArray {

    private final int[] arr;
    private int size;

    public SimpleArray(int size) {
        arr = new int[size];
    }

    public void insert(int value) {
        arr[size] = value;
        size++;
    }

    public int find(int value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value) return i;
        }
        return -1;
    }

    public boolean delete(int value) {
        int i;
        for (i = 0; i < size; i++) {
            if (arr[i] == value) break;
        }
        if (i == size) return false;
        for (int j = i; j < size - 1; j++) {
            arr[j] = arr[j + 1];
        }
        size--;
        return true;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
