package datastructures;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Utils {

    public static void println(String string) {
        System.out.println(string);
    }

    public static void println() {
        System.out.println();
    }

    public static int readInt(String message, int minValue, int maxValue) {
        int intInput = 0;
        boolean isInputSuccessful;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        println(message);
        do {
            isInputSuccessful = true;
            try {
                String stringInput = reader.readLine();
                intInput = Integer.parseInt(stringInput);
                if (intInput < minValue || intInput > maxValue) isInputSuccessful = false;
            } catch (Exception exception) {
                isInputSuccessful = false;
            }
            if (!isInputSuccessful) println("Некорректный ввод!");
        } while (!isInputSuccessful);
        return intInput;
    }
}
