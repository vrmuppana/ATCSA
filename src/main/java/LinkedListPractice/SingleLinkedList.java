package LinkedListPractice;






// Class to represent a Singly Linked List and perform various operations
class SingleLinkedList {
    ListNode head; // head of the list, initially null

    static class ListNode {
        int val;
        ListNode next;
        // Constructor
        ListNode(int d)
        {
            val = d;
            next = null;
        }
    }

    public static void printList(SingleLinkedList list)
    {
        ListNode item = list.head;
        while(item != null) {
            System.out.println(item.val);
            item = item.next;
        }
    }

    // Inserts a new ListNode at the front of the list.
    void insertFirst(int val) {
        ListNode newItem = new ListNode(val);
        newItem.next = head;
        head = newItem;
    }

    // Inserts a new node after the given prev_node.
    void insertAfter(ListNode prev_node, int val) {
        ListNode temp = head;
        ListNode temp2;
        while (temp != null) {
            if (temp == prev_node) {
                temp2 = temp.next;
                temp.next = new ListNode(val);
                temp.next.next = temp2;
            }
            temp = temp.next;
        }
    }
    //1 2 3 [4] 5 6

    void insertLast(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

//    void sortedInsert(int val) {
//        ListNode newNode = new ListNode(val);
//        ListNode curr = head;
//
//        if (curr == null || curr.val > val); {
//            newNode.next = head;
//            head = newNode;
//            return;
//        }
//        while (curr.next!=null & curr.next.val<val) {
//            curr = curr.next;
//        }
//        newNode.next = curr.next;
//        curr.next = newNode;
//
//    }

    void deleteDuplicates() {
        ListNode temp = head;
        SingleLinkedList check = new SingleLinkedList();

        while (temp != null) {
            if (!check.search(temp.val)) {
                check.insertLast(temp.val);
            }
            temp = temp.next;
        }
        head = check.head;
    }

    //1 1

    // Deletes the first occurrence of the specified key in the list
    void delete(int key) {
        ListNode temp = head;
        ListNode prev = temp;

        if (temp.val == key)
            head = head.next;

        while (temp != null) {
            if (temp.val == key) {
                prev.next = temp.next;
                return;
            }
            prev = temp;
            temp = temp.next;
        }

    }

//     Searches for the key in the linked list and returns true if found, otherwise false
    boolean search(int key) {
        ListNode temp = head;
        while (temp != null) {
            if (temp.val == key)
                return true;
            temp = temp.next;
        }
        return false;

    }

    // Main method to test the linked list operations
    public static void main(String[] args) {
//        SingleLinkedList list = new SingleLinkedList(); // Create an empty list
//
//        // Insert nodes into the list
//
//        list.insertFirst(7);
//        list.insertFirst(2);
//        list.insertFirst(21);
//        list.insertFirst(3);
//        printList(list);
//        System.out.println();
//
//        // Search for a key in the list
//        System.out.println("Search 2: " + list.search(2)); // true
//        System.out.println();
////         Delete a node from the list by key
//        list.delete(2);
//        printList(list);
//        System.out.println();
//
//// Insert a node after a specific node
//        ListNode node = list.head.next; // Assuming you want to insert after the second node
//        if (node != null) {
//            list.insertAfter(node, 4);
//            System.out.println("Inserted 4 after the second node.");
//            printList(list);
//            System.out.println();
//        } else {
//            System.out.println("The specified node is null.");
//        }
//
//        // Check if the key is still present in the list
//        System.out.println("Search 2: " + list.search(2) + "\n"); // false
//
//        list.insertLast(26);
//        printList(list);

        SingleLinkedList list2 = new SingleLinkedList(); // Create an empty list

        list2.insertFirst(1);
        list2.insertFirst((2));
        list2.insertFirst((2));
        list2.insertFirst((5));
        list2.insertFirst((5));
        list2.insertFirst((6));
        list2.deleteDuplicates();

        printList(list2);

    }

}