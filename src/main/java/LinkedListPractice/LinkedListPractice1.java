package LinkedListPractice;

import java.util.*;

public class LinkedListPractice1 {
    public static class Node {
        private int value;
        private Node next;

        public Node(int v, Node n) {
            value = v;
            next = n;
        }

    }

    public void addHead(int value) {
        head = new Node(value, head);
    }

    public void addTail(int value) {
        Node newNode = new Node(value, null);
        Node current = head;
        if (head == null) {
            head = newNode;
        }
        while (current.next != null) {
            current = current.next;
        }
        current.next = head;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    Node head;

    public static void main(String[] args) {
        LinkedList<String> al = new LinkedList<String>();
        al.add("Ravi");
        al.add("Vijay");
        al.add("Ravi");
        al.add("Ajay");

        Iterator<String> itr = al.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        al.add(1, "Hanumat");
        itr = al.iterator();
        System.out.println();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        al.remove("Ravi");
        al.removeFirstOccurrence("Ravi");
        al.remove(1);

        itr = al.iterator();
        System.out.println();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }


    }
}
