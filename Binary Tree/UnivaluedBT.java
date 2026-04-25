public class UnivaluedBT {

    // Tree Node class
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    // Check if tree is univalued
    public static boolean isUnivalued(TreeNode root) {
        return check(root, root.val);
    }

    public static boolean check(TreeNode node, int value) {
        // Base case
        if (node == null) {
            return true;
        }

        // If value doesn't match
        if (node.val != value) {
            return false;
        }

        // Check left and right subtree
        return check(node.left, value) && check(node.right, value);
    }

    public static void main(String[] args) {

        // Constructing tree: 2, 2, 2, 5, 2
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(2);

        boolean result = isUnivalued(root);

        if (result) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}