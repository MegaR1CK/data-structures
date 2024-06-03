package datastructures.stacksandqueues.processors;

import datastructures.stacksandqueues.structures.Stack;

public class ExpressionsCalculator {

    private final String input;
    private final StringBuilder postfixForm;

    public ExpressionsCalculator(String input) {
        this.input = input.replaceAll("\\s","");
        this.postfixForm = new StringBuilder();
    }

    public int calculate() {
        String postfixForm = getPostfixForm();
        Stack operandsStack = new Stack(postfixForm.length());
        for (int i = 0; i < postfixForm.length(); i++) {
            char currentChar = postfixForm.charAt(i);
            if (currentChar >= '0' && currentChar <= '9') {
                operandsStack.push(Character.getNumericValue(currentChar));
            } else {
                int firstOperand = operandsStack.pop();
                int secondOperand = operandsStack.pop();
                switch (currentChar) {
                    case '+':
                        operandsStack.push(firstOperand + secondOperand);
                        break;
                    case '-':
                        operandsStack.push(firstOperand - secondOperand);
                        break;
                    case '*':
                        operandsStack.push(firstOperand * secondOperand);
                        break;
                    case '/':
                        operandsStack.push(firstOperand / secondOperand);
                        break;
                }
            }
        }
        return operandsStack.pop();
    }

    private String getPostfixForm() {
        Stack operatorsStack = new Stack(input.length());
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            switch (symbol) {
                case '+':
                case '-':
                case '*':
                case '/':
                    processOperator(symbol, operatorsStack);
                    break;
                case '(':
                case ')':
                    processBrackets(symbol, operatorsStack);
                    break;
                default:
                    postfixForm.append(symbol);
                    break;
            }
        }
        while (!operatorsStack.isEmpty()) postfixForm.append(operatorsStack.popChar());
        return postfixForm.toString();
    }

    private void processOperator(char operator, Stack operatorsStack) {
        while (!operatorsStack.isEmpty()) {
            char previousOperator = operatorsStack.popChar();
            if (previousOperator == '(') {
                operatorsStack.push(previousOperator);
                break;
            } else {
                if (getOperatorPriority(operator) > getOperatorPriority(previousOperator)) {
                    operatorsStack.push(previousOperator);
                    break;
                } else {
                    postfixForm.append(previousOperator);
                }
            }
        }
        operatorsStack.push(operator);
    }

    private void processBrackets(char bracket, Stack operatorsStack) {
        if (bracket == '(') {
            operatorsStack.push(bracket);
        } else {
            while (!operatorsStack.isEmpty()) {
                char operator = operatorsStack.popChar();
                if (operator == '(') {
                    break;
                } else {
                    postfixForm.append(operator);
                }
            }
        }
    }

    private int getOperatorPriority(char operator) {
        if (operator == '+' || operator == '-') {
            return  1;
        } else {
            return  2;
        }
    }
}
