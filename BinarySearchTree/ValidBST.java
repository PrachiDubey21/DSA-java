import java.util.*;

class ValidBST {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Inorder traversal to store values
    public static void inorder(Node root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }

        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }

    // Check if list is strictly increasing
    public static boolean isSorted(ArrayList<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    // Validate BST
    public static boolean isValidBST(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);
        return isSorted(list);
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
