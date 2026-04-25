import java.util.*;

class RootToLeaf {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

        public static void printPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
            if (i != path.size() - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

    // Function to print all root to leaf paths
    public static void printPaths(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }

        // Add current node to path
        path.add(root.data);

        // If leaf node, print path
        if (root.left == null && root.right == null) {
            printPath(path);
        } else {
            // Recur for left and right subtree
            printPaths(root.left, path);
            printPaths(root.right, path);
        }

        // Backtracking
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        /*
                1
               / \
              2   3
               \
                5
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(5);

        ArrayList<Integer> path = new ArrayList<>();
        printPaths(root, path);
    }
}
