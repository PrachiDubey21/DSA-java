public class LargestBSTinBT {

    // Node structure
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Helper Info class (NOW WITH min & max)
    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;

        Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    // Static variable to store maximum BST size
    static int maxSize = 0;

    // Correct function (NO ancestor min/max)
    public static Info findLargestBST(Node root) {

        // Empty tree
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info left = findLargestBST(root.left);
        Info right = findLargestBST(root.right);

        // Check BST condition locally
        if (left.isBST && right.isBST &&
                root.data > left.max && root.data < right.min) {

            int currSize = left.size + right.size + 1;
            maxSize = Math.max(maxSize, currSize);

            int currMin = Math.min(root.data, left.min);
            int currMax = Math.max(root.data, right.max);

            return new Info(true, currSize, currMin, currMax);
        }

        // Not a BST
        return new Info(false, 0, 0, 0);
    }

    // Wrapper function
    public static int largestBST(Node root) {
        maxSize = 0;
        findLargestBST(root);
        return maxSize;
    }

    // Main function
    public static void main(String[] args) {

        /*
         *     50
                /  \
              30    60
             /  \   / \
           5   20 45  70
                      /   \
                     65    80
         */

        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(60);
        root.left.left = new Node(5);
        root.left.right = new Node(20);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);

        System.out.println("Size of Largest BST: " + largestBST(root));
    }
}
