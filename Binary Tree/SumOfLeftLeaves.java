import java.util.*;

// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SumOfLeftLeaves {

    static int sum;

    public static void inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        inorder(root.left);

        // Check if left child is a leaf
        if (root.left != null) {

            if (root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            }
        }

        inorder(root.right);
    }

    public static int sumOfLeftLeaves(TreeNode root) {

        sum = 0;
        inorder(root);

        return sum;
    }

    public static void main(String[] args) {



        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println("Sum of Left Leaves = " + sumOfLeftLeaves(root));

    }

}
