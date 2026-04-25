//searching = o(h) where h is height = o(log n)

//inorder traversal gives a sorted sequence
import java.util.*;

class BuildBST {

    // Node structure
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Function to insert a value in BST
    public static Node insert(Node root, int val) {

        // If tree is empty, create new node
        if (root == null) {
            root = new Node(val);
            return root;
        }

        // If value is smaller, go to left subtree
        if (val < root.data) {
            root.left = insert(root.left, val);
        }
        // If value is greater, go to right subtree
        else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    // Inorder traversal (to check BST)
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Main method
    public static void main(String[] args) {

        int[] values = {8, 5, 3, 6, 10, 11};

        Node root = null;

        // Build BST
        for (int val : values) {
            root = insert(root, val);
        }

        // Print inorder traversal
        System.out.print("Inorder traversal of BST: ");
        inorder(root);
    }
}
