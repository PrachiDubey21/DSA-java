import java.util.*;

public class SumInTwoBSTs {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<int[]> findPairs(TreeNode root1, TreeNode root2, int x) {

        List<int[]> result = new ArrayList<>();

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        TreeNode a = root1;
        TreeNode b = root2;

        while (true) {

            // Left traversal (Tree1)
            while (a != null) {
                s1.push(a);
                a = a.left;
            }

            // Right traversal (Tree2)
            while (b != null) {
                s2.push(b);
                b = b.right;
            }

            if (s1.isEmpty() || s2.isEmpty())
                break;

            TreeNode n1 = s1.peek();
            TreeNode n2 = s2.peek();

            int sum = n1.val + n2.val;

            if (sum == x) {
                result.add(new int[] { n1.val, n2.val });

                s1.pop();
                s2.pop();

                a = n1.right;
                b = n2.left;

            }

             else if (sum < x) {
                s1.pop();
                a = n1.right;
            }

             else {
                s2.pop();
                b = n2.left;
            }
            
        }

        return result;
    }

    public static void main(String[] args) {

        // Tree 1
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(2);
        root1.left.right = new TreeNode(4);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(8);

        // Tree 2
        TreeNode root2 = new TreeNode(10);
        root2.left = new TreeNode(6);
        root2.right = new TreeNode(15);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(8);
        root2.right.left = new TreeNode(11);
        root2.right.right = new TreeNode(18);

        int x = 16;

        List<int[]> pairs = findPairs(root1, root2, x);

        System.out.println("Pairs:");
        for (int[] p : pairs) {
            System.out.println("(" + p[0] + ", " + p[1] + ")");
        }
    }

}
