package Queues;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {

    public static void reverseQueueKElements(Queue<Integer> queue, int k) {
        Stack<Integer> st = new Stack<Integer>();
        int num = k;
        while (num!=0) {
            st.push(queue.poll());
            num--;
        }
        Queue<Integer> tempQ = new LinkedList<Integer>();
        while (!st.isEmpty()) {
            tempQ.offer(st.pop());
        }
        while (!queue.isEmpty()) {
            tempQ.offer(queue.poll());
        }
        queue.addAll(tempQ);

    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        queue.add(60);
        queue.add(70);
        queue.add(80);
        queue.add(90);
        queue.add(100);
        int k = 5;
        reverseQueueKElements(queue, k);
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }

    }
}
