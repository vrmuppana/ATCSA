package Queues;

import java.util.LinkedList;
import java.util.Queue;

public class Q2Stack {
    private Queue<Object> q1; //5 4 3 2 1
    private Queue<Object> q2; //
    private int size;

    public Q2Stack() {
        q1 = new LinkedList<Object>();
        q1 = new LinkedList<Object>();
        size = 0;
    }

    public void push (Object item) {
        if (q1.isEmpty()) {
            q1.offer(item);
            size++;
            return;
        }
        q2 = new LinkedList<Object>(q1);
        q1.clear();
        q1.offer(item);
        q1.addAll(q2);
        size++;
        return;
    }

    public Object pop() {
        size--;
        return q1.poll();
    }

    public Object top() {
        return q1.peek();
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public int size() {
        return size;
    }

    public static void main(String[] args)
    {
        Q2Stack s = new Q2Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println("current size: " + s.size());
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());

        System.out.println("current size: " + s.size());
    }
}
