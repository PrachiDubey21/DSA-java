public class SortedArrayToBST {

    // Node structure
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Function to convert sorted array to balanced BST
    public static Node sortedArrayToBST(int[] arr, int start, int end) {

        // Base case
        if (start > end) {
            return null;
        }

        // Find middle element
        int mid = start + (end - start) / 2;

        // Create root node
        Node root = new Node(arr[mid]);

        // Recursively build left and right subtrees
        root.left = sortedArrayToBST(arr, start, mid - 1);
        root.right = sortedArrayToBST(arr, mid + 1, end);

        return root;
    }

    // Inorder traversal (to verify BST)
    public static void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Main function
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        Node root = sortedArrayToBST(arr, 0, arr.length - 1);

        System.out.print("Inorder Traversal of BST: ");
        inorder(root);
    }
}
