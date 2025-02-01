package StacksPractice;

import java.util.Stack;

public class StackPractice1 {

    public static String reverseString(String word) {
        Stack<Character> stack = new Stack<>();
        String returnedWord = "";
        for (char ch : word.toCharArray()) {
            stack.push(ch);
        }
        while (!stack.empty()) {
            returnedWord+=stack.pop();
        }
        return returnedWord;
    }

    public static boolean isBalanced(String expression) {
        //([)]

        Stack<Character> stack = new Stack<>();
        for (char ch : expression.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (!isMatchingPair(top, ch)) return false;
            }
        }
        return stack.isEmpty();
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}');
    }

    public static boolean isOperator(char ch) {
        switch (ch) {
            case '+':
            case '-':
            case '/':
            case '*':
                return true;
        }
        return false;
    }

    public static String evaluatePostfix(String expression) {
        Stack<String> s = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char current = expression.charAt(i);
            if (isOperator(current)) {
                String op1 = s.pop();
                String op2 = s.pop();
                String temp = current + op2 + op1;
                s.push(temp);
            }
            else {
                s.push(current + "");
            }
        }

        return s.pop();
    }
    //"53+82-*"

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("Top element using peek: " + stack.peek());
        System.out.println("Is the stack empty? " + stack.empty());
        int elementToSearch = 3;
        int position = stack.search(elementToSearch);
        if (position != -1) {
            System.out.println("Element " + elementToSearch + " found at position: " + position + " from the top.");
        } else {
            System.out.println("Element " + elementToSearch + " not found in the stack.");
        }
        System.out.println("Popping elements:");
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
        System.out.println("Is the stack empty after popping all elements? " + stack.empty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(reverseString("Hello World!"));
        System.out.println(isBalanced("([)]"));
        System.out.println(evaluatePostfix("ABC/-AK/L-*"));
        //5 3 + 8 2 - *"
    }

}
