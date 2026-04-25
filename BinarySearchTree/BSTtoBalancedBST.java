import java.util.*;

public class BSTtoBalancedBST {

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

    // Step 1: Store inorder traversal
    public static void inorderStore(Node root, ArrayList<Integer> list) {
        if (root == null)
            return;

        inorderStore(root.left, list);
        list.add(root.data);
        inorderStore(root.right, list);
    }

    // Step 2: Convert sorted list to balanced BST
    public static Node buildBalancedBST(ArrayList<Integer> list, int start, int end) {

        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;

        Node root = new Node(list.get(mid));

        root.left = buildBalancedBST(list, start, mid - 1);
        root.right = buildBalancedBST(list, mid + 1, end);

        return root;
    }

    // Main function to convert BST to balanced BST
    public static Node convertToBalancedBST(Node root) {

        ArrayList<Integer> list = new ArrayList<>();

        // Store inorder
        inorderStore(root, list);

        // Build balanced BST
        return buildBalancedBST(list, 0, list.size() - 1);
    }

    // Inorder traversal (for verification)
    public static void inorderPrint(Node root) {
        if (root == null)
            return;

        inorderPrint(root.left);
        System.out.print(root.data + " ");
        inorderPrint(root.right);
    }

    // Main method
    public static void main(String[] args) {

        /*
         * Unbalanced BST:
         *            10
         *              \
         *               20
         *                 \
         *                  30
         *                    \
         *                     40
         */

        Node root = new Node(10);
        root.right = new Node(20);
        root.right.right = new Node(30);
        root.right.right.right = new Node(40);

        System.out.print("Inorder before balancing: ");
        inorderPrint(root);
        System.out.println();
        System.out.println("the root of this tree is : " + root.data);
        System.out.println();

        root = convertToBalancedBST(root);

        System.out.print("\nInorder after balancing: ");
        inorderPrint(root);
        System.out.println();
        System.out.println("the root of this tree is : " + root.data);
    }
}
