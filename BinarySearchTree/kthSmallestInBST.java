public class kthSmallestInBST {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int count = 0;
    static int result = -1;

    public static int kthSmallest(TreeNode root, int k) {
        count = 0;
        result = -1;
        inorder(root, k);
        return result;
    }

    public static void inorder(TreeNode root, int k) {

        if (root == null) return;

        // Left
        inorder(root.left, k);

        // Root
        count++;
        if (count == k) {
            result = root.val;
            return;
        }

        // Right
        inorder(root.right, k);
    }

    public static void main(String[] args) {

        // Build tree
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(5);
        root.right = new TreeNode(11);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(20);

        int k = 3;

        System.out.println("Kth Smallest: " + kthSmallest(root, k));
    }

    
}
