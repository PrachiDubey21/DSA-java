public class MaxSumInBSTSubTree {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int maxSum = 0;

    static class Info {
        boolean isBST;
        int sum, min, max;

        Info(boolean isBST, int sum, int min, int max) {
            this.isBST = isBST;
            this.sum = sum;
            this.min = min;
            this.max = max;
        }
    }

    public static int maxSumBST(TreeNode root) {
        maxSum = 0;
        solve(root);
        return maxSum;
    }

    public static Info solve(TreeNode root) {

        // Base case
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info left = solve(root.left);
        Info right = solve(root.right);

        // Check BST condition
        if (left.isBST && right.isBST &&
            root.val > left.max && root.val < right.min) {

            int currSum = left.sum + right.sum + root.val;

            maxSum = Math.max(maxSum, currSum);

            int min = Math.min(root.val, left.min);
            int max = Math.max(root.val, right.max);

            return new Info(true, currSum, min, max);
        }

        // Not BST
        return new Info(false, 0, 0, 0);
    }

    public static void main(String[] args) {

        // Build tree
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(6);

        System.out.println("Maximum Sum BST: " + maxSumBST(root));
    }

    
}
