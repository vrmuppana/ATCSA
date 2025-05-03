package BTrees;

class SubtreeOfAnotherTree {
    public static class Node<T> {
        public T val;
        public Node<T> left;
        public Node<T> right;

        public Node(T val) {
            this(val, null, null);
        }

        public Node(T val, Node<T> left, Node<T> right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static boolean subtreeOfAnotherTree(Node<Integer> root, Node<Integer> subRoot) {
        if (subRoot == null) return true;
        if (root == null) return false;
        if (sameTree(root, subRoot)) return true;
        return subtreeOfAnotherTree(root.left, subRoot) || subtreeOfAnotherTree(root.right, subRoot);
    }


    private static boolean sameTree(Node<Integer> a, Node<Integer> b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        if (!a.val.equals(b.val)) return false;
        return sameTree(a.left, b.left) && sameTree(a.right, b.right);
    }



    public static void main(String[] args) {
        Node<Integer> root = new Node<Integer>(3, new Node<Integer>(4, new Node<Integer>(1, null, null), new Node<Integer>(2, null, null)), new Node<Integer>(5, null, null));
        Node<Integer> subroot = new Node<Integer>(4, new Node<Integer>(1, null, null), new Node<Integer>(2, null, null));
        System.out.print(subtreeOfAnotherTree(root, subroot));
    }
}
