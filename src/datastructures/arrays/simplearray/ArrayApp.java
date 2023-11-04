package datastructures.arrays.simplearray;

import java.util.Random;

import static datastructures.Utils.readInt;

public class ArrayApp {

    public static void main(String[] args) {

        int arraySize = readInt("Введите размер массива:", 0, 100);
        SimpleArray array = new SimpleArray(arraySize);
        fillArray(array, arraySize);

        int userInput;
        do {
            userInput = readInt(
                "\n1 - отобразить массив\n" +
                "2 - найти индекс элемента массива\n" +
                "3 - удалить элемент массива\n" +
                "4 - завершить работу\n",
                1,
                4
            );
            switch (userInput) {
                case 1:
                    array.display();
                    break;
                case 2:
                    searchScenario(array);
                    break;
                case 3:
                    deleteScenario(array);
                    break;
            }
        } while (userInput != 4);
        System.out.println("Завершение работы...");
        System.exit(0);
    }

    private static void fillArray(SimpleArray array, int arraySize) {
        Random random = new Random();
        for (int i = 0; i < arraySize; i++) {
            array.insert(random.nextInt(100));
        }
        System.out.println("Массив заполнен случайными числами");
    }

    private static void searchScenario(SimpleArray array) {
        int element = readInt("Введите элемент для поиска: ", 0, 100);
        int index = array.find(element);
        if (index != -1) {
            System.out.println("Искомый элемент расположен по индексу " + index);
        } else {
            System.out.println("Искомый элемент не найден");
        }
    }

    private static void deleteScenario(SimpleArray array) {
        int element = readInt("Введите элемент для удаления: ", 0, 100);
        if (array.delete(element)) {
            System.out.println("Элемент удален");
        } else {
            System.out.println("Элемент не найден");
        }
    }
}
