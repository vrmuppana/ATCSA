package BTrees;

public class FindDepthOfBTree {

        public int findDepth(BinaryTree.Node root) {
            if (root == null) {
                return 0;
            }
            int left = findDepth(root.left);
            int right = findDepth(root.right);
            return Math.max(left, right)+1;
        }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        FindDepthOfBTree fdt = new FindDepthOfBTree();
        tree.root = new BinaryTree.Node(12);
        tree.root.left = new BinaryTree.Node(8);
        tree.root.right = new BinaryTree.Node(9);
        tree.root.left.left = new BinaryTree.Node(5);
        tree.root.left.right = new BinaryTree.Node(6);
        System.out.println(fdt.findDepth(tree.root));
    }
}
