package StacksPractice;
import java.util.Stack;

public class Arithmetic {

    public int calculate(String s){
        Stack<Integer> numStack = new Stack<Integer>();
        Stack<Character> opStack = new Stack<Character>();
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (isOperator(charArr[i])) {
                opStack.push(charArr[i]);
                i++;
                numStack.push(Integer.parseInt((charArr[i] + "")));
                if (i+1 < charArr.length && higherPrecedence(charArr[i+1], opStack.peek())) {

                }
                else {
                    numStack.push(evaluate(numStack.pop(), numStack.pop(), opStack.pop()));
                }
            }
            else {
                numStack.push(Integer.parseInt(charArr[i] + ""));
            }
        }
        return numStack.pop();
    }

    public boolean isOperator(char s) {
        switch(s) {
            case '+':
            case '-':
            case '*':
            case '/':
                return true;
            default:
                return false;
        }
    }

    public boolean higherPrecedence(char operator1, char operator2) {
        int o1 = -1;
        int o2 = -1;
        if (operator1 == '+' || operator1 == '-') {
            o1 = 1;
        }
        else
            o1=0;
        if (operator1 == '+' || operator1 == '-') {
            o2 = 1;
        }
        else
            o2=0;
        return o1>o2;
    }

    public int evaluate(int op1, int op2, char operator) {
        switch(operator) {
            case '+':
                return op2+op1;
            case '-':
                return op2-op1;
            case '*':
                return op2*op1;
            case '/':
                return op2/op1;
            default:
                throw new IllegalStateException(operator + "<-- is not a valid operator");
        }
    }

    public static void main(String[] args) {
        Arithmetic a = new Arithmetic();
        System.out.println(a.calculate("4+2*3"));
    }
}