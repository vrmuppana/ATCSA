package Queues;
import java.util.*;

public class QueuePractice1 {
    public static void main(String[] args) {
        Queue<String> q = new LinkedList<>();
        q.offer("apple");
        q.offer("banana");
        q.offer("cherry");

        System.out.print(q);

        q.remove();


        System.out.println(q);
        System.out.print(q.peek());
    }
}
