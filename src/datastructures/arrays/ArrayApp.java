package datastructures.arrays;

import java.util.Random;

import static datastructures.Utils.println;
import static datastructures.Utils.readInt;

public class ArrayApp {

    static Array array;

    public static void main(String[] args) {

        int arraySize = readInt("Введите размер массива:", 0, 100);
        int arrayType = readInt("Выберите тип массива (1 - обычный, 2 - упорядоченный)", 1, 2);
        if (arrayType == 1) {
            array = new SimpleArray(arraySize);
        } else {
            array = new OrderedArray(arraySize);
        }
        fillArray(array, arraySize);

        int userInput;
        do {
            userInput = readInt(
                "\n1 - отобразить массив\n" +
                "2 - добавить новый элемент в массив\n" +
                "3 - найти индекс элемента массива\n" +
                "4 - удалить элемент массива\n" +
                "5 - отсортировать обычный массив\n" +
                "6 - объединить упорядоченные массивы\n" +
                "7 - удалить дупликаты в массиве\n" +
                "8 - завершить работу\n",
                1,
                8
            );
            switch (userInput) {
                case 1:
                    displayArray(array);
                    break;
                case 2:
                    insertScenario();
                    break;
                case 3:
                    searchScenario();
                    break;
                case 4:
                    deleteScenario();
                    break;
                case 5:
                    sortScenario();
                    break;
                case 6:
                    mergeScenario();
                    break;
                case 7:
                    removeDuplicatesScenario();
                    break;
            }
        } while (userInput != 8);
        println("Завершение работы...");
        System.exit(0);
    }

    private static void fillArray(Array array, int size) {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array.insert(random.nextInt(100));
        }
        println("Массив заполнен случайными числами");
    }

    private static void insertScenario() {
        int value = readInt("Введите элемент для добавления: ", 0, 100);
        try {
            array.insert(value);
            println("Элемент добавлен в массив");
        } catch (ArrayIndexOutOfBoundsException exception) {
            println("Не удалось добавить элемент: массив заполнен.");
        }
    }

    private static void searchScenario() {
        int element = readInt("Введите элемент для поиска: ", 0, 100);
        int index = array.find(element);
        if (index != -1) {
            println("Искомый элемент расположен по индексу " + index);
        } else {
            println("Искомый элемент не найден");
        }
    }

    private static void deleteScenario() {
        int element = readInt("Введите элемент для удаления: ", 0, 100);
        if (array.delete(element)) {
            println("Элемент удален");
        } else {
            println("Элемент не найден");
        }
    }

    private static void sortScenario() {
        if (array instanceof SimpleArray) {
            array = sortArray((SimpleArray) array);
        }
        println("Массив отсортирован");
    }

    private static void mergeScenario() {
        if (array instanceof OrderedArray) {
            int secondArraySize = readInt("Введите размер второго массива:", 0, 100);
            OrderedArray firstArray = (OrderedArray) array;
            OrderedArray secondArray = new OrderedArray(secondArraySize);
            fillArray(secondArray, secondArraySize);
            OrderedArray mergedArray = firstArray.merge(secondArray);
            println("Первый массив:");
            displayArray(firstArray);
            println("Второй массив:");
            displayArray(secondArray);
            println("Объединенный массив:");
            displayArray(mergedArray);
        } else {
            println("Массив не упорядоченный!");
        }
    }

    private static void removeDuplicatesScenario() {
        array.removeDuplicates();
        println("Дубликаты удалены");
    }

    private static void displayArray(Array array) {
        for (int i = 0; i < array.getSize(); i++) {
            System.out.print(array.get(i) + " ");
        }
        println();
    }

    private static SimpleArray sortArray(SimpleArray array) {
        SimpleArray sortedArray = new SimpleArray(array.getSize());
        for (int i = array.getSize() - 1; i >= 0; i--) {
            sortedArray.set(array.removeMax(), i);
        }
        return sortedArray;
    }
}
