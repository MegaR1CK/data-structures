package datastructures.arrays;

public interface Array {

    /** Получение элемента по индексу */
    int get(int index);

    /** Вставка элемента в массив */
    void insert(int value);

    /** Поиск элемента в массиве */
    int find(int value);

    /** Удаление элемента из массива */
    boolean delete(int value);

    /** Получение размера массива */
    int getSize();

}
