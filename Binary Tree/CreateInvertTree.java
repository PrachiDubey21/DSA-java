public class CreateInvertTree {

    static class TreeNode {

        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    
    public static TreeNode invertTree(TreeNode root) {

        // Base case
        if (root == null) {
            return null;
        }

        // Recursively invert left subtree
        TreeNode left = invertTree(root.left);

        // Recursively invert right subtree
        TreeNode right = invertTree(root.right);

        // Swap 
        root.left = right;
        root.right = left;

        // Return root
        return root;
    }

    public static void printTree(TreeNode root) {

        //preorder traversal

        if (root == null) return;

        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.print("Original Tree (Preorder): ");
        printTree(root);

        invertTree(root);

        System.out.print("\nInverted Tree (Preorder): ");
        printTree(root);
    }

    
}
