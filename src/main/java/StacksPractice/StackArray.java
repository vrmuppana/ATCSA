package StacksPractice;

import java.util.Arrays;

public class StackArray {

    private int capacity;
    private int[] data;
    private int top = -1;

    public StackArray() { // initial capacity
        this(1000);
    }

    public StackArray(int s) { //custom capacity
        data = new int[s];
        capacity = s;
    }

    public boolean isEmpty() {
        return (top==-1);
    }

    public int size() {
        return top+1;
    }

    public void print() {
        for (int i = top; i >= 0; i--) {
            System.out.print(data[i] + " ");
        }
    }

    public void push (int value) throws IllegalStateException {
        if (top+1==capacity) {
            throw new IllegalStateException("StackOverflowException");
        }
        top++;
        data[top]=value;
        System.out.print("[index: " + top + ", value pushed: " + data[top] + "]");
    }

    public int pop() throws IllegalStateException {
        if (this.isEmpty()) {
            throw new IllegalStateException("EmptyStackException");
        }
        int removedValue = data[top];
        System.out.print("[index: " + top + ", value popped: " + removedValue + "]");
        top--;
       return removedValue;
    }

    public int peek() {
        if (this.isEmpty()) {
            throw new IllegalStateException("StackEmptyException");
        }
        return data[top];
    }

    public static void main(String[] args) {
        StackArray s = new StackArray();
        s.push(50);
        s.push(36);
        s.push(69);
        s.print();
        System.out.println();
        System.out.println(s.pop());
        System.out.println(s.pop());
    }

}
