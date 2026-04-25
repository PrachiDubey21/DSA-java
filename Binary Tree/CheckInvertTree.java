public class CheckInvertTree {

    static class TreeNode {

        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }

    }

    public static boolean isMirror(TreeNode t1, TreeNode t2) {

        // both null
        if (t1 == null && t2 == null) {
            return true;
        }

        //  one null
        if (t1 == null || t2 == null) {
            return false;
        }

        //  value check 
        if (t1.val != t2.val) return false;

        // recursive mirror check
        return isMirror(t1.left, t2.right) &&
               isMirror(t1.right, t2.left);

    }

    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);

        TreeNode t2 = new TreeNode(1);
        t2.left = new TreeNode(3);
        t2.right = new TreeNode(2);

        boolean result = isMirror(t1, t2);

        if (result) {
            System.out.println("Trees are Mirror ");
        } else {
            System.out.println("Trees are NOT Mirror ");
        }
    }

    
}
