// Three Cases of Deletion
// Leaf Node (0 children)
// → Simply delete the node.
// Node with 1 child
// → Replace node with its child.
// Node with 2 children
// → Replace node with its inorder successor
// (smallest value in right subtree), then delete that successor.

class DeleteBST {

    // Node structure
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Find minimum value node (inorder successor)
    public static Node findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // Delete function
    public static Node delete(Node root, int key) {

        // If tree is empty
        if (root == null) {
            return null;
        }

        // Search the node
        if (key < root.data) {
            root.left = delete(root.left, key);
        }
        else if (key > root.data) {
            root.right = delete(root.right, key);
        }
        else {
            // Node found

            // Case 1: Leaf node
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: One child
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            // Case 3: Two children
            Node successor = findMin(root.right);
            root.data = successor.data;
            root.right = delete(root.right, successor.data);
        }

        return root;
    }

    // Inorder traversal
    public static void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Main function
    public static void main(String[] args) {

        // Manually building BST
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(11);

        System.out.print("Before deletion: ");
        inorder(root);

        int key = 5;
        root = delete(root, key);

        System.out.print("\nAfter deleting " + key + ": ");
        inorder(root);
    }
}

