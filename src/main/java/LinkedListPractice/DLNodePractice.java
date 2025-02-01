package LinkedListPractice;

public class DLNodePractice {

    public DLNode addToFront(Object value, DLNode head1) {
        if (head1 == null) {
            head1 = new DLNode(value);
            return head1;
        }
        DLNode newNode = new DLNode(value);
        head1.prev=newNode;
        newNode.next=head1;
        head1=newNode;
//        printDLList(head1);

        return head1;
    }

    public void printDLList(DLNode head) {
        DLNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        DLNodePractice l1 = new DLNodePractice();
        DLNode head1 = new DLNode(5);
        head1 = l1.addToFront(3, head1);
        head1 = l1.addToFront(1, head1);
        DLNode head2 = new DLNode(6);
        head2 = l1.addToFront(4, head2);
        head2 = l1.addToFront(2, head2);
        l1.printDLList(head1);
        System.out.println("\n");
        l1.printDLList(head2);

    }

}
