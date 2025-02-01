package StacksPractice;

public class StackLinkedList {

    private Node head;
    private int size = 0;
    public static class Node {
        private Object value;
        private Node next;

        public Node(Object value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (head==null) {
            return true;
        }
        return false;
    }

    public void push(Object val) {
        head = new Node(val, head);
        size++;
    }

    public Object pop() {
        if (this.isEmpty()) {
            throw new IllegalStateException("EmptyStackException");
        }
        Object removedVal = head.getValue();
        size--;
//        if (head.getNext()==null) {
//            head = null;
//            return removedVal;
//        }
        head = head.getNext();
        return removedVal;
    }

    public Object peek() {
        if (this.isEmpty()) {
            throw new IllegalStateException("EmptyStackException");
        }
        return head.getValue();
    }

    public void print() {
        Node tempHead = head;
        while (tempHead.getNext()!=null) {
            System.out.print(tempHead.getValue() + ", ");
            tempHead = tempHead.getNext();
        }
        System.out.print(tempHead.getValue());
    }

    public static void main(String[] args) {
        StackLinkedList s = new StackLinkedList();
        s.push(50);
        s.push(36);
        s.push(68);
        s.print();
        System.out.println();
        System.out.println(s.pop());
        System.out.println(s.pop());
    }

}
