import java.util.*;

public class ConvertArrToBST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode sortedArrayToBST(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        return create(start, end, nums);
    }

    public static TreeNode create(int start, int end, int[] nums) {

        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = create(start, mid - 1, nums);
        root.right = create(mid + 1, end, nums);

        return root;
    }

    public static void printTree(TreeNode root) {

        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();

            System.out.print(node.val + " ");

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public static void main(String[] args) {

        int[] nums = { -10, -3, 0, 5, 9 };
        TreeNode root = sortedArrayToBST(nums);

        System.out.println("BST in Level Order:");
        printTree(root);

    }

}