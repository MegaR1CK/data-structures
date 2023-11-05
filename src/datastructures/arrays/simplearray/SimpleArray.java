package datastructures.arrays.simplearray;

/**
 * Стандартный массив, элементы идут друг за другом.
 */
public class SimpleArray {

    private final int[] arr;
    private int size;

    public SimpleArray(int size) {
        arr = new int[size];
    }

    /**
     * Вставка нового элемента в конец массива. Время выполнения - O(1)
     * @param value Значение нового элемента
     */
    public void insert(int value) {
        arr[size] = value;
        size++;
    }

    /**
     * Поиск элемента в массиве. Проход по массиву в поиске элемента с заданным значением.
     * Время выполнения - O(n)
     * @param value Значение искомого элемента
     * @return Индекс искомого элемента, -1, если элемент не найден
     */
    public int find(int value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value) return i;
        }
        return -1;
    }

    /**
     * Удаление элемента из массива. Проход по массиву в поиске элемента с заданным значением,
     * затем сдвиг всех последующих элементов на ячейку назад. Удаляемое значение перезаписывается.
     * Время выполнения - O(n)
     * @param value Значение удаляемого элемента
     * @return true, если удалось удалить элемент, false - если нет
     */
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

    /**
     * Отображение всех элементов массива в консоли. Время выполнения - O(n).
     */
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
