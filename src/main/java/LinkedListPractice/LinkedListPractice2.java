package LinkedListPractice;

class LinkedListPractice2 {

    Node head;

    public static class Node {
        int value;
        LinkedListPractice2.Node next;

        public Node(int v, LinkedListPractice2.Node n) {
            value = v;
            next = n;
        }

    }

    public void printList() {
        LinkedListPractice2.Node temp = head;
        while (temp != null) {
            System.out.println(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void addTail(int value) {
        LinkedListPractice2.Node newNode = new LinkedListPractice2.Node(value, null);
        LinkedListPractice2.Node current = head;
        if (head == null) {
            head = newNode;
        }
        while (current.next != null) {
            current = current.next;
        }
        current.next = head;
    }

    public LinkedListPractice2 mergeTwoLinkedList(LinkedListPractice2 l2) {
        Node temp1 = head;
        Node temp2 = l2.head;

        //1 3 5
        //2 4 6

//        while () {
//
//        }
        return new LinkedListPractice2();
    }

    public static void main(String[] args) {
        LinkedListPractice2 l1 = new LinkedListPractice2();
        LinkedListPractice2 l2 = new LinkedListPractice2();

        l1.printList();
        l2.printList();

//        l1.mergeTwoLinkedList(l2);

    }
}
