package LinkedListPractice;

// Class to represent a Singly Linked List and perform various operations
class LinkedListAddNumbers {
    ListNode1 head; // head of the list, initially null

    static class ListNode1 {
        int val;
        ListNode1 next;
        // Constructor
        ListNode1(int d)
        {
            val = d;
            next = null;
        }
    }

    public static ListNode1 addTwoNumbers(ListNode1 l1, ListNode1 l2) {
        ListNode1 dummyNode = new ListNode1(0);
        ListNode1 current = dummyNode;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            int sum = val1 + val2 + carry;

            carry = sum / 10;
            current.next = new ListNode1(sum % 10);
            current = current.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummyNode.next;
    }

    public static void printList(LinkedListAddNumbers list)
    {
        ListNode1 item = list.head;
        while(item != null) {
            System.out.println(item.val);
            item = item.next;
        }
    }

    // Inserts a new ListNode1 at the front of the list.
    void insertFirst(int val) {
        ListNode1 newItem = new ListNode1(val);
        newItem.next = head;
        head = newItem;
    }


    // Main method to test the linked list operations
    public static void main(String[] args) {
        LinkedListAddNumbers list1 = new LinkedListAddNumbers();
        LinkedListAddNumbers list2 = new LinkedListAddNumbers();


        list1.insertFirst(7);
        list1.insertFirst(2);
        list1.insertFirst(4);
        list1.insertFirst(3);

        list2.insertFirst(3);
        list2.insertFirst(6);

        System.out.println();


    }
}