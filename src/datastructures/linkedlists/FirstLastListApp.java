package datastructures.linkedlists;

import static datastructures.Utils.println;
import static datastructures.Utils.readInt;

public class FirstLastListApp {

    public static void main(String[] args) {
        FirstLastList list = new FirstLastList();

        println("1 - Вывод списка\n" +
                "2 - Вставка первого элемента\n" +
                "3 - Удаление первого элемента\n" +
                "4 - Вставка последнего элемента\n" +
                "5 - Завершение работы");
        int userInput;
        do {
            userInput = readInt(1, 5);
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
                    int input2 = readInt("Введите число: ");
                    list.insertLast(input2);
                    list.displayList();
                    break;
            }
        } while (userInput != 5);
        println("Завершение работы...");
    }
}
