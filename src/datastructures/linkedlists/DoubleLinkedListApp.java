package datastructures.linkedlists;

import static datastructures.Utils.println;
import static datastructures.Utils.readInt;

public class DoubleLinkedListApp {

    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();

        println("1 - Вывод списка\n" +
                "2 - Вывод списка по убыванию\n" +
                "3 - Вставка первого элемента\n" +
                "4 - Удаление первого элемента\n" +
                "5 - Вставка последнего элемента\n" +
                "6 - Удаление последнего элемента\n" +
                "7 - Вставка элемента после\n" +
                "8 - Удаление элемента\n" +
                "9 - Завершение работы");
        int userInput;
        do {
            userInput = readInt(1, 9);
            switch (userInput) {
                case 1:
                    list.displayForward();
                    break;
                case 2:
                    list.displayBackward();
                    break;
                case 3:
                    int input = readInt("Введите число: ");
                    list.insertFirst(input);
                    list.displayForward();
                    break;
                case 4:
                    list.deleteFirst();
                    list.displayForward();
                    break;
                case 5:
                    int input2 = readInt("Введите число: ");
                    list.insertLast(input2);
                    list.displayForward();
                    break;
                case 6:
                    list.deleteLast();
                    list.displayForward();
                    break;
                case 7:
                    int key = readInt("Введите число: ");
                    int value = readInt("Введите значение: ");
                    list.insertAfter(key, value);
                    list.displayForward();
                    break;
                case 8:
                    int deleteKey = readInt("Введите число: ");
                    list.deleteKey(deleteKey);
                    list.displayForward();
                    break;
            }
        } while (userInput != 9);
        println("Завершение работы...");
    }
}
