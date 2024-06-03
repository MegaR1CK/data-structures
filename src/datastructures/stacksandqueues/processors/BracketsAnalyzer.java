package datastructures.stacksandqueues.processors;

import datastructures.stacksandqueues.structures.Stack;

public class BracketsAnalyzer {

    private final String input;

    public BracketsAnalyzer(String input) {
        this.input = input;
    }

    public String analyze() {
        int length = input.length();
        Stack bracketsStack = new Stack(length);
        for (int i = 0; i < length; i++) {
            char currentChar = input.charAt(i);
            switch (currentChar) {
                case '(':
                case '{':
                case '[':
                    bracketsStack.push(currentChar);
                    break;
                case ')':
                case '}':
                case ']':
                    if (!bracketsStack.isEmpty()) {
                        char charFromStack = bracketsStack.popChar();
                        if (!(currentChar == ']' && charFromStack == '[' ||
                            currentChar == ')' && charFromStack == '(' ||
                            currentChar == '}' && charFromStack == '{'
                        )) return "Несоответствие скобок!";
                    } else {
                        return "Недостаточно открывающихся скобок!";
                    }
                    break;
            }
        }
        return bracketsStack.isEmpty() ? "ОК" : "Недостаточно закрывающихся скобок!";
    }
}
