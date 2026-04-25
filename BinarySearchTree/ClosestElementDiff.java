public class ClosestElementDiff {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int closestValue(TreeNode root, int K) {

        int closest = root.val;

        while (root != null) {

            // Update closest if current is better
            if (Math.abs(root.val - K) < Math.abs(closest - K)) {
                closest = root.val;
               // closest = root.val - K;
            }

            if (K < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return closest;
    }

    public static void main(String[] args) {

        // Build tree
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(5);
        root.right = new TreeNode(11);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(20);

        int K = 19;

        System.out.println("Closest Value: " + closestValue(root, K));
    }
    
}
