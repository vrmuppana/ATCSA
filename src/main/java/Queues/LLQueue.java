package Queues;

public class LLQueue implements MyQueue{

    Node first;

    public LLQueue() {
        first = new Node(null, null);
    }

    @Override
    public boolean empty() {
        return (first == null);
    }

    public void add(Object item) {
        if (empty()) {
            first.data = null;
        }
        else {
            Node temp = first;
            while (temp.next!=null) {
                temp = temp.next;
            }
            temp.next = new Node(item, null);
        }
        return;

    }

    @Override
    public boolean offer(Object item) {
        add(item);
        return true;
    }

    @Override
    public Object poll() {
        Object data = first.data;
        first = first.next;
        return data;
    }

    @Override
    public Object peek() {
        return first.data;
    }

    public void append(LLQueue q) {
        while (!q.empty()) {
            this.add(q.poll());
        }
    }

    public LLQueue alternate(LLQueue q) {
        LLQueue result = new LLQueue();
        while (!empty() && !q.empty()) {
            if (empty()) {
                result.offer(poll());
            }
            if (!q.empty()) {
                result.offer(q.poll());
            }
        }
        return result;
    }

    private class Node {
        private Object data;
        private Node next;

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Object getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

    }

    @Override
    public String toString() {
        Node temp = first;
        String result = "";
        while (temp!=null) {
            result += (temp.data) + " ";
            temp = temp.next;
        }
        return result;
    }

    public static void main(String[] args) {
        LLQueue queue = new LLQueue();
        for (int k = 1; k <= 5; k++) {
            queue.offer(k);
        }
        System.out.println(queue);
        LLQueue queue2 = new LLQueue();
        for (int k = 11; k <= 15; k++) {
            queue2.offer(k);
        }
        LLQueue queue3 = new LLQueue();
        for (int k = 21; k <= 27; k++) {
            queue3.offer(k);
        }
        System.out.println(queue3);
        queue.append(queue3);
        System.out.println(queue);
    }

}
