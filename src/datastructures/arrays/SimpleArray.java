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
     * @param index индекс элемента
     * @return элемент
     */
    @Override
    public int get(int index) {
        return arr[index];
    }

    /**
     * Вставка элемента по индексу
     * @param value новый элемент
     * @param index индекс
     */
    public void set(int value, int index) {
        // Предполагается, что нулевыми могут быть только пустые элементы массива
        if (arr[index] == 0) size++;
        arr[index] = value;
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

    /**
     * Удаление дубликатов внутри массива. Считаем вхождения элемента
     * в массив, если вхождений больше одного, удаляем элемент.
     */
    @Override
    public void removeDuplicates() {
        for (int i = 0; i < size; i++) {
            int entries = 0;
            for (int j = 0; j < size; j++) {
                if (arr[i] == arr[j] && entries++ > 0) delete(arr[j]);
            }
        }
    }

    /**
     * Получение максимального элемента массива
     * @return максимальный элемент массива, -1, если массив пуст
     */
    public int getMax() {
        if (size == 0) return -1;
        int maxValue = arr[0];
        for (int i = 1; i < size; i++) {
            if (arr[i] > maxValue) maxValue = arr[i];
        }
        return maxValue;
    }

    /**
     * Удаление максимального элемента массива
     * @return удаленный максимальный элемент массива, -1, если массив пуст
     */
    public int removeMax() {
        int maxValue = getMax();
        delete(maxValue);
        return maxValue;
    }
}
