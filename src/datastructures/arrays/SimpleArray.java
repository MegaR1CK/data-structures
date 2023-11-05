package datastructures.arrays;

/**
 * Стандартный массив, элементы идут друг за другом.
 */
public class SimpleArray implements Array {

    private final int[] arr;
    private int size;

    public SimpleArray(int size) {
        arr = new int[size];
    }

    /**
     * Получение элемента из массива
     * @param index индекс элементп
     * @return элемент
     */
    @Override
    public int get(int index) {
        return arr[index];
    }

    /**
     * Получение размера массива
     * @return размер массива
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * Вставка нового элемента в конец массива. Время выполнения - O(1)
     * @param value Значение нового элемента
     */
    @Override
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
    @Override
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
    @Override
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
}
