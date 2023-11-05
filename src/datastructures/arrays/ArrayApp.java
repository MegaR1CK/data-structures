package datastructures.arrays;

import java.util.Random;
import static datastructures.Utils.readInt;

public class ArrayApp {

    public static void main(String[] args) {

        int arraySize = readInt("Введите размер массива:", 0, 100);
        int arrayType = readInt("Выберите тип массива (1 - обычный, 2 - упорядоченный)", 1, 2);
        Array array;
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
                "5 - завершить работу\n",
                1,
                5
            );
            switch (userInput) {
                case 1:
                    displayArray(array);
                    break;
                case 2:
                    insertScenario(array);
                    break;
                case 3:
                    searchScenario(array);
                    break;
                case 4:
                    deleteScenario(array);
                    break;
            }
        } while (userInput != 5);
        System.out.println("Завершение работы...");
        System.exit(0);
    }

    private static void fillArray(Array array, int arraySize) {
        Random random = new Random();
        for (int i = 0; i < arraySize; i++) {
            array.insert(random.nextInt(100));
        }
        System.out.println("Массив заполнен случайными числами");
    }

    private static void insertScenario(Array array) {
        int value = readInt("Введите элемент для добавления: ", 0, 100);
        try {
            array.insert(value);
            System.out.println("Элемент добавлен в массив");
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Не удалось добавить элемент: массив заполнен.");
        }
    }

    private static void searchScenario(Array array) {
        int element = readInt("Введите элемент для поиска: ", 0, 100);
        int index = array.find(element);
        if (index != -1) {
            System.out.println("Искомый элемент расположен по индексу " + index);
        } else {
            System.out.println("Искомый элемент не найден");
        }
    }

    private static void deleteScenario(Array array) {
        int element = readInt("Введите элемент для удаления: ", 0, 100);
        if (array.delete(element)) {
            System.out.println("Элемент удален");
        } else {
            System.out.println("Элемент не найден");
        }
    }

    private static void displayArray(Array array) {
        for (int i = 0; i < array.getSize(); i++) {
            System.out.print(array.get(i) + " ");
        }
        System.out.println();
    }
}
