class ValidBST3 {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Function to validate BST using range
    public static boolean isValidBST(Node root, long min, long max) {

        // empty tree is valid
        if (root == null) {
            return true;
        }

        // current node must lie in range
        if (root.data <= min || root.data >= max) {
            return false;
        }

        // left subtree: max becomes current node's value
        // right subtree: min becomes current node's value
        return isValidBST(root.left, min, root.data)
                && isValidBST(root.right, root.data, max);
    }

    public static void main(String[] args) {

        /*
                8
               / \
              5   10
             / \    \
            3   6    11
        */

        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(11);

        System.out.println(
            isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE)
        ); // true
    }
}
