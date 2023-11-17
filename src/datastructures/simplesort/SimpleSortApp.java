package datastructures.simplesort;

import static datastructures.Utils.println;
import static datastructures.Utils.readInt;

public class SimpleSortApp {

    public static void main(String[] args) {
        SortArray array = createArray();
        int userInput;
        do {
            userInput = readInt("1 - Сортировка пузырьком\n" +
                "2 - Сортировка выбором\n" +
                "3 - Сортировка вставкой\n" +
                "4 - Пересоздание массива\n" +
                "5 - Завершение работы",
                1,
                5
            );
            long time = System.currentTimeMillis();
            switch (userInput) {
                case 1:
                    array.bubbleSort();
                    println("Массив отсортирован пузырьком:");
                    displayArray(array);
                    break;
                case 2:
                    array.selectionSort();
                    println("Массив отсортирован выбором:");
                    displayArray(array);
                    break;
                case 3:
                    array.insertionSort();
                    println("Массив отсортирован вставкой:");
                    displayArray(array);
                    break;
                case 4:
                    array = createArray();
                    break;
            }
            println("Время операции - " + (System.currentTimeMillis() - time) + " мс");
        } while (userInput != 5);
        println("Завершение работы...");
    }

    private static void displayArray(SortArray array) {
        for (int i = 0; i < array.getSize(); i++) {
            System.out.print(array.get(i) + " ");
        }
        println();
    }

    private static SortArray createArray() {
        SortArray newArray = new SortArray(readInt("Введите размер массива:", 1, 100000));
        println("Создан массив:");
        displayArray(newArray);
        return newArray;
    }
}
