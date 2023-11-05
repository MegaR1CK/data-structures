package datastructures.arrays;

/**
 * Упорядоченный массив. Элементы расположены по возрастанию.
 */
public class OrderedArray implements Array {

    private final int[] arr;
    private int size;

    public OrderedArray(int maxSize) {
        arr = new int[maxSize];
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
     * Бинарный поиск элемента в массиве. Время выполнения - O(log(n))
     * @param value искомый элемент
     * @return индекс искомого элемента, -1, если элемент не найден
     */
    @Override
    public int find(int value) {
        int lowerBound = 0, upperBound = size - 1, currentIndex;
        while (true) {
            // Задаем серединный индекс, разделив пополам область поиска
            currentIndex = (upperBound + lowerBound) / 2;
            // Если серединный элемент - искомый, возвращаем его индекс
            if (arr[currentIndex] == value) return currentIndex;
            // Если нижняя граница стала больше верхней, значит поиск завершен, элемент не найден
            if (lowerBound > upperBound) return -1;
            // Если искомое значение больше серединного элемента, поднимаем
            // нижнюю границу поиска до элемента после серединного.
            // Иначе опускаем верхнюю границу поиска до элемента перед серединным.
            if (value > arr[currentIndex]) {
                lowerBound = currentIndex + 1;
            } else {
                upperBound = currentIndex - 1;
            }
        }
    }


    /**
     * Вставка элемента в упорядоченный массив. Позиция для элемента находится с помощью бинарного поиска.
     * @param value Значение нового элемента
     */
    @Override
    public void insert(int value) {
        int lowerBound = 0, upperBound = size, insertPosition = 0;
        // Цикл бинарного поиска позиции. Если размер массива нулевой, пропускаем этот шаг.
        while (size != 0 && lowerBound < upperBound) {
            // Если серединный элемент (он же позиция вставки) меньше вставляемого значения,
            // поднимаем нижнюю границу до следующего индекса после серединного.
            // Если серединный элемент больше вставляемого значения, опускаем верхнюю границу
            // до серединного индекса, чтобы не упускать сам серединный индекс из области поиска
            if (arr[insertPosition] < value) {
                lowerBound = insertPosition + 1;
            } else {
                upperBound = insertPosition;
            }
            // Назначаем новый серединный индекс, взяв средний элемент из области поиска.
            // Если в области поиска четное количество элементов, берем меньший из средних
            insertPosition = (upperBound + lowerBound) / 2;
        }

        // Сдвигаем все элементы, начиная с элемента на позиции вставки на
        // ячейку вправо, чтобы освободить место для нового элемента
         for (int i = size; i > insertPosition; i--) {
             arr[i] = arr[i - 1];
         }
         arr[insertPosition] = value;
         size++;
    }

    /**
     * Удаление элемента из массива. Элемент находится бинарным поиском.
     * @param value удаляемый элемент
     * @return true - удаление успешно, false - элемент не найден
     */
    @Override
    public boolean delete(int value) {
        int position = find(value);
        if (position == -1) return false;
        for (int i = position; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        return true;
    }

    /**
     * Удаление дубликатов внутри массива. Так как массив упорядоченный,
     * то если текущий и предыдущий элементы равны, текущий удаляем.
     */
    @Override
    public void removeDuplicates() {
        for (int i = 1; i < size; i++) {
            while (arr[i] == arr[i - 1]) {
                delete(arr[i]);
                if (size == i) break;
            }
        }
    }

    /**
     * Объединение текущего массива с другим упорядоченным массивом
     * @param secondArray второй упорядоченный массив
     * @return объединенный массив
     */
    public OrderedArray merge(OrderedArray secondArray) {
        boolean firstArrayCompleted = false, secondArrayCompleted = false;
        int mergedArrayMaxSize = size + secondArray.getSize();
        OrderedArray mergedArray = new OrderedArray(mergedArrayMaxSize);
        // Цикл сливания массивов. Сравниваем два элемента из разных массивов, добавляем в объединенный
        // массив меньший из них. Индекс массива, из которого добавлен элемент, увеличиваем. Если индекс вышел
        // за рамки массива, значит массив закончился, добавляем элементы только из другого.
        for (int firstIndex = 0, secondIndex = 0; firstIndex + secondIndex < mergedArrayMaxSize;) {
            if (firstIndex == size) firstArrayCompleted = true;
            if (secondIndex == secondArray.getSize()) secondArrayCompleted = true;
            if (secondArrayCompleted || !firstArrayCompleted && get(firstIndex) < secondArray.get(secondIndex)) {
                mergedArray.insert(get(firstIndex));
                firstIndex++;
            } else {
                mergedArray.insert(secondArray.get(secondIndex));
                secondIndex++;
            }
        }
        return mergedArray;
    }
}
