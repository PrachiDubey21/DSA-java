import java.util.*;

public class AllRootToLeafPaths {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        findPaths(root, "", ans);
        return ans;
    }

    public static void findPaths(TreeNode root, String path, List<String> ans) {
        if (root == null) {
            return;
        }

        path = path + root.val;

        if (root.left == null && root.right == null) {
            ans.add(path);
            return;
        }

        path = path + "->";

        findPaths(root.left, path, ans);
        findPaths(root.right, path, ans);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        List<String> result = binaryTreePaths(root);
        System.out.println(result);

    }

}