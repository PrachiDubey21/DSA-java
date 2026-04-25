public class DeleteNodeWithX {

    static class TreeNode {

        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode deleteLeaves(TreeNode root, int x) {

        if (root == null) return null;

        root.left = deleteLeaves(root.left, x);
        root.right = deleteLeaves(root.right, x);

        if (root.left == null && root.right == null && root.val == x) {
            return null;
        }

        return root;
    }

    // Preorder print
    public static void printTree(TreeNode root) {
        if (root == null) return;

        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {

        // Build tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);

        System.out.print("Before Deletion: ");
        printTree(root);
        System.out.println();

        int x = 2;

        root = deleteLeaves(root, x);

        System.out.print("After Deletion: ");
        printTree(root);
    }

    
}
