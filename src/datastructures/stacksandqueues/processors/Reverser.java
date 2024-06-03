package datastructures.stacksandqueues.processors;

import datastructures.stacksandqueues.structures.Stack;

public class Reverser {

    private final String input;

    public Reverser(String input) {
        this.input = input;
    }

    public String doReverse() {
        int length = input.length();
        Stack stack = new Stack(length);
        for (int i = 0; i < length; i++) {
            stack.push(input.charAt(i));
        }
        StringBuilder output = new StringBuilder();
        while (!stack.isEmpty()) {
            output.append(stack.pop());
        }
        return output.toString();
    }
}
