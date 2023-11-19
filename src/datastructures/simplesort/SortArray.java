package datastructures.simplesort;

import java.util.Random;

/**
 * Стандартный массив, элементы идут друг за другом.
 */
public class SortArray {

    private final int[] arr;
    private int size;

    /**
     * Конструктор массива, генерирует массив и заполняет его случайными элементами.
     * @param size Размер массива
     */
    public SortArray(int size) {
        arr = new int[size];
        this.size = size;
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(10);
        }
    }

    /**
     * Получение элемента из массива
     * @param index индекс элемента
     * @return элемент
     */
    public int get(int index) {
        return arr[index];
    }

    /**
     * Получение размера массива
     * @return размер массива
     */
    public int getSize() {
        return size;
    }

    /**
     * Обмен позициями двух элементов массива по указанным индексам
     */
    public void swap(int firstPos, int secondPos) {
        int temp = arr[secondPos];
        arr[secondPos] = arr[firstPos];
        arr[firstPos] = temp;
    }

    /**
     * Пузырьковая сортировка:
     * <p>
     * 1. Сравниваем два элемента массива. Если первый элемент больше второго, меняем их местами.
     * <p>
     * 2. Переходим на индекс вправо и выполняем пункт 1.
     * <p>
     * 3. Выполняем пункты 1-2, пока не дойдем до конца массива. В результате самый большой элемент массива окажется
     * в конце. Сужаем границу сортировки на 1 элемент с конца, так как область за границей отсортирована.
     * <p>
     * 4. Выполняем пункт 3, пока область сортировки не сузится до 1 элемента.
     * <p>
     *  Массив отсортирован.
     * <p>
     * Сложность алгоритма - O(n^2)
     */
    public void bubbleSort() {
        for (int i = size - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) swap(j, j + 1);
            }
        }
    }

    /**
     * Двунаправленная пузырьковая сортировка. Имеет два внутренних цикла. Один проходит с начала до конца,
     * другой - с конца до начала. Таким образом сортированная область сходится
     * к центру массива, нарастая с обоих сторон.
     * <p>
     * Сложность алгоритма - O(n^2)
     */
    public void twoSidedBubbleSort() {
        for (int iRight = size - 1, iLeft = 0; iRight > iLeft; iRight--, iLeft++) {
            int j = 0;
            for (; j < iRight; j++) {
                if (arr[j] > arr[j + 1]) swap(j, j + 1);
            }
            for(; j > iLeft; j--) {
                if (arr[j] < arr[j - 1]) swap(j, j - 1);
            }
        }
    }

    /**
     * Сортировка выбором:
     * <p>
     * 1. Находим минимальный элемент в неотсортированной области (изначально - весь массив)
     * проходя по массиву и сравнивая элементы.
     * <p>
     * 2. Меняем местами первый элемент в неотсортированной области и минимальный элемент.
     * <p>
     * 3. Сужаем неотсортированную область на 1 элемент с начала массива.
     * <p>
     * 4. Выполняем пункты - 1-3, пока неотсортированная область не сузится до 1 элемента.
     * <p>
     *  Массив отсортирован.
     * <p>
     * Сложность алгоритма - O(n^2)
     */
    public void selectionSort() {
        for (int i = 0; i < size - 1; i++) {
            int minValueIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (arr[j] < arr[minValueIndex]) minValueIndex = j;
            }
            swap(i, minValueIndex);
        }
    }

    /**
     * Сортировка вставкой:
     * <p>
     * 1. Задаем частично отсортированную область, состоящую из первого элемента массива.
     * <p>
     * 2. Сохраняем первый элемент в неотсортированной области.
     * <p>
     * 3. Сдвигаем по одному элементу частично отсортированной области вправо,
     * пока очередной элемент не станет меньше сохраненного.
     * <p>
     * 4. Вставляем сохраненный элемент перед первым меньшим элементом или в начало массива, если таковых не нашлось.
     * <p>
     * 5. Сужаем неотсортированную область на 1 элемент с начала массива.
     * <p>
     * 6. Повторяем шаги 2-5, пока неотсортированная область не сузится до 1 элемента.
     * <p>
     *  Массив отсортирован.
     * <p>
     * Сложность алгоритма - O(n^2)
     *
     * @return Объект, содержащий количество копирований и сравнений, совершенных во время работы алгоритма.
     */
    public InsertionSortResult insertionSort() {
        long copies = 0, comparisons = 0;
        for (int i = 1; i < size; i++) {
            int selected = arr[i];
            int j = i;
            while (j > 0) {
                comparisons++;
                if (arr[j - 1] < selected) break;
                arr[j] = arr[j - 1];
                copies++;
                j--;
            }
            arr[j] = selected;
        }
        return new InsertionSortResult(copies, comparisons);
    }

    /**
     * Сортировка вставкой с удалением дубликатов.
     * <p>
     * Если во время поиска места для вставки обнаруживается, что в частично отсортированной области уже есть элемент,
     * равный вставляемому, вставляемый элемент получает значение -1 и отправляется в начало массива. После такой
     * сортировки мы получаем массив без дубликатов с некоторым количеством -1 в начале. Сдвигаем все элементы
     * влево на количество -1 и уменьшаем размер массива на это же значение.
     */
    public void insertionSortNoDups() {
        int dupsBound = 0;
        for (int i = 1; i < size; i++) {
            int selected = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= selected) {
                if (selected == arr[j - 1] && selected != -1) {
                    selected = -1;
                    dupsBound++;
                }
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = selected;
        }
        for (int i = 0; i < size - dupsBound; i++) {
            arr[i] = arr[dupsBound + i];
        }
        size -= dupsBound;
    }

    /**
     * Модификация пузырьковой сортировки под названием "Четно-нечетная сортировка".
     * <p>
     * Имеет два внутренних цикла. Один проводит проход пузырьковой сортировки, начиная с нечетного индекса,
     * другой - начиная с четного индекса массива. Это повторяется до полной сортировки массива.
     *
     * @return Число итераций внешнего цикла, понадобившихся для сортировки массива.
     */
    public int oddEvenSort() {
        boolean isSorted;
        int iterationsCounter = 0;
        do {
            isSorted = true;
            for (int j = 1; j < size - 1; j += 2) {
                if (arr[j] > arr[j + 1]) {
                    swap(j, j + 1);
                    isSorted = false;
                }
            }
            for (int k = 0; k < size - 1; k += 2) {
                if (arr[k] > arr[k + 1]) {
                    swap(k, k + 1);
                    isSorted = false;
                }
            }
            iterationsCounter++;
        } while (!isSorted);
        return iterationsCounter;
    }

    /**
     * Проводит сортировку вставкой и вычисляет медиану массива
     * @return Медиана массива
     */
    public double median() {
        insertionSort();
        if (size % 2 == 0) {
            return (arr[size / 2 - 1] + arr[size / 2]) / 2.0;
        } else {
            return arr[size / 2];
        }
    }

    /**
     * Проводит удаление дубликатов в предварительно отсортированном массиве. Алгоритм схож с сортировкой вставкой:
     * <p>
     * 1. Задаем границу области без дубликатов нулевым элементом.
     * <p>
     * 2. Идем по массиву. Если попадается элемент больше, чем крайний элемент в области без дубликатов, меняем его
     * местами с элементом, следующим после области без дубликатов. Сдвигаем границу области без дубликатов на 1 вправо.
     * <p>
     * 3. Задаем размер массива, равный области без дубликатов.
     */
    public void removeDuplicates() {
        insertionSort();
        int noDuplicatesBound = 0;
        for (int i = 1; i < size; i++) {
            if (arr[i] > arr[noDuplicatesBound]) {
                swap(noDuplicatesBound + 1, i);
                noDuplicatesBound++;
            }
        }
        size = noDuplicatesBound + 1;
    }

    /**
     * Вспомогательный класс для возвращения сортировкой вставкой сразу нескольких значений
     */
    static class InsertionSortResult {

        private final long copies;
        private final long comparisons;

        private InsertionSortResult(long copies, long  comparisons) {
            this.copies = copies;
            this.comparisons = comparisons;
        }

        public long getCopies() {
            return copies;
        }

        public long getComparisons() {
            return comparisons;
        }
    }
}
