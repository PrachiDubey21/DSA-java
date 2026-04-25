class SearchInBST {

    // Node structure
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Function to search a key in BST
    public static boolean search(Node root, int key) {

        // Base case: tree empty or key found
        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        }

        // If key is smaller, search left subtree
        if (key < root.data) {
            return search(root.left, key);
        }
        // If key is greater, search right subtree
        else {
            return search(root.right, key);
        }
    }

    // Main method
    public static void main(String[] args) {

        /* Creating BST
                  8
                /   \
               5     10
              / \      \
             3   6      11
        */

        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(11);

        int key = 9;

        if (search(root, key)) {
            System.out.println(key + " found in BST");
        } else {
            System.out.println(key + " not found in BST");
        }
    }
}

