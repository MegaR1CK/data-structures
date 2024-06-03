package datastructures.stacksandqueues;

import datastructures.stacksandqueues.exceptions.FullQueueException;
import datastructures.stacksandqueues.processors.BracketsAnalyzer;
import datastructures.stacksandqueues.processors.ExpressionsCalculator;
import datastructures.stacksandqueues.processors.Reverser;
import datastructures.stacksandqueues.structures.Queue;

import static datastructures.Utils.*;

public class StacksAndQueuesApp {

    public static void main(String[] args) {
        int userInput;
        do {
            userInput = readInt("1 - Реверс строки\n" +
                "2 - Анализ скобок\n" +
                "3 - Решение выражения\n" +
                "4 - Вывести очередь\n" +
                "5 - Завершение работы",
                    1,
                    5
            );
            switch (userInput) {
                case 1:
                    Reverser reverser = new Reverser(readString("Введите строку:"));
                    println(reverser.doReverse());
                    break;
                case 2:
                    BracketsAnalyzer analyzer = new BracketsAnalyzer(readString("Введите строку:"));
                    println(analyzer.analyze());
                    break;
                case 3:
                    ExpressionsCalculator calculator = new ExpressionsCalculator(readString("Введите выражение:"));
                    println(String.valueOf(calculator.calculate()));
                    break;
                case 4:
                    int size = readInt("Введите размер очереди:");
                    Queue queue = new Queue(size);
                    for (int i = 0; i < size; i++) {
                        try {
                            queue.insert(readInt("Элемент " + (i + 1) + ":"));
                        } catch (FullQueueException e) {
                            println("Очередь заполнена!");
                        }
                    }
                    println(queue.display());
                    break;
            }
        } while (userInput != 5);
        println("Завершение работы...");
    }
}
