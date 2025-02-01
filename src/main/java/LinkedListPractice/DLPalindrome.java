package LinkedListPractice;

class DLPalindrome {
    public boolean isPalindrome(DLNode head) {
        if (head == null || head.next == null)
            return true;
        DLNode start = head;
        DLNode end = head;
        while (end.next!=null) {
            end = end.next;
        }
        while (start!=null) {
            if (start==end || start.prev==end)
                return true;
            if (start.data != end.data)
                return false;
            start = start.next;
            end = end.prev;
        }
        return true;
    }

    public static void main(String[] args) {
        DLPalindrome solution = new DLPalindrome();
        //1 2 1
        // Test case 1
        DLNode head1 = new DLNode(1);
        head1.next = new DLNode(2);
        head1.next.prev = head1;
        head1.next.next = new DLNode(1);
        head1.next.next.prev = head1.next;
        System.out.println(solution.isPalindrome(head1)); // Expected: true
    }
}
