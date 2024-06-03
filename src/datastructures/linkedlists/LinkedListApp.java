package datastructures.linkedlists;

import static datastructures.Utils.println;
import static datastructures.Utils.readInt;

public class LinkedListApp {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        println("1 - Вывод списка\n" +
                "2 - Вставка первого элемента\n" +
                "3 - Удаление первого элемента\n" +
                "4 - Поиск элемента\n" +
                "5 - Удаление элемента\n" +
                "6 - Завершение работы");
        int userInput;
        do {
            userInput = readInt(1, 6);
            switch (userInput) {
                case 1:
                    list.displayList();
                    break;
                case 2:
                    int input = readInt("Введите число: ");
                    list.insertFirst(input);
                    list.displayList();
                    break;
                case 3:
                    list.deleteFirst();
                    list.displayList();
                    break;
                case 4:
                    int key = readInt("Введите число: ");
                    Link elem = list.find(key);
                    if (elem != null) {
                        println("Элемент найден");
                    } else {
                        println("Элемент не найден");
                    }
                    break;
                case 5:
                    int deleteKey = readInt("Введите число: ");
                    list.delete(deleteKey);
                    list.displayList();
                    break;
            }
        } while (userInput != 6);
        println("Завершение работы...");
    }
}
