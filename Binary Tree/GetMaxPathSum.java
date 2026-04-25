import java.util.*;

public class GetMaxPathSum {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int maxSum = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {

        maxSum = Integer.MIN_VALUE;
        solve(root);

        return maxSum;
    }

    public static int solve(TreeNode root) {

        if (root == null) return 0;

        int left = solve(root.left);
        int right = solve(root.right);

        // ignore negative paths
        left = Math.max(0, left);
        right = Math.max(0, right);

        // Update max 
        maxSum = Math.max(maxSum, left + right + root.val);

        // Return path to parent (only one side)
        return root.val + Math.max(left, right);
    }

    public static void main(String[] args) {

        // Build tree
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        int result = maxPathSum(root);

        System.out.println("Maximum Path Sum: " + result);
    }

    
}
