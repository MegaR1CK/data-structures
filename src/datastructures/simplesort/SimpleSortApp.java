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
                "4 - Сортировка пузырьком (двухпроходная)\n" +
                "5 - Сортировка методом четно-нечетных перестановок\n" +
                "6 - Сортировка вставкой (без дубликатов)\n" +
                "7 - Вывод медианы\n" +
                "8 - Удаление дубликатов\n" +
                "9 - Пересоздание массива\n" +
                "10 - Завершение работы",
                1,
                10
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
                    SortArray.InsertionSortResult sortResult = array.insertionSort();
                    System.out.printf(
                        "Массив отсортирован вставкой. Сравнений: %d, копирований: %d",
                        sortResult.getComparisons(),
                        sortResult.getCopies()
                    );
                    println();
                    displayArray(array);
                    break;
                case 4:
                    array.twoSidedBubbleSort();
                    println("Массив отсортирован двухпроходной сортировкой пузырьком:");
                    displayArray(array);
                    break;
                case 5:
                    println("Массив отсортирован методом четно-нечетных перестановок. Количество итераций: " +
                        array.oddEvenSort()
                    );
                    displayArray(array);
                    break;
                case 6:
                    array.insertionSortNoDups();
                    println("Массив отсортирован вставкой, дубликаты удалены:");
                    displayArray(array);
                    break;
                case 7:
                    println("Медиана: " + array.median());
                    break;
                case 8:
                    array.removeDuplicates();
                    println("Дубликаты удалены:");
                    displayArray(array);
                    break;
                case 9:
                    array = createArray();
                    break;
            }
            println("Время операции - " + (System.currentTimeMillis() - time) + " мс");
        } while (userInput != 10);
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
