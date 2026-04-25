public class InsertTree {

    // Node of AVL Tree
    static class Node {
        int key;        // value stored in node
        int height;     // height of the node
        Node left;      // left child
        Node right;     // right child

        Node(int key) {
            this.key = key;
            this.height = 1; // new node is initially a leaf
        }
    }

    // Returns height of the node
    static int height(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }

    // Calculates balance factor of node
    // balance = height(left subtree) - height(right subtree)
    static int getBalance(Node node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    // Right rotation (used in LL case)
    static Node rightRotate(Node y) {
        Node x = y.left;     // new root after rotation
        Node T2 = x.right;  // subtree to be moved

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights of affected nodes
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    // Left rotation (used in RR case)
    static Node leftRotate(Node x) {
        Node y = x.right;    // new root after rotation
        Node T2 = y.left;   // subtree to be moved

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights of affected nodes
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // Insert a key into AVL Tree
    static Node insert(Node node, int key) {

        //  Perform normal BST insertion
        if (node == null)
            return new Node(key);

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node; // duplicate keys not allowed

        //  Update height of current node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Get balance factor to check whether node became unbalanced
        int balance = getBalance(node);

        //  If unbalanced, apply rotations

        // LL Case (Left Left)
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // RR Case (Right Right)
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        // LR Case (Left Right)
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RL Case (Right Left)
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        // Return unchanged node pointer
        return node;
    }

    // Inorder traversal (prints sorted order)
    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    // Main function
    public static void main(String[] args) {

        Node root = null;

        // Insert nodes into AVL Tree
        int[] keys = {10, 20, 30, 40, 50, 25};

        for (int key : keys)
            root = insert(root, key);

        // Inorder traversal gives sorted output
        System.out.print("Inorder traversal of AVL tree: ");
        inorder(root);
    }
}
