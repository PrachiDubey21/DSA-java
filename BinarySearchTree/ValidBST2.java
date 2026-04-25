class ValidBST2 {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Find maximum value in a tree
    public static int findMax(Node root) {
        while (root.right != null) {
            root = root.right;
        }
        return root.data;
    }

    // Find minimum value in a tree
    public static int findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    // Validate BST using min/max subtree values
    public static boolean isValidBST(Node root) {

        // empty tree is valid
        if (root == null) {
            return true;
        }

        // check left subtree max
        if (root.left != null && findMax(root.left) >= root.data) {
            return false;
        }

        // check right subtree min
        if (root.right != null && findMin(root.right) <= root.data) {
            return false;
        }

        // recursively validate left and right
        return isValidBST(root.left) && isValidBST(root.right);
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

        System.out.println(isValidBST(root)); // true
    }
}
