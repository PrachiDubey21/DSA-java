class MirrorBST {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Function to mirror the tree
    public static Node mirror(Node root) {

        // base case
        if (root == null) {
            return null;
        }

        // mirror left and right subtrees
        Node leftMirror = mirror(root.left);
        Node rightMirror = mirror(root.right);

        // swap
        root.left = rightMirror;
        root.right = leftMirror;

        return root;
    }

    // Inorder traversal (to verify)
    public static void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
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

        System.out.print("Inorder before mirror: ");
        inorder(root);

        mirror(root);

        System.out.print("\nInorder after mirror: ");
        inorder(root);
    }
}
