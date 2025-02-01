package StacksPractice;
import java.util.*;

class RemoveAdjacent {

    public static String removeDuplicates(String s) {
        Stack <Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && ch == stack.peek()) {
                stack.pop();
            }
            else {
                stack.push(ch);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }

    // Driver code
    public static void main(String[] args) {
        String[] inputs = {
                "g",
                "ggaabcdeb",
                "abbddaccaaabcd",
                "aannkwwwkkkwna",
                "abbabccblkklu"
        };
        for (int i = 0; i < inputs.length; i++) {
            System.out.println((i + 1) + ".\tRemove duplicates from string: '" + inputs[i] + "'");
            String resultingString = removeDuplicates(inputs[i]);
            System.out.println("\tString after removing duplicates: " + resultingString);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

}