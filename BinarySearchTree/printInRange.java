class printInRange {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Function to print nodes in range
    public static void printInRange(Node root, int low, int high) {
        if (root == null) {
            return;
        }

        // Go left if smaller values may exist
        if (root.data > low) {
            printInRange(root.left, low, high);
        }

        // Print if in range
        if (root.data >= low && root.data <= high) {
            System.out.print(root.data + " ");
        }

        // Go right if larger values may exist
        if (root.data < high) {
            printInRange(root.right, low, high);
        }
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

        int low = 5, high = 10;
        printInRange(root, low, high);
    }
}
